package com.heroku.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.heroku.model.User;

public interface UserRepositoryQ extends JpaRepository<User, Long> {
	@Query("SELECT MAX(u.id) FROM User u")
	Long findMaxId();

	
//	@Query("SELECT u.name from USER u WHERE u.id in (:pIdList)")
//	List<String>findByListId(@Param("pIdList")List<Long>idList);
	
//	public List<User> findNamesWithK() {
//        String jpqlQuery = "SELECT entity FROM YourEntityName entity WHERE entity.name LIKE '%k%'";
//        return entityManager.createQuery(jpqlQuery, User.class).getResultList();
//    }
//}
	
	 @Query("SELECT SUBSTRING(u.name, 1, 1) FROM User u WHERE u.id = :userId")
	  Optional<String> findFirstLetterOfUserName(@Param("userId") Long userId);
	 
	 
	 @Query("SELECT u FROM User u WHERE u.name LIKE 'k%'")
	    List<User> findUsersWithNameStartingWithK();
	 
	 @Query("SELECT u FROM User u WHERE u.name LIKE :startsWithLetter%")
	    List<User> findUsersWithNameStartingWithLetter(@Param("startsWithLetter") char startsWithLetter);


}
