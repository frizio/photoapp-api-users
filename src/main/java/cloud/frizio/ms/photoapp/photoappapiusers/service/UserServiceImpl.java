package cloud.frizio.ms.photoapp.photoappapiusers.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.frizio.ms.photoapp.photoappapiusers.data.UserEntity;
import cloud.frizio.ms.photoapp.photoappapiusers.data.UsersRepository;
import cloud.frizio.ms.photoapp.photoappapiusers.shared.UserDto;

@Service
public class UserServiceImpl implements UserService {

  UsersRepository usersRepository;

  @Autowired
  public UserServiceImpl(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }


  @Override
  public UserDto createUser(UserDto userDetails) {
    userDetails.setUserId(UUID.randomUUID().toString());
    ModelMapper modelMapper  = new ModelMapper();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
    userEntity.setEncryptedPassword("HASH1234");
    usersRepository.save(userEntity);
    return null;
  }

  
}