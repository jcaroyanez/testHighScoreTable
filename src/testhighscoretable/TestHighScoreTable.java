/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testhighscoretable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author omen
 */
public class TestHighScoreTable {

    //C:\scores.txt
    /**
     * @param args the command line arguments
     */
    public void readFile() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\scores.txt"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            int i = 1;
            int totalPlayer = 1;
            int numPlayer = 0;
            int numRanking = 0;
            int auxNumRanking = 0;
            ArrayList<ValuesDetails> listValue = new ArrayList<ValuesDetails>();
            boolean paint = false;
            boolean paintNotValue = false;
            while (line != null) {
                if ((line.indexOf(" ") == -1)) {
                    System.out.println("NUMERO DE CASO DE PRUEBA " + line);
                }
                if (line.length() == 3) {
                    if (paint == true) {
                        Collections.sort(listValue, new SortbyScore());
                        int index = 1;
                        if (!(listValue.size() >= numRanking)) {
                            paintNotValue = true;
                            numRanking--;
                        }
                        for (int j = 0; j < numRanking; j++) {
                            if (j >= 1) {
                                if (listValue.get(j).getScore() == listValue.get(j - 1).getScore()) {
                                    System.out.println(index + " " + listValue.get(j).getValue());
                                } else {
                                    index++;
                                    System.out.println(index + " " + listValue.get(j).getValue());
                                }
                            } else {
                                System.out.println(index + " " + listValue.get(j).getValue());
                            }

                        }
                        if (paintNotValue == true) {
                            int count = auxNumRanking - listValue.size();
                            for (int j = 0; j < count; j++) {
                                System.out.println(index + " " + "*** ***");
                            }
                        }
                        listValue = new ArrayList<ValuesDetails>();
                        paint = false;
                        paintNotValue = false;
                    }
                    System.out.println(i);
                    numPlayer = Integer.parseInt(line.split(" ")[0]);
                    numRanking = Integer.parseInt(line.split(" ")[1]);
                    i++;
                    if (numPlayer == 0) {
                        for (int l = 0; l < numRanking; l++) {
                            System.out.println(1 + " " + "*** ***");
                        }
                    }
                } else if (line.length() > 3) {
                    paint = true;
                    ValuesDetails valuesDetails = new ValuesDetails();
                    valuesDetails.setScore(Integer.parseInt(line.split(" ")[1]));
                    valuesDetails.setValue(line);
                    listValue.add(valuesDetails);
                    totalPlayer++;
                }             

                line = br.readLine();
                if(line == null){
                    Collections.sort(listValue, new SortbyScore());
                    int index = 1;

                    if(!(listValue.size() >= numRanking)){
                        paintNotValue = true;
                        auxNumRanking = numRanking;
                        numRanking--;
                    }
                    for (int j = 0; j < numRanking; j++) {
                        if (j >= 1) {
                            if (listValue.get(j).getScore() == listValue.get(j - 1).getScore()) {
                                System.out.println(index + " " + listValue.get(j).getValue());
                            } else {
                                index++;
                                System.out.println(index + " " + listValue.get(j).getValue());
                            }
                        } else {
                            System.out.println(index + " " + listValue.get(j).getValue());
                        }

                    }
                    if(paintNotValue == true){
                        int count = auxNumRanking - listValue.size();
                        index++;
                        for (int j = 0; j < count; j++) {
                            System.out.println(index + " " + "*** ***");
                        }
                    }
                    listValue = new ArrayList<ValuesDetails>();
                    paint = false;
                    paintNotValue = false;
                }
            }
        } catch (Exception e) {
            System.out.println("Error \n" + e.getMessage());
        }

    }

    public static void main(String[] args) {
        TestHighScoreTable scoreTable = new TestHighScoreTable();
        scoreTable.readFile();
    }

}
