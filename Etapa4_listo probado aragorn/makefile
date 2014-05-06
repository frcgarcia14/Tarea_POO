JFLAGS = -g
JC = javac
JVM = java  # Added by Agustín González
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

# main variable: Added by Agustín González
MAIN = PhysicsLab  # (Modified by Me) In PhysicsLab class is the main method

default: classes

classes: $(CLASSES:.java=.class)

# run target added by Agustín González
run: 
	$(JVM) $(MAIN)

clean:
	$(RM) *.class
