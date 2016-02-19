package nl.davidlieffijn.battleofbots.interpreter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Test {
	
	public static void main(String[] args) throws IOException {
		//Statement[] parts = {new If(new Condition(new Number(2), ">", new Number(1)), new Action("UP")), new Action("DOWN")};
		//Statement block = new Block(parts);
		//System.out.println("RESULT: " + block.result());
		//System.out.println(block.toString());
		
			Path file = FileSystems.getDefault().getPath("/Users/David/Documents", "code1.txt");
			List<String> fileArray;
			fileArray = Files.readAllLines(file, Charset.defaultCharset());
			String code = "";
			for (int i = 0; i < fileArray.size(); i++) {
				code += fileArray.get(i) + ";";
			}
			
			Parser parser = new Parser();
			try {
				Statement parsed = parser.parse(code);
				System.out.println("PARSED: " + parsed);
				// 			{DIR, HP, X, Y, TURNS, VL, VF, VR}
				int[] stats = {
						1,	//"DIRECTION",
						2, 	//"DIRECTION_E",
						3,	//"HP",
						4,	//"RANDOM",
						5,	//"TURNS",
						6,	//"X",
						7,	//"Y",
						8,	//"VIEW_L",
						9,	//"VIEW_LF",
						10,	//"VIEW_F",
						11,	//"VIEW_RF",
						12,	//"VIEW_R",
						};
				// TODO: RANDOM doesn't have to be given.
						
				System.out.println("RESULT: " + parsed.result(stats));
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			
	}
}
