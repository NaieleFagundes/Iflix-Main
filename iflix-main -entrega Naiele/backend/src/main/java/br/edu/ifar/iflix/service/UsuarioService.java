package br.edu.ifar.iflix.service;

import br.edu.ifar.iflix.model.Categoria;
import br.edu.ifar.iflix.model.Usuario;
import br.edu.ifar.iflix.repository.UsuarioRepository;
import jakarta.persistence.OrderBy;
import jakarta.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.beans.Transient;
import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usu;

    public UsuarioService (UsuarioRepository u){
        this.usu =u;
    }

    //busca todos os usuários
     public List<Usuario> buscarTodos(){
        return this.usu.findAll(Sort.by(Order.asc("nome"))  );
    }
    //salva novo usuário
    public void gravar(Usuario us){
        this.usu.save(us);
    }

    //busca o usuário pela ID dele
    public Usuario buscaPorId(int id){
        return this.usu.findById(id)
        .orElseThrow( () ->  new  ResponseStatusException(
            HttpStatus.NOT_FOUND, "Usário não encontrado"
        ) ) ;
    }

    //atualizar usuário existente
    public Usuario atualizarUsuario (int id,Usuario atUsuario){
        Usuario usuarioExis = buscaPorId(id);

        usuarioExis.setNome(atUsuario.getNome());
        usuarioExis.setEmail(atUsuario.getEmail());
        usuarioExis.setSenha(atUsuario.getSenha());
        usuarioExis.setTipo(atUsuario.getTipo());

        return this.usu.save(usuarioExis);
    }
   
    //excluir usuário
    public void excluir (int id){
        Usuario usuarioExis = buscaPorId(id);
        this.usu.delete (usuarioExis);
    }

}
