import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//prompt
System.out.println("Enter a message for Sandy to encyrpt and send securely to Spongebob.");
Scanner input = new Scanner(System.in);
String message = input.nextLine();
//convert to binary
String BinaryMessage = convertStringToBinary(message);
//Display Binary
long startTime = System.nanoTime();

System.out.println("Sandy converts the message to binary: " + "\n"+BinaryMessage);
//Initialize objects
Sender Sandy = new Sender(BinaryMessage);
Receiver Spongebob = new Receiver(BinaryMessage.length());
//Generate the basis for Spongebob and sandy
Sandy.GenerateBasis();
Spongebob.GenerateBasis();
//Create key through discarding different basis
ArrayList<String> FinalKey = new ArrayList<String>();
for (int i=0; i< Sandy.getOriginalBasis().size(); i++) {
	if(Sandy.getOriginalBasis().get(i).getBasis().equals(Spongebob.getReceiverOriginalBasis().get(i).getBasis())) {
		Spongebob.getReceiverOriginalBasis().set(i, Sandy.getOriginalBasis().get(i));
		FinalKey.add(Sandy.getOriginalBasis().get(i).getValue());
	}
}
System.out.println("");
//Print Sandy's basis and bit
System.out.println("Sandy Randomly chooses the basis: ");
for (int j =0; j<Sandy.getOriginalBasis().size(); j++) {
	System.out.print(Sandy.getOriginalBasis().get(j).getBasis());
}
System.out.println("\n");
System.out.println("Sandy Randomly chooses the bits: ");
for (int j =0; j<Sandy.getOriginalBasis().size(); j++) {
	System.out.print(Sandy.getOriginalBasis().get(j).getValue());
}
System.out.println("\n");
//Print spongbob's basis and measured bits
System.out.println("Spongebob Randomly chooses the basis: ");
for (int j =0; j<Spongebob.getReceiverOriginalBasis().size(); j++) {
	System.out.print(Spongebob.getReceiverOriginalBasis().get(j).getBasis());
}
System.out.println("\n");
System.out.println("Spongebob measures each photon using his chosen basis: ");
for (int j =0; j<Spongebob.getReceiverOriginalBasis().size(); j++) {
	System.out.print(Spongebob.getReceiverOriginalBasis().get(j).getValue());
}
System.out.println("\n");
//print Final Key
System.out.println("Sandy and Spongebob discard the\nbasis that are different resulting in the key: ");
for (int j =0; j<FinalKey.size(); j++) {
	System.out.print(FinalKey.get(j));
}
//Create encrypted message
Sandy.setFinalKey(FinalKey);
Spongebob.setFinalKey(FinalKey);
String encryptedMessage = Sandy.GenerateencryptedMessage();
//Print encrypted message
System.out.println("\n\nSandy creates the encrypted message\nthrough binary addition of the binary message and key:");
System.out.println( encryptedMessage);
//print binary message and message
String Message = Spongebob.GenerateMessage(encryptedMessage);
System.out.println("\nSpongebob retrieves the binary message\nthrough binary addition of the encrypted message and the key:");
System.out.println(Message);
long endTime = System.nanoTime();
System.out.println("Took "+(endTime - startTime) + " ns");
	}
	
	//Method to convert to binary
	public static String convertStringToBinary(String input) {

        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar))  
                            .replaceAll(" ", "0")                         
            );
        }
        return result.toString();
    }


}
