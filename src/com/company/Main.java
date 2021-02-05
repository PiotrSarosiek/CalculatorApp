package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String example="2+2*2";
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        try {
            example=reader.readLine();
            if(!isValid(example)) throw new Exception();
            System.out.println(doMath(getNumbersOperations(example)));
        } catch (Exception e) {
            System.out.println("pls check Your operation");
        }
    }

    public static int doMath(NumbersOperations nA){
        try{
            for(int i=0;i<nA.getOperations().size();i++){
                if(nA.getOperations().get(i)=='*'){
                    nA.removeOperation(i);
                    nA.setNumber(i,(nA.getNumber(i)*nA.getNumber(i+1)));
                    nA.removeNumber(i+1);
                    i-=1;
                }
            }
            for(int i=0;i<nA.getOperations().size();i++){
                if(nA.getOperations().get(i)=='/'){
                    nA.removeOperation(i);
                    if(nA.getNumber(i+1)==0) throw new Exception();
                    nA.setNumber(i,(nA.getNumber(i)/nA.getNumber(i+1)));
                    nA.removeNumber(i+1);
                    i-=1;
                }
            }
            for(int i=0;i<nA.getOperations().size();i++){
                if(nA.getOperations().get(i)=='-'){
                    nA.removeOperation(i);
                    nA.setNumber(i,(nA.getNumber(i)-nA.getNumber(i+1)));
                    nA.removeNumber(i+1);
                    i-=1;
                }
            }
            for(int i=0;i<nA.getOperations().size();i++){
                if(nA.getOperations().get(i)=='+'){
                    nA.removeOperation(i);
                    nA.setNumber(i,(nA.getNumber(i)+nA.getNumber(i+1)));
                    nA.removeNumber(i+1);
                    i-=1;
                }
            }
            return nA.getNumber(0);
        }
        catch (Exception ex){
            System.out.println("cannot be divided by zero\n");
            return 0;
        }
    }

    public static NumbersOperations getNumbersOperations(String example){
        String SIGNS="/*+-";
        String DIGITS="0123456789";
        String number="";
        ArrayList<Character> actions=new ArrayList<>();
        ArrayList<Integer> numbers=new ArrayList<>();

        for (int i=0;i<example.length();i++){
            if(SIGNS.indexOf(example.charAt(i))!=-1 && i!=example.length()-1){
                actions.add(example.charAt(i));
                numbers.add(Integer.parseInt(number));
                number="";
            }
            if (DIGITS.indexOf(example.charAt(i))!=-1){
                number+=example.charAt(i);
            }
            if(i==example.length()-1){
                numbers.add(Integer.parseInt(number));
                number="";
            }
        }
        return new NumbersOperations(actions,numbers);
    }

    public static boolean isValid(String example){
        String SIGNS="/*+-";
        String DIGITS="0123456789";
        if(example.isEmpty() || SIGNS.indexOf(example.charAt(0))!=-1 || SIGNS.indexOf(example.charAt(example.length()-1))!=-1)
            return false;
        for (int i=0;i<example.length();i++) {
            if (SIGNS.indexOf(example.charAt(i)) == -1 && DIGITS.indexOf(example.charAt(i))==-1)
                return false;
        }
        return true;
    }
}
