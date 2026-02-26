/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CasoEstudio.CasoEstudio.controller;

/**
 *
 * @author ajmg2
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import CasoEstudio.CasoEstudio.domain.Reserva;
import CasoEstudio.CasoEstudio.service.ReservaService;
import CasoEstudio.CasoEstudio.service.ServicioService;

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

    @PostMapping("/guardar")
    public String guardarReserva(@ModelAttribute Reserva reserva) {
        reservaService.guardar(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarReserva(@PathVariable Long id) {
        reservaService.eliminar(id);
        return "redirect:/reservas";
    }
}
