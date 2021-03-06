
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.JTextComponent;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;

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
    private int rowNum, colNum; // current cursor position

    private String currentFileExt;
    private String currentFilePath;
    private JTextPane activePane;
    private Color fontColor;
    private Color clrCrnt;
    private changeStyle2 c;
    SimpleAttributeSet alignment = new SimpleAttributeSet();
// End of Custom Variables

    public GroovyEditGUI() {
        // Constructor
        initComponents();
        b = new boldItalic();

        this.currentFileExt = "";
        this.currentFilePath = "";
        this.unsaved = false;
        c = new changeStyle2();

        String[] fontType = {"Ariel", "Serif", "Comic Sans", "Times New Roman", "Calibari"}; //Makes the options for font type
        cbFontType.setModel(new javax.swing.DefaultComboBoxModel(fontType));
        cbFontType.setFocusable(false);

        String[] fontSize = {"8", "10", "12", "14", "16"}; // Makes the options for font size
        cbFontSize.setModel(new javax.swing.DefaultComboBoxModel(fontSize));
        cbFontSize.setFocusable(false);

        Dimension layout = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(layout.width / 2 - this.getWidth() / 2, layout.height / 2 - this.getHeight() / 2);
        this.setSize(1200, 600);

        FileHandler handleSettings = new FileHandler("settings.txt", ".txt");
        handleSettings.readTxtFile();
        if (!handleSettings.getContentsArry().isEmpty()) {
            if (handleSettings.getContentsArry().get(0).equals("Enable")) {
                // TODO: Change all components to look good over darker background
                this.getContentPane().setBackground(Color.GRAY);
                this.jTextPane1.setBackground(Color.GRAY);
            }
        }

        // Create a new color based on the saved rgb values from the settings file (parsed saved string as int)
        Color savedColor = new Color(Integer.parseInt(handleSettings.getContentsArry().get(1)));
        // Sets the text color
        jTextPane1.setForeground(savedColor);

        rowNum = 1;
        colNum = 0;
        lblRowColNums.setText(" Row: " + rowNum + " Col: " + colNum); // Sets the initial row and col display
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
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jToolBar1 = new javax.swing.JToolBar();
        changeColor = new javax.swing.JButton();
        underline = new javax.swing.JButton();
        btnBold = new javax.swing.JButton();
        btnItalic = new javax.swing.JButton();
        removeFormatting = new javax.swing.JButton();
        insertImage = new javax.swing.JButton();
        counter = new javax.swing.JLabel();
        lblRowColNums = new javax.swing.JLabel();
        leftbtn = new javax.swing.JButton();
        centerbtn = new javax.swing.JButton();
        rightbtn = new javax.swing.JButton();
        cbFontType = new javax.swing.JComboBox<>();
        cbFontSize = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItem_New = new javax.swing.JMenuItem();
        menuItem_Open = new javax.swing.JMenuItem();
        menuItem_OpenPrev = new javax.swing.JMenuItem();
        menuItem_Save = new javax.swing.JMenuItem();
        menuItemSettings = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        emojib = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextPane1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        jTextPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextPane1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextPane1);

        jToolBar1.setRollover(true);
        jToolBar1.setAlignmentY(0.5F);
        jToolBar1.setMaximumSize(new java.awt.Dimension(66000, 33000));
        jToolBar1.setMinimumSize(new java.awt.Dimension(440, 20));
        jToolBar1.setPreferredSize(new java.awt.Dimension(430, 20));

        changeColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/colorText.png"))); // NOI18N
        changeColor.setFocusable(false);
        changeColor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        changeColor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        changeColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeColorActionPerformed(evt);
            }
        });
        jToolBar1.add(changeColor);

        underline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/format-text-underline.png"))); // NOI18N
        underline.setFocusable(false);
        underline.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        underline.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        underline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                underlineActionPerformed(evt);
            }
        });
        jToolBar1.add(underline);

        btnBold.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/format-text-bold.png"))); // NOI18N
        btnBold.setFocusable(false);
        btnBold.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBold.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoldActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBold);

        btnItalic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/format-text-italic.png"))); // NOI18N
        btnItalic.setFocusable(false);
        btnItalic.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnItalic.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnItalic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItalicActionPerformed(evt);
            }
        });
        jToolBar1.add(btnItalic);

        removeFormatting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Eraser-icon.png"))); // NOI18N
        removeFormatting.setFocusable(false);
        removeFormatting.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        removeFormatting.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        removeFormatting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFormattingActionPerformed(evt);
            }
        });
        jToolBar1.add(removeFormatting);

        insertImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/image-x-generic.png"))); // NOI18N
        insertImage.setFocusable(false);
        insertImage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        insertImage.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        insertImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertImageActionPerformed(evt);
            }
        });
        jToolBar1.add(insertImage);

        counter.setText("Length:   Lines:   Words:   ");
        jToolBar1.add(counter);

        lblRowColNums.setText("Row: Col: ");
        jToolBar1.add(lblRowColNums);

        leftbtn.setText("Left");
        leftbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftbtnActionPerformed(evt);
            }
        });

        centerbtn.setText("Center");
        centerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                centerbtnActionPerformed(evt);
            }
        });

        rightbtn.setText("Right");
        rightbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightbtnActionPerformed(evt);
            }
        });

        cbFontType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbFontType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFontTypeActionPerformed(evt);
            }
        });

        cbFontSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbFontSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFontSizeActionPerformed(evt);
            }
        });

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

        menuItemSettings.setText("Settings");
        menuItemSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSettingsActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemSettings);

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

        emojib.setText("Emoji Insert");
        emojib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emojibActionPerformed(evt);
            }
        });
        jMenu2.add(emojib);

        jMenuItem3.setText("Email");
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
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(leftbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(centerbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(rightbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(cbFontType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbFontSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(leftbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(centerbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rightbtn)
                        .addGap(39, 39, 39)
                        .addComponent(cbFontType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbFontSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jToolBar1.getAccessibleContext().setAccessibleDescription("");
        jToolBar1.getAccessibleContext().setAccessibleParent(jTextPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoldActionPerformed
        b.changeItB(jTextPane1, 1);
    }//GEN-LAST:event_btnBoldActionPerformed

    private void btnItalicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItalicActionPerformed
        b.changeItB(jTextPane1, 0);
    }//GEN-LAST:event_btnItalicActionPerformed

    private void insertImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertImageActionPerformed
        insertActionPerformed();
    }//GEN-LAST:event_insertImageActionPerformed

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
            currentFileExt = "";
            boolean extension = false;
            for (char ch : currentFilePath.toCharArray()) {
                if (ch == '.' || extension) {
                    extension = true;
                    currentFileExt += ch;
                }
            }
            FileHandler currFile = new FileHandler(currentFilePath, currentFileExt);
            jTextPane1.setText(currFile.getContents());
        } else {
            System.out.println("Open command cancelled by user." + "\n");
        }
    }//GEN-LAST:event_menuItem_OpenActionPerformed

    private void menuItem_OpenPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_OpenPrevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItem_OpenPrevActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        String s = jTextPane1.getText();
        new FindGUI(s, jTextPane1).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void emojibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emojibActionPerformed
        String emo;
        Emoji em = new Emoji(jTextPane1);
        em.setVisible(true);


    }//GEN-LAST:event_emojibActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        String msg = jTextPane1.getText();
        new EmailSending2(msg).setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void menuItem_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_SaveActionPerformed
        // SAVE FUNCTION IN FILE MENU
        System.out.println(currentFilePath);
        if (!currentFilePath.equals("")) {
            // There is a current file open
            FileHandler saveThis = new FileHandler(currentFilePath, currentFileExt);
            System.out.println(jTextPane1.getText());
            saveThis.writeFile(jTextPane1.getText(), currentFileExt);
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
        int length, lines, words;
        length = jTextPane1.getText().length();
        lines = (jTextPane1.getText() + "|").split("\n").length;
        words = jTextPane1.getText().trim().split("\\s+").length;
        counter.setText("Length:   " + length + " Lines:   " + lines + " Words:   " + words);
    }//GEN-LAST:event_jTextPane1KeyPressed

    private void changeColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeColorActionPerformed
        int start = getFocusedComponent().getSelectionStart();
        int end = getFocusedComponent().getSelectionEnd();
        int selectedLength = end - start;
        StyledDocument style = getFocusedComponent().getStyledDocument();
        AttributeSet oldset = style.getCharacterElement(end - 1).getAttributes();
        StyleContext sc = StyleContext.getDefaultStyleContext();
        fontColor = JColorChooser.showDialog(this, "Select Text Color", clrCrnt);
        AttributeSet s = sc.addAttribute(oldset, StyleConstants.Foreground, fontColor);
        style.setCharacterAttributes(start, selectedLength, s, true);
    }//GEN-LAST:event_changeColorActionPerformed

    private void removeFormattingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFormattingActionPerformed
        int start = getFocusedComponent().getSelectionStart();
        int end = getFocusedComponent().getSelectionEnd();
        int selectedLength = end - start;
        if (selectedLength == 0) {
        } else {
            Font font = new Font("Tahoma", Font.PLAIN, 11);
            clearFormat(getFocusedComponent(), font, Color.black, start);
        }
    }//GEN-LAST:event_removeFormattingActionPerformed

    private void underlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_underlineActionPerformed
        underline.addActionListener(new StyledEditorKit.UnderlineAction());

    }//GEN-LAST:event_underlineActionPerformed

    private void leftbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftbtnActionPerformed
        StyleConstants.setAlignment(alignment, StyleConstants.ALIGN_LEFT);
        jTextPane1.getStyledDocument().setParagraphAttributes(0, jTextPane1.getDocument().getLength(), alignment, false);
    }//GEN-LAST:event_leftbtnActionPerformed

    private void centerbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_centerbtnActionPerformed
        StyleConstants.setAlignment(alignment, StyleConstants.ALIGN_CENTER);
        jTextPane1.getStyledDocument().setParagraphAttributes(0, jTextPane1.getDocument().getLength(), alignment, false);
    }//GEN-LAST:event_centerbtnActionPerformed

    private void rightbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightbtnActionPerformed
        StyleConstants.setAlignment(alignment, StyleConstants.ALIGN_RIGHT);
        jTextPane1.getStyledDocument().setParagraphAttributes(0, jTextPane1.getDocument().getLength(), alignment, false);
    }//GEN-LAST:event_rightbtnActionPerformed


    private void cbFontTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFontTypeActionPerformed
        int size = 12; // Makes initial font size
        Font font = new Font("Serif", Font.PLAIN, size);

        if (cbFontType.getSelectedItem().toString() != null) {
            c.changeFont(jTextPane1, font.getSize(), cbFontType.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cbFontTypeActionPerformed

    private void cbFontSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFontSizeActionPerformed
        // TODO add your handling code here:
        int size = 12; // Makes initial font size
        Font font = new Font("Serif", Font.PLAIN, size);

        if (cbFontSize.getSelectedItem().toString() != null) {
            c.changeFont(jTextPane1, Integer.parseInt(cbFontSize.getSelectedItem().toString()), font.getFontName());
        }
    }//GEN-LAST:event_cbFontSizeActionPerformed

    private void menuItemSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSettingsActionPerformed
        // TODO add your handling code here:
        Settings settingsWindow = new Settings();
        settingsWindow.setVisible(true);

    }//GEN-LAST:event_menuItemSettingsActionPerformed
    public void clearFormat(JTextPane jtp, Font font, Color c, int start) {
        MutableAttributeSet attrs = jtp.getInputAttributes();
        StyleConstants.setFontFamily(attrs, font.getFamily());
        StyleConstants.setFontSize(attrs, font.getSize());
        StyleConstants.setItalic(attrs, false);
        StyleConstants.setBold(attrs, false);
        StyleConstants.setUnderline(attrs, false);
        StyleConstants.setStrikeThrough(attrs, false);
        // Set the font color
        StyleConstants.setForeground(attrs, c);
        // Retrieve the pane's document object
        StyledDocument doc = jtp.getStyledDocument();

        // Replace the style for the entire document.
        doc.setCharacterAttributes(start, getFocusedComponent().getSelectedText().length(), attrs, true);
    }

    private void insertActionPerformed() {
        JFileChooser jf = new JFileChooser();
        // Show open dialog
        int option = jf.showOpenDialog(this);
        // If user chooses to insert
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = jf.getSelectedFile();
            if (isImage(file)) {
                jTextPane1.insertIcon(new ImageIcon(file.getAbsolutePath()));
            } else // Show an error message, if not an image
            {
                JOptionPane.showMessageDialog(this, "The file is not an image.", "Not Image", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean isImage(File file) {
        String name = file.getName();
        return name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".jpeg") || name.endsWith(".gif") || name.endsWith(".JPG") || name.endsWith(".PNG") || name.endsWith(".JPEG") || name.endsWith(".GIF");
    }

    private void calcCursPos() {
        jTextPane1.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                JTextComponent textComp = (JTextComponent) e.getSource();
                try {
                    // Convert the UI to a 2d-rectangle
                    Rectangle rect = textComp.modelToView(e.getDot());

                    // Get the x and y coords from the rect and assign them to appropriate variable
                    // Math accounts for character size
                    rowNum = (int) (((rect.getY() - 4) / 16) + 1); // 
                    colNum = (int) (((rect.getX() - 6) / 7));
                    lblRowColNums.setText(" Row: " + rowNum + " Col: " + colNum);
                } catch (Exception ex) {
                    System.out.println("Caret Exception: " + ex.getMessage());
                }
            }
        }); // end addCaretListener
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
    private javax.swing.JButton centerbtn;
    private javax.swing.JButton changeColor;
    private javax.swing.JLabel counter;
    private javax.swing.JMenuItem emojib;
    private javax.swing.JButton insertImage;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblRowColNums;
    private javax.swing.JButton leftbtn;
    private javax.swing.JMenuItem menuItemSettings;
    private javax.swing.JMenuItem menuItem_New;
    private javax.swing.JMenuItem menuItem_Open;
    private javax.swing.JMenuItem menuItem_OpenPrev;
    private javax.swing.JMenuItem menuItem_Save;
    private javax.swing.JButton removeFormatting;
    private javax.swing.JButton rightbtn;
    private javax.swing.JButton underline;
    // End of variables declaration//GEN-END:variables
protected final JTextPane getFocusedComponent() {
        activePane = jTextPane1;

        KeyboardFocusManager kfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        Component focused = kfm.getPermanentFocusOwner();
        if (focused instanceof JTextPane) {
            activePane = (JTextPane) focused;
        }
        return activePane;
    }
}
