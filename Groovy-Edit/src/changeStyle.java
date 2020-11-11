
import java.awt.Font;
import javax.swing.JTextPane;

/**
 * @author Max
 */


import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class changeStyle {
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
