package fr.iutfbleau.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** 
 * Classe qui permettra à l'utilisateur d'avoir un apercu du theme qu'il choisir
 * @author ANHDIRE Ayoub
 * @version 1.0
 * 
*/

public class ThemeListener implements ActionListener{
	private VueRappelAddPanel vra;

/** 
 * Permet d'ajouter des ecouteurs a chaque bouton 
*/
	public ThemeListener(VueRappelAddPanel a){
		this.vra = a;
		this.vra.getTheme1().addActionListener(this);
		this.vra.getTheme2().addActionListener(this); 		
		this.vra.getTheme3().addActionListener(this);		
		this.vra.getTheme4().addActionListener(this);
		this.vra.getTheme5().addActionListener(this);



	}
	/**
	 * Permet de changer le fond d'ecran du panel selon le bouton cliqué
	 * @param e Classe qui nous permet de recuperer des informations sur des boutons en general
	 * 
	 */

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("1(Rouge)")){
			this.vra.setBackground(new Color(0xFFD6D6));
		}
		if(e.getActionCommand().equals("2(Jaune)")){
			this.vra.setBackground(new Color(0xFFF5CC));
		}
		if(e.getActionCommand().equals("3(Vert)")){
			this.vra.setBackground(new Color(0xDFFFD6));
		}
		if(e.getActionCommand().equals("4(Bleu)")){
			this.vra.setBackground(new Color(0xD6E9FF));
		}
		if(e.getActionCommand().equals("5(Cyan)")){
			this.vra.setBackground(new Color(0xD0F0FD));
		}


	}
}