# Variables
SRC_DIR = src
BIN_DIR = bin
MAIN_CLASS = Main
JAVA_FILES = $(SRC_DIR)/*.java

# Default target
all: compile run

# Create bin directory if it doesn't exist
$(BIN_DIR):
	mkdir -p $(BIN_DIR)

# Compile Java files
compile: $(BIN_DIR)
	javac -d $(BIN_DIR) $(JAVA_FILES)

# Run the program
run: compile
	java -cp $(BIN_DIR) $(MAIN_CLASS)

# Clean compiled files
clean:
	rm -rf $(BIN_DIR)

# Force rebuild
rebuild: clean all

.PHONY: all compile run clean rebuild
