package string_handling;

public class TestStringFunctions {
	/*
	 * String class methods --- to go through
	 * toLowerCase(), toUpperCase() in Day9 TestString8.java
	 * length,replace,charAt,contains,indexOf,lastIndexOf,
	 * startsWith,endsWith,split,matches,compareTo,valueOf,toCharArray,
	 * copyValueOf,format
	 */
	public static void main(String[] args) {
		String s1 = "welcome to java prog";
		//length
		System.out.println("length of string is: "+ s1.length());
		System.out.println(s1.replace('t', 'y'));
		System.out.println(s1);
		//replace(oldCharSeq, newCharSeq)
		String s2 = s1.replace("om", "ee"); 
		System.out.println(s1);
		System.out.println(s2); //all occurences of o is changed to ee
		//replaceFirst(regexp, newCharSeq)
		String s3 = s1.replaceFirst("o", "ee"); 
		System.out.println(s1);
		System.out.println(s3); //first occurence of o is changed to ee
		//charAt(index)
		
		System.out.println(s1.charAt(5)+" "+ s1.charAt(19));
		//substring(startIndex, endIndex):
		//returns string from startIndex to endIndex-1
		System.out.println(s1.substring(11, 20));
		
		String s4 = new String("this is java test prog of java.lang pkg for methods in String class");
		//contains(CharSequence): returns boolean
		System.out.println(s4.contains("java"));

		//indexOf(character/String, [index to search from])
		//returns int(i.e. index of first Occurence if found, o/w returns -1)
		System.out.println(s4.indexOf("java"));
		System.out.println(s4.indexOf("java", 16));
		//lastIndexOf(character/String, [index to search from])
		//returns int(i.e. index of last Occurence if found, o/w returns -1)
		System.out.println(s4.lastIndexOf("java"));
		System.out.println(s4.lastIndexOf("java", 10));
		
		//startsWith(String prefix): returns boolean
		//returns true if string starts with given prefix else false
		System.out.println(s4.startsWith("is")); //false
		//endsWith(String prefix): returns boolean
		//returns true if string ends with given suffix else false
		System.out.println(s4.endsWith("s")); //false
		
		//String[] split(string regex, [int limit])
		//splits given string to number of string separated by given regex 
		//limit indicates no of strings you want
		String[] strArray = s4.split(" ", 5);
		System.out.println("======Strings are=====");
		for(String s : strArray) {
			System.out.println(s);
		}
		//System.out.println(s4.length()); // 67
		//reg expr one or more all alphabets and special characters . and space
		System.out.println(s4.matches("[a-zA-Z. ]{3,70}"));
		//string conatins any CharSeq after and before java.lang
		System.out.println(s4.matches(".*java.lang.*")); 
		
		//compareTo(): do comparison based on unicode
		//returns +ve value if string object(caller) is after argument string
		//returns -ve value if string object is before argument string
		//returns 0 value if both strings are equal
		System.out.println(s4.compareTo("zzzz"));
		
		//valueOf(): this static method converts argument to String
		System.out.println(String.valueOf(s4));
		
		//toCharArray(): converts String Object to character array
		char[] charr = s4.toCharArray();
		for(char ch : charr)
			System.out.print(ch + ",");
		
		System.out.println("%n");
		
		//copyValueOf(char[]): this static mtd returns string contains characters of character array
		String s5 = String.copyValueOf(charr);
		System.out.println(s5);
		
		//format(String format, Object... arg): static method to format given objects to string
		System.out.println(String.format("%n%n%s%n%s", s1, s4));
		System.out.println(String.format("%6.5s", 123.4555));
		//one type of valueOf()
	}

}
