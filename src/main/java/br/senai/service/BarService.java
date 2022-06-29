package br.senai.service;

import br.senai.model.Bar;
import br.senai.model.Cliente;

import java.util.List;

public interface BarService {
    public List<Bar> findAll();
    public Bar findById(Long id);
    public Bar findByNome(String nome);
}
