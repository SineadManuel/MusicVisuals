package C19336081;

import processing.core.*;

// Visual that renders a sunset
public class Test {
    SineadsVisual sv;

    public Test(SineadsVisual sv)
    {
        this.sv = sv; 
    }

    float x = 300;
    float y = 300;
    float angle;
    // float halfHeight = sv.height / 2;

    public void render()
    {
        sv.translate(sv.width/2, sv.height/2);

        for(float a = 0; a < 360; a += 10) {
            sv.pushMatrix();
            sv.rotate(PApplet.radians(a));
            sv.stroke(255);
            sv.strokeWeight(3);
            sv.line(x*PApplet.sin(PApplet.radians(angle)), 0, 0, y);
            sv.popMatrix();
        }

        angle++;

        // for (int i = 0; i < sv.getAudioBuffer().size(); i++) {

        //     float c = PApplet.map(i, 0, sv.getAudioBuffer().size(), 0, 255);
        //     sv.stroke(c, 255, 255);

        //     sv.getSmoothedBands()[i] = PApplet.lerp(sv.getSmoothedBands()[i], sv.getAudioBuffer().get(i), 0.1f);        
        //     sv.line(i, halfHeight - sv.getSmoothedBands()[i] * halfHeight * 4, i, halfHeight + sv.getSmoothedBands()[i] * halfHeight * 4);
        // }    
    }
}
