package game.package_question;

import java.util.ArrayList;

public class ListeQuestions {


    private ArrayList<QuestionsTheme> listQuestionstheme;

    public ListeQuestions(){
        this.listQuestionstheme = new ArrayList<QuestionsTheme>();

    }

    public void AjouterQuestionTheme(QuestionsTheme t ){

        listQuestionstheme.add(t);
    }
    public void SupprimerQuestion(int n){
        listQuestionstheme.remove(n);
    }

    public ArrayList<QuestionsTheme> getListQuestionstheme() {

        return listQuestionstheme;
    }

}
