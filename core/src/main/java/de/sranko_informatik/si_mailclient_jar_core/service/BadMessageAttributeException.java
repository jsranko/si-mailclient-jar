package de.sranko_informatik.si_mailclient_jar_core.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadMessageAttributeException extends RuntimeException {

    public BadMessageAttributeException(String msg) {
        super(msg);
    }
}
