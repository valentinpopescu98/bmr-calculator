import static org.junit.Assert.*;
import org.junit.Test;

public class TestGUI {
	@Test
	public void testSexMale() {
		GUI gui = new GUI();
		
		gui.sexComboBox.setSelectedItem("MALE");
		String actualSex = gui.sexComboBox.getSelectedItem().toString();
		String expectedSex = "MALE";
		assertEquals(expectedSex, actualSex);
	}
	
	@Test
	public void testSexFemale() {
		GUI gui = new GUI();
		
		gui.sexComboBox.setSelectedItem("FEMALE");
		String actualSex = gui.sexComboBox.getSelectedItem().toString();
		String expectedSex = "FEMALE";
		assertEquals(expectedSex, actualSex);
	}

	@Test
	public void testWeight() {
		GUI gui = new GUI();
		
		gui.weightTextField.setText("123.456");
		float actualWeight = Float.parseFloat(gui.weightTextField.getText());
		float expectedWeight = 123.456f;
		assertEquals(expectedWeight, actualWeight, 0.0001f);
	}
	
	@Test
	public void testHeight() {
		GUI gui = new GUI();
		
		gui.heightTextField.setText("123");
		int actualHeight = Integer.parseInt(gui.heightTextField.getText());
		int expectedHeight = 123;
		assertEquals(expectedHeight, actualHeight);
	}
	
	@Test
	public void testAge() {
		GUI gui = new GUI();
		
		gui.ageTextField.setText("123");
		int actualAge = Integer.parseInt(gui.ageTextField.getText());
		int expectedAge = 123;
		assertEquals(expectedAge, actualAge);
	}
	
	@Test
	public void testCalculationMale() {
		GUI gui = new GUI();
		
		gui.sexComboBox.setSelectedItem("MALE");
		gui.weightTextField.setText("1000");
		gui.heightTextField.setText("1000");
		gui.ageTextField.setText("1000");
		gui.calculateBtn.doClick();
		
		String actualResult = gui.bmrResultLabel.getText();
		String expectedResult = "Your BMR is 12607.";
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testCalculationFemale() {
		GUI gui = new GUI();
		
		gui.sexComboBox.setSelectedItem("FEMALE");
		gui.weightTextField.setText("1000");
		gui.heightTextField.setText("1000");
		gui.ageTextField.setText("1000");
		gui.calculateBtn.doClick();
		
		String actualResult = gui.bmrResultLabel.getText();
		String expectedResult = "Your BMR is 8463.";
		assertEquals(expectedResult, actualResult);
	}
}
