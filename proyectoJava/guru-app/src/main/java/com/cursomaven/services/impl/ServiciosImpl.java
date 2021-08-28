package com.cursomaven.services.impl;

import java.util.List;
import java.util.Optional;

import com.cursomaven.clases.Contacto;
import com.cursomaven.services.IServicios;
import com.cursomaven.daos.impl.DaoImpl;
import com.cursomaven.daos.IDao;


public class ServiciosImpl implements IServicios<Contacto>{
    
    private IDao<Contacto> daoImpl = new DaoImpl();

    @Override
    public Optional<Contacto> get(int id){
        return this.daoImpl.get(id);
    }

    @Override
    public List<Contacto> getAll(){
        return this.daoImpl.getAll();
    }

    @Override
    public void save(Contacto contacto){
        this.daoImpl.save(contacto);
    }

    @Override
    public void update(Contacto contacto){
        this.daoImpl.update(contacto);
    }

    @Override
    public void delete(Contacto contacto){
        this.daoImpl.delete(contacto);
    }
}
