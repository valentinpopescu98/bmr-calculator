import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class GUI {

	private JFrame frmBmrCalculator;
	public Base base = new Base(false, 0, 0, 0);
	public JComboBox<String> sexComboBox;
	public JTextField weightTextField;
	public JTextField heightTextField;
	public JTextField ageTextField;
	public JButton calculateBtn;
	public JLabel bmrResultLabel;
	
	private boolean hasShownWarning = false;

	/*
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		frmBmrCalculator = new JFrame();
		frmBmrCalculator.setTitle("BMR Calculator");
		frmBmrCalculator.setBounds(100, 100, 300, 300);
		frmBmrCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBmrCalculator.getContentPane().setLayout(null);
		
		JLabel sexLabel = DefaultComponentFactory.getInstance().createLabel("Sex");
		sexLabel.setBounds(50, 59, 50, 14);
		frmBmrCalculator.getContentPane().add(sexLabel);
		
		JLabel weightLabel = DefaultComponentFactory.getInstance().createLabel("Weight");
		weightLabel.setBounds(50, 88, 50, 14);
		frmBmrCalculator.getContentPane().add(weightLabel);
		
		JLabel heightLabel = DefaultComponentFactory.getInstance().createLabel("Height");
		heightLabel.setBounds(50, 113, 50, 14);
		frmBmrCalculator.getContentPane().add(heightLabel);
		
		JLabel ageLabel = DefaultComponentFactory.getInstance().createLabel("Age");
		ageLabel.setBounds(50, 138, 50, 14);
		frmBmrCalculator.getContentPane().add(ageLabel);
		
		JLabel kgLabel = new JLabel("KG");
		kgLabel.setBounds(215, 88, 20, 14);
		frmBmrCalculator.getContentPane().add(kgLabel);
		
		JLabel cmLabel = new JLabel("CM");
		cmLabel.setBounds(215, 113, 20, 14);
		frmBmrCalculator.getContentPane().add(cmLabel);
		
		JLabel yrsLabel = new JLabel("YRS");
		yrsLabel.setBounds(215, 138, 25, 14);
		frmBmrCalculator.getContentPane().add(yrsLabel);
		
		bmrResultLabel = DefaultComponentFactory.getInstance().createLabel("");
		bmrResultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bmrResultLabel.setBounds(10, 236, 279, 14);
		frmBmrCalculator.getContentPane().add(bmrResultLabel);
		
		String[] comboBoxOptions = {"MALE", "FEMALE"};
		sexComboBox = new JComboBox<>(comboBoxOptions);
		sexComboBox.setToolTipText("Please choose your sex.");
		sexComboBox.setBounds(110, 55, 125, 22);
		frmBmrCalculator.getContentPane().add(sexComboBox);
		
		weightTextField = new JTextField();
		weightTextField.setToolTipText("Please choose your weight in kilograms.");
		weightTextField.setBounds(110, 85, 100, 20);
		frmBmrCalculator.getContentPane().add(weightTextField);
		weightTextField.setColumns(10);
		
		heightTextField = new JTextField();
		heightTextField.setToolTipText("Please choose your height in centimeters.");
		heightTextField.setBounds(110, 110, 100, 20);
		frmBmrCalculator.getContentPane().add(heightTextField);
		heightTextField.setColumns(10);
		
		ageTextField = new JTextField();
		ageTextField.setToolTipText("Please choose your age.");
		ageTextField.setBounds(110, 135, 100, 20);
		frmBmrCalculator.getContentPane().add(ageTextField);
		ageTextField.setColumns(10);
		
		calculateBtn = new JButton("Calculate");
		calculateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == calculateBtn) {					
					if (sexComboBox.getSelectedItem().toString() == "MALE") {
						base.setSex(false);
					}
					else if (sexComboBox.getSelectedItem().toString() == "FEMALE") {
						base.setSex(true);
					}
					else {
						JOptionPane.showMessageDialog(new JFrame(),"Unexpected input for the sex combo box!", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
					try {
						base.setWeight(Float.parseFloat(weightTextField.getText()));
					}
					catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(new JFrame(),"Invalid number!", "Warning", JOptionPane.WARNING_MESSAGE);
						hasShownWarning = true;						
					}
					
					try {
						base.setHeight(Integer.parseInt(heightTextField.getText()));
					}
					catch (NumberFormatException e2) {						
						if(!hasShownWarning) {
							JOptionPane.showMessageDialog(new JFrame(),"Invalid number!", "Warning", JOptionPane.WARNING_MESSAGE);							
						}
						hasShownWarning = true;
					}
					
					try {
						base.setAge(Integer.parseInt(ageTextField.getText()));
					}
					catch (NumberFormatException e3) {						
						if(!hasShownWarning) {
							JOptionPane.showMessageDialog(new JFrame(),"Invalid number!", "Warning", JOptionPane.WARNING_MESSAGE);							
						}
						hasShownWarning = true;
					}
					
					if(!hasShownWarning) {
						base.setResult(base.calculateBMR(base.getSex(), base.getWeight(), base.getHeight(), base.getAge()));
						bmrResultLabel.setText("Your BMR is " + base.getResult() + ".");
					}
					
					hasShownWarning = false;
				}
			}
		});
		calculateBtn.setBounds(50, 170, 92, 22);
		frmBmrCalculator.getContentPane().add(calculateBtn);
		
		JButton quitBtn = new JButton("Quit");
		quitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == quitBtn) {
					base.quit();
				}
			}
		});
		quitBtn.setBackground(Color.RED);
		quitBtn.setForeground(Color.BLACK);
		quitBtn.setBounds(148, 169, 89, 23);
		frmBmrCalculator.getContentPane().add(quitBtn);
	}
	
	/*
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}
	
	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmBmrCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
