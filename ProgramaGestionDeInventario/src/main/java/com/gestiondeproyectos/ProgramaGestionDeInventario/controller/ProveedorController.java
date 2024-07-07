package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Usuario;
import com.gestiondeproyectos.ProgramaGestionDeInventario.service.CategoriaService;
import com.gestiondeproyectos.ProgramaGestionDeInventario.service.ProveedorService;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @GetMapping({"/crearProveedor", "/editarProveedor/{id}"})
    public String mostrarFormulario(@PathVariable(value = "id", required = false) Long id, Model model) {
        Proveedor proveedor;
        if (id != null) {
            proveedor = proveedorService.obtenerProveedorPorId(id);
            if (proveedor == null) {
                return "redirect:/listarProveedores"; // Redirige a la lista de proveedores si el proveedor no existe
            }
        } else {
            proveedor = new Proveedor();
            proveedor.setBaja(false);
        }
        model.addAttribute("proveedor", proveedor);
        return "crearProveedor";
    }


    @PostMapping("/crearProveedor")
    public String guardarProveedor(@ModelAttribute("proveedor") Proveedor proveedor) {
        // Si el proveedor tiene un ID, significa que ya existe y debe ser actualizado
        if (proveedor.getIden() != null) {
            // Obtener el proveedor existente de la base de datos
            Proveedor proveedorExistente = proveedorService.encontrarProveedor(proveedor);
            if (proveedorExistente != null) {
                // Actualizar los campos del proveedor existente con los valores del formulario
                proveedorExistente.setNombre(proveedor.getNombre());
                proveedorExistente.setEmail(proveedor.getEmail());
                proveedorExistente.setTelefono(proveedor.getTelefono());
                proveedorExistente.setDomicilio(proveedor.getDomicilio());
                proveedorExistente.setCuit(proveedor.getCuit());

                // Guardar el proveedor actualizado
                proveedorService.guardar(proveedorExistente);
            }
        } else {
            // Si el proveedor no tiene un ID, es un nuevo proveedor y debe ser creado
            proveedorService.guardar(proveedor);
        }
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

    /*@GetMapping("/editarProveedor/{id}")
    public String mostrarFormularioEditarProveedor(@PathVariable("id") Long id, Model model) {
        Proveedor proveedor = proveedorService.obtenerProveedorPorId(id);
        if (proveedor != null) {
            model.addAttribute("proveedor", proveedor);
            return "crearProveedor"; // Reutilizamos la misma vista para creación y edición
        } else {
            return "redirect:/listarProveedores"; // Redirige a la lista de proveedores si el proveedor no existe
        }
    }*/


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
