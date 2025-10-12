JAVAC = javac
JAVA  = java
JAR   = jar
SRC   = src
BIN   = build

LIB   = lib/mariadb-java-client-3.5.6.jar
PKG_PATH = fr/iutfbleau/example
MAIN_PKG = fr.iutfbleau.example.App

.PHONY: all jar run clean

# Compilation complète (règle par défaut)
all: $(BIN)/$(PKG_PATH)/App.class

# Création du dossier build
$(BIN):
	@mkdir -p $(BIN)

# Classes sans dépendances
$(BIN)/$(PKG_PATH)/DBManager.class: $(SRC)/$(PKG_PATH)/DBManager.java | $(BIN)
	@$(JAVAC) -d $(BIN) -cp "$(BIN);$(LIB)" $<

$(BIN)/$(PKG_PATH)/ComparateurRang.class: $(SRC)/$(PKG_PATH)/ComparateurRang.java | $(BIN)
	@$(JAVAC) -d $(BIN) -cp "$(BIN);$(LIB)" $<

$(BIN)/$(PKG_PATH)/ModelRappel.class: $(SRC)/$(PKG_PATH)/ModelRappel.java | $(BIN)
	@$(JAVAC) -d $(BIN) -cp "$(BIN);$(LIB)" $<


# $(BIN)/$(PKG_PATH)/AjouterRappelListener.class: $(SRC)/$(PKG_PATH)/AjouterRappelListener.java | $(BIN)
# 	@$(JAVAC) -d $(BIN) -cp "$(BIN);$(LIB)" $<

# $(BIN)/$(PKG_PATH)/SauvegarderRappelListener.class: $(SRC)/$(PKG_PATH)/SauvegarderRappelListener.java | $(BIN)
# 	@$(JAVAC) -d $(BIN) -cp "$(BIN);$(LIB)" $<

# Classes Vue
$(BIN)/$(PKG_PATH)/VueListePanel.class: \
	$(SRC)/$(PKG_PATH)/VueListePanel.java \
	$(BIN)/$(PKG_PATH)/ComparateurRang.class | $(BIN)
	@$(JAVAC) -d $(BIN) -cp "$(BIN);$(LIB)" $<

$(BIN)/$(PKG_PATH)/VueDetailPanel.class: $(SRC)/$(PKG_PATH)/VueDetailPanel.java | $(BIN)
	@$(JAVAC) -d $(BIN) -cp "$(BIN);$(LIB)" $<

$(BIN)/$(PKG_PATH)/VueRappelAddPanel.class: $(SRC)/$(PKG_PATH)/VueRappelAddPanel.java | $(BIN)
	@$(JAVAC) -d $(BIN) -cp "$(BIN);$(LIB)" $<

# règle ajoutée / corrigée pour VueRappelModifPanel
$(BIN)/$(PKG_PATH)/VueRappelModifPanel.class: $(SRC)/$(PKG_PATH)/VueRappelModifPanel.java | $(BIN)
	@$(JAVAC) -d $(BIN) -cp "$(BIN);$(LIB)" $<

$(BIN)/$(PKG_PATH)/VueMainFrame.class: $(SRC)/$(PKG_PATH)/VueMainFrame.java \
		$(BIN)/$(PKG_PATH)/VueListePanel.class \
		$(BIN)/$(PKG_PATH)/VueDetailPanel.class \
		$(BIN)/$(PKG_PATH)/VueRappelAddPanel.class \
		$(BIN)/$(PKG_PATH)/VueRappelModifPanel.class | $(BIN)
	@$(JAVAC) -d $(BIN) -cp "$(BIN);$(LIB)" $<

# Modèle avec dépendances
$(BIN)/$(PKG_PATH)/ModelRappelDAO.class: $(SRC)/$(PKG_PATH)/ModelRappelDAO.java \
		$(BIN)/$(PKG_PATH)/ModelRappel.class \
		$(BIN)/$(PKG_PATH)/DBManager.class | $(BIN)
	@$(JAVAC) -d $(BIN) -cp "$(BIN);$(LIB)" $<

# Compilation groupée (contrôleur + listeners) circuit
$(BIN)/$(PKG_PATH)/ControleurRappel.class \
$(BIN)/$(PKG_PATH)/ListenerAjouterRappel.class \
$(BIN)/$(PKG_PATH)/SauvegarderRappelListener.class \
$(BIN)/$(PKG_PATH)/ListenerTheme.class \
$(BIN)/$(PKG_PATH)/ListenerRetourListe.class: \
    $(SRC)/$(PKG_PATH)/ControleurRappel.java \
    $(SRC)/$(PKG_PATH)/ListenerAjouterRappel.java \
    $(SRC)/$(PKG_PATH)/SauvegarderRappelListener.java \
    $(SRC)/$(PKG_PATH)/ListenerTheme.java \
    $(SRC)/$(PKG_PATH)/ListenerRetourListe.java | $(BIN)
	@$(JAVAC) -implicit:none -d $(BIN) -cp "$(BIN);$(LIB)" $^

# Point d'entrée
$(BIN)/$(PKG_PATH)/App.class: $(SRC)/$(PKG_PATH)/App.java \
		$(BIN)/$(PKG_PATH)/DBManager.class \
		$(BIN)/$(PKG_PATH)/ModelRappelDAO.class \
		$(BIN)/$(PKG_PATH)/VueMainFrame.class \
		$(BIN)/$(PKG_PATH)/ControleurRappel.class | $(BIN)
	@$(JAVAC) -implicit:none -d $(BIN) -cp "$(BIN);$(LIB)" $<


jar: all
	@$(JAR) cvfe Papillon.jar $(MAIN_PKG) -C $(BIN) .
	@echo "Papillon.jar cree avec succes."


run: all
	$(JAVA) -cp "$(BIN);$(LIB)" $(MAIN_PKG)

clean:
	-rm -rf $(BIN)/*
	-rm -f Papillon.jar
	@echo "Dossier build et jar nettoyes."
