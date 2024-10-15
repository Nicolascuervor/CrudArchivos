package org.cuervo.Aplication;

import org.cuervo.Aplication.Services.RopaService;
import org.cuervo.Domain.Ropa;

import javax.swing.*;

public class Menu {
    private final RopaService ropaService;


    public Menu(RopaService ropaService) {
        this.ropaService = ropaService;
    }


    public void run() {
        while (true) {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido elija una opcion: \n1. Registrar ropa \n2. Borrar ropa \n3. Actualizar ropa \n4. Lista de ropas \n5. Buscar ropa \n6. Salir del programa"));
            switch (opcion) {
                case 1:
                crearUsuario();
                break;
                case 2:
                borrarRopa();
                break;
                case 3:
                actualizarRopa();
                break;
                case 4:
                listaRopas();
                break;
                case 5:
                buscarRopa();
                break;
                case 6:
                return;
            }
        }
    }


    public void crearUsuario() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Asignele un id a la prenda"));
        String marca = JOptionPane.showInputDialog("Ingrese la marca de la prenda");
        String tipo = JOptionPane.showInputDialog("Ingrese el tipo de prenda");
        int precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio de la prenda"));

        Ropa ropa = new Ropa(id, marca, precio, tipo);

        ropaService.crearRopa(ropa);
        JOptionPane.showMessageDialog(null,"Ropa agregada correctamente");
    }



    public void borrarRopa(){

        int busqueda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la ropa para borrarla del sistema"));

        Ropa ropa = ropaService.buscarRopaPorId(busqueda);

        if (ropa != null) {
            ropaService.eliminarRopa(ropa);
            JOptionPane.showMessageDialog(null, "Se elimino el ropa con exito");
        }
        else{JOptionPane.showMessageDialog(null,"Ropa no encontrada");}
    }


    public void actualizarRopa(){
        int busqueda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la ropa para actualizarla al sistema"));

        Ropa ropa = ropaService.buscarRopaPorId(busqueda);
        if (ropa != null) {
            String marcaNuvea = JOptionPane.showInputDialog("Ingrese la nueva marca de la prenda");
            if (!marcaNuvea.isEmpty()) {
                ropa.setMarca(marcaNuvea);
            }
            String tipoNuvea = JOptionPane.showInputDialog("Ingrese el nuevo tipo de prenda");
            if (!tipoNuvea.isEmpty()) {
                ropa.setTipo(tipoNuvea);
            }

            int precioNueva = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo precio de la prenda: "));
            ropa.setPrecio(precioNueva);

            ropaService.actualizarRopa(ropa);
            JOptionPane.showMessageDialog(null,"Ropa actualizada con éxito");
        } else {
            JOptionPane.showMessageDialog(null,"Ropa no encontrada");
        }
    }



    public void buscarRopa(){
        String busqueda = (JOptionPane.showInputDialog("Ingrese el ID de la ropa para buscarla en el sistema"));

        Ropa ropa = ropaService.buscarRopaPorId(Integer.parseInt(busqueda));

        if (ropa != null) {
            JOptionPane.showMessageDialog(null,"ROPA:" + " [ID = " + ropa.getId() + "]" + " [Marca = " + ropa.getMarca() + "]" + " [Tipp = " + ropa.getTipo() + "]" + " [Precio = " + ropa.getPrecio() + "]");
        } else JOptionPane.showMessageDialog(null,"ID de ropa no encontrada");
    }




    public void listaRopas(){
        System.out.println("Lista de ropas: \n");
        ropaService.listarRopas().forEach(System.out::println);

    }
}
