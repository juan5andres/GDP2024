package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Articulo;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Proveedor;
import com.gestiondeproyectos.ProgramaGestionDeInventario.service.ArticuloService;
import com.gestiondeproyectos.ProgramaGestionDeInventario.service.CategoriaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticuloController {

    private final ArticuloService articuloService;

    private CategoriaService categoriaService;

    @Autowired
    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping("/agregarArticulo")
    public String agregarArticulo(Articulo articulo, Model modelCategorias){
        var categorias = categoriaService.listarCategorias();
        modelCategorias.addAttribute("categorias", categorias);
        return "crearArticulo";
    }
    
    @PostMapping("/guardarArticulo")
    public String guardarArticulo(Articulo articulo, Model model){
        var categorias = categoriaService.listarCategorias();
        model.addAttribute("categorias", categorias);
        articuloService.guardar(articulo);
        return "redirect:/";
    }


    @GetMapping("/editarArticulo/{iden}")
    public String editarArticulo(Articulo articulo, Model modelArticulo, Model modelCategoria) {
        var categorias = categoriaService.listarCategorias();
        modelCategoria.addAttribute("categorias", categorias);
        articulo = articuloService.encontrarArticulo(articulo);
        modelArticulo.addAttribute("articulo", articulo);
        return "crearArticulo";
    }
    
    @GetMapping("/eliminarArticulo")
    public String eliminarArticulo(Articulo articulo) {
        articuloService.eliminar(articulo);
        return "redirect:/";
    }


    @GetMapping("/listarArticulos")
    public String listarArticulos(Model model) {
        List<Articulo> articulos = articuloService.listarArticulos();
        model.addAttribute("articulos", articulos);
        return "listarArticulos";
    }
}
