import java.io.File;
import javax.swing.filechooser.FileFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NickAbel
 */
class TXTSaveFilter extends FileFilter {
  @Override
  public boolean accept(File f) {
    if (f.isDirectory()) {
      return false;
    }

    String s = f.getName().toLowerCase();

    return s.endsWith(".txt");
  }

  @Override
  public String getDescription() {
    return "*.txt,*.TXT";
  }
}
