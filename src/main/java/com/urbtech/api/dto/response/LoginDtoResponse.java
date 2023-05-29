package com.urbtech.api.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LoginDtoResponse {

    private String email;

    @JsonIgnore
    private String senha;

    private String indLoginSucesso;

    private LocalDate loginDate;

    private Long idUser;

}