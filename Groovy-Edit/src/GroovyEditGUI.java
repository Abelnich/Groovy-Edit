<<<<<<< Updated upstream

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import jdk.jfr.events.FileReadEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sarmad Barya
 */
public class GroovyEditGUI extends javax.swing.JFrame {

    /**
     * Creates new form GroovyEditGUI
     */
    
// Custom Variables
    private boldItalic b;
    private boolean unsaved;
    private String currentFileExt;
    private String currentFilePath;
// End of Custom Variables
    
    public GroovyEditGUI() {
        // Constructor
        b = new boldItalic();

        this.currentFileExt = "";
        this.currentFilePath = "";
        this.unsaved = false;

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jToolBar1 = new javax.swing.JToolBar();
        btnBold = new javax.swing.JButton();
        btnItalic = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItem_New = new javax.swing.JMenuItem();
        menuItem_Open = new javax.swing.JMenuItem();
        menuItem_OpenPrev = new javax.swing.JMenuItem();
        menuItem_Save = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextPane1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextPane1);

        jToolBar1.setRollover(true);
        jToolBar1.setAlignmentY(0.5F);
        jToolBar1.setMaximumSize(new java.awt.Dimension(66000, 33000));
        jToolBar1.setMinimumSize(new java.awt.Dimension(440, 40));
        jToolBar1.setPreferredSize(new java.awt.Dimension(430, 40));

        btnBold.setText("Bold");
        btnBold.setFocusable(false);
        btnBold.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBold.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoldActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBold);

        btnItalic.setText("Italic");
        btnItalic.setFocusable(false);
        btnItalic.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnItalic.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnItalic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItalicActionPerformed(evt);
            }
        });
        jToolBar1.add(btnItalic);

        jButton3.setText("jButton3");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jMenu1.setText("File");

        menuItem_New.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuItem_New.setText("New");
        menuItem_New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_NewActionPerformed(evt);
            }
        });
        jMenu1.add(menuItem_New);

        menuItem_Open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuItem_Open.setText("Open");
        menuItem_Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_OpenActionPerformed(evt);
            }
        });
        jMenu1.add(menuItem_Open);

        menuItem_OpenPrev.setText("Open Previous");
        menuItem_OpenPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_OpenPrevActionPerformed(evt);
            }
        });
        jMenu1.add(menuItem_OpenPrev);

        menuItem_Save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuItem_Save.setText("Save");
        menuItem_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_SaveActionPerformed(evt);
            }
        });
        jMenu1.add(menuItem_Save);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Find");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("jMenuItem3");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
        );

        jToolBar1.getAccessibleContext().setAccessibleDescription("");
        jToolBar1.getAccessibleContext().setAccessibleParent(jTextPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoldActionPerformed
        b.changeStyle(jTextPane1, 1);
    }//GEN-LAST:event_btnBoldActionPerformed

    private void btnItalicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItalicActionPerformed
        b.changeStyle(jTextPane1, 0);
    }//GEN-LAST:event_btnItalicActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void menuItem_NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_NewActionPerformed
        // NEW FUNCTION IN FILE MENU
        // TODO: Check if file is open and unsaved before wiping
        // TODO: Set jTextPanel text to empty string

        if (unsaved) {
            // Ask user if they want to create new file even though they have unsaved work
            int dialogResult = JOptionPane.showConfirmDialog(null, "You have unsaved work, are you sure you want to create a new file?", "Warning", DO_NOTHING_ON_CLOSE);
            if (dialogResult == JOptionPane.YES_OPTION) {
                jTextPane1.setText("");
                unsaved = false;
            }
        } else {
            jTextPane1.setText("");
            unsaved = false;
        }

    }//GEN-LAST:event_menuItem_NewActionPerformed

    private void menuItem_OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_OpenActionPerformed
        // OPEN FUNCTION IN FILE MENU
        final JFileChooser fc = new JFileChooser();

        //Handle open button action.
        int returnVal = fc.showOpenDialog(GroovyEditGUI.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            // retrieve the file from the file selector screen
            File file = fc.getSelectedFile();
            currentFilePath = file.getAbsolutePath();
            FileHandler currFile = new FileHandler(currentFilePath);
            System.out.println("path: " + currentFilePath);
            if (currFile.getFileExt().contains(".")) {
                // Has a file extension
                currentFileExt = currFile.getFileExt();
            }
            jTextPane1.setText(currFile.arraylistToString());
        } else {
            System.out.println("Open command cancelled by user." + "\n");
        }
    }//GEN-LAST:event_menuItem_OpenActionPerformed

    private void menuItem_OpenPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_OpenPrevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItem_OpenPrevActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        String s = jTextPane1.getText();
        new FindGUI(s,jTextPane1).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void menuItem_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_SaveActionPerformed
        // SAVE FUNCTION IN FILE MENU
        System.out.println(currentFilePath);
        if (!currentFilePath.equals("")) {
            // There is a current file open
            FileHandler saveThis = new FileHandler(currentFilePath);
            System.out.println(jTextPane1.getText());
            saveThis.writeFile(jTextPane1.getText());
        } else {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new TXTSaveFilter());
            fileChooser.setDialogTitle("Specify a file to save");

            int userSelection = fileChooser.showSaveDialog(GroovyEditGUI.this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {

                String extension = fileChooser.getFileFilter().getDescription();

                if (extension.equals("*.txt,*.TXT")) {
                    currentFileExt = ".txt";
                } else {
                    currentFileExt = ".txt";
                }

                File fileToSave = fileChooser.getSelectedFile();

                System.out.println("Save as file: " + fileToSave.getAbsolutePath());
                try {
                    File newFile = new File(fileToSave.getAbsolutePath() + currentFileExt);
                    FileWriter myWriter = new FileWriter(newFile);
                    this.unsaved = false;
                } catch (Exception e) {
                    System.out.println("File save error: " + e.getMessage());
                }

            }
        }

    }//GEN-LAST:event_menuItem_SaveActionPerformed

    private void jTextPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPane1KeyPressed
        // When something is typed, the file gets marked as having unsaved changes
        this.unsaved = true;
    }//GEN-LAST:event_jTextPane1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GroovyEditGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GroovyEditGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GroovyEditGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GroovyEditGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GroovyEditGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBold;
    private javax.swing.JButton btnItalic;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem menuItem_New;
    private javax.swing.JMenuItem menuItem_Open;
    private javax.swing.JMenuItem menuItem_OpenPrev;
    private javax.swing.JMenuItem menuItem_Save;
    // End of variables declaration//GEN-END:variables
}
=======

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import jdk.jfr.events.FileReadEvent;
import java.awt.Font;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sarmad Barya
 */
public class GroovyEditGUI extends javax.swing.JFrame {

    /**
     * Creates new form GroovyEditGUI
     */
    
// Custom Variables
    private boldItalic b;
    private changeStyle c;
    private boolean unsaved;
    private String currentFileExt;
    private String currentFilePath;
// End of Custom Variables
    
    public GroovyEditGUI() {
        // Constructor
        b = new boldItalic();
        c = new changeStyle();
        
        this.currentFileExt = "";
        this.currentFilePath = "";
        this.unsaved = false;

        initComponents();
        
        String[] fontType = {"Ariel", "Serif", "Comic Sans", "Times New Roman", "Calibari"}; //Makes the options for font type
        cbFontType.setModel(new javax.swing.DefaultComboBoxModel(fontType));
        cbFontType.setFocusable(false);
        
        String[] fontSize = {"8", "10", "12", "14", "16"}; // Makes the options for font size
        cbFontSize.setModel(new javax.swing.DefaultComboBoxModel(fontSize));
        cbFontSize.setFocusable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jToolBar1 = new javax.swing.JToolBar();
        btnBold = new javax.swing.JButton();
        btnItalic = new javax.swing.JButton();
        cbFontType = new javax.swing.JComboBox<>();
        cbFontSize = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItem_New = new javax.swing.JMenuItem();
        menuItem_Open = new javax.swing.JMenuItem();
        menuItem_OpenPrev = new javax.swing.JMenuItem();
        menuItem_Save = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextPane1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextPane1);

        jToolBar1.setRollover(true);
        jToolBar1.setAlignmentY(0.5F);
        jToolBar1.setMaximumSize(new java.awt.Dimension(66000, 33000));
        jToolBar1.setMinimumSize(new java.awt.Dimension(440, 40));
        jToolBar1.setPreferredSize(new java.awt.Dimension(430, 40));

        btnBold.setText("Bold");
        btnBold.setFocusable(false);
        btnBold.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBold.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoldActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBold);

        btnItalic.setText("Italic");
        btnItalic.setFocusable(false);
        btnItalic.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnItalic.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnItalic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItalicActionPerformed(evt);
            }
        });
        jToolBar1.add(btnItalic);

        cbFontType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbFontType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFontTypeActionPerformed(evt);
            }
        });
        jToolBar1.add(cbFontType);

        cbFontSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbFontSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFontSizeActionPerformed(evt);
            }
        });
        jToolBar1.add(cbFontSize);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {"😀"};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jMenu1.setText("File");

        menuItem_New.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuItem_New.setText("New");
        menuItem_New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_NewActionPerformed(evt);
            }
        });
        jMenu1.add(menuItem_New);

        menuItem_Open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuItem_Open.setText("Open");
        menuItem_Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_OpenActionPerformed(evt);
            }
        });
        jMenu1.add(menuItem_Open);

        menuItem_OpenPrev.setText("Open Previous");
        menuItem_OpenPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_OpenPrevActionPerformed(evt);
            }
        });
        jMenu1.add(menuItem_OpenPrev);

        menuItem_Save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuItem_Save.setText("Save");
        menuItem_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_SaveActionPerformed(evt);
            }
        });
        jMenu1.add(menuItem_Save);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem1.setText("jMenuItem1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("jMenuItem3");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jToolBar1.getAccessibleContext().setAccessibleDescription("");
        jToolBar1.getAccessibleContext().setAccessibleParent(jTextPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoldActionPerformed
        b.changeStyle(jTextPane1, 1);
    }//GEN-LAST:event_btnBoldActionPerformed

    private void btnItalicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItalicActionPerformed
        b.changeStyle(jTextPane1, 0);
    }//GEN-LAST:event_btnItalicActionPerformed

    private void menuItem_NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_NewActionPerformed
        // NEW FUNCTION IN FILE MENU
        // TODO: Check if file is open and unsaved before wiping
        // TODO: Set jTextPanel text to empty string

        if (unsaved) {
            // Ask user if they want to create new file even though they have unsaved work
            int dialogResult = JOptionPane.showConfirmDialog(null, "You have unsaved work, are you sure you want to create a new file?", "Warning", DO_NOTHING_ON_CLOSE);
            if (dialogResult == JOptionPane.YES_OPTION) {
                jTextPane1.setText("");
                unsaved = false;
            }
        } else {
            jTextPane1.setText("");
            unsaved = false;
        }

    }//GEN-LAST:event_menuItem_NewActionPerformed

    private void menuItem_OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_OpenActionPerformed
        // OPEN FUNCTION IN FILE MENU
        final JFileChooser fc = new JFileChooser();

        //Handle open button action.
        int returnVal = fc.showOpenDialog(GroovyEditGUI.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            // retrieve the file from the file selector screen
            File file = fc.getSelectedFile();
            currentFilePath = file.getAbsolutePath();
            FileHandler currFile = new FileHandler(currentFilePath);
            System.out.println("path: " + currentFilePath);
            if (currFile.getFileExt().contains(".")) {
                // Has a file extension
                currentFileExt = currFile.getFileExt();
            }
            jTextPane1.setText(currFile.arraylistToString());
        } else {
            System.out.println("Open command cancelled by user." + "\n");
        }
    }//GEN-LAST:event_menuItem_OpenActionPerformed

    private void menuItem_OpenPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_OpenPrevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItem_OpenPrevActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void menuItem_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_SaveActionPerformed
        // SAVE FUNCTION IN FILE MENU
        System.out.println(currentFilePath);
        if (!currentFilePath.equals("")) {
            // There is a current file open
            FileHandler saveThis = new FileHandler(currentFilePath);
            System.out.println(jTextPane1.getText());
            saveThis.writeFile(jTextPane1.getText());
        } else {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new TXTSaveFilter());
            fileChooser.setDialogTitle("Specify a file to save");

            int userSelection = fileChooser.showSaveDialog(GroovyEditGUI.this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {

                String extension = fileChooser.getFileFilter().getDescription();

                if (extension.equals("*.txt,*.TXT")) {
                    currentFileExt = ".txt";
                } else {
                    currentFileExt = ".txt";
                }

                File fileToSave = fileChooser.getSelectedFile();

                System.out.println("Save as file: " + fileToSave.getAbsolutePath());
                try {
                    File newFile = new File(fileToSave.getAbsolutePath() + currentFileExt);
                    FileWriter myWriter = new FileWriter(newFile);
                    this.unsaved = false;
                } catch (Exception e) {
                    System.out.println("File save error: " + e.getMessage());
                }

            }
        }

    }//GEN-LAST:event_menuItem_SaveActionPerformed

    
    int size = 12; // Makes initial font size
    Font font = new Font("Serif", Font.PLAIN, size); // Makes initial font object to alter

    
    private void jTextPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPane1KeyPressed
        // When something is typed, the file gets marked as having unsaved changes
        this.unsaved = true;
    }//GEN-LAST:event_jTextPane1KeyPressed

   
    
    private void cbFontTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFontTypeActionPerformed
        
        if(cbFontType.getSelectedItem().toString() != null) {
        c.changeFont(jTextPane1, font.getSize(), cbFontType.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cbFontTypeActionPerformed

    private void cbFontSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFontSizeActionPerformed
        
        if(cbFontSize.getSelectedItem().toString() != null) {
    c.changeFont(jTextPane1, Integer.parseInt(cbFontSize.getSelectedItem().toString()), font.getFontName());
    }//GEN-LAST:event_cbFontSizeActionPerformed
    }
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GroovyEditGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GroovyEditGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GroovyEditGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GroovyEditGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GroovyEditGUI().setVisible(true);
            }
        });
    }
    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBold;
    private javax.swing.JButton btnItalic;
    private javax.swing.JComboBox<String> cbFontSize;
    private javax.swing.JComboBox<String> cbFontType;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    public javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem menuItem_New;
    private javax.swing.JMenuItem menuItem_Open;
    private javax.swing.JMenuItem menuItem_OpenPrev;
    private javax.swing.JMenuItem menuItem_Save;
    // End of variables declaration//GEN-END:variables
}
>>>>>>> Stashed changes
