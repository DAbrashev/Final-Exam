package softuni.bg.finalproject.services;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import softuni.bg.finalproject.models.User;
import softuni.bg.finalproject.repository.UserRepository;

@Service
public class EcontUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public EcontUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(EcontUserDetailsService::map)
                .orElseThrow(() -> new UsernameNotFoundException("Username with email: " + email + " not found!"));
    }

    private static UserDetails map(User user) {
        return new EcontUserDetailsService(

        );
    }
}
