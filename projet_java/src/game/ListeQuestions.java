package game;

import java.util.ArrayList;

public class ListeQuestions {


    private ArrayList<Question> listQuestionstheme;

    public ListeQuestions(){
    }

    public void AjouterQuestion(Question q ){
        listQuestionstheme.add(q);
    }
    public ArrayList<Question> getListQuestionstheme() {
        return listQuestionstheme;
    }

}
