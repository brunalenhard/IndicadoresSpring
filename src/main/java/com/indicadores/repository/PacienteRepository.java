package com.indicadores.repository;

import com.indicadores.domain.Paciente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Integer> {

    List<Paciente> findByNome(String nome);
}
