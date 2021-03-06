
package com.example.escuela.daoImpl;

import com.example.escuela.dao.EscuelaDao;
import com.example.escuela.model.Escuela;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class EscuelaDaoImpl implements EscuelaDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int create(Escuela esc) {
        String SQL ="INSERT INTO escuela(nombre) VALUES(?)";
        return jdbcTemplate.update(SQL,new Object[]{esc.getNombre()});
   }

    @Override
    public int update(Escuela esc) {
        String SQL ="UPDATE escuela SET nombre=? WHERE idescuela=?";                 
        return jdbcTemplate.update(SQL,new Object[]{esc.getNombre(), esc.getIdescuela()});
   }

    @Override
    public int delete(int id) {
        String SQL ="DELETE FROM escuela WHERE idescuela=?"; 
        return jdbcTemplate.update(SQL,id);
        
         }

    @Override
    public Escuela read(int id) {
        String SQL ="SELECT *FROM escuela WHERE idescuela=?";
        try {
            Escuela esc = jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(Escuela.class),id);
            return esc;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Escuela> readAll() {
       String SQL ="SELECT idescuela, nombre FROM escuela ORDER BY idescuela ASC";        
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Escuela.class));
    }
    
}
