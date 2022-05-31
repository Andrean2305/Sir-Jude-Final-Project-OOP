package entity;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;

public class music {
    Clip clip;
    URL soundURL[] = new URL[30];
    public FloatControl fc;
    boolean mute;
    float previous_volume = 0;
    float current_volume = 0;


    float currentvolume;
    
    public music() {
        soundURL[0] = getClass().getResource("sound/main_theme.wav");
        soundURL[1] = getClass().getResource("sound/dead.wav");
        soundURL[2] = getClass().getResource("sound/get_coin.wav");
        soundURL[3] = getClass().getResource("sound/rain.wav");
        soundURL[4] = getClass().getResource("sound/creepy.wav");
        soundURL[5] = getClass().getResource("sound/click.wav");
        soundURL[6] = getClass().getResource("sound/error.wav");
    }

    public void setFile(int i){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
        }catch(Exception e) {

        }
    }

    public void play(float volume) {
        clip.setFramePosition(0);
        clip.start();
        fc.setValue(volume);

    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }

    public void volumeUp() {
        currentvolume += 1.0f;
        if(currentvolume > 6.0f){
            currentvolume = 6.0f;
        }
        fc.setValue(currentvolume);
    }

    public void volumeDown() {
        currentvolume -= 1.0f;
        if(currentvolume < -80.0f){
            currentvolume = - 80.0f;
        }
        fc.setValue(currentvolume);
    }

    public void volumeMute() {
        if(mute == false){
            previous_volume = current_volume;
            currentvolume = -80.0f;
            fc.setValue(current_volume);
            mute = true;
        }
        else if(mute == true){
            current_volume = previous_volume;
            fc.setValue(current_volume);
            mute = false;
        }
    }

}
