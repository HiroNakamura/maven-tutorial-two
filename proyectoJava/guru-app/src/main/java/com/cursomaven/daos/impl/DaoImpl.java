package com.cursomaven.daos.impl;

import java.util.List;
import java.util.Optional;
import com.cursomaven.clases.Contacto;
import com.cursomaven.daos.IDao;

public class DaoImpl implements IDao<Contacto>{
    @Override
    public Optional<Contacto> get(int id){
        return null;
    }

    @Override
    public List<Contacto> getAll(){
        return null;
    }

    @Override
    public void save(Contacto contacto){

    }

    @Override
    public void update(Contacto contacto){

    }

    @Override
    public void delete(Contacto contacto){

    }
}
