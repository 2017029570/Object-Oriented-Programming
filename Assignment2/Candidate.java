
public class Candidate extends Student{
	public int NumberOfVotes;
	public int compareTo(Candidate c) {
		if(this.NumberOfVotes < c.NumberOfVotes) return -1;
		else if(this.NumberOfVotes > c.NumberOfVotes) return 1;
		else return 0;
	}
}
