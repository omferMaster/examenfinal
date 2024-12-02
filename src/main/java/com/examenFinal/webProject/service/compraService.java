package com.examenFinal.webProject.service;

import com.examenFinal.webProject.entity.compra;
import com.examenFinal.webProject.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class compraService {

    @Autowired
    private compraDao compraDao;

    public List<compra> findAll() {
        return compraDao.findAll();
    }

    public compra findById(Long id) {
        return compraDao.findById(id).orElse(null);
    }

    public compra save(compra compra) {
        return compraDao.save(compra);
    }

    public void deleteById(Long id) {
        compraDao.deleteById(id);
    }
}
