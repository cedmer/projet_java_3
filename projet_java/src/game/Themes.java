package game;

import java.util.ArrayList;
import java.util.Random;

public class Themes {
    private ArrayList<Theme> listThemes;
    private ArrayList<Integer> listIndicateur;

    public Themes() {
        this.listThemes = new ArrayList<Theme>();
        this.listIndicateur = new ArrayList<Integer>();

        String themes_str = "Sciences,Sport,Histoire,Mathematiques,Musique,Geographie,Cuisine,Programmation,Reseau";

        for (String str : themes_str.split(","))
            listThemes.add(new Theme(str));

        for (int cpt = 0; cpt < this.listThemes.size(); ++cpt)
            this.listIndicateur.add(cpt);

    }

    public void Afficher() {
        int cpt = 0;
        for (Theme theme : this.listThemes) {
            System.out.print(theme + " : ");
            if (this.listIndicateur.contains(cpt))
                System.out.println("disponible");
            else
                System.out.println("indisponible");
            ++cpt;
        }
    }

    public Theme SelectionnerTheme() {
        Random rand = new Random();
        return listThemes.get(this.listIndicateur.remove(rand.nextInt(this.listIndicateur.size())));
    }

    public ArrayList<Theme>  SelectionnerCinqThemes() {
        ArrayList<Theme> listChoix = new ArrayList<Theme>();
        if (this.listIndicateur.size() >= 5 ) {
            for (int cpt = 0; cpt < 5; ++cpt)
                listChoix.add(this.SelectionnerTheme());
        }
        else
            System.exit(-1);
        return listChoix;
    }

    /*
    public void MofifierTheme(String nouveauTheme, String ancienTheme){

        for(int i=0 ; i< this.listThemes.size();i++){
            if(ancienTheme.equals(listThemes.get(i))){
                this.listThemes.set(i,nouveauTheme);
            }
        }
    }
     */

    public ArrayList<Theme> getListThemes() {
        return listThemes;
    }

    public void setListThemes(ArrayList<Theme> listThemes) {
        this.listThemes = listThemes;
    }

    public ArrayList<Integer> getListIndicateur() {
        return listIndicateur;
    }

    public void setListIndicateur(ArrayList<Integer> listIndicateur) {
        this.listIndicateur = listIndicateur;
    }



}