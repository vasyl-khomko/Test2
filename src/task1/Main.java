/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author modul
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = null;
        try {
            st = br.readLine();
        } catch (IOException ex) {
        }
        st = st.toLowerCase();
        System.out.println(getIndexMaxPolindrome(getListPalindromes(getListWords(st))));
    }
    
    private static ArrayList<String> getListWords(String st) {
        ArrayList<String> listWords = new ArrayList<String>();
        int beginIndex = 0;
        int endIndex = 0;
        for(int i = 0; i < st.length(); i++) {
            if(Character.isLetter(st.charAt(i)) == false && Character.isDigit(st.charAt(i)) == false && st.charAt(i) != '-') {
                endIndex = i;
                String word = st.substring(beginIndex, endIndex);
                if(word.length() > 0) {
                    //System.out.println("word: " + word);
                    listWords.add(word);
                }
                beginIndex = endIndex + 1;
            }
            if(i == st.length() - 1) {
                endIndex = i + 1;
                String word = st.substring(beginIndex, endIndex);
                if(word.length() > 0) {
                    //System.out.println("word: " + word);
                    listWords.add(word);
                }
            }
        }
        return listWords;
    }
    
    private static ArrayList<Object[]> getListPalindromes(ArrayList<String> listWords) {
        ArrayList<Object[]> listPalindromes = new ArrayList<Object[]>();
        for(int i = 0; i < listWords.size(); i++) {
            String word = listWords.get(i);
            if(isPalindrome(word)){
                Object[] objects = new Object[2];
                objects[0] = i;
                objects[1] = word;
                //System.out.println("palindromes: " + word);
                listPalindromes.add(objects);
            }
        }
        return listPalindromes;
    }
    
    private static boolean isPalindrome(String word) {
        if(word.length() == 1) {
            return false;
        }
        for(int i = 0; i < word.length(); i++) {
            //System.out.println(word.charAt(i) + " ? " + word.charAt((word.length() - 1) - i));  
            if(word.charAt(i) != word.charAt((word.length() - 1) - i)) {                      
                return false;
            }
        }
        return true;
    }
    private static Integer getIndexMaxPolindrome(ArrayList<Object[]> listPalindromes) {
        if(listPalindromes.isEmpty()) {
            return 0;
        }
        Object[] max = listPalindromes.get(0);
        for(int i = 0; i < listPalindromes.size(); i++) {
            if(((String)max[1]).length() < ((String)listPalindromes.get(i)[1]).length()) {
                max = listPalindromes.get(i);
            }
        }
        //System.out.println("max: " + (String)max[1]);
        return (Integer)max[0] + 1;
    }
}
