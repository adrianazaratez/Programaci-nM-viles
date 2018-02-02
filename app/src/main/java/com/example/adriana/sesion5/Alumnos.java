package com.example.adriana.sesion5;

/**
 * Created by adriana on 31/01/2018.
 */

public class Alumnos {

    String nombre;
    String telefono;
    String escolaridad;
    String genero;
    String libro;
    int deporte;

    public Alumnos(String nombre,String telefono, String escolaridad, String genero,String libro,int deporte){
        this.nombre = nombre;
        this.telefono = telefono;
        this.escolaridad = escolaridad;
        this.genero = genero;
        this.libro = libro;
        this.deporte = deporte;
    }

    public String toString(){
        if(deporte == 1){
            return "Nombre: "+nombre+"\nTeléfono: "+telefono+"\nEscolaridad: "+escolaridad+"\nGénero: "+genero+"\nLibro favorito: "+libro+"\nPractica deporte: Sí";
        } else{
            return "Nombre: "+nombre+"\nTeléfono: "+telefono+"\nEscolaridad: "+escolaridad+"\nGénero: "+genero+"\nLibro favorito: "+libro+"\nPractica deporte: No";
        }
    }

}
