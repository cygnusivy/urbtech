package com.urbtech.api.controller;

import com.urbtech.api.dto.request.ComunidadeDtoRequest;
import com.urbtech.api.dto.response.PostDtoResponse;
import com.urbtech.domain.model.ComunidadeModel;
import com.urbtech.domain.service.ComunidadeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("comunidade")
public class ComunidadeController {

    private ComunidadeService comunidadeService;

    @PostMapping("abrirComunidade")
    public ComunidadeModel criarNovaComunidade(@Valid @RequestBody ComunidadeDtoRequest comunidadeDtoRequest){
        return this.comunidadeService.salvar(comunidadeDtoRequest);
    }

    @GetMapping("selecionaPostagensDaComunidade/{id}")
    public List<PostDtoResponse> selecionaPostagensDaComunidade(@Valid @PathVariable Long id){
        return this.comunidadeService.postRequestList(id);
    }

}