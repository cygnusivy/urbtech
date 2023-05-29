package com.urbtech.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDtoRequest {

    private String nome;

    private String imgUrl;

    private String email;

    private String senha;

    private String senha2;

}