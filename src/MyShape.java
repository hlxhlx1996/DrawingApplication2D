/**
 *
 * @author  * @author lkh5155 Liuxuan Huang
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
        
public abstract class MyShape 
{
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Paint paint;
    private Stroke stroke;
        private boolean FilledShape;
    
    public MyShape()
    {
        this.x1 = 0;
        this.y2 = 0;
        this.x2 = 0;
        this.y2 = 0;
        this.paint = Color.BLACK;
        this.stroke = new BasicStroke(BasicStroke.CAP_ROUND); 
    }
    public MyShape(int x1,int x2,int y1,int y2,Paint paint,Stroke stroke)
    {
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        this.paint = paint;
        this.stroke = stroke;
    }
    public int getX1()//get the value of the x
    {
        return x1;
    }
    public void setX1(int x1)//set value for x
    {
        this.x1 = x1;
    }        
    public int getY1()
    {
        return y1;
    }
    public void setY1(int y1)
    {
        this.y1 = y1;
    }    
    public int getX2()//get the value of the x
    {
        return x2;
    }
    public void setX2(int x2)//set value for x
    {
        this.x2 = x2;
    }        
    public int getY2()
    {
        return y2;
    }
    public void setY2(int y2)
    {
        this.y2 = y2;
    }    
    public Paint getPaint()
    {
        return paint;
    }
    public void setPaint(Paint p)
    {
        this.paint = p;
    }
    public Stroke getStroke()
    {
        return stroke;
    }
    public void setStroke(Stroke stroke)
    {
        this.stroke = stroke;
    }
    public void setFilled( boolean IsFilled )
    {
        this.FilledShape = IsFilled;
    } 
    public boolean FilledShape()
    {
        return FilledShape;
    }
    public abstract void draw(Graphics2D g);
}
