package br.com.ufc.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.ufc.model.Student;

public class Application {
	
	public static void main(String[] args) {	
		File file = new File("C:/Users/cezar/Desktop/Atividades reuso/reuse/exercise1-json/"
				+ "resources/file.json");
		
		Gson gson = new Gson();
		Reader reader = null;
		List<Student> students = null;
		
		try {
			reader = new FileReader(file);
			Type collectionType = new TypeToken<List<Student>>() {}.getType();
			students = gson.fromJson(reader, collectionType);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(students != null){
			for(Student student : students){
				System.out.println(student.toString());
			}
		}
	}
	
}
