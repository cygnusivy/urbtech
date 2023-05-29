package com.urbtech.api.mapper;

import com.urbtech.api.dto.request.ComentarioDtoRequest;
import com.urbtech.api.dto.response.ComentarioResponse;
import com.urbtech.domain.model.ComentarioModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ComentarioMapper {

    private ModelMapper modelMapper;

    public ComentarioModel dtoToModel(ComentarioDtoRequest comentarioDtoRequest){
        return this.modelMapper.map(comentarioDtoRequest, ComentarioModel.class);
    }

    public ComentarioResponse modelToRequest(ComentarioModel comentarioModel){
        return this.modelMapper.map(comentarioModel, ComentarioResponse.class);
    }

}