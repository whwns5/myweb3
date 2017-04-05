package yong.emp.model;

public class EmpTestDTO {
	private String testStr;

	public EmpTestDTO() {
		super();
		testStr = "tt";
	}
	public EmpTestDTO(String testStr) {
		super();
		this.testStr = testStr;
	}

	public String getTestStr() {
		return testStr;
	}
	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}
	
	public void testMethod(){
		System.out.println("야야");
	}
}
