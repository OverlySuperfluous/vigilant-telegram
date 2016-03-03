import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;

public class CurrencyMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Type In Amount: ");
		lblNewLabel.setBounds(39, 40, 98, 21);
		panel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(161, 40, 316, 32);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(161, 112, 161, 20);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(444, 112, 150, 20);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("To: ");
		lblNewLabel_1.setBounds(77, 115, 60, 17);
		panel.add(lblNewLabel_1);
		
		JLabel lblFrom = new JLabel("From: ");
		lblFrom.setBounds(353, 115, 46, 14);
		panel.add(lblFrom);
		
		JLabel lblResult = new JLabel("Result: ");
		lblResult.setBounds(39, 189, 46, 14);
		panel.add(lblResult);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(132, 38, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
	}
}
