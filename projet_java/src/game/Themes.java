package game;

import java.util.ArrayList;
import java.util.Random;

public class Themes {
    private ArrayList<String> listThemes;
    private ArrayList<Integer> listIndicateur;

    public Themes() {
        this.listThemes = new ArrayList<String>();
        this.listIndicateur = new ArrayList<Integer>();

        String themes_str = "Sciences,Sport,Histoire,Mathematiques,Musique,Counter-strike,Cuisine,Programmation,Reseau";

        for (String str : themes_str.split(","))
            listThemes.add(str);

        for (int cpt = 0; cpt < this.listThemes.size(); ++cpt)
            this.listIndicateur.add(cpt);

    }

    public void Afficher() {
        int cpt = 0;
        for (String theme : this.listThemes) {
            System.out.print(theme + " : ");
            if (this.listIndicateur.contains(cpt))
                System.out.println("disponible");
            else
                System.out.println("indisponible");
            ++cpt;
        }
    }

    public int SelectionnerTheme() {
        Random rand = new Random();
        return this.listIndicateur.remove(rand.nextInt(this.listIndicateur.size()));
    }

    public ArrayList<Integer>  SelectionnerCinqThemes() {
        ArrayList<Integer> listChoix = new ArrayList<Integer>();
        if (this.listIndicateur.size() >= 5 ) {
            for (int cpt = 0; cpt < 5; ++cpt)
                listChoix.add(this.SelectionnerTheme());
        }
        else
            System.exit(-1);
        return listChoix;
    }

    public void MofifierTheme(String nouveauTheme, String ancienTheme){

        for(int i=0 ; i< this.listThemes.size();i++){
            if(ancienTheme.equals(listThemes.get(i))){
                this.listThemes.set(i,nouveauTheme);
            }
        }
    }

    public ArrayList<String> getListThemes() {
        return listThemes;
    }

    public void setListThemes(ArrayList<String> listThemes) {
        this.listThemes = listThemes;
    }

    public ArrayList<Integer> getListIndicateur() {
        return listIndicateur;
    }

    public void setListIndicateur(ArrayList<Integer> listIndicateur) {
        this.listIndicateur = listIndicateur;
    }



}