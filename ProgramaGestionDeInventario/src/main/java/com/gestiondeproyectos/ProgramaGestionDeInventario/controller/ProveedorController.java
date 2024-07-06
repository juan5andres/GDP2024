package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Usuario;
import com.gestiondeproyectos.ProgramaGestionDeInventario.service.CategoriaService;
import com.gestiondeproyectos.ProgramaGestionDeInventario.service.ProveedorService;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProveedorController {

    @Autowired
    private final ProveedorService proveedorService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping("/crearProveedor")
    public String mostrarFormulario(Model model) {
        Proveedor proveedor = new Proveedor();
        proveedor.setBaja(false);
        model.addAttribute("proveedor", proveedor);
        return "crearProveedor";
    }

    @PostMapping("/crearProveedor")
    public String crearProveedor(Proveedor proveedor) {
        Proveedor proveedorAux = proveedorService.findByName(proveedor.getNombre());
        if (proveedorAux!=null && !proveedorAux.getIden().equals(proveedor.getIden()) && proveedorAux.getNombre().equals(proveedor.getNombre())){
            return "crearProveedor";
        }
        proveedor.setBaja(false);
        proveedorService.guardar(proveedor);
        return "redirect:/listarProveedores";
    }
    
    @PostMapping("/guardarProveedor")
    public String guardarProveedor(Proveedor proveedor, Model model){
        //var personas = personaService.listarPersonas();
        var categorias = categoriaService.listarCategorias();
        //model.addAttribute("personas", personas);
        model.addAttribute("categorias", categorias);
        proveedorService.guardar(proveedor);
        return "redirect:/";
    }

    @GetMapping("/editarProveedor/{iden}")
    public String editarProveedor(Proveedor proveedor, Model modelProveedor, Model modelPersona, Model modelCategoria) {
        //var personas = personaService.listarPersonas();
        //modelPersona.addAttribute("personas", personas);
        var categorias = categoriaService.listarCategorias();
        modelCategoria.addAttribute("categorias", categorias);
        proveedor = proveedorService.encontrarProveedor(proveedor);
        modelProveedor.addAttribute("proveedor", proveedor);
        return "crearProveedor";
    }
    
    @PostMapping("/eliminarProveedor/{iden}")
    public String eliminarProveedor(@PathVariable Long iden) {
        proveedorService.eliminar(iden);
        return "redirect:/listarProveedores";
    }

    @GetMapping("/listarProveedores")
    public String listarProveedores(Model model) {
        List<Proveedor> proveedores = proveedorService.listarProveedores();
        model.addAttribute("proveedores", proveedores);
        return "listarProveedores";
    }
}
