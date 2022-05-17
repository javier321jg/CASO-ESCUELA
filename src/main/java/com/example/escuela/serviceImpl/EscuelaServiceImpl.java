
package com.example.escuela.serviceImpl;

import com.example.escuela.dao.EscuelaDao;
import com.example.escuela.model.Escuela;
import com.example.escuela.service.EscuelaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class EscuelaServiceImpl implements EscuelaService {
    @Autowired
    private EscuelaDao escuelaDao;

    @Override
    public int create(Escuela esc) {
        return escuelaDao.create(esc);
    }

    @Override
    public int update(Escuela esc) {
        return escuelaDao.update(esc);  
    }

    @Override
    public int delete(int id) {
        return escuelaDao.delete(id);
     }

    @Override
    public Escuela read(int id) {
        return escuelaDao.read(id);
     }

    @Override
    public List<Escuela> readAll() {
        return escuelaDao.readAll();
    }
    
    
}
