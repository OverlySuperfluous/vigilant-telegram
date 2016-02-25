package package2;

	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JTextField;
	import javax.swing.JComboBox;
	import javax.swing.JButton;
	import java.awt.Font;
	import javax.swing.DefaultComboBoxModel;
	import java.awt.Color;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
    import java.text.DecimalFormat;
    import javax.swing.JOptionPane;

	public class CurrencyMain {

		private JFrame mainWindow;
		private JTextField entAmount;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						CurrencyMain window = new CurrencyMain();
						window.mainWindow.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the application.
		 */
		public CurrencyMain() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			mainWindow = new JFrame();
			mainWindow.setTitle("Currency Converter ");
			mainWindow.setBounds(100, 100, 450, 370);
			mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainWindow.getContentPane().setLayout(null);
			
			JLabel amountLbl = new JLabel("Enter:");
			amountLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
			amountLbl.setToolTipText("NO MORE THAN TWO DECIMAL PLACES PLEASE");
			amountLbl.setBounds(20, 31, 95, 46);
			mainWindow.getContentPane().add(amountLbl);
			
			entAmount = new JTextField();
			entAmount.setForeground(new Color(0, 128, 0));
			entAmount.setFont(new Font("Tahoma", Font.PLAIN, 19));
			entAmount.setBounds(71, 28, 284, 49);
			mainWindow.getContentPane().add(entAmount);
			entAmount.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Select Currency ");
			lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
			lblNewLabel.setBounds(147, 88, 134, 14);
			mainWindow.getContentPane().add(lblNewLabel);
			
			JLabel fromLbl = new JLabel("From:");
			fromLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
			fromLbl.setBounds(22, 133, 40, 14);
			mainWindow.getContentPane().add(fromLbl);
			
			JComboBox fromBox = new JComboBox();
			fromBox.setForeground(Color.BLUE);
			fromBox.setModel(new DefaultComboBoxModel(new String[] {"United States of America (U.S. Dollar)", "Canada (Canadian Dollar)", "Japan (Yen)", "European Union (Euro)", "China (Yuan)", "Mexico (Pesos)"}));
			fromBox.setBounds(60, 130, 309, 20);
			mainWindow.getContentPane().add(fromBox);
			
			JLabel toLbl = new JLabel("To:");
			toLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
			toLbl.setBounds(32, 164, 25, 14);
			mainWindow.getContentPane().add(toLbl);
			
			JComboBox toBox = new JComboBox();
			toBox.setForeground(Color.RED);
			toBox.setModel(new DefaultComboBoxModel(new String[] {"United States of America (U.S. Dollar)", "Canada (Canadian Dollar)", "Japan (Yen)", "European Union (Euro)", "China (Yuan)", "Mexico (Pesos)"}));
			toBox.setBounds(60, 161, 309, 20);
			mainWindow.getContentPane().add(toBox);
			
			JLabel resultsLbl = new JLabel("Results: ");
			resultsLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
			resultsLbl.setBounds(114, 277, 300, 20);
			mainWindow.getContentPane().add(resultsLbl);
                        
           JButton convertBtn = new JButton("CONVERT");
			convertBtn.addActionListener(new ActionListener() 
			{
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
			convertBtn.setBounds(71, 204, 89, 23);
			mainWindow.getContentPane().add(convertBtn);
						
			JButton exitBtn = new JButton("EXIT");
			exitBtn.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent arg0)
				{
					System.exit(0);
				}
					});
			exitBtn.setBounds(251, 204, 134, 23);
			mainWindow.getContentPane().add(exitBtn);
			
		}
	}