package Maswillaeng.MSLback.domain.repository;

import Maswillaeng.MSLback.domain.entity.Post;
import Maswillaeng.MSLback.domain.enums.Category;
import Maswillaeng.MSLback.dto.post.reponse.PostResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static Maswillaeng.MSLback.domain.entity.QPost.post;
import static Maswillaeng.MSLback.domain.entity.QReport.report;
import static Maswillaeng.MSLback.domain.entity.QUser.user;
import static Maswillaeng.MSLback.domain.entity.QHashTag.hashTag;

@Repository
public class PostQueryRepository extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public PostQueryRepository(JPAQueryFactory queryFactory) {
        super(Post.class);
        this.queryFactory = queryFactory;
    }

    public List<PostResponseDto> findAllPostByCategory(Category category) {
        JPAQuery<PostResponseDto> query = getPostResponseDtoJPAQuery().limit(500);

        if (category != null) {
            if (category == Category.BEST) {
                query.having(post.postLikeList.size().goe(50));
            } else {
                query.where(post.category.eq(category));
            }
        }

        return query.fetch();
    }

    private JPAQuery<PostResponseDto> getPostResponseDtoJPAQuery() {
        return queryFactory
                .select(Projections.bean(PostResponseDto.class,
                        post.id.as("postId"), user.id.as("userId"),
                        user.nickName, user.userImage, post.thumbnail, post.title,
                        post.content, post.createdAt, post.modifiedAt,
                        post.postLikeList.size().longValue().as("likeCnt"),
                        post.commentList.size().longValue().as("commentCnt"),
                        post.hits))
                .from(post)
                .join(post.user, user)
                .where(post.disabled.eq(0))
                .groupBy(post.id)
                .orderBy(post.createdAt.desc());
    }

    public Optional<Post> findByIdFetchJoin(Long postId) {
        return Optional.ofNullable(queryFactory
                .select(post)
                .from(post)
                .leftJoin(post.user).fetchJoin()
                .leftJoin(post.postLikeList).fetchJoin()
                .where(post.id.eq(postId).and(post.disabled.eq(0)))
                .fetchOne());
    }

    public Page<PostResponseDto> findAllPostByUserIdAndCategory(Long userId, String category, Pageable pageable) {
        JPAQuery<PostResponseDto> query = getPostResponseDtoJPAQuery()
                .where(post.user.id.eq(userId));

        if (category != null) {
            query.where(post.category.eq(Category.valueOf(category)));
        }

        int total = query.fetch().size();

        List<PostResponseDto> result = query
                .orderBy(post.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl<>(result, pageable, total);
    }

    public Page<PostResponseDto> findByReportCount(Pageable pageable) {
        JPAQuery<PostResponseDto> query = getPostResponseDtoJPAQuery()
                .leftJoin(post.reportList, report)
                .having(report.count().goe(50));

        int total = query.fetch().size();

        List<PostResponseDto> result = query
                .orderBy(post.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl<>(result, pageable, total);
    }

    public Page<PostResponseDto> findByKeyword(String keyword, Pageable pageable) {
        JPAQuery<PostResponseDto> query = getPostResponseDtoJPAQuery()
                .where(
                        post.title.containsIgnoreCase(keyword)
                                .or(post.content.containsIgnoreCase(keyword))
                );

        int total = query.fetch().size();

        List<PostResponseDto> result = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl<>(result, pageable, total);
    }

    public Page<PostResponseDto> findByHashTagNam(String tagName,Pageable pageable){
        JPAQuery<PostResponseDto> query = getPostResponseDtoJPAQuery()
                .join(post.hashTagList,hashTag)
                .where(hashTag.tag.name.eq(tagName));
        int total = query.fetch().size();

        List<PostResponseDto> result = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return new PageImpl<>(result, pageable, total);
    }

    public Page<PostResponseDto> findByFollowingPost(List<Long> followings,Pageable pageable){
        JPAQuery<PostResponseDto> query = getPostResponseDtoJPAQuery()
                .join(post.user,user)
                .where(user.id.in(followings));

        int total = query.fetch().size();

        List<PostResponseDto> result = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return new PageImpl<>(result, pageable, total);
    }
}

