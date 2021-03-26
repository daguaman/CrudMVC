package com.crud.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.demo.interfaceService.IDocenteService;
import com.crud.demo.model.Docente;

@Controller
@RequestMapping
public class Docentecontroller {
	@Autowired
	private IDocenteService service;
	
	@GetMapping("/listarDocente")
	public String listar(Model model) {
		List<Docente> docentes = service.listar();
		model.addAttribute("docentes",docentes);
		return "listarDocente";
	}
	
	@GetMapping("/newDocente")
	public String agregar(Model model) {
		model.addAttribute("docente",new Docente());
		return "addDocente";
	}
	
	@PostMapping("/saveDocente")
	public String save(@Valid Docente d, Model model) {
		service.Save(d);
		return "redirect:/listarDocente";
		
	}
	
	@GetMapping("/editarDocente/{idDocente}")
	public String editar(@PathVariable int idDocente, Model model) {
		Optional<Docente>docente = service.listarId(idDocente);
		model.addAttribute("docente",docente);
		return "addDocente";
		
	}
	
	@GetMapping("/eliminarDocente/{idDocente}")
	public String eliminar(Model model, @PathVariable int idDocente) {
		service.Delete(idDocente);
		return "redirect:/listarDocente";
		
	}
}
