/*
 * 
 * Given a string A2B1C3D , generate output as AABCCCD
 */
import java.util.*;
import javafx.util.*;
public class JetInterview2 {

	public static void main(String[] args) {
		String input = "A21B1C5D";
		System.out.println(elongateString(input));

	}
	public static String elongateString(String input) {
		List<List<String>> mappings = new ArrayList<List<String>>();
		int i =0;
		for(char c : input.toCharArray()) {
			if(Character.isLetter(c)) {
				List<String> l = new ArrayList<String>();
				String count = "";
				while(i != input.length() -1 && Character.isDigit(input.charAt(++i))){
					count= count + ""+input.charAt(i); 
				}
				l.add(c+"");
				l.add(count==""? "1":count);
				mappings.add(l);
			}
		}
		StringBuilder ans = new StringBuilder();
		for(List<String> list : mappings) {
				String c = list.get(0);
				String count = list.get(1);
				for(int j =0 ; j< Integer.valueOf(count) ; j++) {
					ans.append(c);
				}
		}
		/* JAVA 8 construct
		 * String s = "c";
			int n = 4;
			String sRepeated = IntStream.range(0, n).mapToObj(i -> s).collect(Collectors.joining(""));

		 */
		return ans.toString();
	}
}

