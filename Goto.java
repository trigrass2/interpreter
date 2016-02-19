package nl.davidlieffijn.battleofbots.interpreter;

public class Goto implements Statement {
	String label;
	public static int redirections = 0;
			
	public Goto(String label) {
		this.label = label;
	}
	
	public String result(int[] stats) {
		if (redirections < 10) {
			redirections++;
			return getLabelByName().result(stats);
		} else {
			System.out.println("To many redirections!");
			return null;
		}
	}
	
	private Label getLabelByName() {
		for (int i = 0; i < Parser.labels.size(); i++) {
			Label current = Parser.labels.get(i);
			if (current.getName().equals(label)) {
				return current;
			}
		}
		return null;
	}
	
	public String toString() {
		return "goto " + label;
	}
}
