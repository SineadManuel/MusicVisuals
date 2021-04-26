package C19336081;

import processing.core.*;

public class ExpandingCircles {
    SineadsVisual sv;
    float rot = 0;

    public ExpandingCircles(SineadsVisual sv)
    {
        this.sv = sv;
    }

    public void render() {
        sv.noFill();
        sv.camera(0, 0, 200, 0, 0, 0, 1, 0, 0);
        sv.translate(0, 0, 0);
        sv.strokeWeight(4);

        float[] bands = sv.getSmoothedBands();
        for(int i = 0; i < bands.length; i++) {
            float colour = PApplet.map(i, 0, bands.length, 0, 255);
            sv.stroke(colour, 255, 255);
            float size = bands[i];
            sv.circle(0, 0, size);
        }
    }
}
