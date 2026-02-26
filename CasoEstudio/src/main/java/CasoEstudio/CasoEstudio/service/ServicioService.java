package CasoEstudio.CasoEstudio.service;

import CasoEstudio.CasoEstudio.domain.Servicio;
import CasoEstudio.CasoEstudio.repository.ServicioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> listarServicios() {
        return servicioRepository.findAll();
    }

    public Servicio encontrarServicio(Long id) {
        return servicioRepository.findById(id).orElse(null);
    }

    public void guardar(Servicio servicio) {
        servicioRepository.save(servicio);
    }

    public void eliminar(Long id) {
        servicioRepository.deleteById(id);
    }
}