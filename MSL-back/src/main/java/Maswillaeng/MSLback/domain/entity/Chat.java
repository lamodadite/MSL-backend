package Maswillaeng.MSLback.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoom; // 채팅방이 사라지면 채팅 데이터도 사라지는가?

    private String sender;

    private String recipient; // ??  room 으로 브로드캐스트 하는데 굳이?

    private String content;

    @CreatedDate
    private LocalDateTime createdAt;

    @ColumnDefault("false")
    private boolean state;


    @Builder
    public Chat(ChatRoom chatRoom, String sender, String recipient, String content, LocalDateTime createdAt, boolean state) {
        this.chatRoom = chatRoom;
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.createdAt = createdAt;
        this.state = state;
    }

    public void updateState() {
        this.state = true;
    }

}
