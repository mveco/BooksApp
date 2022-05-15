package finki.ukim.mk.wpproekt.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserBookInteractionNotFoundException extends RuntimeException{

    public UserBookInteractionNotFoundException() { super("UserBookInteraction not found"); }
}
