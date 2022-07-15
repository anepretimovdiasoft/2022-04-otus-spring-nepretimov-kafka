package ru.diasoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ru.diasoft.domain.GreetingMessage;
import ru.diasoft.kafka.GreetingGateway;

import java.util.Date;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingGateway gateway;

    @GetMapping(value = "/hiall/{name}")
    public ResponseEntity<String> hiAll(@PathVariable String name) {
        String message = "Hi, " + name + "!";

        gateway.broadcastGreet("Broadcast: " + message);

        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @GetMapping (value = "/hi/{name}")
    public ResponseEntity<String> hi(@RequestHeader("Authorization") String authorizationToken, @PathVariable String name) {
        String message = "Hi, " + name + "!";

        gateway.directGreet(GreetingMessage.builder().id(Long.valueOf(new Date().getTime())).message(message).jwt(authorizationToken).build());

        return new ResponseEntity<String>(message, HttpStatus.OK);
    }
}
