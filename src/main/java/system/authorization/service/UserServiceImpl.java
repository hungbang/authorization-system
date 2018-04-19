package system.authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.authorization.domain.User;
import system.authorization.repository.UserRepository;
import system.authorization.request.RegistrationRequest;

import javax.validation.Valid;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by KAI on 4/15/18.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User loadUserByUserName(String s) {
        User user = userRepository.findByUsername(s);
        if(Objects.isNull(user))
            throw new UsernameNotFoundException("Username not found");
        return user;
    }

    @Override
    @Transactional
    public User registerUser(@Valid RegistrationRequest registrationRequest) {
        return this.saveUser(this.createUser(registrationRequest));
    }

    private User saveUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }


    private User createUser(@Valid RegistrationRequest registrationRequest) {
        User user = new User();
        user.setUsername(registrationRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        user.markAccountNonExpired();
        user.markAccountNonLocked();
        user.markCredentialsNonExpired();
        return user;
    }
}
