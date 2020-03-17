package cloud.frizio.ms.photoapp.api.users.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.frizio.ms.photoapp.api.users.data.UserEntity;
import cloud.frizio.ms.photoapp.api.users.data.UserRepository;
import cloud.frizio.ms.photoapp.api.users.shared.UserDto;

@Service
public class UserServiceImpl implements UserService {

  UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }


  @Override
  public UserDto createUser(UserDto userDetails) {
    ModelMapper modelMapper  = new ModelMapper();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    userDetails.setUserId(UUID.randomUUID().toString());
    UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
    userEntity.setEncryptedPassword("HASH1234");
    userRepository.save(userEntity);
    UserDto userCreated = modelMapper.map(userEntity, UserDto.class);
    return userCreated;
  }

  
}