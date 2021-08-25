package com.company;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.lang.*;
import java.util.List;


public class ReadFileLineByLine {


    public void readline() {
        try {
            File file = new File("C:\\Java\\test.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            HashMap<String, Integer> map = new HashMap<>();

            while (line != null) {
                if (line.startsWith("#") == false && !line.isEmpty()) {
                    if (line.startsWith("print")) {
                        String printLine = line.substring(6);



                            if (printLine.startsWith("\"")) {
//                                int p2 = printLine.indexOf("\"", 1);
//                                String resultLine = printLine.substring(1, p2);
//                                System.out.println(resultLine);

                                int index1 =-1;
                                int index2= -1;
                                 while (true){
                                     index1 = printLine.indexOf("\"", index2+1);
                                     index2 = printLine.indexOf("\"", index1+1);
                                             if (index1 == -1 || index2 == -1){
                                                 break;
                                             }
                                     System.out.print(printLine.substring((index1)+1, index2)+" ");

                                 }
                                System.out.println(printLine.substring((index1)+1, index2));



                            }



                        else if (printLine.startsWith("$")) {


                            String resultLine = "";
                            String item = "";
                            for (int i = 0; i < printLine.length(); i++){
                                char symbol = printLine.charAt(i);
                                if (symbol != ','){
                                    item += Character.toString(symbol);
                                }
                                if (symbol == ',' || i == printLine.length() - 1 ) {
                                    item = item.trim();
                                    if (item.startsWith("$")){
                                        resultLine += map.get(item);
                                    }
                                    else if(item.startsWith("\"")){
                                        item = item.substring(1, item.length() - 1);
                                        resultLine += item;
                                    }
                                    item = "";
                                }
                            }
                            System.out.println(resultLine);
                        }
                    }
                    else if (line.startsWith("set")) {
                        int index1 = line.indexOf("$");
                        int index2 = line.indexOf("=");
                        String varLeft = line.substring(index1, index2).trim();
                        String expressionRight = line.substring(index2 + 1).trim();


                        if (expressionRight.contains("+")) {
                            String[] vars = expressionRight.split("[+]");
                            String var1 = vars[0].trim();
                            String var2 = vars[1].trim();

                            Integer intVar1 = map.get(var1);
                            Integer intVar2 = map.get(var2);
                            Integer sum = intVar1 + intVar2;
                            map.put(varLeft, sum);
                        }
                        else if (expressionRight.contains("-")) {
                            String[] vars = expressionRight.split("[-]");
                            String var1 = vars[0].trim();
                            String var2 = vars[1].trim();

                            Integer intVar1 = map.get(var1);
                            Integer intVar2 = map.get(var2);
                            Integer diff = intVar1 - intVar2;
                            map.put(varLeft, diff);
                        }
                        else {
                            map.put(varLeft, Integer.parseInt(expressionRight));
                        }

                    }
                    else {
                        System.out.println("Ошибка в скрипте - неправильное начало строки!");
                        break;
                    }
                }

            line = reader.readLine();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
           } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





                           /* String[] itemsArr = printLine.split("[,]");
                            List<String> items = new ArrayList<>(Arrays.asList(itemsArr));
                            String resultLine = "";
                            for (String item : items) {
                                item = item.trim();
                                if (item.startsWith("\"")) {

                                    item = item.substring(1, item.length() - 1);
                                    resultLine+=item;
                                // System.out.print(resultLine);
                                } else   {

                                    item = item.substring(0, item.length() - 1);
                                    resultLine += item;
                                   // System.out.println("----------"+resultLine);
                                }
                            }
                            System.out.println(resultLine);*/

                     /*       String resultLine = "";
                            String item = "";
                            for (int i = 0; i < printLine.length(); i++){
                                char symbol = printLine.charAt(i);
                                if (symbol != ','){
                                    item += Character.toString(symbol);
                                }
                                if (symbol == ',' || i == printLine.length() -1 ) {

                                    item = item.trim();
                                    if (item.startsWith("\"")){
                                        resultLine += item;
                                    }
                                    else if(item.startsWith("\"")){
                                        item = item.substring(1, item.length() -1);
                                        resultLine += item;
                                    }
                                    item = "";
                                }
                            }
                            System.out.println(resultLine);*/




/* String resultLine = "";
                                String item = "";
                                for (int i = 0; i < printLine.length(); i++){
                                    char symbol = printLine.charAt(i);
                                    if (symbol != ','){
//                                        item += Character.toString(symbol);
                                    int p2 = printLine.indexOf("\"", 1);
                                    resultLine = printLine.substring(1, p2);
                                     System.out.println(resultLine);
                                  }

                                    if (symbol == ',' || i == printLine.length() -1 ) {
                                        int p3 = printLine.indexOf(",");
                                        resultLine = printLine.substring(1,p3);
                                        System.out.println(resultLine);

                                        item = item.trim();
                                        if (item.startsWith("\"")){
                                            resultLine += item;
                                        }
                                        else if(item.startsWith("\"")){
                                            item = item.substring(1, item.length() -1);
                                            resultLine += item;
                                        }
                                        item = "";
                                    }
                                }
                                System.out.println(resultLine);
*/

