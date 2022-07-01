package br.senai.repository;

import br.senai.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

    public Usuario findUserByUsername(String username);
}