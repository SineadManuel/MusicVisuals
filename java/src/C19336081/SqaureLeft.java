package C19336081;

import processing.core.*;

public class SqaureLeft {
    SineadsVisual sv;

    float radius = 200;
    float smoothedBoxSize = 0;
    float rot = 0;

    public SqaureLeft(SineadsVisual sv)
    {
        this.sv = sv;
    }

    public void render()
    {
        sv.noFill();
        sv.camera(0, -500, 500, 0, 0, 0, -500, 0, 0);
        // Rotates the cubes
        rot += sv.getAmplitude() / 8.0f;
        // Rotates the cubes
        sv.rotateX(rot); // Rotates vertically

        float[] bands = sv.getSmoothedBands();
        for(int i = 0 ; i < bands.length ; i ++)
        {
            // float theta = PApplet.map(i, 0, bands.length, 0, PApplet.TWO_PI);
            // Gives colour
            sv.stroke(PApplet.map(i, 0, bands.length, 0, 255), 255, 255);
            float h = bands[i];

            sv.pushMatrix();
            // Makes cubes appear
            // sv.rotateY(theta);
            sv.box(500, h, 500);
            sv.popMatrix();
        }       
    }
}
