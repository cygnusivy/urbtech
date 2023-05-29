package com.urbtech.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComentarioDtoRequest {

    private Long idPost;

    private Long idUsuarioComentario;

    private String comentario;

}
