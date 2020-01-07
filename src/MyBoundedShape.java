
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

/**
 *
 * @author lkh5155 Liuxuan Huang
 */
public abstract class MyBoundedShape extends MyShape
{
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Paint paint;
    private Stroke stroke;
    private boolean FilledShape;
    
    public MyBoundedShape()
    {
        this(0,0,0,0,Color.BLACK,new BasicStroke(BasicStroke.CAP_ROUND), false);
    }
    public MyBoundedShape(int x1, int y1, int x2, int y2, Paint paint, Stroke stroke, boolean FilledShape)
    {
        super(x1,y1,x2,y2,paint,stroke);
        setPaint(getPaint());
        setFilled( FilledShape() );
        setStroke(getStroke());
    }
    
    public int upperLeftX()
    {
        return Math.min( getX1(), getX2() );
    }
    public int upperLeftY()
    {
        return Math.min( getY1(), getY2() );
    }
    public int getWidth()
    {
        return Math.abs(getX1() - getX2());
    }
    public int getHeight()
    {
        return Math.abs(getY1() - getY2());
    }
    @Override
    public abstract void draw(Graphics2D g);
}
