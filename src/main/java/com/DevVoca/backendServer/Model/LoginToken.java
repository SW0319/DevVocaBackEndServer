package com.DevVoca.backendServer.Model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LoginToken {

    @Builder
    public LoginToken() {}
    String token;
    String email;
    String name;

}
