package CasoEstudio.CasoEstudio.controller;

import CasoEstudio.CasoEstudio.domain.Categoria;
import CasoEstudio.CasoEstudio.domain.Servicio;
import CasoEstudio.CasoEstudio.service.CategoriaService;
import CasoEstudio.CasoEstudio.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/editar/{id}")
    public String editarServicio(@PathVariable Long id, Model model) {
        Servicio servicio = servicioService.encontrarServicio(id);
        model.addAttribute("servicio", servicio);
        model.addAttribute("listaCategorias", categoriaService.listarCategorias());
        return "servicio/formulario";
    }

    @PostMapping("/guardar")
    public String guardarServicio(@ModelAttribute Servicio servicio) {

        if (servicio.getCategoria() != null && servicio.getCategoria().getId() != null) {
            Categoria cat = categoriaService.encontrarCategoria(servicio.getCategoria().getId());
            servicio.setCategoria(cat);
        }

        servicioService.guardar(servicio);
        return "redirect:/servicios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarServicio(@PathVariable Long id) {
        servicioService.eliminar(id);
        return "redirect:/servicios";
    }
}