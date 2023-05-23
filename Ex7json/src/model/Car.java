package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import interfaces.MyAnotation;

public class Car {
    private int ano;
    private String nome;
    private String marca;
    private String modelo;
    private List<String> listaJson = new ArrayList<>();
    private List<Number> lintNumber = new ArrayList<>();
    private Date data;
    private Rodas rodas;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @MyAnotation
    public Rodas getRodas() {return rodas;
    }

    public void setRodas(Rodas rodas) {
        this.rodas = rodas;
        
    }

    @MyAnotation
    public List<Number> getLintNumber() {
        return lintNumber;
    }

    public void setLintNumber(List<Number> lintNumber) {
        this.lintNumber = lintNumber;
    }

    @MyAnotation
    public List<String> getListaJson() {
        return listaJson;
    }

    public void setListaJson(List<String> listaJson) {
        this.listaJson = listaJson;
    }

    @MyAnotation
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @MyAnotation
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @MyAnotation
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @MyAnotation
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    

    
    
}
