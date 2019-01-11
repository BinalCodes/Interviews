/*
 * Character count
 */
public class JetInterview {

	public static void main(String[] args) {
		String s = "A";
		//display out as A3B2C2A1
		System.out.println("Final string is "+countCharInStr(s));
	}
	public static String countCharInStr(String s) {
		StringBuilder sb = new StringBuilder();
		int j, count =1;
		for(int i =0; i< s.length(); i++) {
			j = i+1;
			count=1;
			while(j<s.length() && s.charAt(i) == s.charAt(j)) {
				j++;
				i++;
				count++;
			}
			sb.append(s.charAt(i));
			sb.append(count);
			if(j==s.length()-1 && count ==1) {
				sb.append(s.charAt(j));
				sb.append(count);
			}
		}
		return sb.toString();
	}

}
