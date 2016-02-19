package nl.davidlieffijn.battleofbots.interpreter;

public class Call implements Statement {
	String call;
	public static int redirections = 0;
			
	public Call(String call) {
		this.call = call;
	}
	
	public String result(int[] stats) {
		if (redirections < 10) {
			redirections++;
			return getFunctionByName().result(stats);
		} else {
			System.out.println("To many redirections!");
			return null;
		}
	}
	
	private Function getFunctionByName() {
		for (int i = 0; i < Parser.functions.size(); i++) {
			Function current = Parser.functions.get(i);
			if (current.getName().equals(call)) {
				return current;
			}
		}
		return null;
	}
	
	public String toString() {
		return "call " + call;
	}
}
