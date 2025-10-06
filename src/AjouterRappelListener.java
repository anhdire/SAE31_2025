import java.awt.event.*;

public class AjouterRappelListener implements ActionListener {
    private ControlRappel controller;

    public AjouterRappelListener(ControlRappel c) { this.controller = c; }

    public void actionPerformed(ActionEvent e) { controller.afficherForm(null); }
}
