/**
 *
 * @author  * @author lkh5155 Liuxuan Huang
 */
//For the useGradient and dashed checkboxes, you have to check them after you made any color or stroke choices for the first time.
//You have to first check them then uncheck them to make solidStroke and plain color of your choice.
//Everytime you need to make changes to the paint and stroke, you need to do the check and uncheck.
import javax.swing.JFrame;
public class TestDraw
{
    public static void main( String args[] )
    {
        DrawFrame frame = new DrawFrame();     
        frame.setVisible(true);

        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    }
} 
    

