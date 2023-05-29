package com.urbtech.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDtoRequest {

    private String email;

    private String senha;

}