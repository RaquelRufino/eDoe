package com.e.doe.manager.user;


import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.e.doe.manager.utils.RestConstants;


import java.util.List;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = RestConstants.USUARIO_URI)
@Api(tags = "User")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@ApiOperation(value="Get All Users")
	@GetMapping({"/", ""})
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@ApiOperation(value="Get a User")
	@GetMapping({"/{id}/", "/{id}"})
	public User getUserById(@PathVariable(value="id") String id){
		return userRepository.findById(id);
	}
	
	@ApiOperation(value="Get a User by name")
	@GetMapping({"/{name}/", "/{name}"})
	public String getUsuariosByName(@PathVariable(value="name") String name){

		List<User> users = userRepository.findByName(name);
		String st = "";
		
		for (int i = 0; i < users.size() - 1; i++) {
			st += users.get(i).toString() + " | ";
		}

		st += users.get(users.size() - 1).toString();
		return st;
	}
	
	@ApiOperation(value="Create a User")
	@PostMapping("/")
	public User postUser(@RequestBody @Valid User user) {
		return userRepository.save(user);
	}

	@ApiOperation(value="Delete a User")
	@DeleteMapping({"/{id}/", "/{id}"})
	public void deleteUser(@PathVariable(value="id") String id) {
		User user =  userRepository.findById(id);
		userRepository.delete(user);
	}
	
	@ApiOperation(value="Update a User")
	@PutMapping({"/{id}/", "/{id}"})
	public User atualizaUsuario(@PathVariable(value="id") String id, @RequestBody @Valid User user) {
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
