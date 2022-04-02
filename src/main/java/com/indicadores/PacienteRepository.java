package com.indicadores;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.image.PackedColorModel;
import java.util.List;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Integer> {

    List<Paciente> findByNome(String nome);
}
