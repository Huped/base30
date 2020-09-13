package com.example.basededatos2.modelo;

public class Articulo {

    private String codigo;
    private String descri;
    private String barra;
    private int grupo;
    private double cospro;
    private double cosult;
    private double preven;
    private double preve2;
    private double preve3;
    private String moneda;
    private double stock1;
    private double stock2;

    public Articulo(String codigo) {
        this.codigo = codigo;
    }

    public Articulo() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public String getBarra() {
        return barra;
    }

    public void setBarra(String barra) {
        this.barra = barra;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public double getCospro() {
        return cospro;
    }

    public void setCospro(double cospro) {
        this.cospro = cospro;
    }

    public double getCosult() {
        return cosult;
    }

    public void setCosult(double cosult) {
        this.cosult = cosult;
    }

    public double getPreven() {
        return preven;
    }

    public void setPreven(double preven) {
        this.preven = preven;
    }

    public double getPreve2() {
        return preve2;
    }

    public void setPreve2(double preve2) {
        this.preve2 = preve2;
    }

    public double getPreve3() {
        return preve3;
    }

    public void setPreve3(double preve3) {
        this.preve3 = preve3;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getStock1() {
        return stock1;
    }

    public void setStock1(double stock1) {
        this.stock1 = stock1;
    }

    public double getStock2() {
        return stock2;
    }

    public void setStock2(double stock2) {
        this.stock2 = stock2;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "codigo='" + codigo + '\'' +
                ", descri='" + descri + '\'' +
                ", barra='" + barra + '\'' +
                ", grupo=" + grupo +
                ", cospro=" + cospro +
                ", cosult=" + cosult +
                ", preven=" + preven +
                ", preve2=" + preve2 +
                ", preve3=" + preve3 +
                ", moneda='" + moneda + '\'' +
                ", stock1=" + stock1 +
                ", stock2=" + stock2 +
                '}';
    }
}
