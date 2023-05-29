package com.urbtech.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDtoRequest {

    private String imgUrl;

    private Long idUsuario;

    private String descricao;

}