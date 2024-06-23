package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;

import com.gestiondeproyectos.ProgramaGestionDeInventario.service.CategoriaService;
import com.gestiondeproyectos.ProgramaGestionDeInventario.service.PersonaService;
import com.gestiondeproyectos.ProgramaGestionDeInventario.service.ProveedorService;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProveedorController {

    private final ProveedorService proveedorService;

    private PersonaService personaService;

    private CategoriaService categoriaService;

    @Autowired
    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping("/agregarProveedor")
    public String agregarProveedor(Proveedor proveedor, Model modelPersonas, Model modelCategorias){
        var personas = personaService.listarPersonas();
        var categorias = categoriaService.listarCategorias();
        modelPersonas.addAttribute("personas", personas);
        modelCategorias.addAttribute("categorias", categorias);
        return "modificarProveedor";
    }
    
    @PostMapping("/guardarProveedor")
    public String guardarProveedor(Proveedor proveedor, Model model){
        var personas = personaService.listarPersonas();
        var categorias = categoriaService.listarCategorias();
        model.addAttribute("personas", personas);
        model.addAttribute("categorias", categorias);
        proveedorService.guardar(proveedor);
        return "redirect:/";
    }

    @GetMapping("/editarProveedor/{iden}")
    public String editarProveedor(Proveedor proveedor, Model modelProveedor, Model modelPersona, Model modelCategoria) {
        var personas = personaService.listarPersonas();
        modelPersona.addAttribute("personas", personas);
        var categorias = categoriaService.listarCategorias();
        modelCategoria.addAttribute("categorias", categorias);
        proveedor = proveedorService.encontrarProveedor(proveedor);
        modelProveedor.addAttribute("proveedor", proveedor);
        return "modificarProveedor";
    }
    
    @PostMapping("/eliminarProveedor")
    public String eliminarProveedor(Proveedor proveedor) {
        proveedorService.eliminar(proveedor);
        return "redirect:/";
    }

    @GetMapping("/listarProveedores")
    public String listarProveedores(Model model) {
        List<Proveedor> proveedores = proveedorService.listarProveedores();
        model.addAttribute("proveedores", proveedores);
        return "listarProveedores";
    }
}
