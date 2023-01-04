package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@GetMapping({"index","/","/home"})
	public String index(Model model) {
		model.addAttribute("titulo","hola spring  con Model");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		
		Usuario usuario= new Usuario();
		//objetos
		usuario.setNombre("diego");
		usuario.setApellido("garcia");
		usuario.setEmail("diego@hotmail.com");
		
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo","Perfil de usuarios: ".concat(usuario.getNombre())+" ".concat(usuario.getApellido()));
		
		return"perfil";
		}
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		List<Usuario> usuarios = new ArrayList<>();
		model.addAttribute("titulo","Listado de Usuario");
		model.addAttribute("usuarios",usuarios);
		return "listar";
	}
}
