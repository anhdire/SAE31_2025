JAVAC = javac
JAVA  = java
JAR   = jar
SRC   = src
BIN   = build
LIB   = lib/mariadb-java-client-3.5.6.jar

PKG_PATH = fr/iutfbleau/example
MAIN_CLASS = fr.iutfbleau.example.App


all: $(BIN)/$(PKG_PATH)/App.class


$(BIN):
	mkdir -p $(BIN)


$(BIN)/$(PKG_PATH)/ErrorManager.class: $(SRC)/$(PKG_PATH)/ErrorManager.java | $(BIN)
	$(JAVAC) -d $(BIN) -cp "$(LIB)" $<

$(BIN)/$(PKG_PATH)/ComparateurRang.class: $(SRC)/$(PKG_PATH)/ComparateurRang.java | $(BIN)
	$(JAVAC) -d $(BIN) -cp "$(LIB):$(BIN)" $<

$(BIN)/$(PKG_PATH)/DBManager.class: $(SRC)/$(PKG_PATH)/DBManager.java $(BIN)/$(PKG_PATH)/ErrorManager.class | $(BIN)
	$(JAVAC) -d $(BIN) -cp "$(LIB):$(BIN)" $<

$(BIN)/$(PKG_PATH)/ModelRappel.class: $(SRC)/$(PKG_PATH)/ModelRappel.java | $(BIN)
	$(JAVAC) -d $(BIN) -cp "$(LIB):$(BIN)" $<

$(BIN)/$(PKG_PATH)/ModelRappelDAO.class: $(SRC)/$(PKG_PATH)/ModelRappelDAO.java $(BIN)/$(PKG_PATH)/ModelRappel.class $(BIN)/$(PKG_PATH)/DBManager.class | $(BIN)
	$(JAVAC) -d $(BIN) -cp "$(LIB):$(BIN)" $<


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
	@echo "Compilation groupée des classes Vue..."
	$(JAVAC) -d $(BIN) -cp "$(LIB):$(BIN)" $^

# Compilation du controleur et des listner  ne pas utiliser le $^ sinon ça marche pas 
$(BIN)/$(PKG_PATH)/ControleurRappel.class \
$(BIN)/$(PKG_PATH)/ListenerBtn.class \
$(BIN)/$(PKG_PATH)/ListenerAjoutBD.class \
$(BIN)/$(PKG_PATH)/ListenerModifieBD.class \
$(BIN)/$(PKG_PATH)/ListenerTheme.class: \
$(SRC)/$(PKG_PATH)/ControleurRappel.java \
$(SRC)/$(PKG_PATH)/ListenerBtn.java \
$(SRC)/$(PKG_PATH)/ListenerAjoutBD.java \
$(SRC)/$(PKG_PATH)/ListenerModifieBD.java \
$(SRC)/$(PKG_PATH)/ListenerTheme.java \
$(BIN)/$(PKG_PATH)/ModelRappel.class \
$(BIN)/$(PKG_PATH)/ModelRappelDAO.class \
$(BIN)/$(PKG_PATH)/VueMainFrame.class \
$(BIN)/$(PKG_PATH)/VueListePanel.class \
$(BIN)/$(PKG_PATH)/VueDetailPanel.class \
$(BIN)/$(PKG_PATH)/VueRappelAddPanel.class \
$(BIN)/$(PKG_PATH)/VueRappelModifPanel.class \
$(BIN)/$(PKG_PATH)/ErrorManager.class | $(BIN)
	@echo "Compilation groupée du contrôleur et des listeners..."
	$(JAVAC) -d $(BIN) -cp "$(LIB):$(BIN)" \
	$(SRC)/$(PKG_PATH)/ControleurRappel.java \
	$(SRC)/$(PKG_PATH)/ListenerBtn.java \
	$(SRC)/$(PKG_PATH)/ListenerAjoutBD.java \
	$(SRC)/$(PKG_PATH)/ListenerModifieBD.java \
	$(SRC)/$(PKG_PATH)/ListenerTheme.java


$(BIN)/$(PKG_PATH)/App.class: $(SRC)/$(PKG_PATH)/App.java \
	$(BIN)/$(PKG_PATH)/ControleurRappel.class \
	$(BIN)/$(PKG_PATH)/VueMainFrame.class \
	$(BIN)/$(PKG_PATH)/ModelRappelDAO.class \
	$(BIN)/$(PKG_PATH)/ErrorManager.class \
	$(BIN)/$(PKG_PATH)/DBManager.class | $(BIN)
	@echo "Compilation de la classe principale App..."
	$(JAVAC) -d $(BIN) -cp "$(LIB):$(BIN)" $<


jar: all
	$(JAR) cvfe Papillon.jar $(MAIN_CLASS) -C $(BIN) .
	@echo "Papillon.jar créé avec succès."


run: jar
	$(JAVA) -cp "Papillon.jar:$(LIB)" $(MAIN_CLASS)

runnotjar: all
	$(JAVA) -cp "$(BIN):$(LIB)" $(MAIN_CLASS)


clean:
	rm -rf $(BIN) Papillon.jar
	@echo "Dossier build et jar nettoyés."

