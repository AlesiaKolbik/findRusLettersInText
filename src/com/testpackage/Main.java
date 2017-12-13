package com.testpackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку, состоящую из слов:");
        String specifiedString = scanner.nextLine();
        ArrayList<String> arrayListrrayWords=split(specifiedString);
        String setOfLetters="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        int noCoincidence=0;
        for(int i=0;i<arrayListrrayWords.size();i++){
            String word=arrayListrrayWords.get(i);
            for(int j=0;j<=word.length()-1;j++){
                if(setOfLetters.contains(String.valueOf(word.charAt(i)))){
                    System.out.println(arrayListrrayWords.get(i));
                    break;
                }
                else {
                    if (j == word.length() - 1)
                        noCoincidence++;
                }
            }
        }

        if (arrayListrrayWords.size()==noCoincidence) {
            System.out.println("Совпадений не найдено.");
        }
    }

    private static ArrayList<String> split(String string) {
        String separator = " ";
        ArrayList<String> stringArray = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            int startInd = findNextIndexWord(string, i, separator);
            int endInd = findLastIndexWord(string, startInd, separator);
            String word = cutWord(string, startInd, endInd);
            stringArray.add(word);
            i = endInd;
        }
        return stringArray;
    }


    private static String cutWord(String string, int startInd, int endInd) {
        StringBuilder word = new StringBuilder();
        for (int i = startInd; i < endInd; i++) {
            word.append(string.charAt(i));
        }
        return word.toString();
    }

    private static int findLastIndexWord(String string, int index, String separator) {
        while (!separator.contains(String.valueOf(string.charAt(index)))) {
            index++;
            if (index == string.length() - 1)
                break;
        }
        return index;
    }

    private static int findNextIndexWord(String string, int index, String separator) {
        while (separator.contains(String.valueOf(string.charAt(index)))) {
            index++;
        }
        return index;
    }

}
