package com.SwiggyUser.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SwiggyUser.entity.SwiggyUser;

@Repository
public interface UserRepository extends JpaRepository<SwiggyUser,String>{

	
}
