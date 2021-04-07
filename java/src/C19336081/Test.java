package C19336081;

import processing.core.*;

// Test Visual
public class Test {
    SineadsVisual sv;
    // waveform
    float cy = 0;

    public Test(SineadsVisual sv)
    {
        this.sv = sv;
        // waveform
        cy = this.sv.height / 2;
    }

    public void render()
    {
        // bar chart
        float gap = sv.width / (float) sv.getBands().length;
        sv.noStroke();
        for(int i = 0 ; i < sv.getBands().length ; i ++)
        {
            float c = PApplet.map(i, 0, sv.getBands().length, 255, 0);
            sv.fill(c, 255, 255);
            sv.rect(i * gap, sv.height, gap,-sv.getSmoothedBands()[i] * 0.2f); 
        }

        // waveform
        for(int i = 0 ; i < sv.getAudioBuffer().size(); i ++)
        {
            float c = PApplet.map(i, 0, sv.getAudioBuffer().size(), 0, 255);
            sv.stroke(c, 255, 255);

            sv.line(i, cy - sv.getAudioBuffer().get(i) * cy, i, cy + sv.getAudioBuffer().get(i) * cy);
        }
    }
}
