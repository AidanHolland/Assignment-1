/**ShopGUI.java will have two tabs and two JLists
  */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;

public class ShopGUI extends JFrame{
  //declarations and creation
  JTabbedPane tabs = new JTabbedPane();
  JPanel stockTab = new JPanel();
  JPanel cartTab = new JPanel();
  //components for stockTab
  JLabel lblName = new JLabel("Enter item name");
  JTextField txtName = new JTextField(10);
  JLabel lblPrice = new JLabel("Enter item price");
  JTextField txtPrice = new JTextField(10);
  JPanel inputPanel = new JPanel();
    JScrollPane scroll;
  
  JButton btnAdd = new JButton("Add new item");
  JButton btnRemove = new JButton("Remove item");
  JButton btnAddToCart = new JButton("Add to cart");
  JButton btnSave = new JButton("Save");
  JButton btnRead = new JButton("Read");
  JPanel buttonPanel = new JPanel();
  
  
  DefaultListModel <Item> stockModel = new DefaultListModel<Item>();
  JList<Item> stockList = new JList<Item>(stockModel);
  
  //components for cartTab
  DefaultListModel<Item> cartModel = new DefaultListModel<Item>();
  JList<Item> cartList = new JList<Item>(cartModel);
  
  JButton btnRemoveFromCart = new JButton("Remove from cart");
  JButton btnSaveCart = new JButton("Save cart");
  JPanel buttonCartPanel = new JPanel();
  
  //storage of data
  ArrayList<Item> stock = new ArrayList<Item>();
  ArrayList<Item> cart = new ArrayList<Item>();
  
  //constructor
  public ShopGUI(){
    super("Shop interface");
    //build tabs
    tabs.addTab("Stock", stockTab);
    tabs.addTab("Cart", cartTab);
    //add to frame
    add(tabs);
    //build inputPanel
    inputPanel.setLayout(new GridLayout(2,2, 10, 30));
    inputPanel.setBorder(new EmptyBorder(30,30,30,30));
    inputPanel.add(lblName);
    inputPanel.add(txtName);
    inputPanel.add(lblPrice);
    inputPanel.add(txtPrice);
    //before to add to tab wich is panel I'll change layout
    //to BorderLayout
    stockTab.setLayout(new BorderLayout());
    stockTab.add(inputPanel,BorderLayout.WEST);
    //build buttonPanel
    buttonPanel.add(btnAdd);
    buttonPanel.add(btnRemove);
    buttonPanel.add(btnAddToCart);
    buttonPanel.add(btnSave);
    buttonPanel.add(btnRead);
    //add buttonPanel to stockTab
    stockTab.add(buttonPanel, BorderLayout.SOUTH);
    //build and add JList
    Item item1 = new Item("Jeans", 100);
    Item item2 = new Item("Shirt", 50);
    stockModel.addElement(item1);
    stockModel.addElement(item2);
    //store data
    stock.add(item1);
    stock.add(item2);
    //add JList embedded into JScrollPane
    scroll = new JScrollPane(stockList);
    stockTab.add(scroll, BorderLayout.CENTER);
    //build cartTab
    cartTab.setLayout(new BorderLayout());
    buttonCartPanel.add(btnRemoveFromCart);
    buttonCartPanel.add(btnSaveCart);
    cartTab.add(buttonCartPanel, BorderLayout.SOUTH);
    cartTab.add(new JScrollPane(cartList), BorderLayout.CENTER);
    
    btnAdd.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        String name = txtName.getText();
        String priceStr = txtPrice.getText();
        double price = Double.parseDouble(priceStr);
        Item item = new Item(name, price);
        stockModel.addElement(item);
        txtName.setText("");
        txtPrice.setText("");
        stock.add(item);
      }
     
    }
     
    );
    btnRemove.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        int index = stockList.getSelectedIndex();
        if(index !=-1){
          stockModel.remove(index);
          stock.remove(index);
        }
      }
    });
   /* btnAddToCart.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        java.util.List<Item> list = stockList.getSelectedValuesList();
        for( Object it: list){
          Item item = (Item)it;
          cartModel.addElement(item);
          cart.add(item);
        }
      }
    });*/
     btnAddToCart.addActionListener(new ActionListener()
     {
      public void actionPerformed(ActionEvent e)
      {
       int[] indices = stockList.getSelectedIndices();
        for( int i = 0; i < indices.length; i++){
          int index = indices[i];
          cartModel.addElement(stock.get(index));
          cart.add(stock.get(index));
        }
      }
    });
     btnSave.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent e){
       saveItems();
     }});
     
    btnRead.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent e){
       readItems();
     }}); 
   
     
   }




//constructor
   private void saveItems(){
     String fileName = JOptionPane.showInputDialog("Enter file name");
    try{
     FileOutputStream fos = new FileOutputStream(fileName);
     ObjectOutputStream oos = new ObjectOutputStream(fos);
      for(Item item : stock){
      oos.writeObject(item);
     }
    }
    catch(Exception e){
     e.printStackTrace();
    }
  }
  
   private void readItems(){
     stock.clear();
     stockModel.clear();
    try{
     FileInputStream fis =  new FileInputStream("items.dat");
     ObjectInputStream ois =   new ObjectInputStream(fis);
     while(true){
      Object obj = ois.readObject();
      Item b = (Item)obj;
      stock.add(b);
      stockModel.addElement(b);
  
     }
      
    }
    catch(EOFException eof){
     //do nothing
    }
    catch(Exception e){
     e.printStackTrace();
    }
    System.out.println(stock);
   // scroll = new JScrollPane(stockList);
   // add(scroll, BorderLayout.CENTER);
  }

  public static void main(String[] args){
    ShopGUI fr = new ShopGUI();
      fr.setLocationRelativeTo(null);
      fr.setSize(500, 250);
      fr.setVisible(true);
  }
}
    
  