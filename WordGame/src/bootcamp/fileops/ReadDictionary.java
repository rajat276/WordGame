package bootcamp.fileops;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadDictionary {

	private final static String DEFAULT_DICTIONARY_FILE="/Users/righosh/Downloads/sowpods.txt";
	private static int maxLength; 

	private static ArrayList<String>getAllWords(String fileName) throws Exception {
		ArrayList<String>wordList=new ArrayList<>();
		BufferedReader br=new BufferedReader(new FileReader(new File(fileName)));
		String str;
		int max=0;
		while((str=br.readLine())!=null) {
			wordList.add(str);
			if(str.length()>max)
				max=str.length();
		}
		ReadDictionary.maxLength=max;
		return wordList;
	}

	public static ArrayList<ArrayList<String>>getWordList() {
		try {
			ArrayList<String>allWords=getAllWords(ReadDictionary.DEFAULT_DICTIONARY_FILE);
			ArrayList<ArrayList<String>>list=new ArrayList<>();
			for(int i=0;i<=ReadDictionary.maxLength+1;i++)
				list.add(new ArrayList<String>());
			for(String str:allWords)
				list.get(str.length()).add(str);
			return list;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ArrayList<ArrayList<String>>getWordList(String fileName) {
		try {
			ArrayList<String>allWords=getAllWords(fileName);
			ArrayList<ArrayList<String>>list=new ArrayList<>();
			for(int i=0;i<=ReadDictionary.maxLength+1;i++)
				list.add(new ArrayList<String>());
			for(String str:allWords)
				list.get(str.length()).add(str);
			return list;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/*
	public static void main(String a[]) {
		ArrayList<ArrayList<String>>list=getWordList();
		if(list==null)
			System.out.println("Hello");
		for(int i=0;i<=10;i++)
			System.out.println(list.get(4).get(i)+" | "+list.get(5).get(i));
	}
*/


}
