import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

/**
 *
 * @author lkh5155 Liuxuan Huang
 */
public class MyLine extends MyShape
{
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Paint paint;
    private Stroke stroke;
    
    public MyLine()
    {
        this(0, 0, 0, 0, Color.BLACK, new BasicStroke(BasicStroke.CAP_ROUND));
    }
    public MyLine( int x1, int y1, int x2, int y2, Paint paint,Stroke stroke )
    {
        super(x1,y1,x2,y2,paint,stroke);
        setPaint( getPaint() );        
        setStroke(getStroke());
    }

    @Override
    public void draw(Graphics2D g) 
    {        
        g.setPaint(getPaint());
        g.setStroke(getStroke());
        g.drawLine(getX1(),getY1(), getX2(), getY2());
    }
}
