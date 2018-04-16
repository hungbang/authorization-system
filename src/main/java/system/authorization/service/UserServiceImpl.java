package system.authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import system.authorization.domain.User;
import system.authorization.repository.UserRepository;

import java.util.Optional;

/**
 * Created by KAI on 4/15/18.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User loadUserByUserName(String s) {
        Optional<User> user = userRepository.findByUsername(s);

        if(!user.isPresent())
            throw new UsernameNotFoundException("Username not found");

        return user.get();
    }
}
