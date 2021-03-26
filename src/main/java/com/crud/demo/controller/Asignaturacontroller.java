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

import com.crud.demo.interfaceService.IAsignaturaService;
import com.crud.demo.model.Asignatura;

//En vez de controller cambiarle a Rest
@Controller
@RequestMapping
public class Asignaturacontroller {

	@Autowired
	private IAsignaturaService service;
	
	@GetMapping("/listarAsignatura")
	public String listar(Model model) {
		List<Asignatura> asignaturas = service.listar();
		model.addAttribute("asignaturas",asignaturas);
		return "listarAsignatura";
	}
	
	@GetMapping("/newAsignatura")
	public String agregar(Model model) {
		model.addAttribute("asignatura",new Asignatura());
		return "addAsignatura";
	}
	
	@PostMapping("/saveAsignatura")
	public String save(@Valid Asignatura a, Model model) {
		service.Save(a);
		return "redirect:/listarAsignatura";
		
	}
	
	@GetMapping("/editarAsignatura/{idAsignatura}")
	public String editar(@PathVariable int idAsignatura, Model model) {
		Optional<Asignatura>asignatura = service.listarid(idAsignatura);
		model.addAttribute("asignatura",asignatura);
		return "addAsignatura";
		
	}
	
	@GetMapping("/eliminarAsignatura/{idAsignatura}")
	public String eliminar(Model model, @PathVariable int idAsignatura) {
		service.Delete(idAsignatura);
		return "redirect:/listarAsignatura";
		
	}
}
