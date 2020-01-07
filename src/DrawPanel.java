/**
 *
 * @author lkh5155 Liuxuan Huang
 */
import java.awt.BasicStroke;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JColorChooser;

public class DrawPanel extends JPanel
{
    private final MyShape shapes[];
    private int shapeCount;
    private int shapeType;
    private MyShape currentShape;
    private Paint currentPaint;
    private boolean filledShape;     
    private final JLabel statusLabel; 
    private Color colorA,colorB,tempA,tempB;
    DrawFrame frame = null;
    
    private int width;
    private final float dashes[];
    private Stroke currentStroke;
    private int X,Y;
    
    public void setShapeType(int shapeType)
    {
        this.shapeType = shapeType;
    }
    public void setFilled( boolean filledShape )
    {
        this.filledShape = filledShape;
    } 
    public void setStrokeDash()
    {
        currentStroke = new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,10, dashes, 0);
    }
    public void setStrokeSolid()
    {
        currentStroke = new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
    }
    public void setLineWidth(int width)
    {
        this.width = width;
    }
    public void setDashLength(int dashes)
    {
        this.dashes[0] = dashes;
    }
    public void clearLastShape()
    {
        if (shapeCount > 0)
            shapeCount--;
        repaint();
    }
    public void clearDrawing()
    {
        shapeCount = 0;
        repaint();
    }
    public void chooseColor1()
    {
	colorA = JColorChooser.showDialog(frame, "Please Choose a Color", colorA);
    }
    public void chooseColor2()
    {
	colorB = JColorChooser.showDialog(frame, "Please Choose a Color", colorB);
    }
    public void setPaintGradient()
    {
        currentPaint = new GradientPaint(0, 0, colorA, 50, 50, colorB, true);
    }
    public void setPaintA()
    {
        currentPaint = colorA;
    }
    
    private class MouseHandler extends MouseAdapter implements MouseMotionListener
    {
        @Override
        public void mousePressed(MouseEvent e)
        {
            if (shapeType == 1)
                currentShape = new MyLine();
            else if (shapeType == 2)
                currentShape = new MyOval();
            else if (shapeType == 3)
                currentShape = new MyRectangle();

            currentShape.setX1(e.getX());
            currentShape.setY1(e.getY());            
        }
        @Override
        public void mouseReleased(MouseEvent e)
        {
            currentShape.setX2(e.getX());
            currentShape.setY2(e.getY());

            shapes[shapeCount] = currentShape;
            shapeCount++;
            
            currentShape = null;
            repaint();        
        }
        @Override
        public void mouseMoved(MouseEvent e) 
        {
            statusLabel.setText(String.format("(%d,%d)",e.getX(),e.getY()));
        }
        @Override
        public void mouseDragged(MouseEvent e) 
        {
            currentShape.setX2(e.getX());
            currentShape.setY2(e.getY());
            currentShape.setPaint(currentPaint);
            currentShape.setStroke(currentStroke);
            currentShape.setFilled(filledShape);
            repaint();     
            statusLabel.setText(String.format("(%d,%d)",e.getX(),e.getY()));
        }
    }
        public DrawPanel(JLabel label)
    {
        this.statusLabel = label;
        shapes = new MyShape[100];
        shapeCount = 0;
        shapeType = 0;
        currentPaint = Color.BLACK;
        currentShape = null;
        setBackground(Color.WHITE);
        MouseHandler handler = new MouseHandler();
        addMouseListener(handler); 
        addMouseMotionListener(handler); 
        

        filledShape = false;
        width = 1;
        dashes = new float[1];
        dashes[0] = 5;
        currentStroke = new BasicStroke(BasicStroke.CAP_ROUND);
        colorA = Color.BLACK;
        colorB = Color.BLACK;
        
        setStrokeSolid();
        setPaintA();
        setFilled(false);
    }

    @Override
    public void paintComponent(Graphics g )
    {
        super.paintComponent( g );
        Graphics2D g2d = (Graphics2D) g;     

        for ( int i = 0 ; i<shapeCount ; i++ )
            shapes[i].draw(g2d);
        if (currentShape != null) 
            currentShape.draw(g2d );
    } 
    
}