package softuni.bg.finalproject.services;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import softuni.bg.finalproject.models.EcontUserDetails;
import softuni.bg.finalproject.models.Role;
import softuni.bg.finalproject.models.User;
import softuni.bg.finalproject.models.UserRole;
import softuni.bg.finalproject.repository.UserRepository;


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
        return new EcontUserDetails(
                user.getEmail(),
                user.getPassword(),
                user.getRoles().stream().map(UserRole::getRole).map(EcontUserDetailsService::map).toList(),
                user.getFirstName(),
                user.getLastName()
        );
    }

    private static GrantedAuthority map(Role role) {
        return new SimpleGrantedAuthority("ROLE_" + role);
    }
}
