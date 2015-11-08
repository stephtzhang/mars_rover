# from : http://www.cs.swarthmore.edu/~newhall/unixhelp/howto_makefiles.html#java

# define a makefile variable for the java compiler
JCC = javac

# define a makefile variable for compilation flags
JFLAGS = -g

# default actions executed on 'make' command
default: Parser.class Mission.class Rover.class Plateau.class Runner.class

Runner.class: Runner.java
	$(JCC) $(JFLAGS) Runner.java

Parser.class: mission/Parser.java
	$(JCC) $(JFLAGS) mission/Parser.java

Mission.class: mission/Mission.java
	$(JCC) $(JFLAGS) mission/Mission.java

Rover.class: mission/Rover.java
	$(JCC) $(JFLAGS) mission/Rover.java

Plateau.class: mission/Plateau.java
	$(JCC) $(JFLAGS) mission/Plateau.java

# to start over from scratch, type 'make clean'.
clean:
	$(RM) *.class
	$(RM) mission/*.class
	$(RM) tests/*.class