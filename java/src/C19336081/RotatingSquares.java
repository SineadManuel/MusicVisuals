package C19336081;

import processing.core.*;

public class RotatingSquares {
    SineadsVisual sv;
    float rot = 0;

    public RotatingSquares(SineadsVisual sv)
    {
        this.sv = sv;
    }

    public void render()
    {
        sv.noFill(); 
        rot += sv.getAmplitude() / 10f;
        sv.rotateX(rot);
        sv.strokeWeight(4);

        float[] bands = sv.getSmoothedBands();
        for(int i = 0 ; i < bands.length ; i ++)
        {
            float colour = PApplet.map(i, 0, bands.length, 0, 255);
            sv.stroke(colour, 255, 255);
            float h = bands[i]; 

            sv.pushMatrix();
            sv.box(500, h, 500);
            sv.popMatrix();
        }       
    }
}
