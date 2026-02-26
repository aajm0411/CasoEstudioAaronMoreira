/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CasoEstudio.CasoEstudio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import CasoEstudio.CasoEstudio.domain.Servicio;
import CasoEstudio.CasoEstudio.service.ServicioService;
import CasoEstudio.CasoEstudio.service.CategoriaService;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String listarServicios(Model model) {
        model.addAttribute("listaServicios", servicioService.listarServicios());
        return "servicio/lista";
    }

    @GetMapping("/nuevo")
    public String nuevoServicio(Model model) {
        model.addAttribute("servicio", new Servicio());
        model.addAttribute("listaCategorias", categoriaService.listarCategorias());
        return "servicio/formulario";
    }

    @PostMapping("/guardar")
    public String guardarServicio(@ModelAttribute Servicio servicio) {
        servicioService.guardar(servicio);
        return "redirect:/servicios";
    }

    @GetMapping("/editar/{id}")
    public String editarServicio(@PathVariable Long id, Model model) {
        Servicio servicio = servicioService.obtenerPorId(id);
        model.addAttribute("servicio", servicio);
        model.addAttribute("listaCategorias", categoriaService.listarCategorias());
        return "servicio/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarServicio(@PathVariable Long id) {
        servicioService.eliminar(id);
        return "redirect:/servicios";
    }
}
