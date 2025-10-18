package fr.iutfbleau.example;
import java.awt.event.*;
import javax.swing.*;

public class ListenerAjoutBD implements ActionListener{
	private static int i = 17;
	private ControleurRappel control;
	private VueMainFrame vmr;

	 public ListenerAjoutBD(ControleurRappel cc,VueMainFrame vvv) {
	 	i++;
        this.control = cc;
        this.vmr = vvv;
    }

    @Override
    public void actionPerformed(ActionEvent e){
    	boolean b = true;
    	String titre = new String();
    	String contenu = new String();
    	int rang = 0;
    	int theme = 0;
    	if(e.getActionCommand().equals("Ajouter ce rappel")){
    		// Verifier que l'utilisateur entre bien qqc dans chaque champs 
    		// 1ere verification : que le titre ne soit pas vide
    	if(vmr.getFormAjoutPanel().getLabel().equals("Nom : ") || 
    	   vmr.getFormAjoutPanel().getLabel().isEmpty()){
    			JOptionPane.showMessageDialog(null,
    			"Veuillez remplir tout les champs svp !!",
    			"Message d'alerte",
    			JOptionPane.WARNING_MESSAGE
			);
    			b=false;

    	}else{
    		titre = vmr.getFormAjoutPanel().getLabel();
    		contenu = vmr.getFormAjoutPanel().getContenu();
    		b=true;
    		//System.out.println(titre);
    		//System.out.println(contenu);
    	}
			//2eme verification : que le rang a bien été mis par l'user
    		if(vmr.getFormAjoutPanel().getRank().equals("Rang : ") || 
    		   vmr.getFormAjoutPanel().getRank().isEmpty()){
    			JOptionPane.showMessageDialog(null,
    			"Veuillez remplir tout les champs svp !!",
    			"Message d'alerte",
    			JOptionPane.WARNING_MESSAGE
    			);
    			b=false;
    		}else{
    		rang = Integer.parseInt(vmr.getFormAjoutPanel().getRank());
    		b=true;
    		//System.out.println(rang);
    		}
    		
    		//3eme verification : le choix du theme
    		if(ListenerTheme.i !=1 && ListenerTheme.i !=2 && ListenerTheme.i !=3 && ListenerTheme.i !=4 && ListenerTheme.i !=5){
    			JOptionPane.showMessageDialog(null,
    			"Veuillez choisir un theme svp !!!",
    			"Choix d'un thème",
    			JOptionPane.WARNING_MESSAGE


    			);
    			b=false;
    		}else{
    			theme = ListenerTheme.i;
    			b=true;
    			//System.out.println(theme);
    		}

    	if(b){

    	ModelRappel mr = new ModelRappel(i,titre,contenu,rang,theme);
    	//i++;
    	//System.out.println(mr);
    	control.ajouterRappel(mr);
    }
    	}




}

}