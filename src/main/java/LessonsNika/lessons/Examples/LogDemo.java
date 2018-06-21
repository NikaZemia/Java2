package LessonsNika.lessons.Examples;

import java.util.Arrays;
import java.util.logging.*;

public class LogDemo {
        private static final Logger LOGGER = Logger.getLogger(LogDemo.class.getName());

        public static void main(String[] args) {
                LOGGER.log(Level.FINE, "started with arguments: {0}", Arrays.toString(args));

                try {
                        randomlyFailingAlgorithm();
                }
                catch (IllegalStateException e){
                        LOGGER.log(Level.SEVERE, "Exception caught", e);
                        System.exit(2);
                }
                LOGGER.fine("Finished successfully");
        }

        private static void randomlyFailingAlgorithm(){
                double randomNumber = Math.random();
                LOGGER.log(Level.FINE, "Generation random number: {0}", randomNumber);
                if(randomNumber<0.5){
                        throw  new IllegalStateException("Invalid phase of the Moon");
                }
        }
}


