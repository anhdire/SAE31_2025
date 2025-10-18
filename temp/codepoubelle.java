 // this.setLayout(new BorderLayout());
        // this.setBackground(Color.WHITE);

        // // Panneau contenant tous les rappels
        // this.listeRappel = new JPanel();
        // this.listeRappel.setLayout(new BoxLayout(this.listeRappel, BoxLayout.Y_AXIS));
        // this.listeRappel.setBackground(Color.WHITE);

        // this.scrollPane = new JScrollPane(listeRappel);
        // this.scrollPane.setBorder(null);
        // this.scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // // masquer les barres (ne plus afficher)
        // //this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        // this.scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);



        // this.add(scrollPane, BorderLayout.CENTER);

        // // Bouton d'ajout "+"
        // this.boutonAjout = new JButton("+");
        // boutonAjout.setFont(new Font("Arial", Font.BOLD, 19));
        // boutonAjout.setPreferredSize(new Dimension(35, 35));
        // boutonAjout.setFocusPainted(false);
        // boutonAjout.setBackground(new Color(0x007BFF));
        // boutonAjout.setForeground(Color.WHITE);
        // boutonAjout.setBorder(BorderFactory.createEmptyBorder());
        // boutonAjout.setCursor(new Cursor(Cursor.HAND_CURSOR));


        // // ============================== CETTE Partie n'est pas definitive ============================

        // // un JLayeredPane pour superposer le bouton au scrolloane
        // JLayeredPane layered = new JLayeredPane();
        // this.setPreferredSize(new Dimension(VueMainFrame.WIDTH, VueMainFrame.HEIGHT));
        // layered.setLayout(null);
    
        // // scrollPane prend tout l'espace
        // scrollPane.setBounds(0, 0, VueMainFrame.WIDTH, VueMainFrame.HEIGHT);
        // layered.add(scrollPane, JLayeredPane.DEFAULT_LAYER); // DEFAULT_LAYER = 0 (plus bas)

        // // je positionne le bouton en bas à droite (marge 12px)
        // Dimension b = boutonAjout.getPreferredSize();
        // int x = VueMainFrame.WIDTH - b.width - 55;
        // int y = VueMainFrame.HEIGHT - b.height - 75;
        // boutonAjout.setBounds(x, y, b.width, b.height);
        // layered.add(boutonAjout, JLayeredPane.PALETTE_LAYER); // PALETTE_LAYER = 100 (plus haut)

        
        // // Ajouter le layeredPane au panel principal
        // this.removeAll(); // au cas où il y avait déjà quelque chose
        // this.setLayout(new BorderLayout());
        // this.add(layered, BorderLayout.CENTER);

        // // ============================================================================================