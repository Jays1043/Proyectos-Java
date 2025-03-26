package com.jyaquian.lab.springlab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/forma1")
public class form1 {
    @GetMapping("/nombre")
    @ResponseBody
    public String Nombre(){
        return "Nombre: Josue Alejandro Yaquian Sarceño";
    }

    @GetMapping("/carnet")
    @ResponseBody
    public String Carnet(){
        return "Carnet: 3190-22-7332";
    }

    @GetMapping("/listado")
    @ResponseBody
    public String Listado(){
        return "Numero de listado: 10";
    }

    @GetMapping("/completo")
    @ResponseBody
    public String Completo(){
        return "Nombre: Josue Alejandro Yaquian Sarceño "+"Carnet: 3190-22-7332 "+"Numero de listado: 10";
    }
}
