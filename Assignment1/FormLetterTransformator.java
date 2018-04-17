import java.util.StringTokenizer;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FormLetterTransformator {
	public static void main(String args[]) {
		String str = "";
		String tp = "";
		String k="";
		Scanner input1 = null;
		Scanner input2 = null;
		FileWriter output = null;
		KeyValue[] arr = new KeyValue[6];
		KeyValue cl;
		
		try {
			input1 = new Scanner(new FileInputStream("properties.txt"));
			input2 = new Scanner(new FileInputStream("template_file.txt"));
			output = new FileWriter("output_file.txt");
			
			
			for(int i=0;i<6;i++) {
				str = input1.nextLine();
				StringTokenizer tok = new StringTokenizer(str, "=");
				
				cl = new KeyValue(tok.nextToken(), tok.nextToken());
				arr[i] = cl;
			}
			
			while(input2.hasNextLine()) {
				tp = input2.nextLine();
				
				StringTokenizer st = new StringTokenizer(tp, "{", true);
				
				while(st.hasMoreTokens()) {
					k = st.nextToken("{");

					if(k.equals("{")) {
						k = st.nextToken("}");
						for(int i=0;i<6;i++) {
							if(k.equals(arr[i].getKey())) {
								output.write(arr[i].getValue());
								//System.out.print(arr[i].getValue());
								break;
							}
						}
						k = st.nextToken();
					}
					else { 
						output.write(k);
						//System.out.print(k);
					}
				}
				output.write("\n");
				//System.out.print("\n");
			}
			output.flush();
		Scanner result = null;
		result = new Scanner(new FileInputStream("output_file.txt"));
		
		while(result.hasNextLine()) System.out.println(result.nextLine());
		
		result.close();
			
		}
		catch(FileNotFoundException e) { System.out.println("No File");} 
		catch (IOException e) { e.printStackTrace(); }
		
		
	
	}
}
