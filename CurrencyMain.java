import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import package2.CurrencyConverter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class CurrencyMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField entAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrencyMain frame = new CurrencyMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CurrencyMain() {
		setTitle("Team 10 Converters");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 765, 284);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Currency Converter", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Type In Amount: ");
		lblNewLabel.setBounds(39, 40, 98, 21);
		panel.add(lblNewLabel);
		
		entAmount = new JTextField();
		entAmount.setBounds(161, 40, 316, 32);
		panel.add(entAmount);
		entAmount.setColumns(10);
		
		JComboBox toBox = new JComboBox();
		toBox.setModel(new DefaultComboBoxModel(new String[] {"United States of America (U.S. Dollar)", "Canada (Canadian Dollar)", "Japan (Yen)", "European Union (Euro)", "China (Yuan)", "Mexico (Pesos)"}));
		toBox.setBounds(109, 112, 251, 20);
		panel.add(toBox);
		
		JComboBox fromBox = new JComboBox();
		fromBox.setModel(new DefaultComboBoxModel(new String[] {"United States of America (U.S. Dollar)", "Canada (Canadian Dollar)", "Japan (Yen)", "European Union (Euro)", "China (Yuan)", "Mexico (Pesos)"}));
		fromBox.setBounds(444, 112, 258, 20);
		panel.add(fromBox);
		
		JLabel lblNewLabel_1 = new JLabel("To: ");
		lblNewLabel_1.setBounds(77, 115, 60, 17);
		panel.add(lblNewLabel_1);
		
		JLabel lblFrom = new JLabel("From: ");
		lblFrom.setBounds(388, 115, 46, 14);
		panel.add(lblFrom);
		
		JLabel resultsLbl = new JLabel("Result: ");
		resultsLbl.setBounds(39, 189, 168, 14);
		panel.add(resultsLbl);
		
		JButton btnConvertCurrency = new JButton("Convert Currency");
		btnConvertCurrency.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				DecimalFormat money = new DecimalFormat("#.00");
                                    double input = 0;
                                    String user = entAmount.getText();
				try{
                                        input = Double.parseDouble(user);
                                    }
                                    catch(Exception e){
                                        JOptionPane.showMessageDialog(null, "That is not a valid number. Please enter a valid number.", "InfoBox: " + "Error!", JOptionPane.INFORMATION_MESSAGE);
                                        
                                        System.out.println("That is not a valid number. Please enter a valid number.");
                                    }
				CurrencyConverter n = new CurrencyConverter(0, 0, 0, null, null);
				n.setUserAmount(input);
                                    n.setUserFrom(fromBox.getSelectedItem().toString());
                                    n.setUserTo(toBox.getSelectedItem().toString());
                                    double results = n.Convert();
                                    
                                    resultsLbl.setText("Results: " + money.format(results));
				
			}
			
			
			
		});
		btnConvertCurrency.setBounds(282, 152, 181, 23);
		panel.add(btnConvertCurrency);
		
		JPanel panel1 = new JPanel();
		tabbedPane.addTab("Distance Converter ", null, panel1, null);
		panel1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(169, 38, 372, 34);
		panel1.add(textField);
		textField.setColumns(10);
		
		JLabel distAmount = new JLabel("Input Distance: ");
		distAmount.setBounds(25, 41, 92, 14);
		panel1.add(distAmount);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Inch (in)", "Foot (ft)", "Yard (yds) ", "Mile (mi)", "Micrometer (um)", "Milimeter (mm)", "Centimeter (cm)", "Meter (m)", "Kilometer (km)", "Nautical Mile (nmi)"}));
		comboBox_2.setBounds(169, 123, 170, 20);
		panel1.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Inch (in)", "Foot (ft)", "Yard (yds) ", "Mile (mi)", "Micrometer (um)", "Milimeter (mm)", "Centimeter (cm)", "Meter (m)", "Kilometer (km)", "Nautical Mile (nmi)"}));
		comboBox_3.setBounds(455, 123, 170, 20);
		panel1.add(comboBox_3);
		
		JLabel lblFrom_1 = new JLabel("From: ");
		lblFrom_1.setBounds(71, 126, 46, 14);
		panel1.add(lblFrom_1);
		
		JLabel lblTo = new JLabel("To: ");
		lblTo.setBounds(368, 126, 46, 14);
		panel1.add(lblTo);
		
		JLabel lblResult_1 = new JLabel("Result: ");
		lblResult_1.setBounds(71, 208, 73, 14);
		panel1.add(lblResult_1);
		
		JButton btnNewButton = new JButton("Convert Distance");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton.setBounds(299, 168, 181, 23);
		panel1.add(btnNewButton);
	}
}
