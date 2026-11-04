package br.edu.ifar.iflix.controller;

import br.edu.ifar.iflix.model.Usuario;
import br.edu.ifar.iflix.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/usuario")

public class UsuarioController {

    private UsuarioService serviceUsu;

    public UsuarioController (UsuarioService usua){
        this.serviceUsu = usua;
    }

    @GetMapping
    public List<Usuario> buscarTodos(){
        return this.serviceUsu.buscarTodos();
    }

    @PostMapping
    public Usuario gravar( @RequestBody Usuario usuario){
        this.serviceUsu.gravar(usuario);
        return usuario;   
    }
   
    @GetMapping("/{id}") 
    public Usuario buscaPorId( @PathVariable int id ){
        return this.serviceUsu.buscaPorId(id);
    }

    @PutMapping ("/{id}") 
    public Usuario atualizar(  @PathVariable int id, @RequestBody Usuario usuario){
        return this.serviceUsu.atualizarUsuario(id, usuario);   
    }

    @DeleteMapping ("/{id}") 
    public void excluir(@PathVariable int id) {
        this.serviceUsu.excluir(id);
    }


}
