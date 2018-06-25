import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
class ElectionSim {
	ArrayList<Department> d = new ArrayList<Department>(11);
	ArrayList<Candidate> cd = new ArrayList<Candidate>();
	
	BufferedReader inputstream = null;
	BufferedReader inputstream1 = null;
	
	ElectionSim(String input1, String input2, String output)  {
		Department dp1 = new Department();
		d.add(dp1);
		try {
			String line = null;
			inputstream = new BufferedReader(new InputStreamReader(new FileInputStream(input1), "UTF-8"));
			
			
			int i=0;
			
			line = inputstream.readLine();
			line = inputstream.readLine();
			while(line != null) {
				
				StringTokenizer tok = new StringTokenizer(line, ",");
				
				i = Integer.parseInt(tok.nextToken());
				Department dp = new Department();
				dp.NameOfDepartment = tok.nextToken();
				
				d.add(i,dp);
				line = inputstream.readLine();
			}
			
			inputstream1 = new BufferedReader(new InputStreamReader(new FileInputStream(input2), "UTF-8"));
			int id, dpm = 0 ;
			String name = null, str = null;
			int can = 0;
			
			line = inputstream1.readLine();
			line = inputstream1.readLine();
			while(line != null) {
				
				StringTokenizer tok = new StringTokenizer(line, ",");
				//System.out.println(line);
				id = Integer.parseInt(tok.nextToken());
				dpm = Integer.parseInt(tok.nextToken());
				name = tok.nextToken();
				str = tok.nextToken();
				if(str.compareTo("TRUE") == 0) 
					can = 1;
				
				else if(str.compareTo("FALSE")==0)
					can = 0;
				
				if(can == 1) {
					Candidate cand = new Candidate();
					cand.NumberOfStudent = id;
					cand.Name = name;
					cand.department.NameOfDepartment = d.get(dpm).NameOfDepartment;
		
					d.get(dpm).c.add(cand);
				}
				
				
				Student stu = new Student();
				stu.NumberOfStudent = id;
				stu.Name = name;
				//System.out.println(d.get(dpm).NameOfDepartment);
				stu.department.NameOfDepartment = d.get(dpm).NameOfDepartment;
				
				d.get(dpm).s.add(stu);
					
				line = inputstream1.readLine();
				
			}
			
		}
		catch(UnsupportedEncodingException e ) {
			System.out.println("Error");
			System.exit(0);
		}
		catch(IOException e) {
			System.out.println("File was not found.");
			System.exit(0);
		}
		
		
	}
	
	void saveData() {
		try {
			PrintWriter pw = new PrintWriter("output_file.txt","UTF-8");
			
			for(int i=0;i<cd.size();i++) {
				pw.println("======== Elected Candidate ========");
				pw.println("Department name: "+cd.get(i).department.NameOfDepartment);
				pw.println("name: "+cd.get(i).Name);
				pw.println("Student_id: "+cd.get(i).NumberOfStudent);
				pw.println("Votes: "+cd.get(i).NumberOfVotes);
				pw.println("===================================");
				
			}
			pw.close();

		}
		catch(IOException e) {
			System.out.println("No output file");
		}	
	}
	
	void runSimulation() {
		for(int i=1;i<d.size();i++) {
			System.out.println(d.get(i).NameOfDepartment);
			for(int j=0;j<d.get(i).s.size();j++) {
				d.get(i).s.get(j).vote(d.get(i));
				//System.out.println("j = " + j);
			}
		}
		
		for(int i=1;i<d.size();i++) {
			Collections.sort(d.get(i).c);
			
			cd.add(d.get(i).Cmethod());
		}
		
		this.saveData();
		
	}
}
