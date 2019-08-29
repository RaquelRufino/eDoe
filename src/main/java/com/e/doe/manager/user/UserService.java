package com.e.doe.manager.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getUsers(){
		List<User> users = userRepository.findAll();
		
		return users;
	}
	
	public User getUserById(String id){
		User user = userRepository.findById(id);

		return user;
	}
	
	public List<User> getUserByName(String name){

		List<User> users = userRepository.findByName(name);
		
		return users;
	}
	
	public User postUser(User user) {
		
		User newUser = userRepository.save(user);
		return newUser;
	}

	public void deleteUser(String id) {
		User user =  userRepository.findById(id);
		userRepository.delete(user);
	}
	
	public User updateUser(String id, User user) {
		User existingUser =  userRepository.findById(id);
		
		if (!(user.getName() == null) && !(user.getName().trim().equals(""))) {
			existingUser.setName(user.getName());
		}
		
		if (!(user.getEmail() == null) && !(user.getEmail().trim().equals(""))) {
			existingUser.setEmail(user.getEmail());
		}
		
		if (!(user.getTelephone() == null) && !(user.getTelephone().trim().equals(""))) {
			existingUser.setTelephone(user.getTelephone());
		}
		
		User updaterUser = userRepository.save(existingUser);
		return updaterUser;
	}
}
