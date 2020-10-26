/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Robert Brosig
 */
public class boldItalic {
    public boolean changeStyle(JTextPane inp, int style){ //0 is italic, 1 is bold
        StyledDocument d = (StyledDocument) inp.getStyledDocument();
        int selSt = inp.getSelectionStart();
        int selEn = inp.getSelectionEnd();
        if (selSt == selEn){
            return false;
        }
        Element ele = d.getCharacterElement(selSt);
        AttributeSet as = ele.getAttributes();
        
        MutableAttributeSet asN = new SimpleAttributeSet(as.copyAttributes());
        switch (style){
            case 0: StyleConstants.setItalic(asN, !StyleConstants.isItalic(as));
                    break;
            case 1: StyleConstants.setBold(asN, !StyleConstants.isBold(as));
                    break;
            default:StyleConstants.setBold(asN, false);
                    StyleConstants.setItalic(asN, false);
        }
        d.setCharacterAttributes(selSt, selEn-selSt, asN, true);
        return true;
        
    }
}
