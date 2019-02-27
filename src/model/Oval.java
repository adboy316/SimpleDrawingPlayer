package model;


import sound.MidiSynth;

import java.awt.*;


public class Oval extends Shape {

    public Oval(Point topLeft, MidiSynth midiSynth) {
        this((int) topLeft.getX(), (int) topLeft.getY(), 0, 0); //note to students: calls the other constructor!
        selected = false;
        this.midiSynth = midiSynth;
        instrument = 3;
        playLineCoord = 0;
        PLAYING_COLOR = new Color(230, 40, 223);
    }

    public Oval(int x, int y, int w, int h) {
        super(x, y, w, h);
    }


    @Override
    //EFFECTS: draws the shape
    public void drawGraphics(Graphics g) {
        g.drawOval(x, y, width, height);
    }

    @Override
    //EFFECTS: fills the shape
    public void fillGraphics(Graphics g) {
        g.fillOval(x, y, width, height);
    }

    @Override
    public boolean contains(Point p) {
        final double TOL = 1.0e-6;
        double halfWidth = width / 2.0;
        double halfHeight = height / 2.0;
        double diff = 0.0;

        if (halfWidth > 0.0) {
            diff = diff + sqrDiff(x + halfWidth, p.x) / (halfWidth * halfWidth);
        } else {
            diff = diff + sqrDiff(x + halfWidth, p.x);
        }
        if (halfHeight > 0.0) {
            diff = diff + sqrDiff(y + halfHeight, p.y) / (halfHeight * halfHeight);
        } else {
            diff = diff + sqrDiff(y + halfHeight, p.y);
        }
        return  diff <= 1.0 + TOL;
    }

    // Compute square of difference
// EFFECTS: returns the square of the difference of num1 and num2
    private double sqrDiff(double num1, double num2) {
        return (num1 - num2) * (num1 - num2);
    }

}
