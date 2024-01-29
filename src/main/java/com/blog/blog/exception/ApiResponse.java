package com.blog.blog.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;

public class ApiResponse {
    private String mensaje;
    private LocalDate date = LocalDate.now();
    private HttpStatus httpStatus;

    private int estado;

    public ApiResponse(String mensaje, HttpStatus httpStatus) {
        this.mensaje = mensaje;
        this.httpStatus = httpStatus;
        this.estado = this.httpStatus.value();
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

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public int getEstado() {
        return this.estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
