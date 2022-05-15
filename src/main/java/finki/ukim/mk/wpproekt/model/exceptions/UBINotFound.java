package finki.ukim.mk.wpproekt.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UBINotFound extends RuntimeException{
    public UBINotFound() {
        super("UBI was not found");
    }
}