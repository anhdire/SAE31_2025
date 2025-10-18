package fr.iutfbleau.example;

import java.awt.event.*;

/** 
 * Classe qui permettra à l'utilisateur d'avoir un apercu du theme qu'il choisir
 * @author ANHDIRE Ayoub
 * @version 1.0
 * 
*/

public class ListenerTheme implements ActionListener{
	private ControleurRappel controller;
	static int i; //
	//private VueRappelAddPanel vra;

	/** 
	 * Permet d'ajouter des ecouteurs a chaque bouton 
	*/
	public ListenerTheme(ControleurRappel ctr){
		this.controller = ctr;
		// this.vra = a;
		// this.vra.getTheme1().addActionListener(this);
		// this.vra.getTheme2().addActionListener(this); 		
		// this.vra.getTheme3().addActionListener(this);		
		// this.vra.getTheme4().addActionListener(this);
		// this.vra.getTheme5().addActionListener(this);



	}
	/**
	 * Permet de changer le fond d'ecran du panel selon le bouton cliqué
	 * @param e Classe qui nous permet de recuperer des informations sur des boutons en general
	 * 
	 */

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("1")){
			i=1; //
			controller.changerTheme(1);
		}
		if(e.getActionCommand().equals("2")){
			i=2; //
			controller.changerTheme(2);
		}
		if(e.getActionCommand().equals("3")){
			i=3; //
			controller.changerTheme(3);
		}
		if(e.getActionCommand().equals("4")){
			i=4; //
			controller.changerTheme(4);
		}
		if(e.getActionCommand().equals("5")){
			i=5;
			controller.changerTheme(5);
		}

	}
	public int getI(){
		return i;
	}
}