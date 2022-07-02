package br.senai.service.barservice;

import br.senai.model.Bar;

import java.util.List;

public interface BarService {
    public List<Bar> findAll();
    public Bar findById(Long id);
    public Bar findByNome(String nome);
}
