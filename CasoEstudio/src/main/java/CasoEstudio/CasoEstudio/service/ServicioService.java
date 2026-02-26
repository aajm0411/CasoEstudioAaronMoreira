/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CasoEstudio.CasoEstudio.service;

/**
 *
 * @author ajmg2
 */

import CasoEstudio.CasoEstudio.domain.Servicio;
import CasoEstudio.CasoEstudio.repository.ServicioRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> listarServicios() {
        return servicioRepository.findAll();
    }

    public void guardar(Servicio servicio) {
        servicioRepository.save(servicio);
    }

    public Servicio obtenerPorId(Long id) {
        return servicioRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        servicioRepository.deleteById(id);
    }
}
