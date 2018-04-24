package org.bootcamp.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
class ResponseEntityUtils {
    private static final String NOT_FOUND_MESSAGE = "<h1>URL does not exist :(</h1>";

    public <Body> ResponseEntity<Body> wrapResponseEntity(Body calculationResult) {
        return new ResponseEntity<>(calculationResult, HttpStatus.OK);
    }

    public ResponseEntity getNotFoundResponseEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.TEXT_HTML);

        return new ResponseEntity<>(NOT_FOUND_MESSAGE, httpHeaders, HttpStatus.NOT_FOUND);
    }
}
