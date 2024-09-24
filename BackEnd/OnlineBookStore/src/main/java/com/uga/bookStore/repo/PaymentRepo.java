package com.uga.bookStore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uga.bookStore.model.PaymentCard;
import com.uga.bookStore.model.User;

@Repository
public interface PaymentRepo extends JpaRepository<PaymentCard, Integer> {

    List<PaymentCard> findAllByUser(User user);
 
//    @Transactional
//    @Modifying
//    @Query(value = "delete from payment_cards p where p.user_id = :userId", nativeQuery = true)
//    void deletePaymentCard(@Param("userId") Integer userId);
//
//    @Modifying
//    @Query(value = "ALTER TABLE payment_cards AUTO_INCREMENT = (SELECT MAX(User_Id) FROM payment_cards)", nativeQuery = true)
//    void resetPaymentAutoIncrement();

    void deleteByCardNumber(String cardNumber);

	PaymentCard findByPaymentId(Integer paymentId);
}
