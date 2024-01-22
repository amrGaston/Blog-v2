package com.blog.blog.exception;

import java.time.LocalDate;
import java.util.Date;

public class RespuestaError {
    private String mensaje;
    private int estado;
    private LocalDate date = LocalDate.now();

    public int getEstado() {
        return estado;
    }

    public RespuestaError(String mensaje, int estado) {
        this.mensaje = mensaje;
        this.estado = estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDate getTimeStamp() {
        return this.date;
    }

}
