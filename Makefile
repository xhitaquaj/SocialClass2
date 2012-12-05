JFLAGS = -g

JC = javac

CLASSPATH=/usr/java/jdk1.7.0_09/jre/lib/jfxrt.jar:.

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java	

CLASSES = \
	gui/FriendsList.java \
	gui/Friend.java \
	gui/JavaFXClient.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
	$(RM) gui/*.class
	$(RM) core/*.class
	$(RM) communication/*.class
