package system.authorization.service;

import system.authorization.domain.User;

/**
 * Created by KAI on 4/15/18.
 */
public interface UserService {
    User loadUserByUserName(String s);
}
