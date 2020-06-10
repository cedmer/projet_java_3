package game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreQuestion {

	private String basePath = "projet_java/src/Questions/";

	public FenetreQuestion(String str) {
		System.out.print(str);
		JFrame frameQuestions = new JFrame();
		JPanel panelQuestion = new JPanel();
		panelQuestion.setLayout(new GridLayout(6,1));
		frameQuestions.setTitle("Liste des questions du theme : " + str);
		frameQuestions.setSize(1400,200);
		frameQuestions.setLocationRelativeTo(null);
		frameQuestions.setVisible(true);

		//for QCM

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
			System.out.print("add a QCM");
			QCM theQCM = new QCM(question.get(2),question.get(3), question.get(4), question.get(5), question.get(6));
			Question<QCM> theQuestion = new Question<QCM>(question.get(0), Integer.valueOf(question.get(1)), theQCM);
			lesQuestions.add(theQuestion);
		}
		
		//for RC
		
		fileName= basePath + str +"/RC";
		file= new File(fileName);
		// this gives you a 2-dimensional array of strings
		lines.clear();

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
			System.out.print("add a RC");
			RC theRC = new RC(question.get(2), question.get(3));
			Question<RC> theQuestion = new Question<RC>(question.get(0), Integer.valueOf(question.get(1)), theRC);
			lesQuestions.add(theQuestion);
		}
		
		//for VF
		
		fileName= basePath + str +"/VF";
		file= new File(fileName);
		// this gives you a 2-dimensional array of strings
		lines.clear();;

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
			System.out.print("add a VF");
			VF theVF = new VF(question.get(2),Boolean.parseBoolean(question.get(3)));
			Question<VF> theQuestion = new Question<VF>(question.get(0), Integer.valueOf(question.get(1)), theVF);
			lesQuestions.add(theQuestion);
		}
		
		
	
		for(Question question: lesQuestions) {
			System.out.println(question.toString());
			panelQuestion.add(new JLabel(question.toString()));
		}
		frameQuestions.add(panelQuestion);
	}

}
