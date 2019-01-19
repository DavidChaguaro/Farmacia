package chaguaro.com.restaurante;

/**
 * Created by Luis Rocha on 17/1/2019.
 */

public class Item {

    private String titulo;
    private String descripcion;
    private String precio;

    public Item(){}

    public Item(String titulo, String descripcion, String precio){

        this.precio=precio;
        this.descripcion=descripcion;
        this.titulo=titulo;

    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
