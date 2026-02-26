package CasoEstudio.CasoEstudio.service;

import CasoEstudio.CasoEstudio.domain.Categoria;
import CasoEstudio.CasoEstudio.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria encontrarCategoria(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public void guardar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }
}