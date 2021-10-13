package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj parametr K: ");
        int k = sc.nextInt();
        System.out.println();
        sc.close();
        int counter = 0;
        File testFile = new File("iris_test.txt");
        File trainingFile = new File("iris_training.txt");
        Scanner testCol = new Scanner(testFile);
        Scanner trainingSc = new Scanner(trainingFile);
        String columns = testCol.nextLine();
        columns.trim();
        String[] col = columns.split("\\s+");
        int colCounter = -1;
        for (String s:col) {
            //System.out.println(s);
            colCounter++;
        }
       // System.out.println(colCounter);
        testCol.close();
        Scanner testSc = new Scanner(testFile);
        double[] testDatas = new double[colCounter-1];
        double[] trainingDatas = new double[colCounter-1];
        double[] minVec = new double[k];
       // double[]
        String testType, trainingType;
        HashMap<Double,String> map = new HashMap();
        List<Iris> lista = new ArrayList();
        double vec = 0;


        while(testSc.hasNext()){
            for (int i = 0; i < colCounter-1; i++){
                testDatas[i] = Double.parseDouble(testSc.next().replaceAll(",","."));
            }
            testType = testSc.next();

            while(trainingSc.hasNext()){
                for (int i = 0; i < colCounter-1; i++){
                    trainingDatas[i] = Double.parseDouble(trainingSc.next().replaceAll(",","."));
                    vec += Math.pow(trainingDatas[i] - testDatas[i], 2.0);
                }
                trainingType = trainingSc.next();
                vec = Math.sqrt(vec);
                lista.add(new Iris(vec,testType,trainingType));
                vec=0;
                trainingType="";
                testType="";
                testDatas = new double[colCounter-1];
                trainingDatas = new double[colCounter-1];
            }
            Collections.sort(lista, (u1, u2) -> Double.compare(u1.getDistance(),u2.getDistance()));



        }for (Iris s:lista){
            System.out.println(s.toString());}


    }
}
