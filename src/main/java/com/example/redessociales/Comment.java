package com.example.redessociales;

import java.util.Calendar;

public final class Comment {

    public int postId;
    public String autor;
    public String comentario;
    public Calendar fechaComent;

    public Comment(int postId, String autor, String comentario) {
        this.postId = postId;
        this.autor = autor;
        this.comentario = comentario;
        this.fechaComent = Calendar.getInstance();
        fechaComent = Calendar.getInstance();
    }

    public void print() {
        System.out.println("Autor: " + autor + " Fecha: " + fechaComent.getTime() + "\nComentario: " + comentario);
    }

}
