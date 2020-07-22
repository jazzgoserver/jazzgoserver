package regine.util;

import java.util.Random;

import org.apache.log4j.Logger;

public interface Single {
	Logger log = Logger.getRootLogger();
	Random caso = new Random();

	String EMPTY = "";
	String DEBUG = ": ";
	String EOL = "\n";
}
