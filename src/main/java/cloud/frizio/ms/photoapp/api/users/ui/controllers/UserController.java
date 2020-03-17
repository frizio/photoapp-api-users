package cloud.frizio.ms.photoapp.api.users.ui.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.frizio.ms.photoapp.api.users.service.UserService;
import cloud.frizio.ms.photoapp.api.users.shared.UserDto;
import cloud.frizio.ms.photoapp.api.users.ui.model.UserRequestModel;
import cloud.frizio.ms.photoapp.api.users.ui.model.UserResponseModel;


@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  Environment env;

  @Autowired
  UserService userService;

  @GetMapping("/status/check")
  public String status() {
    return "Api users working on port " + env.getProperty("local.server.port");
  }

  @PostMapping
  public ResponseEntity<UserResponseModel> createUser(@Valid @RequestBody UserRequestModel user) {
    ModelMapper modelMapper  = new ModelMapper();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    UserDto userDto = modelMapper.map(user, UserDto.class);
    UserDto createdUser = userService.createUser(userDto);
    UserResponseModel userBody = modelMapper.map(createdUser, UserResponseModel.class);
    return ResponseEntity.status(HttpStatus.CREATED).body(userBody); 
  }

}
