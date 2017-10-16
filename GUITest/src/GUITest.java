

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUITest extends JFrame implements ActionListener
{
    //Container Classes: JFrame, JApplet and JPanel, contains other components
    //Helper Classes: Color, Graphics, Font, Dimension, Layout Manager, not subclasses of component, located in AWT
    //FlowLayout is for left to right style order
    //GridLayout = setLayout(new GridLayout(2,3) //This will make 2 coloumns and 3 rows
    
    //ActionListener is an interface (class with no variables but declaration of some methods, to import AL use import java.awt.event.*;
    //AL has a single method, actionPerformed.
    
    
    JPanel pnlGreen;
    JButton jbtOK = new JButton ("OK");
    JLabel jlblName = new JLabel("Enter your name: ");
    JTextField jtfName = new JTextField("Type Name Here");
    JTextField jtfNameNumSize = new JTextField(8); //Sets as a certain size, only displays one row
    JTextArea jta = new JTextArea(10,25); //Shows more than one row, goes as height + width
    JButton btnOne, btnTwo;
    
    
    public GUITest()
    {
        pnlGreen = new JPanel();
        pnlGreen.setBackground(Color.GREEN);
        stuff(); 
        
        setLayout(new GridLayout(1,2));
        btnOne = new JButton("Button One");
        btnTwo = new JButton("Button Two");
        btnOne.addActionListener(this);
        btnTwo.addActionListener(this);
        add(btnOne);
        add(btnTwo);

    }
    
    public void stuff()
    {
        pnlGreen.add(jbtOK);
        jbtOK.addActionListener(this);
        pnlGreen.add(jlblName, BorderLayout.EAST);
    }
    
   
    
    public void actionPerformed(ActionEvent e)
    {
        /*String buttonText= jbtOK.getText();
        if(buttonText.equals("OK"))
        {
            jbtOK.setText("Cancel");
        }
        else
        {
            jbtOK.setText("OK");
        }*/
        
        if(e.getSource() == btnOne)
        {
            System.out.println("Button One");
        }
        else
        {
            System.out.println("Button Two");
        }
    }
    
    public void exercise()
    {
        JPanel p1 = new JPanel();
        p1.add(jbtOK);
        p1.add(jbtOK);
        p1.add(jbtOK);
        
    setLayout(new FlowLayout()); //frame uses BorderLayout by default
    add(p1);
    add(p1);
    }

    public static void main(String[] args) {
        GUITest fw = new GUITest();
        fw.setSize(600, 400);
        fw.add(fw.pnlGreen, BorderLayout.CENTER);
        fw.pnlGreen.setSize(1, 1);
        fw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fw.setLocationRelativeTo(null); //Makes window appear in centre
        fw.setVisible(true);
      
        
    }
    
}
