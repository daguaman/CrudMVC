package com.crud.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.crud.demo.models.entity.Docente;
import com.crud.demo.models.service.IDocenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class DocenteController {
	
	@Autowired
	private IDocenteService service;
	
	@GetMapping("/listarDocente")
	public String listar(Model model) {
		List<Docente> docentes = service.findAll();
		model.addAttribute("docentes",docentes);
		return "listarDocente";
	}
	
	@GetMapping("/newDocente")
	public String agregar(Model model) {
		model.addAttribute("docente", new Docente());
		return "addDocente";
	}
	
	@PostMapping("/saveDocente")
	public String save(@Valid Docente d, Model model) {
		service.save(d);
		return "redirect:/listarDocente";
		
	}
	
	// @GetMapping("/editarDocente/{idDocente}")
	// public String editar(@PathVariable Long idDocente, Docente docente) {
	// 	Docente docente = service.findById(idDocente);
	// 	model.addAttribute("docente",docente);
	// 	return "addDocente";
		
	// }
	
	@GetMapping("/eliminarDocente/{idDocente}")
	public String eliminar(Model model, @PathVariable Long idDocente) {
		service.deleteById(idDocente);
		return "redirect:/listarDocente";
		
	}
}
