package fr.iutfbleau.example;
import javax.swing.*;
import java.awt.event.*;



public class ListenerModifieBD implements ActionListener{
	private ControleurRappel c;
	private VueMainFrame v;

	public ListenerModifieBD(ControleurRappel cr,VueMainFrame vmn){
		this.c = cr;
		this.v = vmn;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		/** pas finalisé encore
		*/
		if(!e.getActionCommand().equals("Confirmer les modifications")){
			return;
		}
		//boolean
		String newTitle = v.getFormModifPanel().getnewTitle();
		String newwContent = v.getFormModifPanel().getnewContent();
		String newRank = v.getFormModifPanel().getnewRank();

		System.out.println(newTitle);
		System.out.println(newwContent);
		System.out.println(newRank);


	}
}