package com.example.calculatorprojectv2.utils;

import android.util.Log;

import java.util.ArrayList;

public class UnlimitedNumberGenerator {
    String[] operations = {"+", "-", "*"};
    int[] numbers = {2, 3, 4, 5, 6, 7, 8, 9};
    ArrayList<Integer> numbersFinal = new ArrayList<>();
    ArrayList<Boolean> numberOrOperations = new ArrayList<>();
    ArrayList<String> operationsFinal = new ArrayList<>();

    public int getNumber(int amountNums){
        boolean num = true;
        boolean first = true;
        int daNumber = 0;
        for(int i = 0; i < amountNums; i++){
            if(num){
                if(first){
                    int index = (int) (Math.random() * ((numbers.length - 1) + 1));
                    Log.d("TAG", String.valueOf(index));
                    numbersFinal.add(numbers[index]);
                    first = false;
                    daNumber += numbers[index];
                }else{
                    int index = (int) (Math.random() * ((numbers.length - 1) + 1));
                    Log.d("TAG", String.valueOf(index));
                    numbersFinal.add(numbers[index]);
                    numberOrOperations.add(false);

                    if(operationsFinal.get(operationsFinal.size() - 1).equals("+")){
                        daNumber += numbers[index];
                    }else if(operationsFinal.get(operationsFinal.size() - 1).equals("-")){
                        daNumber -= numbers[index];
                    }else{
                        daNumber *= numbers[index];
                    }

                }

                num = false;

            }else{
                int index = (int) (Math.random() * ((operations.length - 1) + 1));
                operationsFinal.add(operations[index]);
                numberOrOperations.add(true);
                num = true;
            }
    //                if(i == 0){
    //                    int index = (int) (Math.random() * ((numbers.length - 1) + 1));
    //                    Log.d("TAG", String.valueOf(index));
    //                    numbersFinal.add(numbers[index]);
    //                }else if(i == amountNums - 1){
    //                    int index = (int) (Math.random() * ((numbers.length - 1) + 1));
    //                    Log.d("TAG", String.valueOf(index));
    //                    numbersFinal.add(numbers[index]);
    //                }else{
    //                    if()
    //                }
                }



            Log.d("TAG", String.valueOf(numbersFinal));
            Log.d("TAG", String.valueOf(operationsFinal));
            Log.d("TAG", String.valueOf(numberOrOperations));

            return daNumber;
    }

    public int getNumber(int amountNums, String operation){
        boolean num = true;
        boolean first = true;
        int daNumber = 0;
        for(int i = 0; i < amountNums; i++){
            if(num){
                if(first){
                    int index = (int) (Math.random() * ((numbers.length - 1) + 1));
                    Log.d("TAG", String.valueOf(index));
                    numbersFinal.add(numbers[index]);
                    first = false;
                    daNumber += numbers[index];
                }else{
                    int index = (int) (Math.random() * ((numbers.length - 1) + 1));
                    Log.d("TAG", String.valueOf(index));
                    numbersFinal.add(numbers[index]);
                    numberOrOperations.add(false);

                    if(operationsFinal.get(operationsFinal.size() - 1).equals("+")){
                        daNumber += numbers[index];
                    }else if(operationsFinal.get(operationsFinal.size() - 1).equals("-")){
                        daNumber -= numbers[index];
                    }else{
                        daNumber *= numbers[index];
                    }

                }

                num = false;

            }else{
                operationsFinal.add(operation);
                numberOrOperations.add(true);
                num = true;
            }
        }

        Log.d("TAG", String.valueOf(numbersFinal));
        Log.d("TAG", String.valueOf(operationsFinal));
        Log.d("TAG", String.valueOf(numberOrOperations));

        return daNumber;
    }
}
