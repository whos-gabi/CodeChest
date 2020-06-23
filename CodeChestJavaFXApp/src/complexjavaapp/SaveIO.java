/*
This is a save class!
dont make any changes here 

copyright:
@the_cyber_bro
 */
package complexjavaapp;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author theCYBERbro
 */
public class SaveIO{//TODO:update;refactor;comment

        public static final String SCORE_FILE_NAME="scor.csv";
    
    public static void saveScorToFile(int money){
        
        FileWriter fw = null;
        try {
            fw = new FileWriter(SCORE_FILE_NAME, true);
            LocalDate castigDate =  LocalDate.now();
            int hour =LocalDateTime.now().getHour();
            int minute=LocalDateTime.now().getMinute();
            String stringToWrite= castigDate+" , "+hour+":"+minute+" , "+money+"\n";
            fw.write(stringToWrite);
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
      
    }
            
}
