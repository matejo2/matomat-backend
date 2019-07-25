package com.wilfer.matomatdemo.boundary;

import com.wilfer.matomatdemo.UserRepository;
import com.wilfer.matomatdemo.entity.User;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return repository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
      return repository.findById(id);
    }

    @PostMapping("/users")
    public Resource<User> addUser(@RequestBody User user){
        User newUser = repository.save(user);

        return new Resource<>(newUser,
                linkTo(methodOn(UserController.class).addUser(user)).withSelfRel(),
                linkTo(methodOn(UserController.class).getAllUsers()).withRel("getAllUsers"));
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable Long id){
        repository.deleteById(id);
        return "User gelöscht";
    }

}
