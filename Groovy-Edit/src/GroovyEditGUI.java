
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.KeyboardFocusManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.UIManager;
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
    private boolean encrypted;

    private String currentFileExt;
    private String currentFilePath;
    private JTextPane activePane;
    private Color fontColor;
    private Color clrCrnt;
    private changeStyle c;
    SimpleAttributeSet alignment = new SimpleAttributeSet();
    SimpleAttributeSet margins = new SimpleAttributeSet();
    SimpleAttributeSet spacing = new SimpleAttributeSet();
    
    //Create Global music player object
    private static musicPlayer player = musicPlayer.getInstance();
    private static String filePath;
    private String savedFilePath;
    private static String trackTitle;
    private static long clipTimePosition;

    private static boolean isPlaying = false;
    private static boolean isLooping = false;
    
    private FileHandler handleSettings;
    private ArrayList<String> settingsContents;
    private boolean darkMode;
    
// End of Custom Variables

    JMenuBar mbar;

    JMenu menu;
    
    public GroovyEditGUI() {
        // Constructor
        initComponents();
        //dispose();
        //setUndecorated(true);
        b = new boldItalic();

        this.currentFileExt = "";
        this.currentFilePath = "";
        this.unsaved = false;
        c = new changeStyle();
        
        mbar=new JMenuBar(){

        @Override
        public void paintComponent(Graphics g)

        {

            boolean j = g.drawImage(Toolkit.getDefaultToolkit().getImage("GradientToolbar.png"),0,0,this);

        }

        };
       
        jMenuBar1=mbar;
        
        this.jMenuBar1.paintComponents(this.jMenuBar1.getGraphics());

        String[] fontType = {"Ariel", "Serif", "Comic Sans", "Times New Roman", "Calibari"}; //Makes the options for font type
        cbFontType.setModel(new javax.swing.DefaultComboBoxModel(fontType));
        cbFontType.setFocusable(false);

        String[] fontSize = {"8", "10", "12", "14", "16"}; // Makes the options for font size
        cbFontSize.setModel(new javax.swing.DefaultComboBoxModel(fontSize));
        cbFontSize.setFocusable(false);

        Dimension layout = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(layout.width / 2 - this.getWidth() / 2, layout.height / 2 - this.getHeight() / 2);
        this.setSize(1200, 600);

        // Settings stuff
        handleSettings = new FileHandler("settings.txt", ".txt", false);

        settingsContents = handleSettings.getContentsArry();

        // Dark mode
        if (settingsContents.size() == 0) {
            // if settings file is missing the first item
            settingsContents.add("Disable"); // dark mode toggle : index 0
            handleSettings.clearTxtFile();
            handleSettings.writeTxtFile(handleSettings.arraylistToString(handleSettings.getContentsArry()));
        }
        
        if (settingsContents.get(0).equals("Enable")) {
            darkMode = true;
        } else {
            darkMode = false;
        }
        
        // Default text color
        if (settingsContents.size() == 1) {
            // if settings file is missing the second item
            settingsContents.add("-16777216"); // default text color (black in this case) in rgb : index 1
            handleSettings.clearTxtFile();
            handleSettings.writeTxtFile(handleSettings.arraylistToString(handleSettings.getContentsArry()));
        }

        // Create a new color based on the saved rgb values from the settings file (parsed saved string as int)
        Color savedColor = new Color(Integer.parseInt(handleSettings.getContentsArry().get(1)));
        // Sets the text color
        jTextPane1.setForeground(savedColor);
                
        // Last saved music file location
        if (settingsContents.size() == 2) {
            // if settings file is missing the third item
            savedFilePath = "C:\\Users"; // first \ is an escape character for the second
            settingsContents.add(savedFilePath); // default music file location : index 2
            handleSettings.clearTxtFile();
            handleSettings.writeTxtFile(handleSettings.arraylistToString(handleSettings.getContentsArry()));
        }
        savedFilePath = settingsContents.get(2);

        rowNum = 1;
        colNum = 0;
        lblRowColNums.setText(" Row: " + rowNum + " Col: " + colNum); // Sets the initial row and col display
        
                // Music Stuff
        player.loadMusic(savedFilePath);
        if (isPlaying) {
            // There is currently music playing
            fileLocationField.setText(filePath);
        } else {
            // Nothing is playing
            if (savedFilePath != null && savedFilePath.contains(".wav")) {
                // if file exists and is playable
                fileLocationField.setText(savedFilePath);
            }
            filePath = "";
            trackTitle = "";
        }
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
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jFrame3 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jMenuItem4 = new javax.swing.JMenuItem();
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
        jLabel2 = new javax.swing.JLabel();
        btnPlayPause = new javax.swing.JButton();
        lblMusic = new javax.swing.JLabel();
        fileLocationField = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        btnOneInch = new javax.swing.JButton();
        btnOneAndHalfInch = new javax.swing.JButton();
        btnTwoInch = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        menuItem_New = new javax.swing.JMenuItem();
        menuItem_Open = new javax.swing.JMenuItem();
        menuItem_Save = new javax.swing.JMenuItem();
        menuItemSettings = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        emojib = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jButton1.setText("jButton1");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jTextPane1 = new javax.swing.JTextPane(){

            @Override
            public void paintComponent(Graphics g)

            {

                Dimension size = this.getSize();
                g.drawImage(new ImageIcon(this.getClass().getResource("Space.png")).getImage(),0,0,size.width,size.height,this);
                super.paintComponent(g);
            }

        };

        jTextPane1.setOpaque(false);
        jTextPane1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        jTextPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextPane1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextPane1);

        jToolBar1.setFloatable(false);
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
  
        jLabel2.setText("jLabel2");

        jMenuBar1 = new javax.swing.JMenuBar(){

            @Override
            public void paintComponent(Graphics g)

            {
                Dimension size = this.getSize();
                g.drawImage(new ImageIcon(this.getClass().getResource("GradientToolbar.png")).getImage(),0,0,size.width,size.height,this);

            }

        };

        jMenu3.setText("—| | Groovy Edit | |—");
        jMenu3.setFocusable(false);
        jMenu3.setRequestFocusEnabled(false);
        jMenu3.setRolloverEnabled(false);
        jMenuBar1.add(jMenu3);
        btnPlayPause.setText("⏯");
        btnPlayPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayPauseActionPerformed(evt);
            }
        });

        lblMusic.setText("Music");

        fileLocationField.setText("No file selected");

        btnBrowse.setText("...");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        btnOneInch.setText("1\"");
        btnOneInch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOneInchActionPerformed(evt);
            }
        });

        btnOneAndHalfInch.setText("1.5\"");
        btnOneAndHalfInch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOneAndHalfInchActionPerformed(evt);
            }
        });

        btnTwoInch.setText("2\"");
        btnTwoInch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTwoInchActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        menuItem_New.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItem_New.setText("New");
        menuItem_New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_NewActionPerformed(evt);
            }
        });
        jMenu1.add(menuItem_New);

        menuItem_Open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItem_Open.setText("Open");
        menuItem_Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_OpenActionPerformed(evt);
            }
        });
        jMenu1.add(menuItem_Open);

        menuItem_Save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
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

        jMenuItem2.setText("Print");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
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
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(leftbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(centerbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(rightbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(cbFontType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbFontSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOneInch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOneAndHalfInch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTwoInch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(lblMusic)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fileLocationField, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBrowse)
                        .addGap(18, 18, 18)
                        .addComponent(btnPlayPause)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leftbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMusic)
                    .addComponent(fileLocationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowse)
                    .addComponent(btnPlayPause))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(centerbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rightbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOneInch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOneAndHalfInch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTwoInch)
                        .addGap(10, 10, 10)
                        .addComponent(cbFontType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbFontSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(281, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)))
        );

        jToolBar1.getAccessibleContext().setAccessibleDescription("");

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
                currentFilePath = "";
                currentFileExt = "";
            }
        } else {
            jTextPane1.setText("");
            unsaved = false;
            currentFilePath = "";
            currentFileExt = "";
        }

    }//GEN-LAST:event_menuItem_NewActionPerformed

    public void toggleEncrypt(){
        encrypted = !encrypted;
    }
    
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
            FileHandler currFile = new FileHandler(currentFilePath, currentFileExt,encrypted);
            jTextPane1.setText(currFile.getContents());
        } else {
            System.out.println("Open command cancelled by user." + "\n");
        }
    }//GEN-LAST:event_menuItem_OpenActionPerformed

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
        if (!currentFilePath.equals("")) {
            // There is a current file open
            FileHandler saveThis = new FileHandler(currentFilePath, currentFileExt, encrypted);
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

                try {
                    FileHandler saveThis;
                    currentFilePath = fileToSave.getAbsolutePath();
                    if (currentFilePath.contains(".txt")) {
                        // If the file name contains the extension, don't add it again
                        saveThis = new FileHandler(currentFilePath.substring(0, currentFilePath.length() - 3), currentFileExt, encrypted);
                    } else {
                        saveThis = new FileHandler(currentFilePath + currentFileExt, currentFileExt, encrypted);
                    }
                    saveThis.writeFile(jTextPane1.getText(), currentFileExt);
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
        calcCursPos();
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
        Settings settingsWindow = new Settings(this);
        settingsWindow.setVisible(true);

    }//GEN-LAST:event_menuItemSettingsActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new Thread(() -> {  //Multithread it so that it doesn't freeze the system
            PrinterJob job = PrinterJob.getPrinterJob();
            PageFormat form = job.defaultPage();
            Paper pap = new Paper();
            pap.setImageableArea(40, 40, pap.getWidth() - 40 * 2, pap.getHeight() - 40 * 2); //Margin is 40, can change to variable later
            form.setPaper(pap);
            Printable gPrint = jTextPane1.getPrintable(null, null);  //Header and footer are arguments, we don't need those
            job.setPrintable(gPrint,form); 
            boolean doPrint = job.printDialog();
            if (doPrint) {
                try {
                    job.print();
                } catch (PrinterException e) {
                    // Job failed
                }
            }
        }).start();
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    
    private void halfbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_halfbtnActionPerformed
        StyleConstants.setLineSpacing(spacing, (float).25);
        jTextPane1.getStyledDocument().setParagraphAttributes(0, jTextPane1.getDocument().getLength(), spacing, false);
    }//GEN-LAST:event_halfbtnActionPerformed

    private void singlebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singlebtnActionPerformed
        StyleConstants.setLineSpacing(spacing, (float).5);
        jTextPane1.getStyledDocument().setParagraphAttributes(0, jTextPane1.getDocument().getLength(), spacing, false);

    }//GEN-LAST:event_singlebtnActionPerformed

    private void doublebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doublebtnActionPerformed
        StyleConstants.setLineSpacing(spacing, (float)1);
        jTextPane1.getStyledDocument().setParagraphAttributes(0, jTextPane1.getDocument().getLength(), spacing, false);
    }//GEN-LAST:event_doublebtnActionPerformed

    private void btnPlayPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayPauseActionPerformed
        if (savedFilePath.contains(".wav")) {filePath = savedFilePath;}
        if (!filePath.isEmpty()) {
            // A file has been loaded
            int extStart = filePath.indexOf(".");
            if (filePath.substring(extStart).equals(".wav")) {
                if (isPlaying) {
                    // User has paused the audio
                    clipTimePosition = player.clip.getMicrosecondPosition();
                    player.clip.stop();
                    btnPlayPause.setText("▶");
                } else {
                    // User has resumed the audio
                    player.clip.setMicrosecondPosition(clipTimePosition);
                    player.clip.start();
                    btnPlayPause.setText("⏸");
                }
                isPlaying = !isPlaying;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a .wav audio file first.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnPlayPauseActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
         final JFileChooser fc = new JFileChooser();

        //Handle open button action.
        int returnVal = fc.showOpenDialog(GroovyEditGUI.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            // retrieve the file from the file selector screen
            File file = fc.getSelectedFile();
            filePath = file.getAbsolutePath();
            fileLocationField.setText(filePath);
            int extStart = filePath.indexOf(".");
            trackTitle = file.getPath().substring(0, extStart);
            if (filePath.substring(extStart).equals(".wav")) {
                player.loadMusic(filePath);
                savedFilePath = filePath;
                settingsContents.set(2, savedFilePath); // write last file location to settings
                handleSettings.clearTxtFile();
                System.out.println("f " + settingsContents);
                handleSettings.writeTxtFile(handleSettings.arraylistToString(settingsContents));
            } else {
                // not a supported file
                JOptionPane.showMessageDialog(null, "Please select a wav file.", "File Compatibility Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnOneInchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOneInchActionPerformed
        StyleConstants.setLeftIndent(margins, 75);
        jTextPane1.getStyledDocument().setParagraphAttributes(0, jTextPane1.getDocument().getLength(), margins, false);    
    }//GEN-LAST:event_btnOneInchActionPerformed

    private void btnOneAndHalfInchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOneAndHalfInchActionPerformed
        StyleConstants.setLeftIndent(margins, 113);
        jTextPane1.getStyledDocument().setParagraphAttributes(0, jTextPane1.getDocument().getLength(), margins, false);
    }//GEN-LAST:event_btnOneAndHalfInchActionPerformed

    private void btnTwoInchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTwoInchActionPerformed
        StyleConstants.setLeftIndent(margins, 150);
        jTextPane1.getStyledDocument().setParagraphAttributes(0, jTextPane1.getDocument().getLength(), margins, false);
    }//GEN-LAST:event_btnTwoInchActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // update dark mode if needed
        handleSettings.readTxtFile();
        settingsContents = handleSettings.getContentsArry();
        if (!settingsContents.isEmpty()) { // make sure the settings file has been created
            if (settingsContents.get(0).equals("Enable")) {
                darkMode = true;
            } else {
                darkMode = false;
            }
        }
        changeDarkMode(darkMode);
        
        // Create a new color based on the saved rgb values from the settings file (parsed saved string as int)
        Color savedColor = new Color(Integer.parseInt(handleSettings.getContentsArry().get(1)));
        // Sets the text color
        jTextPane1.setForeground(savedColor);
        
    }//GEN-LAST:event_formWindowGainedFocus
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
                    rowNum = (int) (((rect.getY() - 4) / 16) + 1) +1; // 
                    colNum = (int) (((rect.getX() - 6) / 7));
                    lblRowColNums.setText(" Row: " + rowNum + " Col: " + colNum);
                } catch (Exception ex) {
                    System.out.println("Caret Exception: " + ex.getMessage());
                }
            }
        }); // end addCaretListener
    }
    
    private void changeDarkMode(boolean dark) {
        if (dark) {
            jToolBar1.setBackground(Color.GRAY);
            this.getContentPane().setBackground(Color.GRAY);
            jTextPane1.setBackground(Color.LIGHT_GRAY);
            lblMusic.setForeground(Color.WHITE);
        } else {
            jToolBar1.setBackground(UIManager.getColor("Panel.background"));
            this.getContentPane().setBackground(UIManager.getColor("Panel.background"));
            jTextPane1.setBackground(Color.WHITE);
            lblMusic.setForeground(Color.BLACK);
        }
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
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnItalic;
    private javax.swing.JButton btnOneAndHalfInch;
    private javax.swing.JButton btnOneInch;
    private javax.swing.JButton btnPlayPause;
    private javax.swing.JButton btnTwoInch;
    private javax.swing.JComboBox<String> cbFontSize;
    private javax.swing.JComboBox<String> cbFontType;
    private javax.swing.JButton centerbtn;
    private javax.swing.JButton changeColor;
    private javax.swing.JLabel counter;
    private javax.swing.JMenuItem emojib;
    private javax.swing.JTextField fileLocationField;
    private javax.swing.JButton insertImage;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblMusic;
    private javax.swing.JLabel lblRowColNums;
    private javax.swing.JButton leftbtn;
    private javax.swing.JMenuItem menuItemSettings;
    private javax.swing.JMenuItem menuItem_New;
    private javax.swing.JMenuItem menuItem_Open;
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
