package fr.iutfbleau.example;
import java.awt.event.*;
import javax.swing.*;

public class ListenerAjoutBD implements ActionListener{
	private ControleurRappel control;
	private VueMainFrame vmr;

	 public ListenerAjoutBD(ControleurRappel cc,VueMainFrame vvv) {
        this.control = cc;
        this.vmr = vvv;
        //this.vrap = v;
    }

    @Override
    public void actionPerformed(ActionEvent e){
    	String titre;
    	String contenu;
    	int rang;
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

    	}else{
    		titre=vmr.getFormAjoutPanel().getLabel().substring(6);
    		System.out.println(titre);

    	}
			//2eme verification : que le rang a bien été mis par l'user
    		if(vmr.getFormAjoutPanel().getRank().equals("Rang : ") || 
    		   vmr.getFormAjoutPanel().getRank().isEmpty()){
    			JOptionPane.showMessageDialog(null,
    			"Veuillez remplir tout les champs svp !!",
    			"Message d'alerte",
    			JOptionPane.WARNING_MESSAGE
    			);
    		}else{
    			rang = Integer.parseInt(vmr.getFormAjoutPanel().getRank().substring(7));
    			System.out.println(rang);


    		}
    	}


}

}