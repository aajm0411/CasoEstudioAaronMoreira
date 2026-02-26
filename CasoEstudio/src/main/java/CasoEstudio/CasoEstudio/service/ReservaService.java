/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CasoEstudio.CasoEstudio.service;

/**
 *
 * @author ajmg2
 */

import CasoEstudio.CasoEstudio.domain.Reserva;
import CasoEstudio.CasoEstudio.repository.ReservaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    public void guardar(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    public Reserva obtenerPorId(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        reservaRepository.deleteById(id);
    }
}
