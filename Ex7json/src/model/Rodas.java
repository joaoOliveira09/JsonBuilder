package model;

import interfaces.MyAnotation;

import java.util.List;

public class Rodas {
    private int aro;
    private int qtd;
    private String marca;
    private List<Integer> strings;
    public Rodas(int aro, int qtd, String marca, List<Integer> strings) {
        this.aro = aro;
        this.qtd = qtd;
        this.marca = marca;
        this.strings = strings;
    }
    @MyAnotation
    public List<Integer> getStrings() {
        return strings;
    }

    public void setStrings(List<Integer> strings) {
        this.strings = strings;
    }



    public int getAro() {
        return aro;
    }

    public void setAro(int aro) {
        this.aro = aro;
    }

    @MyAnotation
    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    @MyAnotation
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}
