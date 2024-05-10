package sensor_priority.Com.multi.nw;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
public class PlottingFloats {
static class Plotter extends JPanel {
float PAD = 25;
java.util.List dataList = new ArrayList();
public Plotter() {
setBackground(Color.white);
setPreferredSize(new Dimension(400,300));
}
public void paintComponent(Graphics g) {
super.paintComponent(g);
Graphics2D g2 = (Graphics2D)g;
float width = getWidth();
float height = getHeight();
float xStep = (width - 2*PAD)/(dataList.size() - 1);
float x = PAD;
float y;
// scale data
float max = ((Float)Collections.max(dataList)).floatValue();
float min = ((Float)Collections.min(dataList)).floatValue();
float vertSpace = height - 2*PAD;
float yOffset = height - PAD;
float yDataOffset = (min >= 0 ? min : max > 0 ? 0 : max);
float scale = vertSpace/(max - min);
float yOrigin = yOffset + (min > 0 ? 0 : max > 0 ? scale*min : - vertSpace);
// draw ordinate
g2.draw(new Line2D.Float(PAD, PAD, PAD, yOffset));
// draw abcissa
g2.draw(new Line2D.Float(PAD, yOrigin, width - PAD, yOrigin));
// label ordinate limits
g2.drawString(String.valueOf(max), 10, PAD - 10);
g2.drawString(String.valueOf(min), 10, yOffset + PAD/2);
g2.setStroke(new BasicStroke(4f));
g2.setPaint(Color.red);
for(int j = 0; j < dataList.size(); j++) {
y = yOrigin - scale * (((Float)dataList.get(j)).floatValue() - yDataOffset);
g2.draw(new Line2D.Float(x, y, x, y));
x += xStep;
}
}
protected void plot(float input) {
dataList.add(new Float(input));
repaint();
}
}
public static void main(String[] args) {
float[] data = {
100f, 220f, 12.9f, 65f, 47.3f, 175f, 190f, 18f
};
Plotter plotter = new Plotter();
for(int j = 0; j < 8; j++)
plotter.plot(data[j]);
JFrame f = new JFrame("Plotting Floats");
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.getContentPane().add(plotter);
f.pack();
f.setLocationRelativeTo(null);
f.setVisible(true);
}
}