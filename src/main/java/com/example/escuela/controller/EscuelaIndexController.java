
package com.example.escuela.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ACER
 */
@Controller
@RequestMapping({"/","/index"})
public class EscuelaIndexController {
    @GetMapping
    public String main() {
        return "index";
    }
}
