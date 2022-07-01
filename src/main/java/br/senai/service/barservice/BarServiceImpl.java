package br.senai.service.barservice;

import br.senai.model.Bar;
import br.senai.repository.BarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarServiceImpl implements BarService{

    @Autowired
    BarRepository barRepository;

    @Override
    public List<Bar> findAll() {
        return barRepository.findAll(Sort.by("nome"));
    }

    @Override
    public Bar findById(Long id){
        Optional listBar = barRepository.findById(id);
        if (!listBar.isEmpty()){
            return (Bar) listBar.get();
        } else {
            return new Bar();
        }

    }

    @Override
    public Bar findByNome
            (String nome) {
        return barRepository.findByNome(nome);
    }
}
