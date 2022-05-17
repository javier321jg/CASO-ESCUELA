
package com.example.escuela.service;

import com.example.escuela.model.Escuela;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface EscuelaService {
    int create(Escuela esc);

    int update(Escuela esc);

    int delete(int id);

    Escuela read(int id);

    List<Escuela> readAll();
}
