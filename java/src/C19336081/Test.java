package C19336081;

import processing.core.*;

// Test Visual
public class Test {
    SineadsVisual sv;

    float rot = 0;

    public Test(SineadsVisual sv)
    {
        this.sv = sv;

    }

    public void render()
    {
        // sv.rectMode(PApplet.CENTER);
        // // sv.fill(51);
        // // sv.stroke(255);

        // // sv.translate(100, 100, 0);
        // // sv.rotateZ(PApplet.PI/8);
        // sv.rect(sv.width/2, sv.height/2, 100, 100);

        // sv.noFill();
        // // for (int i = 0; i < sv.getAudioBuffer().size(); i++) {
        // //     float c = PApplet.map(i, sv.height/2, sv.getAudioBuffer().size(), 0, 255);
        // //     sv.stroke(c, 255, 255);
        // //     sv.lerpedBuffer[i] = PApplet.lerp(sv.lerpedBuffer[i], sv.getAudioBuffer().get(i), 0.1f);
        // // }
        
        // // sv.rectMode(PApplet.CENTER);
        // // sv.rect(sv.width / 2, sv.height/2, 50 + (sv.lerpedAverage * 500), 50 + (sv.lerpedAverage * 500));
        // sv.strokeWeight(2);
        // sv.stroke(PApplet.map(sv.lerpedAverage, 0, 1, 0, 255), 255, 255);
        // sv.rectMode(PApplet.CENTER);
        // sv.rect(sv.width / 2, sv.height/2, sv.lerpedAverage * sv.width * 2, sv.lerpedAverage * sv.width * 2);

        sv.lights();
        rot += sv.getAmplitude() / 8.0f;

        sv.pushMatrix();
        sv.translate(130, sv.height/2, 0);
        sv.rotateY(rot);
        sv.rotateX(rot);
        sv.noStroke();
        sv.box(100);
        sv.popMatrix();

        // sv.pushMatrix();
        sv.translate(500, sv.height, -200);
        sv.noFill();
        float[] bands = sv.getSmoothedBands();
        sv.rotateY(rot);
        sv.rotateX(rot);
        sv.rotateZ(rot); 
        // sv.stroke(255);
        for(int i = 0 ; i < bands.length ; i ++)
        {
            // float theta = PApplet.map(i, 0, bands.length, 0, PApplet.TWO_PI);
            // Gives colour
            sv.stroke(PApplet.map(i, 0, bands.length, 0, 255), 255, 255);
            sv.pushMatrix();
            sv.sphere(280);
            sv.popMatrix();
        }
        // sv.sphere(280);
        // sv.popMatrix();
    }
}
