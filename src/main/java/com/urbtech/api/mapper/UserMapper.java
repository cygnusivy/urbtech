package com.urbtech.api.mapper;

import com.urbtech.api.dto.response.UserDtoResponse;
import com.urbtech.domain.model.UserModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserMapper {

    private ModelMapper modelMapper;

    public UserDtoResponse userModelToRequest(Optional<UserModel> userModel){
        return modelMapper.map(userModel.get(), UserDtoResponse.class);
    }

    public UserModel userRequestToModel(UserDtoResponse userDtoResponse){
        return modelMapper.map(userDtoResponse, UserModel.class);
    }

}