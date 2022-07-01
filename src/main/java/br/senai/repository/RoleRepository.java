package br.senai.repository;

import br.senai.model.Role;
import br.senai.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    public List<Role> findByUsuariosIn(Usuario... usuarios);

    public Role findByNome(String role_name);

}