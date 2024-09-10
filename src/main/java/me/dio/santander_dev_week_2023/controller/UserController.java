package me.dio.santander_dev_week_2023.controller;

import me.dio.santander_dev_week_2023.model.User;
import me.dio.santander_dev_week_2023.model.dto.UserCreateDTO;
import me.dio.santander_dev_week_2023.model.dto.UserDto;
import me.dio.santander_dev_week_2023.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id){
        var user = new UserDto(userService.findById(id));
        return ResponseEntity.ok(user);
    }

    @PostMapping()
    public ResponseEntity<UserDto> create(@RequestBody UserCreateDTO userCreateDTO){
        var userCreated = new UserDto(userService.create(new User(userCreateDTO)));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.id())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }


}
