package com.heroku.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.heroku.model.User;

public interface UserRepositoryQ extends JpaRepository<User, Long> {
	
//	@Query("select max(id) from user")
//	Long findMaxId();
//	
//	@Query("select u.name from user u where u.id in (:pIdList)")
//	List<String>findByListId(@Param("pIdList")List<Long>idList);

}
