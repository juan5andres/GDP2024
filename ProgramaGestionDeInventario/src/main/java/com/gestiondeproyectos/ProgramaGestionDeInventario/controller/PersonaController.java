package com.gestiondeproyectos.ProgramaGestionDeInventario.controller;


import org.springframework.stereotype.Controller;

@Controller
public class PersonaController {

    /*@Autowired
    private PersonaService personaService;

    @GetMapping("/agregarPersona")
    public String agregarPersona(Persona persona){
        return "modificarPersona";
    }

    @PostMapping("/guardarPersona")
    public String guardarPersona(Persona persona){
        personaService.guardar(persona);
            return "redirect:/";
        }

    @GetMapping("/editarPersona/{iden}")
    public String editarPersona(Persona persona, Model model) {
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificarPersona";
    }

    @GetMapping("/eliminarPersona")
    public String eliminarPersona(Persona persona) {
        if(personaService.personaNoVinculada(persona)){
            personaService.eliminar(persona);
            return "redirect:/";
        }
        else{
            return "redirect:/";
        }
    }

    @GetMapping("/listarPersonas")
    public String listarPersonas(Model model) {
        var personas = personaService.listarPersonas();
        model.addAttribute("personas", personas);
        return "listarPersonas";
    }*/

}