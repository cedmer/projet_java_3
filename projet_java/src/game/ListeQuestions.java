package game;

import java.util.ArrayList;

public class ListeQuestions {


    private ArrayList<Question> listQuestionstheme;

    public ListeQuestions(){
        this.listQuestionstheme = new ArrayList<Question>();

    }

    public void AjouterQuestion(Question q ){
        listQuestionstheme.add(q);
    }
    public ArrayList<Question> getListQuestionstheme() {
        return listQuestionstheme;
    }

}
