package C19336081;

import processing.core.*;

public class Dots {
    SineadsVisual sv;
    float rot = 0;

    public Dots(SineadsVisual sv) {
        this.sv = sv;
    }
    
    public void render() {
        sv.camera(0, 0, 200, 0, 0, 0, 1, 0, 0);
        sv.translate(0, 0, -100);

        sv.rotate(PApplet.radians(rot));
        for(float i = 0; i < PApplet.TWO_PI; i += 0.1f) {

            float colour = PApplet.map(i, 0, PApplet.TWO_PI, 0, 255);
            
            sv.stroke(colour, 255, 255);
            
            float r = 50 * PApplet.cos(4 * i);
            float x = r * PApplet.cos(i);
            float y = r * PApplet.sin(i);
            sv.point(20 *(x * sv.lerpedAverage), 20 * (y * sv.lerpedAverage));
            rot += 1;
        }
    }
}
