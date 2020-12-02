
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sheku
 */
public class changeStyle2 {

    void changeFont(JTextPane jTextPane1, int parseInt, String fontName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public class ChangeStyle {
    
    public ChangeStyle() {
        
    }
    
    public boolean changeFont(JTextPane inp, int size, String style) {
        
        StyledDocument d = (StyledDocument) inp.getStyledDocument();
        int selSt = inp.getSelectionStart();
        int selEn = inp.getSelectionEnd();
        if (selSt == selEn){
            return false;
        }
        
        Element ele = d.getCharacterElement(selSt);
        AttributeSet as = ele.getAttributes();
        MutableAttributeSet asN = new SimpleAttributeSet(as.copyAttributes());
        
        StyleConstants.setFontFamily(asN, style);
        StyleConstants.setFontSize(asN, size);
        
        d.setCharacterAttributes(selSt, selEn-selSt, asN, true);
        
        return true;
    }
}
}
