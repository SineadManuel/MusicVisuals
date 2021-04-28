package C19336081;

import processing.core.*;

public class MoreCircles {
    SineadsVisual sv;
    float rot = 0;

    public MoreCircles(SineadsVisual sv) {
        this.sv = sv;
    }
    
    public void render() {
        sv.noFill();
        sv.camera(0, 0, 200, 0, 0, 0, 1, 0, 0);
        sv.translate(0, 0, -200);
        sv.strokeWeight(4);

        sv.ellipseMode(PApplet.CENTER);
        sv.rotate(PApplet.radians(rot));
        
        float[] bands = sv.getSmoothedBands();
        for(int i = 0 ; i < bands.length ; i ++)
        {
            float colour = PApplet.map(i, 0, bands.length, 0, 255);
            sv.stroke(colour, 255, 255);
            float size = bands[i];

            sv.ellipseMode(PApplet.CENTER);
            sv.circle(0 + 36, 0 + 36, size);
            sv.circle(0 - 36, 0 - 36, size);
            sv.circle(0 + 36, 0 - 36, size);
            sv.circle(0 - 36, 0 + 36, size);
            sv.circle(0 + 50, 0, size);
            sv.circle(0 - 50, 0, size);
            sv.circle(0, 0 + 50, size);
            sv.circle(0, 0 - 50, size);
        }
        rot += 1;
    }
}
