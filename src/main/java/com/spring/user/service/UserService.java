package com.spring.user.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.user.model.User;
import com.spring.user.repository.UserRepository;

@Service
public class UserService 
{
	
	@Autowired
	public UserRepository userRepository;
	
	
	
	public UserService(UserRepository userRepository) 
	{

		this.userRepository = userRepository;
	}
    @Transactional
	public List<User> getAll()
	{
		List<User> user = new ArrayList<>();
		userRepository.findAll().forEach(user::add);
		return user;
	}
    @Transactional
	public void addUser(User user)
	{
	     userRepository.save(user);
	}
    @Transactional
    public Optional<User> getById(Long id)
    {
    	
    	return userRepository.findById(id);
    }
    @Transactional
    public List<User> getByNameAndAge(String name, Long age)
    {
    	return userRepository.findByNameAndFindByAge(name, age);
    }
	
    public List<User> getByIdOrFindByName(Long id, String name)
    {
    	return userRepository.findByIdOrFindByName(id, name);
    }
    public List<User> getByDegreeStartingWith(String degree)
    {
    	return userRepository.findByDegreeStartingwith(degree);
    }
    
   public List<User> findCreatedDateLess(LocalDateTime createdDate)
    {
    	return userRepository.findByCreatedDateLess(createdDate);
    }
    
   
   public Page<User> findByCreatedDateGreater(LocalDateTime createdDate, Pageable pageable) 
   {
       return userRepository.findByCreatedDateGreater(createdDate, pageable);
   }
    
    public List<User> findByAgeLessThan(Long age)
    {
    	return  userRepository.findByAgeLessThan(age);
    }
    
    public long countUsersWithAgeLessThan(Long age)
    {
        return userRepository.countUsersWithAgeLessThan(age);
    }
    
    public long countUsersWithAgeGreaterThan(Long age)
    {
        return userRepository.countUsersWithAgeGreaterThan(age);
    }
    public User update( Long id ,User user)
    {
  
            return userRepository.save(user);
       
    }
   
	public void deleteUser(Long id)
	{
		userRepository.deleteById(id);
	}
	


}



























