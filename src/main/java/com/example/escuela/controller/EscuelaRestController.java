
package com.example.escuela.controller;

import com.example.escuela.model.Escuela;
import com.example.escuela.service.EscuelaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("/escuela")
public class EscuelaRestController {
  


    @Autowired
    private EscuelaService escuelaService;

    @GetMapping("/all")
    public List<Escuela> getEscuela() {
        return escuelaService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Escuela> getEScuela(@PathVariable int id) {
        Escuela esc = escuelaService.read(id);
        return ResponseEntity.ok(esc);
    }

    @DeleteMapping("/{id}")
    public int deleteEscuela(@PathVariable int id) {        
        return escuelaService.delete(id);
    }
    @PostMapping("/add")
    public int addEscuela(@RequestBody Escuela esc) {  
        System.out.println(esc.getNombre());
        return escuelaService.create(esc);
    }
    @PutMapping("/edit")
    public int editEscuela(@RequestBody Escuela esc) {  
        Escuela escu = new Escuela(esc.getIdescuela(),esc.getNombre());
        System.out.println(esc.getIdescuela()+" , "+esc.getNombre());
        return escuelaService.update(esc);
    }
} 

