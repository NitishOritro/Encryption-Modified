/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography.project;

import com.ciphertext.generate.PlaintextToCiphertext;
import com.letter.cyptography.LetterInNumber;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Character.isLetter;
import static java.lang.Character.isWhitespace;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Nitish Ranjan Bhownmik
 */
public class CryptographyProject 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        //String plaintext = "BANGLADESH BEAUTIFUL MY NUMBER 12#@&";
        String plaintext = "";
        System.out.println("Enter Your Plaintext");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        plaintext = br.readLine();
        
        String ciphertext = "";
        String ciphertextGenerate = "";
        
        Random rand = new Random();
        int key = rand.nextInt(3) + 3;
        
        //System.out.println("Plaintext length is "+plaintext.length());
        
        PlaintextToCiphertext plaintextToCiphertext = new PlaintextToCiphertext();
        ciphertext = plaintextToCiphertext.generateCipherText(plaintext, key);
        int i,j,k,row=0,column=16;
   
        
        //Divide a row column accorfing to detect cipherRotor machine
        
        if(plaintext.length() % 16 == 0) 
        {
            row = plaintext.length() / 16;
        }
        else 
        {
            row = plaintext.length() / 16 + 1;
        }
        //System.out.println("Column is : " +column);
        
        //Call 2d rotor machine array
        ciphertextGenerate = plaintextToCiphertext.generateCipherTextToRotorCiphertext(plaintext ,ciphertext, row, column);
        
        System.out.println("Here Random key = "+key+"\nGenerate CipherText is : " +ciphertextGenerate);
    }
    
}
