
public class Photon {
//Attributes
	private String Basis;
	private String Value;
//Constructor
	public Photon() {
		this.Basis =  BasisMethod();
		this.Value = ValueMethod();
}   
	public String getBasis(){
		return Basis;
	}
	//To get the basis for a photon
	public String BasisMethod() {
		int num = (int) (Math.random() * 2);
		String BasisValue = null;
		if (num==0) {
			BasisValue = "+";
		}
		else if (num==1) {
			BasisValue = "x";
		}
		return BasisValue;
	}
	public String getValue(){
		return Value;
	}
	//to get the bit value for a photon
	public String ValueMethod() {
		int num = (int) (Math.random() * 2);
		String StringValue = String.valueOf(num);
		return StringValue;
	}
}
