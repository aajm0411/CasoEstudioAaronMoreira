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
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactoController {

    @GetMapping("/contacto")
    public String mostrarFormulario(Model model) {
        model.addAttribute("titulo", "Contacto");
        return "contacto";
    }

    @PostMapping("/contacto")
    public String enviarFormulario() {
        return "redirect:/contacto";
    }
}