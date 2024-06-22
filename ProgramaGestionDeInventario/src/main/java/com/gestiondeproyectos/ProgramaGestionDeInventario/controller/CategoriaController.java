package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gestiondeproyectos.ProgramaGestionDeInventario.service.CategoriaService;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Categoria;

@Controller
public class CategoriaController{
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/agregarCategoria")
    public String agregarCategoria(Categoria categoria) {
        // Va a retornar otra vista llamada 'modificar' que estará definida en
        // '/templates/modificar.html'
        // Se va a llamar 'modificar' ya que va a realizar los dos casos de uso: agregar
        // y modificar
        return "modificarCategoria";
    }

    @PostMapping("/guardarCategoria")
    public String guardarCategoria(Categoria categoria) {
        categoriaService.guardar(categoria);
        return "redirect:/";
        }

    @GetMapping("/editarCategoria/{idCategoria}")
    public String editarCategoria(Categoria categoria, Model model) {
        categoria = categoriaService.encontrarCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "modificarCategoria";
    }

    @GetMapping("/eliminarCategoria")
    public String eliminarCategoria(Categoria categoria) {
        if(categoriaService.categoriaNoVinculada(categoria)){
            categoriaService.eliminar(categoria);
            return "redirect:/";
        }
        else{
            return "redirect:/";
        }
    }

}