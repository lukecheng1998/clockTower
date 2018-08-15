import java.io.File;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.*;
import java.io.*;


public class ClockTower implements LineListener {
    String hour = "westminster-top-hour-chime.wav";
    String quarterHour = "westminster-quarter-hour-chime.wav";
    String thirdQuarter = "westminster-third-quarter-chime.wav";
    String halfHour = "westminster-half-chime.wav";
    String chime = "hour-chimes.wav";
//TODO: Rewrite playsounds to include 5 different play sounds

    public boolean finishedPlaying;

    public void playHour() {
        File hourFile = new File(hour);
        try {
            AudioInputStream inHour = AudioSystem.getAudioInputStream(hourFile);
            AudioFormat formatHour = inHour.getFormat();
            DataLine.Info infoHour = new DataLine.Info(Clip.class, formatHour);
            Clip audioHour = (Clip) AudioSystem.getLine(infoHour);
            audioHour.addLineListener(this);
            audioHour.open(inHour);
            audioHour.start();
            while (!finishedPlaying) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            audioHour.close();
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }
    }
    public void playChime(){
        File chimeFile = new File(chime);

        try {
            AudioInputStream inChime = AudioSystem.getAudioInputStream(chimeFile);
            AudioFormat formatChime = inChime.getFormat();
            DataLine.Info infoChime = new DataLine.Info(Clip.class, formatChime);
            Clip audioChime = (Clip) AudioSystem.getLine(infoChime);
            audioChime.addLineListener(this);
            audioChime.open(inChime);
            audioChime.start();
            while (!finishedPlaying) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            audioChime.close();
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }
    }

    public void playQuarter(){
        File quarterFile = new File(quarterHour);
        try {
            AudioInputStream inQuarter = AudioSystem.getAudioInputStream(quarterFile);
            AudioFormat formatQuarter = inQuarter.getFormat();
            DataLine.Info infoQuarter = new DataLine.Info(Clip.class, formatQuarter);
            Clip audioQuarter = (Clip) AudioSystem.getLine(infoQuarter);
            audioQuarter.addLineListener(this);
            audioQuarter.open(inQuarter);
            audioQuarter.start();
            while(!finishedPlaying){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }audioQuarter.close();
        }catch(IOException e){
            e.printStackTrace();
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        }
    }

    public void playHalf(){
        File halfFile = new File(halfHour);
        try {
            AudioInputStream inHalf = AudioSystem.getAudioInputStream(halfFile);
            AudioFormat formatHalf = inHalf.getFormat();
            DataLine.Info infoHalf = new DataLine.Info(Clip.class, formatHalf);
            Clip audioHalf = (Clip) AudioSystem.getLine(infoHalf);
            audioHalf.addLineListener(this);
            audioHalf.open(inHalf);
            audioHalf.start();
            while(!finishedPlaying){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            audioHalf.close();
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Error playing the audio file.");

        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        }
    }

    public void playThirdQuarterHour(){
        File thirdQuarterFile = new File(thirdQuarter);
        try {
            AudioInputStream inThirdQuarter = AudioSystem.getAudioInputStream(thirdQuarterFile);
            AudioFormat formatThirdQuarter = inThirdQuarter.getFormat();
            DataLine.Info infoThirdQuarter = new DataLine.Info(Clip.class, formatThirdQuarter);
            Clip audioThirdQuarter = (Clip) AudioSystem.getLine(infoThirdQuarter);
            audioThirdQuarter.addLineListener(this);
            audioThirdQuarter.open(inThirdQuarter);
            audioThirdQuarter.start();
            while(!finishedPlaying){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            audioThirdQuarter.close();
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Error playing the audio file.");

        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        }
    }

    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();
        if (type == LineEvent.Type.START) {
            System.out.println("This shit works");
        } else if (type == LineEvent.Type.STOP) {
            System.out.println("This shit stopped");
            finishedPlaying = true;
        }
    }

    public static void main(String[] args) throws Exception {
        boolean isplayed = false;
        while (true) {
            int getMinutes;
            int getHours;
            int getSeconds;

            Calendar calendar = Calendar.getInstance();
            getHours = calendar.get(Calendar.HOUR);
            getMinutes = calendar.get(Calendar.MINUTE);
            getSeconds = calendar.get(Calendar.SECOND);
            //getMinutes = 0;
            //getSeconds = 0;
            ClockTower tower = new ClockTower();

            if(getMinutes == 0){
                if(getSeconds == 0){
                    System.out.println(getHours + ":" + getMinutes + ":" + getSeconds);
                    tower.playHour();
                    isplayed = true;
                }
            }else if(getMinutes == 15){
                if(getSeconds == 0){
                    System.out.println(getHours + ":" + getMinutes + ":" + getSeconds);
                    tower.playQuarter();
                }
            }else if(getMinutes == 30){
                if(getSeconds == 0){
                    System.out.println(getHours + ":" + getMinutes + ":" + getSeconds);
                    tower.playHalf();
                }
            }else if(getMinutes == 45){
                if(getSeconds == 0){
                    System.out.println(getHours + ":" + getMinutes + ":" + getSeconds);
                    tower.playThirdQuarterHour();
                }
            }
            if(isplayed){
                if (getSeconds == 20){
                    tower.playChime();
                    isplayed = false;
                }
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
