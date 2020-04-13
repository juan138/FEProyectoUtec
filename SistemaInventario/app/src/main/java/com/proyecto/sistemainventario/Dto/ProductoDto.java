package com.proyecto.sistemainventario.Dto;

public class ProductoDto {
    private String nombre;
    private String catidad;
    private String id;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the catidad
     */
    public String getCatidad() {
        return catidad;
    }

    /**
     * @param catidad the catidad to set
     */
    public void setCatidad(String catidad) {
        this.catidad = catidad;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }


}
