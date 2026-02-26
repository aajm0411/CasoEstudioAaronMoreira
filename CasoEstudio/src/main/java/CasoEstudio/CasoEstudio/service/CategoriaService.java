/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CasoEstudio.CasoEstudio.service;

/**
 *
 * @author ajmg2
 */

import CasoEstudio.CasoEstudio.domain.Categoria;
import CasoEstudio.CasoEstudio.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public void guardar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public Categoria obtenerPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }
}
