package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Articulo;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Categoria;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Proveedor;
import com.gestiondeproyectos.ProgramaGestionDeInventario.service.ArticuloService;
import com.gestiondeproyectos.ProgramaGestionDeInventario.service.CategoriaService;

import java.util.List;

import com.gestiondeproyectos.ProgramaGestionDeInventario.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ArticuloController {

    @Autowired
    private final ArticuloService articuloService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }


    @GetMapping("/crearArticulo")
    public String mostrarFormularioCrearArticulo(@RequestParam(value = "id", required = false) Long id, Model model) {
        List<Categoria> categorias = categoriaService.listarCategorias();
        List<Proveedor> proveedores = proveedorService.listarProveedores();
        model.addAttribute("categorias", categorias);
        model.addAttribute("proveedores", proveedores);

        if (id != null) {
            Articulo articulo = articuloService.obtenerArticuloPorId(id);
            model.addAttribute("articulo", articulo);
        } else {
            model.addAttribute("articulo", new Articulo());
        }

        return "crearArticulo";
    }



    @PostMapping("/crearArticulo")
    public String guardarArticulo(@ModelAttribute("articulo") Articulo articulo) {
        // Si el artículo tiene un ID, significa que ya existe y debe ser actualizado
        if (articulo.getIden() != null) {
            // Obtener el artículo existente de la base de datos
            Articulo articuloExistente = articuloService.obtenerArticuloPorId(articulo.getIden());
            if (articuloExistente != null) {
                // Actualizar los campos del artículo existente con los valores del formulario
                articuloExistente.setNombre(articulo.getNombre());
                articuloExistente.setCodigoProducto(articulo.getCodigoProducto());
                articuloExistente.setCategoria(articulo.getCategoria());
                articuloExistente.setProveedor(articulo.getProveedor());
                articuloExistente.setStock(articulo.getStock());
                articuloExistente.setPrecioUnitario(articulo.getPrecioUnitario());
                articuloExistente.setFechaVencimiento(articulo.getFechaVencimiento());
                articuloExistente.setUnidadDeReferencia(articulo.getUnidadDeReferencia());
                articuloExistente.setCantidadMinima(articulo.getCantidadMinima());

                // Guardar el artículo actualizado
                articuloService.guardar(articuloExistente);
            }
        } else {
            // Si el artículo no tiene un ID, es un nuevo artículo y debe ser creado
            articuloService.guardar(articulo);
        }
        return "redirect:/listarArticulos";
    }


    /*@GetMapping("/editarArticulo/{id}")
    public String mostrarFormularioEditarArticulo(@PathVariable("id") Long id, Model model) {
        Articulo articulo = articuloService.obtenerArticuloPorId(id);
        if (articulo != null) {
            model.addAttribute("articulo", articulo);
            return "crearArticulo";
        }
        return "redirect:/listarArticulos";
    }*/
    @GetMapping("/editarArticulo/{id}")
    public String mostrarFormularioEditarArticulo(@PathVariable("id") Long id, Model model) {
        return mostrarFormularioCrearArticulo(id, model);
    }

    @PostMapping("/eliminarArticulo/{iden}")
    public String eliminarArticulo(@PathVariable Long iden) {
        articuloService.eliminar(iden);
        return "redirect:/listarArticulos";
    }

    @GetMapping("/listarArticulos")
    public String listarArticulos(Model model) {
        List<Articulo> articulos = articuloService.listarArticulos();
        model.addAttribute("articulos", articulos);
        return "listarArticulos";
    }
}
