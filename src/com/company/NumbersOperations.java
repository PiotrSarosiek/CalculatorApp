package com.company;

import java.util.ArrayList;

public class NumbersOperations {

    private ArrayList<Character> operations;
    private ArrayList<Integer> numbers;

    public NumbersOperations(ArrayList<Character> operations, ArrayList<Integer> numbers){
        this.operations=new ArrayList<>();
        this.numbers=new ArrayList<>();
        this.operations=operations;
        this.numbers=numbers;
    }

    public int getNumber(int i){
        return numbers.get(i);
    }

    public void setNumber(int i, int number) {
        numbers.set(i,number);
    }

    public void removeNumber(int i){
        numbers.remove(i);
    }

    public void removeOperation(int i){
        operations.remove(i);
    }

    public ArrayList<Character> getOperations() {
        return operations;
    }

    public ArrayList<Integer> getNumbers(){
        return numbers;
    }
}
