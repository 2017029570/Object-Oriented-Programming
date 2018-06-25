
import java.util.Random;
public class Student implements Voter{
	protected String Name;
	protected int NumberOfStudent;
	protected int Grade;
	protected Department department = new Department();
	
	public void vote(Department d) {
		Random r = new Random();
		this.department.c = d.c;
		int i = r.nextInt(d.c.size());
		System.out.println("r : " + i);
		d.c.get(i).NumberOfVotes++;
	}

	@Override
	public int compareTo(Candidate c) {
		return 0;
	}


	







	
}
