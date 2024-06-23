package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;

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

    @Autowired
    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

       @GetMapping("/agregarProveedor")
    public String agregarProveedor(Proveedor proveedor, Model model){
        var personas = personaService.listarPersonas();
        model.addAttribute("personas", personas);
        return "modificarProveedor";
    }
    
    @PostMapping("/guardarProveedor")
    public String guardarProveedor(Proveedor proveedor, Model model){
        var personas = personaService.listarPersonas();
        model.addAttribute("personas", personas);
        proveedorService.guardar(proveedor);
        return "redirect:/";
    }

    @GetMapping("/editarProveedor/{iden}")
    public String editarProveedor(Proveedor proveedor, Model modelProveedor, Model modelPersona) {
        var personas = personaService.listarPersonas();
        modelPersona.addAttribute("personas", personas);
        proveedor = proveedorService.encontrarProveedor(proveedor);
        modelProveedor.addAttribute("proveedor", proveedor);
        return "modificarProveedor";
    }
    
    @GetMapping("/eliminarProveedor")
    public String eliminarProveedor(Proveedor proveedor, Model model) {
        proveedor = proveedorService.encontrarProveedor(proveedor);
        proveedor.setBaja(true);
        model.addAttribute("proveedor", proveedor);
        return "redirect:/";
    }

    @GetMapping("/listarProveedores")
    public String listarProveedores(Model model) {
        List<Proveedor> proveedores = proveedorService.listarProveedores();
        model.addAttribute("proveedores", proveedores);
        return "listarProveedores";
    }
}
