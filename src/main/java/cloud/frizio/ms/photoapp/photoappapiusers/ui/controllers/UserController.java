package cloud.frizio.ms.photoapp.photoappapiusers.ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.frizio.ms.photoapp.photoappapiusers.ui.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  Environment env;

  @GetMapping("/status/check")
  public String status() {
    return "Api users working on port " + env.getProperty("local.server.port");
  }

  @PostMapping
  public String createUser(@RequestBody User user) {
    return "User created!"; 
  }

}
