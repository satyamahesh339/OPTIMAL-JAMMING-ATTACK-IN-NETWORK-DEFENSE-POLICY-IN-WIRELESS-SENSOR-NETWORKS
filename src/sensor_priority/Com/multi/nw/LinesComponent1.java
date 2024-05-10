package sensor_priority.Com.multi.nw;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class LinesComponent1 extends JComponent{
public static class Line{
    final int x1; 
    final int y1;
    final int x2;
    final int y2;   
    final Color color;

    public Line(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }               
}

public  LinkedList<Line> lines = new LinkedList<Line>();

public void addLine(int x1, int x2, int x3, int x4) {
    JOptionPane.showMessageDialog(null,"Adding Lines..........");
    addLine(x1, x2, x3, x4, Color.black);
    JOptionPane.showMessageDialog(null,"Added Lines..........");
}

public void addLine(int x1, int x2, int x3, int x4, Color color) {
    
     JOptionPane.showMessageDialog(null,"Lines..........");
    lines.add(new Line(x1,x2,x3,x4, color));        
    JOptionPane.showMessageDialog(null,"OutSide Lines..........");
    repaint();
    
    //g.drawLine(x1, y1, line.x2, line.y2);
    JOptionPane.showMessageDialog(null,"Inside Lines..........");
}

public void clearLines() {
    lines.clear();
    repaint();
}

@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
   for (Line line : lines) {
       g.setColor(Color.BLUE);
        JOptionPane.showMessageDialog(null,"HELO");
        g.drawLine(line.x1, line.y1, line.x2, line.y2);
   //     g.drawLine(250,500,500, 250);
        
    }
}

public static void main(String[] args) {
    JFrame testFrame = new JFrame();
    testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    LinesComponent1 comp = new LinesComponent1();
    comp.setPreferredSize(new Dimension(320, 200));
    testFrame.getContentPane().add(comp, BorderLayout.CENTER);
    JPanel buttonsPanel = new JPanel();
    JButton newLineButton = new JButton("New Line");
    JButton clearButton = new JButton("Clear");
    buttonsPanel.add(newLineButton);
    buttonsPanel.add(clearButton);
    testFrame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
    newLineButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            int x1 = (int) (Math.random()*320);
            int x2 = (int) (Math.random()*320);
            int y1 = (int) (Math.random()*200);
            int y2 = (int) (Math.random()*200);
            Color randomColor = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
           // comp.addLine(x1, y1, x2, y2, randomColor);
        }
    });
    clearButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
         //   comp.clearLines();
        }
    });
    testFrame.pack();
    testFrame.setVisible(true);
    
}

}