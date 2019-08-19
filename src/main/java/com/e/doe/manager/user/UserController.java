package com.e.doe.manager.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@ApiOperation(value="Get All Users")
	@GetMapping({"/", ""})
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@ApiOperation(value="Get a User")
	@GetMapping({"/{id}/", "/{id}"})
	public User getUserById(@PathVariable(value="id") String id){
		return userService.getUserById(id);
	}
	
	@ApiOperation(value="Get a User by name")
	@GetMapping({"/{name}/", "/{name}"})
	public String getUsuariosByName(@PathVariable(value="name") String name){

		return userService.getUsuariosByName(name);
	}
	
	@ApiOperation(value="Create a User")
	@PostMapping("/")
	public User postUser(@RequestBody @Valid User user) {
		return userService.postUser(user);
	}

	@ApiOperation(value="Delete a User")
	@DeleteMapping({"/{id}/", "/{id}"})
	public ResponseEntity<?> deleteUser(@PathVariable(value="id") String id) {
		userService.deleteUser(id);
		
		return ResponseEntity.ok().build();
		
	}
	
	@ApiOperation(value="Update a User")
	@PutMapping({"/{id}/", "/{id}"})
	public User atualizaUsuario(@PathVariable(value="id") String id, @RequestBody @Valid User user) {
		
		return userService.atualizaUsuario(id, user);
	}


}
