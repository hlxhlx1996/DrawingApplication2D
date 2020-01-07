import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

/**
 *
 * @author lkh5155 Liuxuan Huang
 */
public class MyOval extends MyBoundedShape
{
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Paint paint;
    private boolean FilledShape;
    private Stroke stroke;
    public MyOval()
    {
        this( 0, 0, 0, 0, Color.BLACK,new BasicStroke(BasicStroke.CAP_ROUND), false );
    }
    public MyOval( int x1, int y1, int x2, int y2, Paint paint,Stroke stroke, boolean FilledShape)
    {
        super(x1,y1,x2,y2,paint,stroke,false);
        setPaint(getPaint());
        setFilled( FilledShape() );
        setStroke(getStroke());
    }

    @Override
    public void draw(Graphics2D g) 
    {
        g.setPaint(getPaint());
        g.setStroke(getStroke());
        setFilled( FilledShape() );
        if (FilledShape())
            g.fillOval(upperLeftX(),upperLeftY(),getWidth(),getHeight() );
        else
            g.drawOval(upperLeftX(),upperLeftY(),getWidth(),getHeight() );
    }
}
