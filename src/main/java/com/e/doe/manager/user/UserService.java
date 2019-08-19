package com.e.doe.manager.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public User getUserById(String id){
		return userRepository.findById(id);
	}
	
	public String getUsuariosByName(String name){

		List<User> users = userRepository.findByName(name);
		String st = "";
		
		for (int i = 0; i < users.size() - 1; i++) {
			st += users.get(i).toString() + " | ";
		}

		st += users.get(users.size() - 1).toString();
		return st;
	}
	
	public User postUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(String id) {
		User user =  userRepository.findById(id);
		userRepository.delete(user);
	}
	
	public User atualizaUsuario(String id, User user) {
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
		return userRepository.save(existingUser);
	}
}
