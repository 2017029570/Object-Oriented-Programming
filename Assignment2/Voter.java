
public interface Voter extends Comparable<Candidate>{	
	void vote(Department d);

	int compareTo(Candidate c);
}
