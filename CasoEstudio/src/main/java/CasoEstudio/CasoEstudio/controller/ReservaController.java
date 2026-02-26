package CasoEstudio.CasoEstudio.controller;

import CasoEstudio.CasoEstudio.domain.Reserva;
import CasoEstudio.CasoEstudio.domain.Servicio;
import CasoEstudio.CasoEstudio.service.ReservaService;
import CasoEstudio.CasoEstudio.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public String listarReservas(Model model) {
        model.addAttribute("listaReservas", reservaService.listarReservas());
        return "reserva/lista";
    }

    @GetMapping("/nuevo")
    public String nuevaReserva(Model model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("listaServicios", servicioService.listarServicios());
        return "reserva/formulario";
    }

    @GetMapping("/editar/{id}")
    public String editarReserva(@PathVariable Long id, Model model) {
        Reserva reserva = reservaService.encontrarReserva(id);
        model.addAttribute("reserva", reserva);
        model.addAttribute("listaServicios", servicioService.listarServicios());
        return "reserva/formulario";
    }

    @PostMapping("/guardar")
    public String guardarReserva(@ModelAttribute Reserva reserva) {

        if (reserva.getServicio() != null && reserva.getServicio().getId() != null) {
            Servicio s = servicioService.encontrarServicio(reserva.getServicio().getId());
            reserva.setServicio(s);
        }

        reservaService.guardar(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarReserva(@PathVariable Long id) {
        reservaService.eliminar(id);
        return "redirect:/reservas";
    }
}