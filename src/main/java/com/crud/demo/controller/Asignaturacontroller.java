package com.crud.demo.controller;

import java.util.List;

import javax.validation.Valid;

import com.crud.demo.models.entity.Asignatura;
import com.crud.demo.models.service.IAsignaturaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//En vez de controller cambiarle a Rest
@Controller
@RequestMapping
public class AsignaturaController {

	@Autowired
	private IAsignaturaService service;
	
	@GetMapping("/listarAsignatura")
	public String listar(Model model) {
		List<Asignatura> asignaturas = service.findAll();
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
		service.save(a);
		return "redirect:/listarAsignatura";
		
	}
	
	// @GetMapping("/editarAsignatura/{idAsignatura}")
	// public String editar(@PathVariable Long idAsignatura, Model model) {
	// 	Asignatura asignatura = service.findById(idAsignatura);
	// 	model.addAttribute("asignatura",asignatura);
	// 	return "addAsignatura";
		
	// }
	
	@GetMapping("/eliminarAsignatura/{idAsignatura}")
	public String eliminar(Model model, @PathVariable Long idAsignatura) {
		service.deleteById(idAsignatura);
		return "redirect:/listarAsignatura";
		
	}
}
