package C19336081;

import processing.core.*;

// Test Visual
public class ExpandingCircles {
    SineadsVisual sv;

    public ExpandingCircles(SineadsVisual sv)
    {
        this.sv = sv;
    }

    public void render()
    {        
        // Keeps shape 2D
        sv.camera(0, 0, 200, 0, 0, 0, 1, 0, 0);
        sv.strokeWeight(4);
        // Centres 2D shape
        sv.translate(-sv.height/2, -sv.width/2, 0);

        float[] bands = sv.getSmoothedBands();
        for(int i = 0; i < bands.length; i++) {
            float colour = PApplet.map(i, 0, bands.length, 0, 255);
            sv.stroke(colour, 255, 255);
            float size = bands[i];
            sv.circle(sv.height/2, sv.width/2, size);
        }
    }
}
