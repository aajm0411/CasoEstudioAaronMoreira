package CasoEstudio.CasoEstudio.service;

import CasoEstudio.CasoEstudio.domain.Reserva;
import CasoEstudio.CasoEstudio.repository.ReservaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    public Reserva encontrarReserva(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public void guardar(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    public void eliminar(Long id) {
        reservaRepository.deleteById(id);
    }
}