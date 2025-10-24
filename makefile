JAVAC = javac
JAVADOC = javadoc
JAVA  = java
JAR   = jar
SRC   = src
DOC   = docjava
BIN   = build
LIB   = lib/mariadb-java-client-3.5.6.jar

PKG_PATH = fr/iutfbleau/example
MAIN_CLASS = fr.iutfbleau.example.App
FATJAR = Papillon-FAT.jar
TMPDIR = tmpjar


# corection du bug de classpath
ifeq ($(OS),Windows_NT)
    SEP = ;
else
    SEP = :
endif


all: $(BIN)/$(PKG_PATH)/App.class


$(BIN):
	@mkdir -p $(BIN)

$(DOC):
	@mkdir -p $(DOC)

$(BIN)/$(PKG_PATH)/ListenerFermeture.class: $(SRC)/$(PKG_PATH)/ListenerFermeture.java | $(BIN)
	@$(JAVAC) -d $(BIN) -cp "$(LIB)$(SEP)$(BIN)" $<

$(BIN)/$(PKG_PATH)/ErrorManager.class: $(SRC)/$(PKG_PATH)/ErrorManager.java | $(BIN)
	@$(JAVAC) -d $(BIN) -cp "$(LIB)" $<

$(BIN)/$(PKG_PATH)/DBManager.class: $(SRC)/$(PKG_PATH)/DBManager.java $(BIN)/$(PKG_PATH)/ErrorManager.class | $(BIN)
	@$(JAVAC) -d $(BIN) -cp "$(LIB)$(SEP)$(BIN)" $<

$(BIN)/$(PKG_PATH)/ModelRappel.class: $(SRC)/$(PKG_PATH)/ModelRappel.java | $(BIN)
	@$(JAVAC) -d $(BIN) -cp "$(LIB)$(SEP)$(BIN)" $<

$(BIN)/$(PKG_PATH)/ModelRappelDAO.class: $(SRC)/$(PKG_PATH)/ModelRappelDAO.java $(BIN)/$(PKG_PATH)/ModelRappel.class $(BIN)/$(PKG_PATH)/DBManager.class | $(BIN)
	@$(JAVAC) -d $(BIN) -cp "$(LIB)$(SEP)$(BIN)" $<


$(BIN)/$(PKG_PATH)/VueMainFrame.class \
$(BIN)/$(PKG_PATH)/VueListePanel.class \
$(BIN)/$(PKG_PATH)/VueDetailPanel.class \
$(BIN)/$(PKG_PATH)/VueRappelAddPanel.class \
$(BIN)/$(PKG_PATH)/VueRappelModifPanel.class: \
$(SRC)/$(PKG_PATH)/VueMainFrame.java \
$(SRC)/$(PKG_PATH)/VueListePanel.java \
$(SRC)/$(PKG_PATH)/VueDetailPanel.java \
$(SRC)/$(PKG_PATH)/VueRappelAddPanel.java \
$(SRC)/$(PKG_PATH)/VueRappelModifPanel.java
	@$(JAVAC) -d $(BIN) -cp "$(LIB)$(SEP)$(BIN)" $^

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
	@$(JAVAC) -d $(BIN) -cp "$(LIB)$(SEP)$(BIN)" \
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
	$(BIN)/$(PKG_PATH)/DBManager.class \
	$(BIN)/$(PKG_PATH)/ListenerFermeture.class | $(BIN)
	@$(JAVAC) -d $(BIN) -cp "$(LIB)$(SEP)$(BIN)" $<


jar: all
	$(JAR) cvfe Papillon.jar $(MAIN_CLASS) -C $(BIN) .


run: jar
	$(JAVA) -cp "Papillon.jar$(SEP)$(LIB)" $(MAIN_CLASS)

fatjar: jar
	echo "Création du jar avec le driver MariaDB... JAR"
	@rm -rf $(TMPDIR)
	@mkdir $(TMPDIR)
	@cd $(TMPDIR) && jar xf ../Papillon.jar
	@cd $(TMPDIR) && jar xf ../$(LIB)
	@cd $(TMPDIR) && $(JAR) cfe ../$(FATJAR) $(MAIN_CLASS) .
	@rm -rf $(TMPDIR)
	echo "L'operation is good"

doc: $(DOC)
	@echo "Génération de la documentation java..."
	$(JAVADOC) -d $(DOC) -cp "$(LIB)" -sourcepath $(SRC) fr.iutfbleau.example
	@echo "Documentation générée dans le dossier '$(DOC)/' ."

runfatjar: fatjar
	$(JAVA) -jar Papillon-Fat.jar



runnotjar: all
	$(JAVA) -cp "$(LIB)$(SEP)$(BIN)" $(MAIN_CLASS)


clean:
	rm -rf $(BIN) $(DOC) Papillon.jar Papillon-FAT.jar
	@echo "Dossier build et jar nettoyés."

