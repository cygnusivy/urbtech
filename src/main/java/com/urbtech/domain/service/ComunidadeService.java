package com.urbtech.domain.service;

import com.urbtech.api.dto.request.ComunidadeDtoRequest;
import com.urbtech.api.dto.response.PostDtoResponse;
import com.urbtech.domain.exception.BusinessException;
import com.urbtech.domain.model.ComunidadeModel;
import com.urbtech.domain.model.UsuarioComunidadeModel;
import com.urbtech.domain.repository.ComunidadeRepository;
import com.urbtech.domain.repository.UsuarioComunidadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ComunidadeService {

    private ComunidadeRepository comunidadeRepository;

    private UserService userService;

    private PostService postService;

    private UsuarioComunidadeRepository usuarioComunidadeRepository;

    @Transactional
    public ComunidadeModel salvar(ComunidadeDtoRequest comunidadeDtoRequest){
        if (this.comunidadeRepository.existsByNomeComunidade(comunidadeDtoRequest.getNomeComunidade())){
            throw new BusinessException("Já exixte uma comunidade com mesmo nome.");
        }
        ComunidadeModel comunidadeModel = new ComunidadeModel();
        comunidadeModel.setNomeComunidade(comunidadeDtoRequest.getNomeComunidade());
        comunidadeModel.setDataCriacaoComunidade(LocalDateTime.now());

        return this.comunidadeRepository.save(comunidadeModel);
    }

    public List<PostDtoResponse> postRequestList(Long idComunidade){
        this.userService.validaExistenciaDaComunidade(idComunidade);

        List<PostDtoResponse> postDtoResponseList = new ArrayList<>();

        List<Long> idUsuariosList = new ArrayList<>();

        List<UsuarioComunidadeModel> usuarioComunidadeModelList = this.usuarioComunidadeRepository.findAllByIdComunidade(idComunidade);

        for (UsuarioComunidadeModel usuarioComunidadeModel : usuarioComunidadeModelList){
            Long idUsuario = usuarioComunidadeModel.getIdUsuario();
            idUsuariosList.add(idUsuario);
        }

        for (Long idUsuario : idUsuariosList){
            List<PostDtoResponse> list = this.postService.postRequestListPeloIdUsuario(idUsuario);
            for (PostDtoResponse postDtoResponse : list){
                postDtoResponseList.add(postDtoResponse);
            }
        }

        return postDtoResponseList;

    }
}
