package br.senai.repository;

import br.senai.model.Bar;
import br.senai.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarRepository extends JpaRepository<Bar, Long> {

    public Bar findByNome(String nome);
}
