/**
 *
 * @author lkh5155 Liuxuan Huang
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
public class DrawFrame extends JFrame implements ActionListener
{
    private final JButton undo,clear,color1,color2; 
    private final JLabel Text1,Text2,Text3;
    private JLabel statusLabel;
    private final JComboBox shapeChooser;
    private final JCheckBox filled,dashed,useGradient;
    private final JTextField lineWidth,dashLength;
    private final String shapeList[] = {"","Line","Oval","Rectangle"}; 
    DrawPanel panel = new DrawPanel(statusLabel);

    public DrawFrame() 
    {        
        super( "Java 2D drawings" ); 
        setLayout( new BorderLayout() ); 
        
        JPanel UpperPanel = new JPanel();
        JPanel northPanel = new JPanel();
        JPanel lowerPanel = new JPanel();

        UpperPanel.setLayout(new BorderLayout());
        northPanel.setLayout( new FlowLayout() );
        lowerPanel.setLayout( new FlowLayout());
        statusLabel = new JLabel();
        panel = new DrawPanel(statusLabel);

        UpperPanel.add( northPanel, BorderLayout.NORTH );
        UpperPanel.add( lowerPanel, BorderLayout.SOUTH );
        add(UpperPanel,BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER );   
        add(statusLabel,BorderLayout.SOUTH);

        undo = new JButton( "Undo" );
        clear = new JButton( "Clear" );
        Text1 = new JLabel("Shape:");
        shapeChooser = new JComboBox( shapeList );
        filled = new JCheckBox( "Filled" );    
            
        northPanel.add( undo);
        northPanel.add( clear);
        northPanel.add( Text1 );
        northPanel.add( shapeChooser );
        northPanel.add( filled );

        useGradient = new JCheckBox("Use Gradient");
        color1 = new JButton("1st Color");
        color2 = new JButton("2nd Color");
        dashed = new JCheckBox("Dashed");
        lineWidth = new JTextField(2);
        lineWidth.setEditable(true);
        Text2 = new JLabel("Line Width:");
        dashLength = new JTextField(2);
        dashLength.setEditable(true);
        Text3 = new JLabel("Dash Length:");
            
        lowerPanel.add(useGradient);
        lowerPanel.add(color1);
        lowerPanel.add(color2);
        lowerPanel.add( Text2);
        lowerPanel.add(lineWidth);
        lowerPanel.add( Text3);
        lowerPanel.add(dashLength);
        lowerPanel.add( dashed);
        
        undo.addActionListener( this );
        clear.addActionListener( this );
        color1.addActionListener( this);
        color2.addActionListener( this);
        
        TextFieldHandler THandler = new TextFieldHandler();
        lineWidth.addActionListener(THandler);
        dashLength.addActionListener(THandler);
        
        CheckBoxHandler CHandler = new CheckBoxHandler();
        dashed.addItemListener( CHandler );
        useGradient.addItemListener( CHandler );        
        filled.addItemListener( CHandler );
        
        ComboBoxHandler ShapeChooser = new ComboBoxHandler();
        shapeChooser.addItemListener( ShapeChooser );
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()== undo)
            panel.clearLastShape();
        else if (e.getSource() == clear)
            panel.clearDrawing();
        else if (e.getSource() == color1)
            panel.chooseColor1();
        else if (e.getSource() == color2)
            panel.chooseColor2();
    }

    public class ComboBoxHandler implements ItemListener 
    {
        @Override
        public void itemStateChanged( ItemEvent e) 
        {
            if ( e.getStateChange() == ItemEvent.SELECTED ) 
            {
                switch (shapeChooser.getSelectedIndex()) {
                    case 1:
                        panel.setShapeType(1);
                        break;
                    case 2:
                        panel.setShapeType(2);
                        break;
                    case 3:
                        panel.setShapeType(3);
                        break;
                    default:
                        break;
                }
            }
        }
    }
    public class CheckBoxHandler implements ItemListener 
    {
        @Override
        public void itemStateChanged( ItemEvent e ) 
        {
            if(e.getSource() == dashed)
            {    
                if(e.getStateChange() == ItemEvent.SELECTED)
                    panel.setStrokeDash();
                else
                    panel.setStrokeSolid();
            }
            else if(e.getSource() == useGradient)
            {
                if(e.getStateChange() == ItemEvent.SELECTED)
                    panel.setPaintGradient();
                else
                    panel.setPaintA();
            }
            else if(e.getSource() == filled)
            {
                if(e.getStateChange() == ItemEvent.SELECTED)
                    panel.setFilled(true);
                else
                    panel.setFilled(false);
            }   
        }
    }
    public class TextFieldHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if (e.getSource()== lineWidth)
                panel.setLineWidth(Integer.parseInt(lineWidth.getText()));
            else if (e.getSource()== dashLength)
                panel.setDashLength(Integer.parseInt(dashLength.getText()));

        }
    }
}