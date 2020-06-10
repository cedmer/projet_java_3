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
		JFrame frameQuestions = new JFrame();
		JPanel panelQuestion = new JPanel();
		panelQuestion.setLayout(new GridLayout(0,3));
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
			VF theVF = new VF(question.get(2),Boolean.parseBoolean(question.get(3)));
			Question<VF> theQuestion = new Question<VF>(question.get(0), Integer.valueOf(question.get(1)), theVF);
			lesQuestions.add(theQuestion);
		}
		
		ArrayList<Question> Q1 = new ArrayList<Question>();
		JPanel panelQ1 = new JPanel();
		panelQ1.setLayout(new GridLayout(10,0));
		panelQ1.add(new JLabel("Question de niveau 1 :"));
		ArrayList<Question> Q2 = new ArrayList<Question>();
		JPanel panelQ2 = new JPanel();
		panelQ2.setLayout(new GridLayout(10,0));
		panelQ2.add(new JLabel("Question de niveau 2 :"));
		ArrayList<Question> Q3 = new ArrayList<Question>();
		JPanel panelQ3 = new JPanel();
		panelQ3.setLayout(new GridLayout(10,0));
		panelQ3.add(new JLabel("Question de niveau 3 :"));
	
		for(Question question: lesQuestions) {
			//System.out.println(question.toString());
			switch(question.difficulty){
			case 1:
				Q1.add(question);
				break;
			case 2:
				Q2.add(question);
				break;
			case 3:
				Q3.add(question);
				break;
			}

			
			
		}
		for(Question question: Q1) {
			panelQ1.add(new JLabel(question.toString()));
		}
		for(Question question: Q2) {
			panelQ2.add(new JLabel(question.toString()));
		}
		for(Question question: Q3) {
			panelQ3.add(new JLabel(question.toString()));
		}
		panelQuestion.add(panelQ1);
		panelQuestion.add(panelQ2);
		panelQuestion.add(panelQ3);
		frameQuestions.add(panelQuestion);
	}

}
