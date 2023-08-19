package com.spring.user.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.spring.user.model.User;
import com.spring.user.service.UserService;

@RestController
@RequestMapping("/api/users")

public class UserController 
{
	@Autowired
	
	public UserService userService;
	
	
	    
	@GetMapping
	public List<User> getAllUser()
	{
		return userService.getAll();
	}
	
	@PostMapping
	public void addUser(@RequestBody User user)
	{
		userService.addUser(user);

	}
	
	@GetMapping("/id")
	public Optional<User> getId(@RequestParam("id") Long id)
	{
	
		return userService.getById(id);
	}
	@GetMapping("/nameAndAge")
	public List<User> getNameAndAge(@Param("name") String name, @Param("age") Long age)
	{
		return userService.getByNameAndAge(name, age);
	}
	@GetMapping("/idOrName")
	public List<User> getIdOrName(@Param("id") Long id, @Param("name") String name)
	{
		return userService.getByIdOrFindByName(id, name);
	}
	
	@GetMapping("/degree")
	public List<User> getDegreeStartWith(@Param("degree") String degree)
	{
		return userService.getByDegreeStartingWith(degree);
	}
	
	@GetMapping("/byAge")
	public List<User> getAgeLessThan(@Param("age") Long age)
	{
		return userService.findByAgeLessThan(age);
	}
	
	@GetMapping("/dateLess")
	public List<User> getCreatedDateLss( @RequestParam("createdDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime createdDate)
	{
		return userService.findCreatedDateLess(createdDate);
	}
	
	@GetMapping("/dateGreater")
	public Page<User> getCreatedDateGreater(
	            @RequestParam("createdDate")  LocalDateTime createdDate,
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {
	        Pageable pageable = PageRequest.of(page, size);
	        return userService.findByCreatedDateGreater(createdDate, pageable);
	}
	
	@GetMapping("/countUsersWithAgeLessThan")
	public long countUsersWithAgeLessThan(@RequestParam("age") Long age) 
	{
	    return userService.countUsersWithAgeLessThan(age);
	}
	
	@GetMapping("/countUsersWithAgeGreaterThan")
	public long countUsersWithAgeGreaterThan(@RequestParam("age") Long age) 
	{
	    return userService.countUsersWithAgeGreaterThan(age);
	}

	@PutMapping("/{id}")
	public String updateUser(@PathVariable("id") Long id,@RequestBody User user)
	{
	     userService.update(id,user);
	     return "updated";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id)
	{
	  userService.deleteUser(id);
		return "deleted";
		
	}
	
}











