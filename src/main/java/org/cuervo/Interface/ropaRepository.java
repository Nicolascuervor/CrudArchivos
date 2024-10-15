package org.cuervo.Interface;

import org.cuervo.Domain.Ropa;

import java.util.List;

public interface ropaRepository {
    
    void save(Ropa ropa);

    List<Ropa> findAll();

    Ropa findById(int id);

    void delete(Ropa ropa);

    void update(Ropa ropa);
}
