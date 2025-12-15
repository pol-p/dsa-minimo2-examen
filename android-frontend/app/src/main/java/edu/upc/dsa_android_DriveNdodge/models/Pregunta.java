package edu.upc.dsa_android_DriveNdodge.models;
public class Pregunta {
    private String enunciado;
    private String respuesta;
    private int id;

    public Pregunta() {
    }

    public Pregunta(int id, String enunciado, String respuesta) {
        this.enunciado = enunciado;
        this.id = id;
        this.respuesta = respuesta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

