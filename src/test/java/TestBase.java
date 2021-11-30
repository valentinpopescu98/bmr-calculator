import static org.junit.Assert.*;

import org.junit.Test;

public class TestBase {
	/* We shall now test the BMR Calculator
	 * First, we will test the method for a male
	 * The formula is BMR = 88.362 + (13.397 × weight in kg) + (4.799 × height in cm) - (5.677 × age in years)
	 * Let's consider a man with:
	 * WEIGHT = 1000
	 * HEIGHT = 1000
	 * AGE = 1000
	 * According to my manual calculation, we expect BMR = 12607.362, which rounds to 12607
	 */
	
	@Test
	public void testMale() {
		Base base = new Base(false, 1000, 1000, 1000);
		
		int calculated_BMR = base.calculateBMR(base.sex, base.weight, base.height, base.age);
		int expected_BMR = 12607;
		assertEquals(expected_BMR, calculated_BMR);
	}
	
	/* Now, we will test the method for a female
	 * The formula is BMR = 447.593 + (9.247 × weight in kg) + (3.098 × height in cm) - (4.330 × age in years)
	 * We will consider the same values for the woman's weight, height and age
	 * According to my manual calculation, we expect BMR = 8462.593, which rounds to 8463
	 */

	@Test
	public void testFemale() {
		Base base = new Base(true, 1000, 1000, 1000);
		
		int calculated_BMR = base.calculateBMR(base.sex, base.weight, base.height, base.age);
		int expected_BMR = 8463;
		assertEquals(expected_BMR, calculated_BMR);
	}
}
