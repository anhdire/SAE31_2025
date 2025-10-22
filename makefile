
#  MAKEFILE - PAPILLON

JAVAC = javac
JAVA  = java
JAR   = jar
SRC   = src
BIN   = build

LIB   = lib/mariadb-java-client-3.5.6.jar
PKG_PATH = fr/iutfbleau/example
MAIN_PKG = fr.iutfbleau.example.App

.PHONY: all jar run runnotjar clean

# RÈGLE PAR DÉFAUT

all: $(BIN)/$(PKG_PATH)/App.class 

# Création du dossier build
$(BIN):
	@mkdir -p $(BIN)

#   CLASSES SANS DÉPENDANCES
$(BIN)/$(PKG_PATH)/DBManager.class: $(SRC)/$(PKG_PATH)/DBManager.java | $(BIN)
	@$(JAVAC) -implicit:none -d $(BIN) -cp "$(BIN);$(LIB)" $<

$(BIN)/$(PKG_PATH)/ListenerFermeture.class: $(SRC)/$(PKG_PATH)/ListenerFermeture.java | $(BIN)
	@$(JAVAC) -implicit:none -d $(BIN) -cp "$(BIN);$(LIB)" $<

$(BIN)/$(PKG_PATH)/ComparateurRang.class: $(SRC)/$(PKG_PATH)/ComparateurRang.java | $(BIN)
	@$(JAVAC) -implicit:none -d $(BIN) -cp "$(BIN);$(LIB)" $<

$(BIN)/$(PKG_PATH)/ModelRappel.class: $(SRC)/$(PKG_PATH)/ModelRappel.java | $(BIN)
	@$(JAVAC) -implicit:none -d $(BIN) -cp "$(BIN);$(LIB)" $<

$(BIN)/$(PKG_PATH)/ErrorManager.class: $(SRC)/$(PKG_PATH)/ErrorManager.java | $(BIN)
	@$(JAVAC) -implicit:none -d $(BIN) -cp "$(BIN);$(LIB)" $<


#   CLASSES DU MODÈLE
$(BIN)/$(PKG_PATH)/ModelRappelDAO.class: $(SRC)/$(PKG_PATH)/ModelRappelDAO.java \
		$(BIN)/$(PKG_PATH)/ModelRappel.class \
		$(BIN)/$(PKG_PATH)/DBManager.class | $(BIN)
	@$(JAVAC) -implicit:none -d $(BIN) -cp "$(BIN);$(LIB)" $<


#   COMPILATION GROUPÉE DES VUES

$(BIN)/$(PKG_PATH)/VueMainFrame.class \
$(BIN)/$(PKG_PATH)/VueListePanel.class \
$(BIN)/$(PKG_PATH)/VueDetailPanel.class \
$(BIN)/$(PKG_PATH)/VueRappelAddPanel.class \
$(BIN)/$(PKG_PATH)/VueRappelModifPanel.class: \
	$(SRC)/$(PKG_PATH)/VueMainFrame.java \
	$(SRC)/$(PKG_PATH)/VueListePanel.java \
	$(SRC)/$(PKG_PATH)/VueDetailPanel.java \
	$(SRC)/$(PKG_PATH)/VueRappelAddPanel.java \
	$(SRC)/$(PKG_PATH)/VueRappelModifPanel.java \
	$(BIN)/$(PKG_PATH)/ComparateurRang.class | $(BIN)
	@echo "Compilation groupée des classes de la Vue..."
	@$(JAVAC) -implicit:none -d $(BIN) -cp "$(BIN);$(LIB)" $(filter %.java,$^)



#   COMPILATION GROUPÉE DU CONTRÔLEUR + TOUS LES LISTENERS
# Elles sont compilées ensemble pour éviter toute dépendance circulaire.
$(BIN)/$(PKG_PATH)/ControleurRappel.class \
$(BIN)/$(PKG_PATH)/ListenerBtn.class \
$(BIN)/$(PKG_PATH)/ListenerTheme.class \
$(BIN)/$(PKG_PATH)/ListenerAjoutBD.class \
$(BIN)/$(PKG_PATH)/ListenerModifierRappel.class \
$(BIN)/$(PKG_PATH)/Utils.class \
$(BIN)/$(PKG_PATH)/ListenerModifieBD.class: \
$(SRC)/$(PKG_PATH)/ControleurRappel.java \
$(SRC)/$(PKG_PATH)/ListenerBtn.java \
$(SRC)/$(PKG_PATH)/ListenerTheme.java \
$(SRC)/$(PKG_PATH)/ListenerAjoutBD.java \
$(SRC)/$(PKG_PATH)/ListenerModifierRappel.java \
$(SRC)/$(PKG_PATH)/Utils.java \
$(SRC)/$(PKG_PATH)/ListenerModifieBD.java \
$(BIN)/$(PKG_PATH)/ModelRappelDAO.class \
$(BIN)/$(PKG_PATH)/ErrorManager.class | $(BIN)
	@echo "Compilation groupée du contrôleur et des listeners..."
	@$(JAVAC) -implicit:none -d $(BIN) -cp "$(BIN);$(LIB)" $(filter %.java,$^)



#   CLASSE PRINCIPALE
$(BIN)/$(PKG_PATH)/App.class: $(SRC)/$(PKG_PATH)/App.java \
		$(BIN)/$(PKG_PATH)/DBManager.class \
		$(BIN)/$(PKG_PATH)/ModelRappelDAO.class \
		$(BIN)/$(PKG_PATH)/VueMainFrame.class \
		$(BIN)/$(PKG_PATH)/ListenerFermeture.class \
		$(BIN)/$(PKG_PATH)/ControleurRappel.class | $(BIN)
	@$(JAVAC) -implicit:none -d $(BIN) -cp "$(BIN);$(LIB)" $<


#   ARCHIVE JAR
jar: all
	@$(JAR) cvfe Papillon.jar $(MAIN_PKG) -C $(BIN) .
	@echo "Papillon.jar cree avec succes."


#   EXÉCUTION
run: jar
	@echo "Execution de l'application Papillon..."
	@$(JAVA) -cp "Papillon.jar;$(LIB);$(RES)" $(MAIN_PKG)

runnotjar: all
	@echo "Execution en mode developpement (sans jar)..."
	@$(JAVA) -cp "$(BIN);$(LIB);$(RES)" $(MAIN_PKG)


#   NETTOYAGE
clean:
	@rm -rf $(BIN) Papillon.jar
	@rm -rf build
	@echo "Nettoyage termine."
