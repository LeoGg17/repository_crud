package com.leogg.crud.controller;


import com.leogg.crud.models.Productos;
import com.leogg.crud.repository.IProductosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("api/productos")
public class ProductoController {

    @Autowired
    private IProductosDAO productosDAO;

    @PostMapping
    public ResponseEntity<Productos> create(@RequestBody Productos productos){
        return new ResponseEntity<Productos>(productosDAO.insert(productos), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<Productos>> readAll(){
        return new ResponseEntity<List<Productos>>(productosDAO.findAll(), HttpStatus.ACCEPTED);
    }
    @PutMapping
    public ResponseEntity<Productos> update(@RequestBody Productos productos){
        return new ResponseEntity<Productos>(productosDAO.save(productos), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        productosDAO.deleteById(id);
        return new ResponseEntity(null, HttpStatus.OK);
    }


}
