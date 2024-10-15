package org.cuervo.Domain;


import java.io.Serializable;

public class Ropa implements Serializable {
    private static final long serialVersionUID = 1L;

    //SI SE TRABAJA SOBRE ARCHIVOS LA CLASE SE TRABAJA "NORMAL"

    private int id;
    private String marca;
    private String tipo;
    private int precio;


    public Ropa() {}

    public Ropa(int id, String marca, int precio, String tipo) {
        this.id = id;
        this.marca = marca;
        this.precio = precio;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "ROPA:" + " [ID = " + id + "]" + " [Marca = " + marca + "]" + " [Tipp = " + tipo + "]" + " [Precio = " + precio + "]";
    }
}
