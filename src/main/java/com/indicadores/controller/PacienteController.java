package com.indicadores.controller;

import com.indicadores.controller.model.PacienteResponse;
import com.indicadores.domain.Paciente;
import com.indicadores.mapper.PacienteMapper;
import com.indicadores.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Component
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    public Paciente criaPaciente(@RequestBody Paciente paciente){
        return service.criarPaciente(paciente);
    }

    @GetMapping
    public Iterable<Paciente> buscarTodos(){
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public Paciente buscaPorId(@PathVariable("id") Integer id){
        return service.findById(id);
    }

}
