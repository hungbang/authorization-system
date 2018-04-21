package system.authorization.model;

import system.authorization.domain.User;

import java.io.Serializable;

/**
 * Created by KAI on 4/21/18.
 */
public class WrapperUserResponse implements Serializable{

    private String userId;

    public WrapperUserResponse(User user) {
        this.createResponse(user);
    }

    private void createResponse(User user) {
        this.userId = user.getId();
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
