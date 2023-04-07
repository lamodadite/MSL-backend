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
    @Column(name = "chat_id")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoom;

    private Long senderId;

    private Long recipientId;

    private String content;

    @CreatedDate
    private LocalDateTime createdAt;

    @ColumnDefault("false")
    private boolean state;


    @Builder
    public Chat(String id, ChatRoom chatRoom, Long senderId, Long recipientId, String content, LocalDateTime createdAt, boolean state) {
        this.id = id;
        this.chatRoom = chatRoom;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.content = content;
        this.createdAt = createdAt;
        this.state = state;
    }

    public void changeState() {
        this.state = true;
    }
}
