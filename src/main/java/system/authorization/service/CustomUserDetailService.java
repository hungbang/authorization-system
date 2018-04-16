package system.authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import system.authorization.domain.CustomUserDetail;
import system.authorization.domain.User;

import java.util.Objects;

/**
 * Created by KAI on 4/15/18.
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public CustomUserDetail loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.loadUserByUserName(s);
        if(Objects.isNull(user))
            throw new UsernameNotFoundException(s);

        return new CustomUserDetail(user);
    }
}
