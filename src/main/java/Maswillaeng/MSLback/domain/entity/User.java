package Maswillaeng.MSLback.domain.entity;

import Maswillaeng.MSLback.domain.enums.RoleType;
import Maswillaeng.MSLback.dto.user.request.UserUpdateRequestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "users")
public class User extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
    @Column(nullable = false, length = 30, unique = true)
    private String nickName;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    @Column(length = 1000)
    private String refreshToken;

    private String userImage;

    @Column(length = 100)
    private String introduction;

    @ColumnDefault("0")
    private int withdrawYn;

    private LocalDateTime withdrawAt;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Set<Post> postList = new HashSet<>();

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Comment> commentList = new ArrayList<>(); // 회원이 탈퇴해도 댓글은 그대로 유지할 것인가?

    @OneToMany(mappedBy = "follower",fetch = FetchType.LAZY)
    private Set<Follow> followerList = new HashSet<>();

    @OneToMany(mappedBy = "following",fetch = FetchType.LAZY)
    private Set<Follow> followingList = new HashSet<>();

//    @OneToMany(mappedBy = "owner")
//    private List<ChatRoom> ownerRooms = new ArrayList<>();
//
//    @OneToMany(mappedBy = "invited")
//    private List<ChatRoom> invitedRooms = new ArrayList<>();

    public void destroyRefreshToken(){
        this.refreshToken = null;
    }

    @Builder
    public User(String email, String password,
                String nickName, String userImage, String introduction) {
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.role = RoleType.USER;
        this.userImage = userImage;
        this.introduction = introduction;
        this.withdrawYn = 0;
    }

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void update(UserUpdateRequestDto requestDto) {
        this.nickName = requestDto.getNickName();
        this.userImage = requestDto.getUserImage();
        this.introduction = requestDto.getIntroduction();
    }

    public void resetPassword(String encryptedPassword) {
        this.password = encryptedPassword;
    }

    public void withdraw() {
        this.withdrawYn = 1;
        this.withdrawAt = LocalDateTime.now();
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }
}
