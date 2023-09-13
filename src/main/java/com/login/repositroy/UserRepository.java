package com.login.repositroy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.login.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{


	User findByUsername(String name);
	List<User> findByUsernameAndPassword(String name,String password);

}
