package system.authorization.token;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

/**
 * Created by KAI on 4/15/18.
 */
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private String userId;
    private String name;
    private String token;


    public JwtAuthenticationToken(Object principal, Object credentials, String userId, String name, String token) {
        super(principal, credentials);
        this.userId = userId;
        this.name = name;
        this.token = token;
    }

    public JwtAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, String token) {
        super(principal, credentials, AuthorityUtils.NO_AUTHORITIES);
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }



    @Override
    public Object getCredentials() {
        return  "N/A";
    }

    @Override
    public Object getPrincipal() {
        return name;
    }
}
