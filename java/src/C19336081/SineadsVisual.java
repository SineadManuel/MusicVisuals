package C19336081;

import ie.tudublin.*;

public class SineadsVisual extends Visual {
    // Make files with shapes and add them below;
    Test test;
    // WaveForm wf;
    // AudioBandsVisual abv;


    public void settings()
    {
        size(800, 630, P3D);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("Wait_a_Minute!.mp3");
        
        test = new Test(this);
        colorMode(HSB);
        // wf = new WaveForm(this);
        // abv = new AudioBandsVisual(this);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            // Rewinds music
            // getAudioPlayer().cue(0);

            if (getAudioPlayer().isPlaying()) {
                getAudioPlayer().pause();
            }
            else {
                getAudioPlayer().play();
            }
        }
    }

    public void draw()
    {
        background(0);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();   

        test.render();
        // wf.render();
        // abv.render();
    }
}
