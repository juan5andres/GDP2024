package com.gestiondeproyectos.ProgramaGestionDeInventario.service;
import com.gestiondeproyectos.ProgramaGestionDeInventario.dao.CategoriaDao;
import com.gestiondeproyectos.ProgramaGestionDeInventario.model.Categoria;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaDao categoriaDao;

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

    @Override
    @Transactional
    public void eliminar(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

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
    public boolean categoriaNoVinculada (Categoria categoria){
        var listaDeArticulos = articuloService.searchItemsByCategoryDescription(categoria.getDescripcion());
        var listaDeProveedores = proveedorService.searchProvidersByCategoryDescription(categoria.getDescripcion());
        if(listaDeArticulos.isEmpty() && listaDeProveedores.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public Categoria obtenerCategoriaPorId(Long id) {
        return categoriaDao.findById(id).orElse(null);
    }

}
