package com.example;

import java.util.List;

public class Lion {

    private Feline feline;
    boolean hasMane;

    //Убрана зваисимость Feline feline = new Feline() и добавлен аргумент Feline feline в конструктор класса,
    //для инъекции интерфейсы не использовались специально, так как на лекции рассказывалось, что можно использовать
    //конструктор, с помощью которого можно создавать экземпляры в другом классе, например в Main или в любой другой
    //точке входа, которая в проекте отсутствует
    public Lion(String sex, Feline feline) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
        this.feline = feline;
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}
