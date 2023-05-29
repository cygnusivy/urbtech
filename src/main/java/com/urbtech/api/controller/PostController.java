package com.urbtech.api.controller;

import com.urbtech.api.dto.request.PostDtoRequest;
import com.urbtech.api.dto.response.PostDtoResponse;
import com.urbtech.domain.model.CurtidaModel;
import com.urbtech.domain.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("post")
public class PostController {

    private PostService postService;

    @PostMapping("postar")
    @ResponseStatus(HttpStatus.CREATED)
    public PostDtoRequest salvar(@Valid @RequestBody PostDtoRequest postDtoRequest){
        return this.postService.postar(postDtoRequest);
    }

    @PostMapping("curtir")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> curtir(@RequestBody CurtidaModel curtidaModel){
        this.postService.curtir(curtidaModel);
        return ResponseEntity.ok().build();
    }

    @GetMapping("selecionarPost/{id}")
    public PostDtoResponse selecionar(@PathVariable Long id){
        return this.postService.selecionarPost(id);
    }

    @GetMapping("selecionaListaPost/{id}")
    public List<PostDtoResponse> listarPosts(@Valid @PathVariable Long id){
        return this.postService.postRequestListPeloIdUsuario(id);
    }

    @DeleteMapping("deletarPost/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deletarPost(@PathVariable Long id){
        this.postService.deletarPost(id);
        return ResponseEntity.noContent().build();
    }

}