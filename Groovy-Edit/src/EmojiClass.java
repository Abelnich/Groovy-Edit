


import java.io.FileWriter;
import java.io.IOException;
import emoji-java-



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sheku
 */
public class EmojiClass {
    
    
   String ToConvertToEmoji(String emj)
   {
       String str = emj;
       String Convert = EmojiParser.ParseToUnicode(str);
       return Convert;
   }
    
}
