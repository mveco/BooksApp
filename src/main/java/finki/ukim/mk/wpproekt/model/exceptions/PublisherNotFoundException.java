package finki.ukim.mk.wpproekt.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class PublisherNotFoundException extends RuntimeException{
    public PublisherNotFoundException() {
        super("Publisher was not found");
    }
}





