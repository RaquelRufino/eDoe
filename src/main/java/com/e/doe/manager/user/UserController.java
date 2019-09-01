package com.e.doe.manager.user;


import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.e.doe.manager.utils.PrivilegeUtils;
import com.e.doe.manager.utils.RestConstants;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = RestConstants.USER_URI)
@Api(tags = "User")
public class UserController {
	
	private UserService userService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@ApiOperation(value="Get All Users")
	@GetMapping({"/", ""})
	@PreAuthorize("hasRole('" + PrivilegeUtils.PRIVILAGE_USER + "')")
	public List<User> getUsers(){
		
		LOGGER.info("get Users");

		return userService.getUsers();
	}
	
	@ApiOperation(value="Get a User by id")
	@GetMapping({"/findById"})
	@PreAuthorize("hasRole('" + PrivilegeUtils.PRIVILAGE_USER + "')")
	public User getUserById(@RequestParam("id") String id){
		
		LOGGER.info("get user: " + id);

		return userService.getUserById(id);
	}
	
	@ApiOperation(value="Get Users by name")
	@GetMapping({"/findByName"})
	@PreAuthorize("hasRole('" + PrivilegeUtils.PRIVILAGE_USER + "')")
	public List<User> getUsersByName(@RequestParam("name") String name){
		
		LOGGER.info("get user: " + name);

		return userService.getUserByName(name);
	}
	
	@ApiOperation(value="Create a User")
	@PostMapping({"/", ""})
	@PreAuthorize("hasRole('" + PrivilegeUtils.PRIVILAGE_USER + "')")
	public User postUser(@RequestBody @Valid User user) {
		
		LOGGER.info("trying create item");
		
		User newUser = userService.postUser(user);
		
		LOGGER.info("User created");
		
		return newUser;
	}

	@ApiOperation(value="Delete a User")
	@DeleteMapping({"/{id}/", "/{id}"})
	@PreAuthorize("hasRole('" + PrivilegeUtils.PRIVILAGE_ADMIN + "')")
	public ResponseEntity<?> deleteUser(@PathVariable(value="id") String id) {
		
		LOGGER.info("trying delete user: " + id);

		userService.deleteUser(id);
		
		LOGGER.info("User " + id + " deleted");

		return ResponseEntity.ok().build();
		
	}
	
	@ApiOperation(value="Update a User")
	@PutMapping({"/{id}/", "/{id}"})
	@PreAuthorize("hasRole('" + PrivilegeUtils.PRIVILAGE_ADMIN + "')")
	public User atualizaUsuario(@PathVariable(value="id") String id, @RequestBody @Valid User user) {
		
		LOGGER.info("trying update User: " + id);
		
		User userUpdate = userService.updateUser(id, user);
		
		LOGGER.info("User " + id + " update");
		
		return userUpdate;
	}


}
