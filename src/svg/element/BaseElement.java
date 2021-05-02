package svg.element;

import main.decorators.Decorator;
import main.decorators.shapes.DecoratorGraphics2DRect;
import svg.element.shape.Rect;

import java.awt.*;
import java.awt.geom.Rectangle2D;

//-----------------------------------------------------------------------------

/**
 * Base SVG element type.
 * @author cambolbro
 */
public abstract class BaseElement implements Element
{
	private final String label;
	private int filePos;  // start position in SVG file

	protected Rectangle2D.Double bounds = new Rectangle2D.Double();

	//-------------------------------------------------------------------------
	
	public BaseElement(final String label)
	{
		this.label = new String(label);
	}
	
	//-------------------------------------------------------------------------

	@Override
	public String label()
	{
		return label;
	}
	
	@Override
	public int compare(final Element other)
	{
		return filePos - ((BaseElement)other).filePos;
	}

	//-------------------------------------------------------------------------

	public int filePos()
	{
		return filePos;
	}

	public void setFilePos(final int pos)
	{
		filePos = pos;
	}
	
	//-------------------------------------------------------------------------

	public Rectangle2D.Double bounds()
	{
		return bounds;
	}

	/**
	 * Set bounds for this shape.
	 */
	public abstract void setBounds();

	//-------------------------------------------------------------------------

	/**
	 * @return Stroke width of element (else 0 is none specified). 
	 */
	public double strokeWidth()
	{
		return 0;  // default implementation
	}
	
	//-------------------------------------------------------------------------

	public void renderShape(Element element, final Graphics2D g2dImage)
	{
		//...
	}

	//-------------------------------------------------------------------------

}
