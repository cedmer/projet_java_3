package game.package_question;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class QuestionsTheme {



	private ArrayList<Question> listQuestions = new ArrayList<Question>();
	private String basePath = "projet_java/src/Questions/";


	public QuestionsTheme(String str) {
		this.listQuestions.addAll(getQCM(str));
		this.listQuestions.addAll(getRC(str));
		this.listQuestions.addAll(getVF(str));

		Collections.shuffle(listQuestions);//pour mélanger les questions
		
	}
	public ArrayList<Question> getListQuestions() {
		return listQuestions;
	}

	private  ArrayList<Question> getQCM(String str){

		String fileName= basePath + str +"/QCM";
		File file= new File(fileName);

		ArrayList<Question> lesQuestions = new ArrayList<Question>();

		// this gives you a 2-dimensional array of strings
		List<List<String>> lines = new ArrayList<>();
		Scanner inputStream;

		try{
			inputStream = new Scanner(file);

			while(inputStream.hasNextLine()){
				String line= inputStream.nextLine();
				String[] values = line.split(",");
				lines.add(Arrays.asList(values));
			}

			inputStream.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for(List<String> question: lines) {
			QCM theQCM = new QCM(question.get(2),question.get(3), question.get(4), question.get(5), question.get(6));
			Question<QCM> theQuestion = new Question<QCM>(question.get(0), Integer.valueOf(question.get(1)), theQCM);
			lesQuestions.add(theQuestion);
		}
		return lesQuestions;
	}

	private  ArrayList<Question> getRC(String str){

		String fileName= basePath + str +"/RC";
		File file= new File(fileName);

		ArrayList<Question> lesQuestions = new ArrayList<Question>();

		// this gives you a 2-dimensional array of strings
		List<List<String>> lines = new ArrayList<>();
		Scanner inputStream;

		try{
			inputStream = new Scanner(file);

			while(inputStream.hasNextLine()){
				String line= inputStream.nextLine();
				String[] values = line.split(",");
				lines.add(Arrays.asList(values));
			}

			inputStream.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		for(List<String> question: lines) {
			RC theRC = new RC(question.get(2), question.get(3));
			Question<RC> theQuestion = new Question<RC>(question.get(0), Integer.valueOf(question.get(1)), theRC);
			lesQuestions.add(theQuestion);
		}
		return lesQuestions;
	}


	private  ArrayList<Question> getVF(String str){

		String fileName= basePath + str +"/VF";
		File file= new File(fileName);

		ArrayList<Question> lesQuestions = new ArrayList<Question>();

		// this gives you a 2-dimensional array of strings
		List<List<String>> lines = new ArrayList<>();
		Scanner inputStream;

		try{
			inputStream = new Scanner(file);

			while(inputStream.hasNextLine()){
				String line= inputStream.nextLine();
				String[] values = line.split(",");
				lines.add(Arrays.asList(values));
			}

			inputStream.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for(List<String> question: lines) {
			VF theVF = new VF(question.get(2),Boolean.parseBoolean(question.get(3)));
			Question<VF> theQuestion = new Question<VF>(question.get(0), Integer.valueOf(question.get(1)), theVF);
			lesQuestions.add(theQuestion);
		}
		return lesQuestions;
	}


}
