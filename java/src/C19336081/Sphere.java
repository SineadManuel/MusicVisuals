package C19336081;

import processing.core.*;

public class Sphere {
    SineadsVisual sv;
    float rot = 0;

    public Sphere(SineadsVisual sv) {
        this.sv = sv;
    }

    public void render() {
        sv.noFill();
        sv.camera(0, 0, 200, 0, 0, 0, 1, 0, 0);
        sv.strokeWeight(1);

        float colour = PApplet.map(sv.average, 0, 1, 0, 255);
        sv.stroke(colour, 255, 255);

        sv.pushMatrix();
        sv.noFill();
        sv.rotateX(PApplet.radians(rot));
        sv.rotateY(PApplet.radians(rot));
        sv.rotateZ(PApplet.radians(rot));
        sv.sphere(600 * sv.lerpedAverage);
        sv.popMatrix();
        rot += 1;
    }
}
