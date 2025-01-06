package br.edu.CadastroDeProduto.controller;

import br.edu.CadastroDeProduto.dto.ProdutoInputDTO;
import br.edu.CadastroDeProduto.dto.ProdutoOutputDTO;
import br.edu.CadastroDeProduto.model.Produto;
import br.edu.CadastroDeProduto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api3/produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<ProdutoOutputDTO>> listar(){
        List<Produto> produtos = produtoRepository.findAll();
        if(produtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            List<ProdutoOutputDTO> produtoOutputDTOS = new ArrayList<>();
            for(Produto p:produtos){
                produtoOutputDTOS.add(new ProdutoOutputDTO(p));
            }
            return new ResponseEntity<>(produtoOutputDTOS, HttpStatus.OK);
        }
    }

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutoOutputDTO> create(@RequestBody ProdutoInputDTO produtoInputDTO){
        try{
            Produto produto = produtoInputDTO.build();
            Produto prodSalvo = produtoRepository.save(produto);
            return new ResponseEntity<>(new ProdutoOutputDTO(prodSalvo), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutoOutputDTO> getByID(@PathVariable Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isPresent()){
            return new ResponseEntity<>(new ProdutoOutputDTO(produto.get()), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isPresent()){
            produtoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Não existe este produto", HttpStatus.NOT_FOUND);
        }
    }

}
