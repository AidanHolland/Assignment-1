import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NameFrame extends JFrame implements ActionListener
{
 JPanel pnlCenter, pnlSouth, pnlNorth;  //subcontainers
 //other components
  JButton btnPrint, btnClear;
  JLabel lblFirst, lblLast;
  JTextField txtFirst, txtLast;
  JTextArea jtaName;
  
//constructor
  public NameFrame()  
  {
//create components
    pnlNorth = new JPanel();
    pnlNorth.setLayout(new GridLayout(2,2,10,20));
    pnlSouth = new JPanel();
    pnlCenter = new JPanel();
    lblFirst = new JLabel("        First name");
    lblLast = new JLabel("        Last name");
    txtFirst = new JTextField(30);
    txtLast = new JTextField(30);
    btnPrint = new JButton("PRINT");
    btnClear = new JButton("CLEAR");
    jtaName = new JTextArea(10,25);
//add components to panels
    pnlNorth.add(lblFirst);
    pnlNorth.add(txtFirst);
    pnlNorth.add(lblLast);
    pnlNorth.add(txtLast);
    pnlCenter.add(jtaName);
    pnlSouth.add(btnPrint);
//add panels to frame
    add(pnlCenter, BorderLayout.CENTER);
    add(pnlNorth, BorderLayout.NORTH);
    add(pnlSouth, BorderLayout.SOUTH);
    pnlSouth.add(btnPrint);
    btnPrint.addActionListener(this);
    pnlSouth.add(btnClear);
    btnClear.addActionListener(this);  
  }
  
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == btnPrint){
     String name = "Your full name is " + txtFirst.getText() + " " +   
      txtLast.getText()+ "\n";
       jtaName.append(name);
    }
    else{
      txtFirst.setText("");
      txtLast.setText(""); 
    }
  }
  
  public static void main(String[] args) {
    NameFrame fr = new NameFrame();
    fr.setSize(300,200);
    fr.setLocationRelativeTo(null);
    fr.setVisible(true);
  }
}

    
    

