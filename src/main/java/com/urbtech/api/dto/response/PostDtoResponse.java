package com.urbtech.api.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostDtoResponse {

    private Long id;

    private String nomeUsuario;

    private String imgUrlUsuario;

    private String imgUrl;

    private String descricao;

    private Long qtdCurtidas;

    private List<ComentarioResponse> listaComentario;

}