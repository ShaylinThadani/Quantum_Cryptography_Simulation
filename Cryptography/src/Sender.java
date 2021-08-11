import java.util.ArrayList;

public class Sender {
//attributes
	private String BinaryMessage;
	private String encryptedMessage;
	private int charNum;
    private ArrayList<Photon> OriginalBasis = new ArrayList<Photon>();
    private ArrayList<String> FinalKey = new ArrayList<String>();
//Constructor
	public Sender(String BinaryMessage) {
		this.BinaryMessage = BinaryMessage;
		charNum = BinaryMessage.length();
		//OriginalBasis = GenerateBasis();
}
	//Generate Basis
	public void GenerateBasis(){
		
        for (int i = 0; i< 3*charNum;i++){
            OriginalBasis.add(new Photon());
        }
        
    }
	public ArrayList<Photon> getOriginalBasis() {
		return OriginalBasis;
	}
	public void setFinalKey(ArrayList<String> newBasis) {
		for (int j =0; j<newBasis.size(); j++) {
			FinalKey.add(newBasis.get(j));
		}
		
	}
	//Make the encrypted message through binary addition
	public String GenerateencryptedMessage() {
		encryptedMessage = "";
		for (int i=0; i< BinaryMessage.length(); i++) {
			if(FinalKey.get(i).equals("0") && BinaryMessage.charAt(i)=='0') {
				encryptedMessage=encryptedMessage + "0";
			}
			else if(FinalKey.get(i).equals("1") && BinaryMessage.charAt(i)=='1') {
				encryptedMessage=encryptedMessage + "0";
			}
			else if(FinalKey.get(i).equals("1") && BinaryMessage.charAt(i)=='0') {
				encryptedMessage=encryptedMessage + "1";
			}
			else if(FinalKey.get(i).equals("0") && BinaryMessage.charAt(i)=='1') {
				encryptedMessage=encryptedMessage + "1";
			}
			}
		return encryptedMessage;
		
	}
	
}