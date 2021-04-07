package C19336081;

import ie.tudublin.*;

public class SineadsVisual extends Visual {
    // Make files with shapes and add them below;
    Test test;
    SquareRight sqr;
    SqaureLeft sql;
    // WaveForm wf;
    // AudioBandsVisual abv;

    int visual = 0;
    float[] lerpedBuffer;
    float lerpedAverage = 0;

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
        sqr = new SquareRight(this);
        sql = new SqaureLeft(this);
        colorMode(HSB);
        lerpedBuffer = new float[width];
        // wf = new WaveForm(this);
        // abv = new AudioBandsVisual(this);
    }

    public void keyPressed()
    {
        if (keyCode == ' ')
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

        if (keyCode >= '0' && keyCode <= '5') {
            visual = keyCode - '0';
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
        
        float average = 0;
        float sum = 0;

        // Calculate the average of the buffer
        for (int i = 0; i < getAudioBuffer().size(); i ++)
        {
            sum += abs(getAudioBuffer().get(i));
        }
        average = sum / getAudioBuffer().size();
        // Move lerpedAverage 10% closer to average every frame
        lerpedAverage = lerp(lerpedAverage, average, 0.1f);

        switch (visual)
        {
            case 0:
            {
                sqr.render();
                sql.render();
                break;
            }
            case 1:
            {
                test.render();
                break;
            }
        }
        // wf.render();
        // abv.render();
    }
}
