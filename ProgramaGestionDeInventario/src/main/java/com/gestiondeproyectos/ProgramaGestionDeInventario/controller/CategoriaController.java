package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gestiondeproyectos.ProgramaGestionDeInventario.service.CategoriaService;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Categoria;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoriaController{
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/agregarCategoria")
    public String mostrarFormularioCrearCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "crearCategoria";
    }

    @PostMapping("/agregarCategoria")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        if (categoria.getIden() != null) {
            // Actualizar categoría existente
            Categoria categoriaExistente = categoriaService.obtenerCategoriaPorId(categoria.getIden());
            if (categoriaExistente != null) {
                categoriaExistente.setDescripcion(categoria.getDescripcion());
                if(categoriaService.findByDesc(categoriaExistente.getDescripcion()) == null){
                    categoriaService.guardar(categoriaExistente);
                }
                else{
                    return "crearCategoria";
                }
            }
        } else {
            // Crear nueva categoría
            Categoria categoriaAux = categoriaService.findByDesc(categoria.getDescripcion());
            if (categoriaAux!=null && !categoriaAux.getIden().equals(categoria.getIden()) && categoriaAux.getDescripcion().equals(categoria.getDescripcion())){
                return "crearCategoria";
            }
            categoriaService.guardar(categoria);
        }
        return "redirect:/listarCategorias";
    }

    @GetMapping("/editarCategoria/{id}")
    public String mostrarFormularioEditarCategoria(@PathVariable("id") Long id, Model model) {
        Categoria categoria = categoriaService.obtenerCategoriaPorId(id);
        if (categoria != null) {
            model.addAttribute("categoria", categoria);
            return "crearCategoria";
        }
        return "redirect:/listarCategorias";
    }

    @PostMapping("/eliminarCategoria/{iden}")
    public String eliminarCategoria(@PathVariable("iden") Long id, Model model) {
        try {
            Categoria categoria = categoriaService.obtenerCategoriaPorId(id);
            categoriaService.eliminar(categoria);
        } catch (IllegalStateException e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/listarCategorias?error=" + e.getMessage();
        }
        return "redirect:/listarCategorias";
    }

    @GetMapping("/listarCategorias")
    public String listarCategorias(Model model) {
        var categorias = categoriaService.listarCategorias();
        model.addAttribute("categorias", categorias);
        return "listarCategorias";
    }


}