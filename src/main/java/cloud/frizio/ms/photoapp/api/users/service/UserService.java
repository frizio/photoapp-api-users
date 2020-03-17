package cloud.frizio.ms.photoapp.api.users.service;

import cloud.frizio.ms.photoapp.api.users.shared.UserDto;


public interface UserService {

  public UserDto createUser(UserDto userDetails);

}