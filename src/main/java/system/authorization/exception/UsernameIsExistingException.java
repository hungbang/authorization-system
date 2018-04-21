package system.authorization.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by KAI on 4/20/18.
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class UsernameIsExistingException extends Exception {
    public UsernameIsExistingException(String s) {
        super(s);
    }

    public UsernameIsExistingException() {
        super();
    }

    public UsernameIsExistingException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameIsExistingException(Throwable cause) {
        super(cause);
    }

    protected UsernameIsExistingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
