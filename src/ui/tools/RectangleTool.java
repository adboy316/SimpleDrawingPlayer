package ui.tools;

import model.Oval;
import model.Rectangle;
import model.Shape;
import ui.DrawingEditor;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class RectangleTool extends ShapeTool {


    public RectangleTool(DrawingEditor editor, JComponent parent) {

        super(editor, parent);
    }

    //EFFECTS: Returns the string for the label.
    @Override
    public String getLabel() {
        return "Rectangle";
    }

    //EFFECTS: Constructs and returns the new shape
    public void makeShape(MouseEvent e) {
        shape = new Rectangle(e.getPoint(), editor.getMidiSynth());
    }


}

