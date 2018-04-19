package system.authorization.service;

import system.authorization.domain.User;
import system.authorization.request.RegistrationRequest;

import javax.validation.Valid;

/**
 * Created by KAI on 4/15/18.
 */
public interface UserService {
    User loadUserByUserName(String s);

    User registerUser(@Valid RegistrationRequest registrationRequest);
}
