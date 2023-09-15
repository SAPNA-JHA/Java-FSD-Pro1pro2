package FileHandling;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
	public class FileHandling {

		public static void main(String[] args) throws FileNotFoundException, IOException {
		        System.out.println("Please select one of the following operations");
		        System.out.println(" write content ");
		        System.out.println(" read content ");
		        System.out.println(" append content ");
		        
		        Scanner in = new Scanner(System.in);
		        String s = in.nextLine().toLowerCase();
		        
		        if ("r".equals(s)) {
		            new FReading();
		        } else if ("w".equals(s) || "a".equals(s)) {
		            writingToFile(s);
		        } else {
		            System.out.println("Sorry, you tried to do something unexpected. Better luck next time.");
		        }
		        
		        in.close();
		    }

		    public static void writingToFile(String s) {
		        Scanner in = null;
		        try {
		            String source = "";
		            File f = new File("file1.txt");
		            
		            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		            
		            FileWriter f0 = null;
		            if ("w".equals(s)) {
		                f0 = new FileWriter(f, false);
		                System.out.println("CAUTION >> Please understand it will overwrite the content of the file ");
		                System.out.println("Type 'no' to exit");
		                System.out.println("Do you want to proceed: type 'yes'");
		                
		                in = new Scanner(System.in);
		                String s1 = in.nextLine();
		                if ("no".equals(s1)) {
		                    System.exit(0);
		                }
		                
		                System.out.println("Write 'stop' when you finish writing the file ");
		                f.delete();
		                f.createNewFile();
		                
		                while (!(source = bf.readLine()).equalsIgnoreCase("stop")) {
		                    f0.write(source + System.getProperty("line.separator"));
		                }
		                
		                in.close();
		            } else {  
		                f0 = new FileWriter(f, true);
		                System.out.println("Write 'stop' when you finish appending the file ");
		                
		                while (!(source = bf.readLine()).equalsIgnoreCase("stop")) {
		                    f0.append(source + System.getProperty("line.separator"));
		                }
		            }
		            f0.close();
		        } catch (Exception e) {
		            System.out.println("Error: " + e.getMessage());
		            e.printStackTrace();
		        }
		    }
		}

		class FReading {
		    public static String str = "";
		    
		    public FReading() {
		        try {
		            File f5 = new File("file1.txt");
		            if (!f5.exists()) {
		                f5.createNewFile();
		            }
		            
		            FileReader fl = new FileReader(f5);
		            BufferedReader bf = new BufferedReader(fl);
		            
		            while ((str = bf.readLine()) != null) {
		                System.out.println(str);
		            }
		            fl.close();
		        } catch (Exception e) {
		            System.out.println("Error: " + e.getMessage());
		            e.printStackTrace();
		        }
		    }
	}
