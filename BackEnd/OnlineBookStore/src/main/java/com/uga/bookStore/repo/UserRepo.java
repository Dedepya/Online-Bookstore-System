package com.uga.bookStore.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.uga.bookStore.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUserId(Long userId);  
    void deleteByUserId(Long userId);
	User findByOtpCode(int otpCode);
	 @Modifying
	    @Transactional
	    @Query("UPDATE User u SET u.password = :newPassword WHERE u.email = :email")
	    void updatePasswordByEmail(String email, String newPassword);
	 
}
