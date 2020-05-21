package br.com.longping.endpoint;

import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.hibernate.boot.model.relational.AuxiliaryDatabaseObject.Expandable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.longping.error.ResourceNotFoundException;
import br.com.longping.model.User;
import br.com.longping.repository.UserRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("v1")
public class UserEndpoint {
	
	private final UserRepository userDAO;
	
	@Autowired
	public UserEndpoint(UserRepository userDAO) {
		this.userDAO = userDAO;
	}
	@CrossOrigin
	@GetMapping(path ="protected/users/")
	@ApiOperation(value="Return a list with all students", response = User[].class)
//	@ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value ="Bearer token", required = true, dataType = "string",paramType = "header")})
	public ResponseEntity<?> listAll(Pageable pageable) {
		return new ResponseEntity<>(userDAO.findAll(pageable),HttpStatus.OK);
	}
	
	@GetMapping(path ="protected/users/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id")Long id,Authentication authentication){
		verifyIfStudentExists(id);
		Optional<User> user = userDAO.findById(id);
		
					
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	@GetMapping(path = "protected/users/findByName/{name}")
	public ResponseEntity<?> findUserByName(@PathVariable String name){
		return new ResponseEntity<>(userDAO.findByNameIgnoreCaseContaining(name),HttpStatus.OK);
		}
	@CrossOrigin
	@PostMapping(path ="admin/users")
	@Transactional(rollbackOn = Exception.class)
	public ResponseEntity<?>save(@RequestBody User user){
		
		return new ResponseEntity<>(userDAO.save(user),HttpStatus.OK);
	}
	
	@DeleteMapping(path = "admin/users/{id}")
//	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?>delete(@PathVariable Long id){
		verifyIfStudentExists(id);
		userDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(path ="admin/users/{id}")
	public ResponseEntity<?>update(@RequestBody User user){
		verifyIfStudentExists(user.getId());
		userDAO.save(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private void verifyIfStudentExists(Long id) {
		Optional<User> user = userDAO.findById(id);
		if (user==null)
			throw new ResourceNotFoundException("User not found for id "+id);
		
	}

}
