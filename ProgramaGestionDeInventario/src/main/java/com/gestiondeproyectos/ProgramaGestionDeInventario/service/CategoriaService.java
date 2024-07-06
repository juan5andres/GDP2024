package com.gestiondeproyectos.ProgramaGestionDeInventario.service;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Categoria;
import java.util.List;

public interface CategoriaService {

    public List<Categoria> listarCategorias();

    public void guardar(Categoria categoria);

    public void eliminar(Categoria categoria);

    public Categoria encontrarCategoria(Categoria categoria);

    public boolean categoriaNoVinculada(Categoria categoria);

    public Categoria obtenerCategoriaPorId(Long id);

    Categoria findByDesc(String desc);
}