package Maswillaeng.MSLback.service;

import Maswillaeng.MSLback.common.exception.EntityNotFoundException;
import Maswillaeng.MSLback.common.exception.NotAuthorizedException;
import Maswillaeng.MSLback.domain.entity.HashTag;
import Maswillaeng.MSLback.domain.entity.Post;
import Maswillaeng.MSLback.domain.entity.User;
import Maswillaeng.MSLback.domain.enums.Category;
import Maswillaeng.MSLback.domain.repository.PostQueryRepository;
import Maswillaeng.MSLback.domain.repository.PostRepository;
import Maswillaeng.MSLback.domain.repository.UserRepository;
import Maswillaeng.MSLback.dto.post.reponse.PostDetailResponseDto;
import Maswillaeng.MSLback.dto.post.reponse.PostResponseDto;
import Maswillaeng.MSLback.dto.post.request.PostRequestDto;
import Maswillaeng.MSLback.dto.post.request.PostUpdateDto;
import Maswillaeng.MSLback.utils.auth.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostQueryRepository postQueryRepository;
    private final HashTagService hashTagService;

    @Transactional
    public void savePost(Long userId, PostRequestDto postRequestDto) {
        User user = userRepository.findById(userId).get();
        Post post = postRequestDto.toEntity(user);

        List<HashTag> resultHashTagList = hashTagService.insertHashTagList(postRequestDto.getHashTagList(), post);

        post.setHashTagList(resultHashTagList);

        postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponseDto> getPostList(Category category) {

        return postQueryRepository.findAllPostByCategory(category);
    }

    @Transactional
    public PostDetailResponseDto getPostById(Long postId) {
        Post post = postQueryRepository.findByIdFetchJoin(postId)
                .orElseThrow(() -> new EntityNotFoundException(Post.class.getSimpleName()));
        post.increaseHits();

        if (UserContext.userData.get() == null) {
            return new PostDetailResponseDto(post);
        } else {
            Long userId = UserContext.userData.get().getUserId();
            return new PostDetailResponseDto(post, userId);
        }

    }

    @Transactional
    public void updatePost(Long userId, PostUpdateDto updateDto) {
        Post selectedPost = postRepository.findById(updateDto.getPostId()).get();

        if (!Objects.equals(selectedPost.getUser().getId(), userId)) {
            throw new NotAuthorizedException("접근 권한 없음");
        }

        List<String> updateHashTagList = updateDto.getHashTagList();
        List<HashTag> resultHashTagList = hashTagService.updateHashTagList(updateHashTagList, selectedPost);

        selectedPost.setHashTagList(resultHashTagList);
        selectedPost.update(updateDto);

    }

    @Transactional
    public void deletePost(Long userId, Long postId) {
        Post post = postRepository.findById(postId).get();
        if (!Objects.equals(userId, post.getUser().getId())) {
            throw new NotAuthorizedException(Post.class.getSimpleName());
        }

        List<String> deleteHashTag = post.getHashTagList().stream().map(h -> h.getTag().getName()).collect(Collectors.toCollection(ArrayList::new));
        hashTagService.deleteHashTagList(deleteHashTag, post);
        post.disablePost();


    }

    @Transactional(readOnly = true)
    public Page<PostResponseDto> getUserPostList(Long userId, String category, int page) {

        return postQueryRepository.findAllPostByUserIdAndCategory(userId, category,
                PageRequest.of(page - 1, 20));
    }

    @Transactional(readOnly = true)
    public Page<PostResponseDto> getReportedPostList(int page) {
        return postQueryRepository.findByReportCount(PageRequest.of(page - 1, 20));
    }

    public Map<String, String> uploadImage(MultipartFile imageFile) throws IOException {
        byte[] imageData = imageFile.getBytes();
        UUID uuid = UUID.randomUUID();
        String uploadDir = "MSL-back/src/main/upload/img/";
        String savedFileName = uuid.toString() + "_" + imageFile.getOriginalFilename();
        Path path = Paths.get(uploadDir, savedFileName);

        Files.write(path, imageData);

        Map<String, String> imagePath = new HashMap<>();
        imagePath.put("img", "/upload_img/" + savedFileName);

        return imagePath;
    }
}
