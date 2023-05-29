package com.urbtech.api.mapper;

import com.urbtech.api.dto.request.PostDtoRequest;
import com.urbtech.api.dto.response.PostDtoResponse;
import com.urbtech.domain.model.PostModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PostMapper {

    private ModelMapper modelMapper;

    public PostModel dtoToEntity (PostDtoRequest postDtoRequest){
        return modelMapper.map(postDtoRequest, PostModel.class);
    }

    public PostDtoResponse entityToRequest (PostModel postModel){
        return this.modelMapper.map(postModel, PostDtoResponse.class);
    }

}