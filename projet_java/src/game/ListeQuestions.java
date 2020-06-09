package game;

import java.util.ArrayList;

public class ListeQuestions {


    private ArrayList<Theme> listQuestionstheme;

    public ListeQuestions(){
        this.listQuestionstheme = new ArrayList<Theme>();

    }

    public void AjouterQuestionTheme(Theme t ){

        listQuestionstheme.add(t);
    }

    public ArrayList<Theme> getListQuestionstheme() {

        return listQuestionstheme;
    }

}
