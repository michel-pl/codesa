package com.codesa.controller;

import com.codesa.mapper.UserMapper;
import com.codesa.resource.UserResource;
import com.codesa.service.userService.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "List all users",
            notes = "List all users",
            nickname = "findAllUsers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Users found", response = List.class),
            @ApiResponse(code = 204, message = "Users not found")
    })
    @GetMapping(value = "/users", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserResource>> findAllUsers() {
        return new ResponseEntity<>(userService.findAll().stream()
                .map(user -> userMapper.userToUserResource(user))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @ApiOperation(value = "Find user by name",
            notes = "Find user by name",
            nickname = "finByUserName")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Users found", response = List.class),
            @ApiResponse(code = 204, message = "Users not found")
    })
    @GetMapping(value = "/username/{name}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserResource>> finByUserName(@PathVariable final String name) {
        return new ResponseEntity<>(userService.getUsersByName(name)
                .stream().map(user -> userMapper.userToUserResource(user)
                ).collect(Collectors.toList()), HttpStatus.OK);
    }

    @ApiOperation(value = "Find user by Id",
            notes = "Find user by id",
            nickname = "findByIdUser")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User found", response = List.class),
            @ApiResponse(code = 204, message = "User not found")
    })
    @GetMapping(value = "/user/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResource> findByIdUser(@PathVariable final Long id) {
        return new ResponseEntity<>(userMapper.INSTANCE.userToUserResource(userService.findById(id)),
                HttpStatus.OK);
    }

    @ApiOperation(value = "Save user",
            notes = "Save user",
            nickname = "saveUser")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User Created", response = UserResource.class),
    })
    @PostMapping(value = "/user", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResource> saveUser(@RequestBody final UserResource userResource) {
        return new ResponseEntity<>(userMapper.INSTANCE
                .userToUserResource(userService.save(userMapper.INSTANCE.userResourceToUser(userResource))),
                HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete user by Id",
            notes = "Delete user by Id",
            nickname = "deleteUser")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "User Deleted"),
    })
    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable final Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Update user",
            notes = "Update user",
            nickname = "updateUser")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User Updated", response = UserResource.class),
    })
    @PutMapping(value = "/user", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResource> updateUser(@RequestBody final UserResource userResource) {
        return new ResponseEntity<>(userMapper.INSTANCE
                .userToUserResource(userService.save(userMapper.INSTANCE.userResourceToUser(userResource))),
                HttpStatus.OK);
    }
}
