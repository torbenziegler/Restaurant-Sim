package de.hdm_stuttgart.mi.se2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

/**
 * adds music to the customer menus
 */
public class Sound implements Runnable {

    private static Logger log = LogManager.getLogger(Sound.class);

    private boolean running = true;
    private String fileLocation;

    String name;


    /**
     * Sound constructor with parameter
     * @param fileLocation String of file path to play music
     */
    public Sound(String fileLocation, String name) {
        this.fileLocation = fileLocation;
        Thread thread = new Thread(this, name);
        this.name = name;
        thread.start();
    }

    /**
     * starts the music thread
     */
    public void run() {
        log.info("Music thread for " + fileLocation + " started");
        while (running) {
            playSound(fileLocation);
        }
    }

    /**
     * ends the music thread
     */
    public void terminate() {
        running = false;
    }


    /**
     * plays the music located at the specified file path
     *
     * @param fileName file path of music file
     */
    private void playSound(String fileName) {
        File soundFile = new File(fileName);
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e) {
            log.error(e);
        }
        assert audioInputStream != null;
        AudioFormat audioFormat = audioInputStream.getFormat();
        SourceDataLine line = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        try {
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(audioFormat);
        } catch (Exception e) {
            log.error(e);
        }
        assert line != null;
        line.start();
        int nBytesRead = 0;
        byte[] abData = new byte[128000];
        while (nBytesRead != -1 && running) {
            try {
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                log.error(e);
            }
            if (nBytesRead >= 0) {
                int nBytesWritten = line.write(abData, 0, nBytesRead);
            }
        }
        line.drain();
        line.close();
    }
}