import javax.print.attribute.standard.Media;
import java.applet.AudioClip;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.*;
import java.io.*;
//import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
public class ClockTower {
    public static int getMinutes;
    public static int getHours;
    public static int getSeconds;

    static String hour = "westminster-top-hour-chime.wav";
    static String quarterHour = "westminster-quarter-hour-chime.wav";
    static String thirdQuarter = "westminster-third-quarter-chime.wav";
    static String halfHour = "westminster-half-chime.wav";
    static String chime = "hour-chimes.wav";

    public static void main(String[] args) throws Exception{
        while(true) {
            Calendar calendar = Calendar.getInstance();
            getHours = calendar.get(Calendar.HOUR);
            getMinutes = calendar.get(Calendar.MINUTE);
            getSeconds = calendar.get(Calendar.SECOND);
            ringTime(getHours, getMinutes, getSeconds);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void ringTime(int hours, int minutes, int seconds) throws Exception{
        if(minutes == 0){
            if(seconds == 0){
                System.out.println(hours + ":" + minutes + ":" + seconds + " sound was played");
                AudioInputStream inHour = AudioSystem.getAudioInputStream(new File(hour).getAbsoluteFile());
                Clip clipHour = AudioSystem.getClip();
                clipHour.open(inHour);
                clipHour.start();
                clipHour.wait();
                clipHour.close();
                clipHour.flush();
                for(int i = 0; i < hours; i++){
                    AudioInputStream inChime = AudioSystem.getAudioInputStream(new File(chime).getAbsoluteFile());
                    Clip clipChime = AudioSystem.getClip();
                    clipChime.open(inChime);
                    clipChime.start();
                    if(i == hours - 1){
                        clipChime.wait();
                    }
                    clipChime.wait();
                    clipChime.close();
                    clipChime.flush();
                }
            }
        }else if(minutes % 15 == 0){
            if(seconds == 0){
                if(minutes == 15){
                    System.out.println(hours + ":" + minutes + ":" + seconds + " the sound was played");
                    AudioInputStream inQuarter = AudioSystem.getAudioInputStream(new File(quarterHour).getAbsoluteFile());
                    Clip clipQuarter = AudioSystem.getClip();
                    clipQuarter.open(inQuarter);
                    clipQuarter.start();
                    clipQuarter.wait();
                    clipQuarter.close();
                    clipQuarter.flush();
                }else if(minutes == 30){
                    System.out.println(hours + ":" + minutes + ":" + seconds + " sound was played");
                    AudioInputStream inHalf = AudioSystem.getAudioInputStream(new File(halfHour).getAbsoluteFile());
                    Clip clipHalf = AudioSystem.getClip();
                    clipHalf.open(inHalf);
                    clipHalf.start();
                    clipHalf.wait();
                    clipHalf.close();
                    clipHalf.flush();
                }else if(minutes == 45){
                    System.out.println(hours + ":" + minutes + ":" + seconds + " played sound");
                    AudioInputStream inThreeQuarters = AudioSystem.getAudioInputStream(new File(thirdQuarter).getAbsoluteFile());
                    Clip clipThreeQuarters = AudioSystem.getClip();
                    clipThreeQuarters.open(inThreeQuarters);
                    clipThreeQuarters.start();
                    clipThreeQuarters.wait();
                    clipThreeQuarters.close();
                    clipThreeQuarters.flush();
                }
            }
        }
    }
}
