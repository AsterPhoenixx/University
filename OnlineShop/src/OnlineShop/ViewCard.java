package OnlineShop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import jdk.jfr.events.FileWriteEvent;
import jdk.nashorn.internal.runtime.UserAccessorProperty;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class ViewCard extends JFrame {
	
	static JPanel contentPane;
    static	JTable table = new JTable();
    static JScrollPane panell= new JScrollPane(table);
    static  DefaultTableModel model = new  DefaultTableModel();
    static ViewCard frame ;
   static JLabel lblOverallSum;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame= new ViewCard();
					frame.setVisible(true);
					getOverAllSumOfOrders();
	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewCard() {
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 916, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Object[] column = {"Product name ","Quantity","Price","overall"};
		//Object[] rows= new Object[4];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		table.setBackground(Color.red);
		table.setForeground(Color.white);
		 Font font =new  Font("", 1, 12);
         table.setFont(font);
         table.setRowHeight(30);
         panell.setBounds(10, 12, 649, 251);
         contentPane.add(panell);
		
		JButton btnNewButton = new JButton("Pay with debit card");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
			  File file = new File("D:\\JULIEN\\Uni\\Java\\OnlineShop\\ExportOrders\\OrderTxt.txt");
				if(!file.exists())
				{
					
						file.createNewFile();
				}
					FileWriter writeOrder= new FileWriter(file.getAbsoluteFile());
					BufferedWriter bf = new BufferedWriter(writeOrder);
					
					for(int i =0;i<table.getRowCount();i++)
					{
						for(int j =0;j<table.getColumnCount();j++)
						{
							bf.write(table.getModel().getValueAt(i, j)+"|  |");
						}
					
						bf.newLine();
						bf.write("__________________________________________");
						bf.newLine();
					}
					System.out.println();
				
					bf.write("....................................................");bf.newLine();
					bf.write("........|Thank you for purchasing with us|..........");bf.newLine();
					bf.write("....................................................");bf.newLine();
					bf.write("Payed by Debit card"+" on date: " +OnlineShopGrame.lblClock.getText() +" Overall amount :"+lblOverallSum.getText());
					bf.close();
					writeOrder.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(new CompoundBorder());
		btnNewButton.setOpaque(false);
		btnNewButton.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\atmDebitcard.png"));
		btnNewButton.setBounds(669, 196, 235, 67);
		contentPane.add(btnNewButton);
		
		JButton btnPayWithPaypall = new JButton("Pay with PayPall");
		btnPayWithPaypall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {File file = new File("D:\\JULIEN\\Uni\\Java\\OnlineShop\\ExportOrders\\OrderTxt.txt");
				if(!file.exists())
				{
					
						file.createNewFile();
				}
					FileWriter writeOrder= new FileWriter(file.getAbsoluteFile());
					BufferedWriter bf = new BufferedWriter(writeOrder);
					
					for(int i =0;i<table.getRowCount();i++)
					{
						for(int j =0;j<table.getColumnCount();j++)
						{
							bf.write(table.getModel().getValueAt(i, j)+"|  |");
						}
					
						bf.newLine();
						bf.write("__________________________________________");
						bf.newLine();
					}
					System.out.println();
				
					bf.write("....................................................");bf.newLine();
					bf.write("........|Thank you for purchasing with us|..........");bf.newLine();
					bf.write("....................................................");bf.newLine();
					bf.write("Payed by Paypal"+" on date: " +OnlineShopGrame.lblClock.getText() +" Overall amount :"+lblOverallSum.getText());
					bf.close();
					writeOrder.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnPayWithPaypall.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnPayWithPaypall.setContentAreaFilled(false);
		btnPayWithPaypall.setBorder(new CompoundBorder());
		btnPayWithPaypall.setOpaque(false);
		btnPayWithPaypall.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\paypal.png"));
		btnPayWithPaypall.setBounds(669, 106, 211, 67);
		contentPane.add(btnPayWithPaypall);
		
		JButton btnClearOrder = new JButton("Clear Order");
		btnClearOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i= table.getSelectedRow();
				if(i>=0) {
					model.removeRow(i);
					getOverAllSumOfOrders();
				}else {
					System.out.println("Delete error!");
				}
			}
		});
		btnClearOrder.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnClearOrder.setContentAreaFilled(false);
		btnClearOrder.setOpaque(false);
		btnClearOrder.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\ResizedImages\\clear-icon-3.png"));
		btnClearOrder.setBorder(new CompoundBorder());
		btnClearOrder.setBounds(661, 12, 173, 82);
		contentPane.add(btnClearOrder);
		
		JLabel lblOverallOrder = new JLabel("Overall Order: ");
		lblOverallOrder.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		lblOverallOrder.setBounds(465, 284, 96, 31);
		contentPane.add(lblOverallOrder);
		
		 lblOverallSum = new JLabel();
		lblOverallSum.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		
		lblOverallSum.setBounds(553, 284, 102, 31);
		contentPane.add(lblOverallSum);
		JLabel labelBackground = new JLabel("");
		labelBackground.setIcon(new ImageIcon("D:\\JULIEN\\Uni\\Java\\OnlineShop\\Images\\Blue_gaussian_blur_1920x1200.jpg"));
		labelBackground.setBounds(0, -25, 969, 499);
		contentPane.add(labelBackground);
	}
	public static void getOverAllSumOfOrders() {
		int sum=0;
		for(int i=0;i<table.getRowCount();i++)
		{
			sum=sum+ Integer.parseInt(table.getValueAt(i, 3).toString().substring(2));
			
		}
		lblOverallSum.setText("ˆ "+Integer.toString(sum));
	}
	public static void getAllElementsCount() {
		int sumCount=0;
		for(int i=0;i<table.getRowCount();i++)
		{
			sumCount=sumCount+ Integer.parseInt(table.getValueAt(i, 1).toString());
			
		}
		OnlineShopGrame.btnViewCard.setToolTipText("You have "+Integer.toString(sumCount)+" items in your shop bag");
		OnlineShopGrame.btnViewCardShirts.setToolTipText("You have "+Integer.toString(sumCount)+" items in your shop bag");
		OnlineShopGrame.btnViewCardDress.setToolTipText("You have "+Integer.toString(sumCount)+" items in your shop bag");
	}
}
