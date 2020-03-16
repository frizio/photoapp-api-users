package cloud.frizio.ms.photoapp.photoappapiusers.service;

import java.util.UUID;

import cloud.frizio.ms.photoapp.photoappapiusers.shared.UserDto;

public class UserServiceImpl implements UserService {

  @Override
  public UserDto createUser(UserDto userDetails) {
    userDetails.setUserId(UUID.randomUUID().toString());
    return null;
  }

  
}