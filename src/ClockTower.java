import javax.print.attribute.standard.Media;
import java.applet.AudioClip;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.*;
import java.io.*;
public class ClockTower {
    public static int getMinutes;
    public static int getHours;
    public static int getSeconds;

    static String hour = "westminster-top-hour-chime.mp3";
    static String quarterHour = "westminster-quarter-hour-chime.mp3";
    static String thirdQuarter = "westminster-third-quarter-chime.mp3";
    static String halfHour = "westminster-half-chime.mp3";
    static String chime = "hour-chimes.mp3";

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
        InputStream inHour = new FileInputStream(hour);
        InputStream inQuarterHour = new FileInputStream(quarterHour);
        InputStream inThirdQuarter = new FileInputStream(thirdQuarter);
        InputStream inHalfHour = new FileInputStream(halfHour);
        InputStream inChime = new FileInputStream(chime);

        if(minutes == 0){
            if(seconds == 0){
                System.out.println(hours + ":" + minutes + ":" + seconds);
                for(int i = 0; i < hours; i++){

                }
            }
        }else if(minutes % 15 == 0){
            if(seconds == 0){
                if(minutes == 15){
                    System.out.println(hours + ":" + minutes + ":" + seconds);

                }else if(minutes == 30){
                    System.out.println(hours + ":" + minutes + ":" + seconds);
                }else if(minutes == 45){
                    System.out.println(hours + ":" + minutes + ":" + seconds);
                }
            }
        }
    }
}
