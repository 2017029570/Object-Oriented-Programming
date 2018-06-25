import java.util.ArrayList;
public class Department {
	public String NameOfDepartment=null;
	public ArrayList<Candidate> c = new ArrayList<Candidate>();
	public ArrayList<Student> s = new ArrayList<Student>();
	
	
	Candidate Cmethod() {
		//int max=0;
		int imax = c.size()-1;
		/*for(int i=0;i<c.size();i++) {
			if(max<=c.get(i).NumberOfVotes) {
				max = c.get(i).NumberOfVotes;
				imax = i;
			}
		}
		*/
		return c.get(imax);
	}
}
