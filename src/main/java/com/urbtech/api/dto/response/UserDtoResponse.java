package com.urbtech.api.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserDtoResponse {

    private Long id;

    private String nome;

    private String email;

    private String imgUrl;

    private String descricao;

    private String localizacao;

    private String site;

    private LocalDate nascimento;

}