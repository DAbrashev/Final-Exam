package softuni.bg.finalproject.services;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.bg.finalproject.models.User;
import softuni.bg.finalproject.models.dtos.UserRegisterDTO;
import softuni.bg.finalproject.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    public boolean doRegister(UserRegisterDTO userRegisterDTO) {
        Optional<User> byEmail = userRepository.findByEmail(userRegisterDTO.getEmail());
        if (byEmail.isPresent()){
            return false;
        }
        if (!userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())){
            return false;
        }
        User user = modelMapper.map(userRegisterDTO, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        userRepository.save(user);
        return true;
    }
}
