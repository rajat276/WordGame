package bootcamp.fileops;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

class WordList {
	public ArrayList<String>wordList;
	public int maxLength;
	
	public WordList() {
		wordList=new ArrayList<>();
		maxLength=0;
	}
}

public class ReadDictionary {

	private final static String DEFAULT_DICTIONARY_FILE="../sowpods.txt";

	private static WordList getAllWords(String fileName) throws Exception {
		WordList wordList=new WordList();
		BufferedReader br=new BufferedReader(new FileReader(new File(fileName)));
		String str;
		int max=0;
		while((str=br.readLine())!=null) {
			wordList.wordList.add(str);
			if(str.length()>wordList.maxLength)
				wordList.maxLength=str.length();
		}
		return wordList;
	}

	public static ArrayList<ArrayList<String>>getWordList() {
		try {
			WordList allWords=getAllWords(ReadDictionary.DEFAULT_DICTIONARY_FILE);
			ArrayList<ArrayList<String>>list=new ArrayList<>();
			for(int i=0;i<=allWords.maxLength+1;i++)
				list.add(new ArrayList<String>());
			for(String str:allWords.wordList)
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
			WordList allWords=getAllWords(fileName);
			ArrayList<ArrayList<String>>list=new ArrayList<>();
			for(int i=0;i<=allWords.maxLength+1;i++)
				list.add(new ArrayList<String>());
			for(String str:allWords.wordList)
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
		for(int i=0;i<=10;i++)
			System.out.println(list.get(4).get(i)+" | "+list.get(5).get(i));
	}
	*/



}
