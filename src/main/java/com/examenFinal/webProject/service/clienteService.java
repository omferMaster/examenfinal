package com.examenFinal.webProject.service;

import com.examenFinal.webProject.entity.*;
import com.examenFinal.webProject.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class clienteService {

    @Autowired
    private clienteDao clienteDao;

    // Obtener todos los clientes
    public List<cliente> getAllclientes() {
        return clienteDao.findAll();
    }

    // Obtener un cliente por ID
    public cliente getclienteById(Long id) {
        return clienteDao.findById(id).orElseThrow(() -> 
                new IllegalArgumentException("El cliente con id " + id + " no existe."));
    }

    // Crear un nuevo cliente
    public cliente createcliente(cliente cliente) {
        return clienteDao.save(cliente);
    }

    // Actualizar un cliente existente
    public cliente updatecliente(Long id, cliente clienteActualizado) {
        cliente clienteExistente = getclienteById(id);
        clienteExistente.setNombre(clienteActualizado.getNombre());
        clienteExistente.setDocumento(clienteActualizado.getDocumento());
        clienteExistente.setTipoDocumento(clienteActualizado.getTipoDocumento());
        return clienteDao.save(clienteExistente);
    }

    // Eliminar un cliente
    public void deletecliente(Long id) {
        clienteDao.deleteById(id);
    }
}
