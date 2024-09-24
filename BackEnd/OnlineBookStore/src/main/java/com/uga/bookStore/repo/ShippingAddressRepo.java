package com.uga.bookStore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uga.bookStore.model.ShippingAddress;
import com.uga.bookStore.model.User;

import org.springframework.transaction.annotation.Transactional;

public interface ShippingAddressRepo  extends JpaRepository<ShippingAddress, Integer> {


	List<ShippingAddress> findAllByUser(User user);
//	
//	@Modifying
//	@Transactional	
//	@Query(value="delete from shipping_address s where s.user_id=:userId",nativeQuery = true)
//	void deletShippingAddress(@Param("userId") Integer userId);
//
//	@Modifying
//	@Query(value="ALTER TABLE shipping_address AUTO_INCREMENT = (SELECT MAX(User_Id) FROM users);",nativeQuery = true)
//	void resetShippingAutoIncrement(); 
//	

	ShippingAddress findByAddressId(int addressId);
}
