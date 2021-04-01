package com.crud.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.demo.models.entity.AsgDocente;
import com.crud.demo.models.entity.Asignatura;
import com.crud.demo.models.entity.Docente;
import com.crud.demo.models.serviceImp.IAsgDocenteService;
import com.crud.demo.models.serviceImp.IAsignaturaService;
import com.crud.demo.models.serviceImp.IDocenteService;

@Controller
@RequestMapping
public class AsgDocenteController {

	@Autowired
	private IDocenteService serviceDoc;
	@Autowired
	private IAsignaturaService serviceAsg;
	
	@Autowired
	private IAsgDocenteService serviceAsgDoc;
	
	private List<AsgDocente> listaAsgdocentes=null;
	
	@GetMapping("/listarAsgDocente")
	public String listarAsgDoc(@PathVariable Long idAsignatura, Model model) {
		List<Docente> docentes = serviceDoc.listar();
		Long idDoc = (long) 0;
		for (Docente docente : docentes) {
			idDoc = docente.getId();
			AsgDocente objAsgdoc = new AsgDocente(idAsignatura, idDoc);
			listaAsgdocentes.add(objAsgdoc);
		}
		model.addAttribute("asgdoc",listaAsgdocentes);
		return "listarAsgDoc";
	}
	
	@GetMapping("/newAsignaturaDocente")
	public String agregar(Model model) {
		model.addAttribute("asgdocente",new AsgDocente());
		
		List<Asignatura> asignaturas = serviceAsg.listar();
		model.addAttribute("asignaturas", asignaturas);
	    model.addAttribute("asignatura", new Asignatura());
	    List<Docente> docentes = serviceDoc.listar();
		model.addAttribute("docentes", docentes);
	    model.addAttribute("docente", new Docente());
		return "addAsgDocente";
	}
	
	

	@PostMapping("/saveAsgDocente")
	public String save(@ModelAttribute ("asgdocente") 
						Asignatura asignaturaform, Docente docenteform,
						Model model) {
		Long idDoc = docenteform.getId();
		Long idAsg = asignaturaform.getId();
		System.out.println("Docente "+  idDoc + "Asig " + idAsg);
		Asignatura objAsignatura = new Asignatura();
		objAsignatura.setId(idAsg);
		AsgDocente objAsgDoc = new AsgDocente(idDoc,idAsg);
		serviceAsgDoc.Save(objAsgDoc);
		return "redirect:/listarAllAsgDocente";
	}
	
	
	@GetMapping("/listarAllAsgDocente")
	public String listarAll(Model model) {
		listaAsgdocentes = new ArrayList<AsgDocente>();
		
		try {
		List<AsgDocente> lista = serviceAsgDoc.listar();
		for (AsgDocente asgDocente : lista) {
			Long idAsignatura = asgDocente.getIdAsg();
			Long idDocente = asgDocente.getIdDoc();
			Optional<Asignatura>asignatura = serviceAsg.listarid(idAsignatura);
			Optional<Docente>docente = serviceDoc.listarId(idDocente);
			AsgDocente objAsgdoc = new AsgDocente(asgDocente.getIdDoc(),
												  asgDocente.getIdAsg(), 
												  asignatura.get().getNombre(),
												  asignatura.get().getCodigo(),
												  docente.get().getNombres(),
												  docente.get().getIdentificacion()
												  );
			listaAsgdocentes.add(objAsgdoc);
		}
		}catch(Exception ex)
		{
			
			System.out.println("Exception " + ex.getMessage());
		}
		model.addAttribute("listaAsgdocentes",listaAsgdocentes);
		return "listarAsgDocente";
	}
}
