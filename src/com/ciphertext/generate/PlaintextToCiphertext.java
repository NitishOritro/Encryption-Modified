/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciphertext.generate;

import com.letter.cyptography.LetterInNumber;
import java.util.Random;

/**
 *
 * @author Nitish Ranjan Bhownmik
 */
public class PlaintextToCiphertext 
{
    int i,j,k,row=16,column=0;
    String ciphertext = "";
    
    public String generateCipherText(String plaintext, int n)
    {
        for(i=0;i<plaintext.length();i++)
        {
            if(Character.isLetter(plaintext.charAt(i)) && plaintext.charAt(i) != ' ')
            {
                LetterInNumber letterInNumber = new LetterInNumber(plaintext.charAt(i));
                int cipherValue =  (letterInNumber.getNumber() + n) % 26;       
                
                if(cipherValue == 0)
                {
                    cipherValue = 26;
                }
                if(cipherValue < 0)
                {
                    cipherValue = cipherValue + 26;
                }
                    
                LetterInNumber numberInLetter = new LetterInNumber(cipherValue);
                
                char cipherCharacter = numberInLetter.getLetter();
                if(Character.isLowerCase(plaintext.charAt(i)))
                {
                    cipherCharacter = Character.toLowerCase(cipherCharacter);
                    ciphertext = ciphertext + cipherCharacter;
                }
                else
                {
                    ciphertext = ciphertext + cipherCharacter;
                }
            }
            else if(plaintext.charAt(i) != ' ' || Character.isWhitespace(plaintext.charAt(i)))
            {
                ciphertext = ciphertext + plaintext.charAt(i);
            }
        }
        //System.out.println("CipherText is : " +ciphertext);
        return ciphertext;
    }
    
    public String generateCipherTextToRotorCiphertext(String plaintext, String ciphertext, int row, int column)
    {
        //Initialize a 2d array
        char ciphertextRotor [][] = new char [row][column];
        char ciphertextLetterCheckRotor [][] = new char [row][column];
        int pointer = 0;
        
        int padding = ciphertext.length() % 16;
        
        for(i=0;i<column;i++)
        {
            for(j=0;j<row;j++)
            {
                if(pointer <= ciphertext.length())
                {
                    if(j == row-1 && i >= padding && padding != 0)
                    {
                        ciphertextRotor [j][i] = 'X';
                    }
                    else
                    {
                        ciphertextRotor [j][i] = ciphertext.charAt(pointer);
                        pointer++;
                    }
                }
            }
            //System.out.println(pointer);
        }
        
        //System.out.println("ciphertextRotor is");
        
        for(i=0;i<row;i++)
        {
            for(j=0;j<column;j++)
            {
                //ciphertextRotor [row][column] = plaintext.charAt(j);
                 //System.out.print(" ("+i+" "+j+")"+ciphertextRotor [i][j]+"   ");
            }
            //System.out.println();
        }
        
        for(i=0;i<row;i++)
        {
            for(j=0;j<column;j++)
            {
                 ciphertextLetterCheckRotor[i][j] = ciphertextRotor [i][j];
            }
            //System.out.println();
        }
        //System.out.println("ciphertext LetterCheck Rotor is");
        for(i=0;i<row;i++)
        {
            for(j=0;j<column;j++)
            {
                //ciphertextRotor [row][column] = plaintext.charAt(j);
                 //System.out.print(" ("+i+" "+j+")"+ciphertextLetterCheckRotor [i][j]+"   ");
            }
            //System.out.println();
        }
        int paddIndexI = ciphertext.length() / 16; 
        int padIndexJ = ciphertext.length() % 16;
        for(i=0;i<row;i++)
        {
            for(j=0;j<column;j++)
            {
                if(Character.isLetter(ciphertextRotor[i][j]) && ciphertextRotor[i][j] != ' ')
                {
                    if(j >= padIndexJ && i == paddIndexI)
                    {
                        ciphertextRotor [i][j] = 'Z';
                    }
                    else 
                    {
                        LetterInNumber cipherInNumber = new LetterInNumber(ciphertextRotor[i][j]);
                    
                        int cipherValue =  (cipherInNumber.getNumber() + i + 1) % 26;       
                    
                        if(cipherValue == 0)
                        {
                            cipherValue = 26;
                        }
                        LetterInNumber cipherInLetter = new LetterInNumber(cipherValue);
                        if(Character.isLowerCase(ciphertextLetterCheckRotor [i][j]))
                        {
                            ciphertextRotor[i][j] = Character.toLowerCase(cipherInLetter.getLetter());
                            
                        }
                        else
                        {
                            ciphertextRotor[i][j] = cipherInLetter.getLetter();
                        }
                    }
                    //ciphertext = ciphertext + cipherCharacter;
                    
                }//ciphertextRotor [row][column] = plaintext.charAt(j);
                 //System.out.print(" ("+i+" "+j+")"+ciphertextRotor [i][j]+"   ");
            }
            //System.out.println();
        }
        
        
        System.out.println();System.out.println();
        for(i=0;i<row;i++)
        {
            for(j=0;j<column;j++)
            {
                //ciphertextRotor [row][column] = plaintext.charAt(j);
                 //System.out.print(" ("+i+" "+j+")"+ciphertextRotor [i][j]+"   ");
            }
            //System.out.println();
        }
        String ciphertextGenerate = "";
        for(i=0;i<row;i++)
        {
            for(j=0;j<column;j++)
            {
                
                ciphertextGenerate = ciphertextGenerate + ciphertextRotor [i][j];
            }
            ciphertextGenerate = ciphertextGenerate + ' ';
        }
        
        //System.out.println("Generate CipherText is : " +ciphertextGenerate);
        return ciphertextGenerate;
    }
       
}
