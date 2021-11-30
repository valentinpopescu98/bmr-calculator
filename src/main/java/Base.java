public class Base {
	boolean sex;  // 0 - MAN; 1 - WOMAN
	float weight; // weight in kilograms
	int height;   // height in centimeters
	int age;
	int result;
	
	public Base(boolean sex, float weight, int height, int age) {
		setSex(sex);
		setWeight(weight);
		setHeight(height);
		setAge(age);
	}
	
	public boolean getSex() {
		return sex;
	}
	
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getResult() {
		return result;
	}
	
	public void setResult(int result) {
		this.result = result;
	}
	
	/* Calculate the BMR.
	 * If the user is a woman (sex = 1) apply the first formula.
	 * If the user is a man (sex = 0) apply the second formula.
	 */
	public int calculateBMR(boolean sex, float weight, int height, int age) {
		return sex? Math.round(447.593f + 9.247f * weight + 3.098f * height - 4.330f * age) :
			Math.round(88.362f + 13.397f * weight + 4.799f * height - 5.677f * age);
	}
	
	public void quit() {
		System.exit(0);
	}
}