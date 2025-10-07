
JAVAC = javac
JAVA  = java
JAR   = jar
SRC   = src
BIN   = build

# --- Nom du package et classe principale ---
PKG_PATH = fr/iutfbleau/example
MAIN_PKG = fr.iutfbleau.example.App


#         BUILD BASE


$(BIN):
	@mkdir -p $(BIN)


#      COMPILATION

# Classes sans dépendances
$(BIN)/$(PKG_PATH)/DBManager.class: $(SRC)/$(PKG_PATH)/DBManager.java | $(BIN)
	$(JAVAC) -d $(BIN) $<

$(BIN)/$(PKG_PATH)/ModelRappel.class: $(SRC)/$(PKG_PATH)/ModelRappel.java | $(BIN)
	$(JAVAC) -d $(BIN) $<

# Classes Vue
$(BIN)/$(PKG_PATH)/VueListePanel.class: $(SRC)/$(PKG_PATH)/VueListePanel.java | $(BIN)
	$(JAVAC) -d $(BIN) -cp $(BIN) $<

$(BIN)/$(PKG_PATH)/VueDetailPanel.class: $(SRC)/$(PKG_PATH)/VueDetailPanel.java | $(BIN)
	$(JAVAC) -d $(BIN) -cp $(BIN) $<

$(BIN)/$(PKG_PATH)/VueRappelAddPanel.class: $(SRC)/$(PKG_PATH)/VueRappelAddPanel.java | $(BIN)
	$(JAVAC) -d $(BIN) -cp $(BIN) $<

$(BIN)/$(PKG_PATH)/VueMainFrame.class: $(SRC)/$(PKG_PATH)/VueMainFrame.java \
		$(BIN)/$(PKG_PATH)/VueListePanel.class \
		$(BIN)/$(PKG_PATH)/VueDetailPanel.class \
		$(BIN)/$(PKG_PATH)/VueRappelAddPanel.class | $(BIN)
	$(JAVAC) -d $(BIN) -cp $(BIN) $<

# Listeners
$(BIN)/$(PKG_PATH)/SauvegarderRappelListener.class: $(SRC)/$(PKG_PATH)/SauvegarderRappelListener.java | $(BIN)
	$(JAVAC) -d $(BIN) -cp $(BIN) $<

$(BIN)/$(PKG_PATH)/AjouterRappelListener.class: $(SRC)/$(PKG_PATH)/AjouterRappelListener.java | $(BIN)
	$(JAVAC) -d $(BIN) -cp $(BIN) $<

# Modèle & Base de données
$(BIN)/$(PKG_PATH)/ModelRappelDataBase.class: $(SRC)/$(PKG_PATH)/ModelRappelDataBase.java \
		$(BIN)/$(PKG_PATH)/ModelRappel.class \
		$(BIN)/$(PKG_PATH)/DBManager.class | $(BIN)
	$(JAVAC) -d $(BIN) -cp $(BIN) $<

# Contrôleur
$(BIN)/$(PKG_PATH)/ControleurRappel.class: $(SRC)/$(PKG_PATH)/ControleurRappel.java \
		$(BIN)/$(PKG_PATH)/ModelRappelDataBase.class \
		$(BIN)/$(PKG_PATH)/VueMainFrame.class \
		$(BIN)/$(PKG_PATH)/SauvegarderRappelListener.class \
		$(BIN)/$(PKG_PATH)/AjouterRappelListener.class | $(BIN)
	$(JAVAC) -d $(BIN) -cp $(BIN) $<

# Application principale 
$(BIN)/$(PKG_PATH)/App.class: $(SRC)/$(PKG_PATH)/App.java \
		$(BIN)/$(PKG_PATH)/DBManager.class \
		$(BIN)/$(PKG_PATH)/ModelRappelDataBase.class \
		$(BIN)/$(PKG_PATH)/VueMainFrame.class \
		$(BIN)/$(PKG_PATH)/ControleurRappel.class | $(BIN)
	$(JAVAC) -d $(BIN) -cp $(BIN) $<


#         BUILD FINAL

# Compilation complète
all: $(BIN)/$(PKG_PATH)/App.class

# Création du JAR (sans fichier manifest externe)
jar: all
#$(JAR) --create --file=Papillon.jar --main-class=$(MAIN_PKG) -C $(BIN) .
	$(JAR) cvfe Papillon.jar $(MAIN_PKG) -C $(BIN) .
	@echo "Papillon.jar créé avec succès."


run: jar
	$(JAVA) -jar Papillon.jar

clean:
	rm -rf $(BIN)/*
	rm -f Papillon.jar
	@echo "Dossier build et jar nettoyés."
