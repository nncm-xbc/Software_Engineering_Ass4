package main.decorators;

import main.decorators.shapes.*;
import svg.element.BaseElement;
import svg.element.Element;
import svg.element.shape.*;
import svg.element.shape.Polygon;
import svg.element.shape.path.Path;
import svg.element.style.Fill;
import svg.element.style.Stroke;
import svg.element.style.StrokeWidth;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//-----------------------------------------------------------------------------

/**
 * Singleton class that holds a factory method for creating new SVG style objects.
 * @author cambolbro
 */
public class DecoratorFactory
{
    // List of concrete classes to be instantiated
    private final static List<BaseElement> prototypes = new ArrayList<BaseElement>();
    {
        prototypes.add(new Circle());
        prototypes.add(new Ellipse());
        prototypes.add(new Line());
        prototypes.add(new Polygon());
        prototypes.add(new Polyline());
        prototypes.add(new Rect());
        prototypes.add(new Path());
    }

    // Singleton occurrence of this class
    private static DecoratorFactory singleton = null;

    //-------------------------------------------------------------------------

    /**
     * Private constructor: only this class can construct itself.
     */
    public DecoratorFactory()
    {
        // Nothing to do...
    }

    //-------------------------------------------------------------------------

    public static DecoratorFactory get()
    {
        if (singleton == null)
            singleton = new DecoratorFactory();  // lazy initialisation
        return singleton;
    }

    public List<BaseElement> prototypes()
    {
        return prototypes;
    }

    //-------------------------------------------------------------------------

    /**
     * @param label Symbol type to make.
     * @return New symbol of specified type, with fields unset.
     */
    public Element makeShape(final String label, final Graphics2D g2dImage, Element element)
    {
        for (BaseElement prototype : prototypes) {
            if (prototype.label().equals(label)) {
                prototype.renderShape(element, g2dImage);
                return prototype.newInstance();
            }
        }
        System.out.println("* Failed to find prototype for BaseElement " + label + ".");
        return null;
    }

    //-------------------------------------------------------------------------

}
