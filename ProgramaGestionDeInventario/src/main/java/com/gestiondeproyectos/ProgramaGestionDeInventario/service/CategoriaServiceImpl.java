package com.gestiondeproyectos.ProgramaGestionDeInventario.service;
import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.CategoriaDao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Categoria;
import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.ArticuloDao;
import java.util.List;

import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaDao categoriaDao;

    @Autowired
    private ArticuloDao articuloDao;

    @Autowired
    private ArticuloService articuloService;

    @Autowired
    private ProveedorService proveedorService;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> listarCategorias() {
        return (List<Categoria>) categoriaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Autowired
    public CategoriaServiceImpl(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }

    @Override
    @Transactional
    public void eliminar(Categoria categoria) {
        if (categoriaNoVinculada(categoria)) {
            categoriaDao.delete(categoria);
        } else {
            throw new IllegalStateException("La categoria esta vinculada a articulos o proveedores y no puede ser eliminada.");
        }
    }
    @Override
    public Categoria findByDesc(String desc) {
        return categoriaDao.findByDescripcion(desc);
    }
    /*@Transactional
    public void eliminar(Categoria categoria) {categoriaDao.delete(categoria);}*/

    @Override
    // Como solo estamos recorriendo la lista de categorias y no modificamos información va a ser un método de consulta solamente
    @Transactional(readOnly = true)
    public Categoria encontrarCategoria(Categoria categoria){
        // Como el findById espera el ID de la categoria como parámetro por lo que tenemos que hacer un get del ID 
        // El .get() devuelve el objeto buscado
        // NOTA: el .get() da error si no encuentra el objeto
        // El .orElse(variablePorDefecto) devuelve la variablePorDefecto si el objeto encontrado no se encuentra
        return categoriaDao.findById(categoria.getIden()).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public boolean categoriaNoVinculada(Categoria categoria) {
        var listaDeArticulos = articuloDao.findByCategoriaId(categoria.getIden());
        return listaDeArticulos.isEmpty();
    }

    @Override
    public Categoria obtenerCategoriaPorId(Long id) {
        return categoriaDao.findById(id).orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));
    }

}
