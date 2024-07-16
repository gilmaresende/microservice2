package br.com.gir.book_service.response;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Cambio implements Serializable {

    private Long id;

    private String from;

    private String to;

    private BigDecimal conversionFactor;

    private BigDecimal conversionValue;

    private String enviroment;

    public Cambio(Long id, String from, String to, BigDecimal conversionFactor, BigDecimal conversionValue, String enviroment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
        this.conversionValue = conversionValue;
        this.enviroment = enviroment;
    }

    public Cambio() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(BigDecimal conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public BigDecimal getConversionValue() {
        return conversionValue;
    }

    public void setConversionValue(BigDecimal conversionValue) {
        this.conversionValue = conversionValue;
    }

    public String getEnviroment() {
        return enviroment;
    }

    public void setEnviroment(String enviroment) {
        this.enviroment = enviroment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cambio cambio = (Cambio) o;
        return Objects.equals(id, cambio.id) && Objects.equals(from, cambio.from) && Objects.equals(to, cambio.to) && Objects.equals(conversionFactor, cambio.conversionFactor) && Objects.equals(conversionValue, cambio.conversionValue) && Objects.equals(enviroment, cambio.enviroment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, conversionFactor, conversionValue, enviroment);
    }
}
