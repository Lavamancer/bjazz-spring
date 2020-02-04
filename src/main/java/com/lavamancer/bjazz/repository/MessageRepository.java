package com.lavamancer.bjazz.repository;

import com.lavamancer.bjazz.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    // select * from message m where m.sender_id = :senderId and m.receiver_id = :reciverId
    List<Message> findBySender_IdAndReceiver_Id(Long senderId, Long receiverId);

}
