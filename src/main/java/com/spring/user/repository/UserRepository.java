package com.spring.user.repository;



import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.user.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	   @Query("SELECT u FROM User u WHERE u.name=?1 AND u.age=?2")
	   List<User> findByNameAndFindByAge(String name,Long age);	
	   
	   @Query("SELECT u FROM User u WHERE u.id=?1 OR u.name=?2")
	   List<User> findByIdOrFindByName(Long id,String name);
	   
	   @Query("SELECT u FROM User u WHERE u.age<?1")
	   List<User> findByAgeLessThan(Long age);
	   
	   @Query("SELECT u FROM User u WHERE u.degree LIKE ?1%")
	   List<User> findByDegreeStartingwith(String degree);
	   
	   @Query("SELECT u FROM User u WHERE u.createdDate<?1")
	   List<User> findByCreatedDateLess(LocalDateTime createdDate);
	   
	   @Query("SELECT u FROM User u WHERE u.createdDate>?1")
	   Page<User> findByCreatedDateGreater(LocalDateTime createdDate,Pageable pageable);
	   
	   @Query("SELECT COUNT(u) FROM User u WHERE u.age < ?1")
	    long countUsersWithAgeLessThan(Long age);
	   
	   @Query("SELECT COUNT(u) FROM User u WHERE u.age > ?1")
	    long countUsersWithAgeGreaterThan(Long age);


 
}
