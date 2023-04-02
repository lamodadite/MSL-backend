package Maswillaeng.MSLback.domain.repository;

import Maswillaeng.MSLback.domain.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat,Long> {

    @Query("select c from Chat c where c.recipientId =:userId and c.state =false")
    Chat findByChatMessage(@Param("userId") Long userId);


    @Modifying(clearAutomatically = true)
    @Query("update Chat c set c.state = true where c.id = :chatId and c.state = false")
    void updateState(@Param("chatId") Long roomId);

    @Modifying(clearAutomatically = true)
    @Query("update Chat c set c.state = true where c.chatRoom.id = :roomId and not c.senderId = :userId and c.state = false")
    void updateStateByRoomIdAndUserId(@Param("roomId") Long roomId, @Param("userId") Long userId);

    @Query ("select c from Chat c where c.chatRoom.id = :roomId order by c.createdAt asc ")
    List<Chat> findAllByChatRoomId(@Param("roomId") Long roomId);

    @Query("SELECT c FROM Chat c " +
            "WHERE c.id IN " +
            "(SELECT MAX(c2.id) FROM Chat c2 WHERE c.chatRoom.id = c2.chatRoom.id) " +
            "AND (c.chatRoom.owner.id = :userId OR c.chatRoom.invited.id = :userId) " +
            "GROUP BY c.chatRoom.id " +
            "ORDER BY c.chatRoom.id ASC")
    List<Chat> findLastChatByUserId(@Param("userId") Long userId);

}
