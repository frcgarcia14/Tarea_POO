JFLAGS = -g
JC = javac
JVM = java  # Added by Agust�n Gonz�lez
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Ball.java \
	MyWorld.java \
	PhysicsElement.java \
	PhysicsLab.java \
	Spring.java \
	FixedHook.java \
	SpringAttachable.java

# main variable: Added by Agust�n Gonz�lez
MAIN = PhysicsLab  # (Modified by Me) In PhysicsLab class is the main method

default: classes

classes: $(CLASSES:.java=.class)

# run target added by Agust�n Gonz�lez
run: 
	$(JVM) $(MAIN)

clean:
	$(RM) *.class
