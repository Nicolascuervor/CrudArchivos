package org.cuervo.Infrastructure;

import org.cuervo.Domain.Ropa;
import org.cuervo.Interface.ropaRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class fileRopaRepository implements ropaRepository {
    private static final String FILE_NAME = "Ropa.dat";

    @Override
    public void save(Ropa ropa) {
            List<Ropa> ropas = findAll();
            ropas.add(ropa);
            saveAll(ropas);
    }

    @Override
    public List<Ropa> findAll() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){
            return (List<Ropa>) ois.readObject();

        }

        catch(FileNotFoundException e){
            return new ArrayList<>();
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Ropa findById(int id) {
        return findAll().stream().filter(e -> e.getId() == id).findFirst().orElse(null);

    }

    @Override
    public void delete(Ropa ropa) {
        List<Ropa> ropas = findAll();
        ropas.removeIf(e -> e.getId() == ropa.getId());
        saveAll(ropas);
    }

    @Override
    public void update(Ropa ropa) {
        List<Ropa> ropas = findAll();
        for(int i = 0; i < ropas.size(); i++ ){
            if(ropas.get(i).getId() == ropa.getId()){
                ropas.set(i, ropa);
                break;
            }
        }
        saveAll(ropas);
    }



    public void saveAll(List<Ropa> ropas){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
            oos.writeObject(ropas);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
