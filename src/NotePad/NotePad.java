import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class NotePad extends JFrame {
    private JEditorPane textArea = new JEditorPane();
    JTextPane jTextPanel = new JTextPane();
    JTextArea theText = new JTextArea();
    JPanel contentPanel;
    BorderLayout borderLayout = new BorderLayout();
    JMenu jMenuFile = new JMenu();
    JMenuBar jMenuBar = new JMenuBar();
    JLabel statusBar = new JLabel();
    JMenu File = new JMenu();
    JMenuItem open = new JMenuItem();
    JMenuItem save = new JMenuItem();
    JMenuItem exit = new JMenuItem();
    JMenu View = new JMenu();
    JMenuItem bold = new JMenuItem();
    JMenuItem italic = new JMenuItem();
    JMenu Copytext = new JMenu();
    JMenuItem copy = new JMenuItem();
    JMenuItem past = new JMenuItem();
    JMenuItem cut = new JMenuItem();
    JMenu Textoption = new JMenu();
    JMenuItem textj = new JMenuItem();
    JMenuItem texti = new JMenuItem();
    JMenuItem textp = new JMenuItem();
    JMenu Coloroption = new JMenu();
    JMenuItem colorpink = new JMenuItem();
    JMenuItem colorblue = new JMenuItem();
    JMenuItem colordark = new JMenuItem();
    JMenuItem colorred = new JMenuItem();
    JMenuItem coloryellow = new JMenuItem();
    JMenuItem colorgreen = new JMenuItem();
    JMenu Sizeoption = new JMenu();
    JMenuItem size10 = new JMenuItem();
    JMenuItem size12 = new JMenuItem();
    JMenuItem size14 = new JMenuItem();
    JMenuItem size16 = new JMenuItem();
    JMenuItem size18 = new JMenuItem();
    JMenuItem size20 = new JMenuItem();
    JMenuItem size22 = new JMenuItem();
    JMenuItem size24 = new JMenuItem();
    JMenuItem size26 = new JMenuItem();
    JMenuItem size28 = new JMenuItem();
    JMenuItem size30 = new JMenuItem();
    JMenu Font = new JMenu();
    JMenuItem Font1 = new JMenuItem();
    JMenuItem Font2 = new JMenuItem();
    JMenuItem Font3 = new JMenuItem();
    JMenuItem Font4 = new JMenuItem();
    JMenuItem Font5 = new JMenuItem();
    JMenuItem Font6 = new JMenuItem();
    JMenu Help = new JMenu();
    JMenuItem popi = new JMenuItem();

    public NotePad() throws Exception {
        this.setSize(700, 500);
        this.setTitle("Notepad");
        this.setDefaultCloseOperation(2);
        this.textArea.setFont(new Font("", 0, 14));
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(this.textArea);
        this.jMenuBar.add(this.File);
        this.jMenuBar.add(this.Copytext);
        this.jMenuBar.add(this.Textoption);
        this.jMenuBar.add(this.Coloroption);
        this.jMenuBar.add(this.Sizeoption);
        this.jMenuBar.add(this.Font);
        this.jMenuBar.add(this.Help);
        this.setJMenuBar(this.jMenuBar);
        this.File.setText("File");
        this.open.setText("Open");
        this.File.add(this.open);
        this.save.setText("Save");
        this.File.add(this.save);
        this.exit.setText("Exit");
        this.File.add(this.exit);
        this.exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(NotePad.this.exit, "Good job. Byeeee!");
                System.exit(0);
            }
        });
        this.save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser save = new JFileChooser();
                int option = save.showSaveDialog(save);
                if (option == 0) {
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
                        out.write(NotePad.this.textArea.getText());
                        out.close();
                    } catch (Exception var5) {
                        System.out.println(var5.getMessage());
                    }
                }

            }
        });
        this.open.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser open = new JFileChooser();
                int option = open.showOpenDialog(open);
                if (option == 0) {
                    NotePad.this.theText.setText("");

                    try {
                        Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));

                        while(scan.hasNext()) {
                            NotePad.this.textArea.setText(scan.nextLine() + "\n");
                        }
                    } catch (Exception var5) {
                        System.out.println(var5.getMessage());
                    }
                }

            }
        });
        this.Copytext.setText("CopyPaste");
        this.copy.setText("Copy");
        this.Copytext.add(this.copy);
        this.past.setText("Paste");
        this.Copytext.add(this.past);
        this.cut.setText("Cut");
        this.Copytext.add(this.cut);
        this.copy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NotePad.this.textArea.copy();
            }
        });
        this.past.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NotePad.this.textArea.paste();
            }
        });
        this.cut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NotePad.this.textArea.cut();
            }
        });
        this.Textoption.setText("Change font");
        this.textj.setText("Bold");
        this.Textoption.add(this.textj);
        this.texti.setText("Italic");
        this.Textoption.add(this.texti);
        this.textp.setText("Plain");
        this.Textoption.add(this.textp);
        this.texti.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setFont(new Font("TAHOMA", 2, NotePad.this.textArea.getFont().getSize()));
            }
        });
        this.textj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setFont(new Font("", 1, NotePad.this.textArea.getFont().getSize()));
            }
        });
        this.textp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setFont(new Font("", 0, NotePad.this.textArea.getFont().getSize()));
            }
        });
        this.Font.setText("Font");
        this.Font1.setText("Times New Roman");
        this.Font.add(this.Font1);
        this.Font2.setText("Arial");
        this.Font.add(this.Font2);
        this.Font3.setText("Cambial");
        this.Font.add(this.Font3);
        this.Font4.setText("Georgia");
        this.Font.add(this.Font4);
        this.Font5.setText("Verdana");
        this.Font.add(this.Font5);
        this.Font6.setText("Monospaced");
        this.Font.add(this.Font6);
        this.Font1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setFont(new Font("Times New Roman", NotePad.this.textArea.getFont().getStyle(), NotePad.this.textArea.getFont().getSize()));
            }
        });
        this.Font2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setFont(new Font("Arial", NotePad.this.textArea.getFont().getStyle(), NotePad.this.textArea.getFont().getSize()));
            }
        });
        this.Font3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setFont(new Font("Cambial", NotePad.this.textArea.getFont().getStyle(), NotePad.this.textArea.getFont().getSize()));
            }
        });
        this.Font4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setFont(new Font("Georgia", NotePad.this.textArea.getFont().getStyle(), NotePad.this.textArea.getFont().getSize()));
            }
        });

        this.Font5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setFont(new Font("Verdana", NotePad.this.textArea.getFont().getStyle(), NotePad.this.textArea.getFont().getSize()));
            }
        });

        this.Font6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setFont(new Font("Monospaced", NotePad.this.textArea.getFont().getStyle(), NotePad.this.textArea.getFont().getSize()));
            }
        });




        this.Sizeoption.setText("Change size");
        this.size10.setText("10");
        this.Sizeoption.add(this.size10);
        this.size12.setText("12");
        this.Sizeoption.add(this.size12);
        this.size14.setText("14");
        this.Sizeoption.add(this.size14);
        this.size16.setText("16");
        this.Sizeoption.add(this.size16);
        this.size18.setText("18");
        this.Sizeoption.add(this.size18);
        this.size20.setText("20");
        this.Sizeoption.add(this.size20);
        this.size22.setText("22");
        this.Sizeoption.add(this.size22);
        this.size24.setText("24");
        this.Sizeoption.add(this.size24);
        this.size26.setText("26");
        this.Sizeoption.add(this.size26);
        this.size28.setText("28");
        this.Sizeoption.add(this.size28);
        this.size30.setText("30");
        this.Sizeoption.add(this.size30);
        this.size10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setFont(new Font("", 2, 10));
            }
        });
        this.size12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setFont(new Font("", 2, 12));
            }
        });
        this.size14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setFont(new Font("", 2, 14));
            }
        });
        this.size16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setFont(new Font("", 2, 16));
            }
        });
        this.size18.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setFont(new Font("", 2, 18));
            }
        });
        this.size20.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setFont(new Font("", 2, 20));
            }
        });
        this.size22.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setFont(new Font("", 2, 22));
            }
        });
        this.size24.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setFont(new Font("", 2, 24));
            }
        });
        this.size26.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setFont(new Font("", 2, 26));
            }
        });
        this.size28.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setFont(new Font("", 2, 28));
            }
        });
        this.size30.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setFont(new Font("", 2, 30));
            }
        });
        this.Coloroption.setText("Change color");
        this.colorpink.setText("Pink");
        this.Coloroption.add(this.colorpink);
        this.colorblue.setText("Blue");
        this.Coloroption.add(this.colorblue);
        this.colordark.setText("Dark Grey");
        this.Coloroption.add(this.colordark);
        this.colorred.setText("Red");
        this.Coloroption.add(this.colorred);
        this.coloryellow.setText("Yellow");
        this.Coloroption.add(this.coloryellow);
        this.colorgreen.setText("Green");
        this.Coloroption.add(this.colorgreen);
        this.colorpink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setForeground(Color.pink);
            }
        });
        this.colorblue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setForeground(Color.blue);
            }
        });
        this.colordark.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setForeground(Color.darkGray);
            }
        });
        this.colorred.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setForeground(Color.red);
            }
        });
        this.coloryellow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setForeground(Color.yellow);
            }
        });
        this.colorgreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NotePad.this.textArea.setForeground(Color.green);
            }
        });
        this.Help.setText("Help");
        this.popi.setText("About");
        this.Help.add(this.popi);
        this.popi.addActionListener((e) -> {
            JOptionPane.showMessageDialog((Component)null, "Java Developer Baranets Artemiy\n All rights reserved.(Ты пидор!)", "", 1, new ImageIcon("/Users/enter/Desktop/аvаllоn/src/photo43.jpg"));
        });
    }


    public static void main(String[] args) throws Exception {
        NotePad app = new NotePad();
        app.setVisible(true);
    }
}
