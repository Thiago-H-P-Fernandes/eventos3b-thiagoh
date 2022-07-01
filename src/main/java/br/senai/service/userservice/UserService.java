package br.senai.service.userservice;

import br.senai.model.Usuario;

import java.util.List;

public interface UserService {

    public boolean createUsuario(Usuario usuario);

    public List<Usuario> findAllUsuarios();

}