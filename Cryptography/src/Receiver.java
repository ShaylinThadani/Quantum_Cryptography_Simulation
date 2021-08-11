import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Receiver {
	//attribute
		private String encryptedMessage;
		private int charNum;
	    private ArrayList<Photon> ReceiverOriginalBasis  = new ArrayList<Photon>();
	    private ArrayList<String> FinalKey  = new ArrayList<String>();
	    private String BinaryMessage;
	    private String Message;
	//Constructor
		public Receiver(int charNum) {
			this.charNum = charNum;
			//ReceiverOriginalBasis = GenerateBasis();
	}
		//Generate Basis
		public void GenerateBasis(){
	        
	        for (int i = 0; i< 3*charNum;i++){
		            ReceiverOriginalBasis.add(new Photon());
	        }
	        
	    }
		public void setencryptedMessage(String CodedMessage) {
			this.encryptedMessage = CodedMessage;
		}
		public String getencryptedMessage() {
			return this.encryptedMessage;
		}
		public ArrayList<Photon> getReceiverOriginalBasis() {
			return ReceiverOriginalBasis;
		}
		public void setFinalKey(ArrayList<String> newBasis) {
			for (int j =0; j<newBasis.size(); j++) {
				FinalKey.add(newBasis.get(j));
			}
			//FinalKey = newBasis;
		}
		//deciphers encrypted message through binary addition with key
		public String GenerateMessage(String encryptedMessage) {
			BinaryMessage = "";
			for (int i=0; i< encryptedMessage.length(); i++) {
				if(FinalKey.get(i).equals("0") && encryptedMessage.charAt(i)=='0') {
					BinaryMessage=BinaryMessage + "0";
				}
				else if(FinalKey.get(i).equals("1") && encryptedMessage.charAt(i)=='1') {
					BinaryMessage=BinaryMessage + "0";
				}
				else if(FinalKey.get(i).equals("1") && encryptedMessage.charAt(i)=='0') {
					BinaryMessage=BinaryMessage+ "1";
				}
				else if(FinalKey.get(i).equals("0") && encryptedMessage.charAt(i)=='1') {
					BinaryMessage=BinaryMessage + "1";
				}
				}
			//separates the bits into bytes
			int n =8;
			StringBuilder str = new StringBuilder(BinaryMessage);
			int idx = str.length() - n;
			while (idx > 0){
			   str.insert(idx, " ");
			   idx = idx - n;
			}
			//converts the binary to the message
			String SeparatedBinary = str.toString();
			 Message = Arrays.stream(SeparatedBinary.split(" "))
		                .map(binary -> Integer.parseInt(binary, 2))
		                .map(Character::toString)
		               .collect(Collectors.joining()); 
             String MessageBinary = "Binary Message:\n" + BinaryMessage + "\nSpongebob converts the binary back to message:\n" + Message;
		      			return MessageBinary ;
		}
}
