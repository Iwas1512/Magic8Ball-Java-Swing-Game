import java.awt.*;
import javax.swing.*;

/**
 * Magic8BallPanel - Panel that draws the 8 ball graphical representation
 */
public class Magic8BallPanel extends JPanel {
    
    public Magic8BallPanel() {
        setPreferredSize(new Dimension(300, 300));
        setBackground(new Color(240, 240, 240)); // Light gray background
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Use Graphics2D for better rendering
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                             RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Calculate dimensions for the ball
        int diameter = Math.min(getWidth(), getHeight()) - 20;
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;
        
        // Draw outer black circle (the 8 ball)
        g2d.setColor(Color.BLACK);
        g2d.fillOval(x, y, diameter, diameter);
        
        // Add a light reflection effect
        g2d.setColor(new Color(255, 255, 255, 60)); // Semi-transparent white
        int reflectionSize = diameter / 3;
        g2d.fillOval(x + diameter/5, y + diameter/5, reflectionSize, reflectionSize);
        
        // Draw blue circle in the center (the "window")
        int blueDiameter = diameter / 3;
        int blueX = x + (diameter - blueDiameter) / 2;
        int blueY = y + (diameter - blueDiameter) / 2;
        g2d.setColor(new Color(0, 0, 139)); // Dark blue
        g2d.fillOval(blueX, blueY, blueDiameter, blueDiameter);
        
        // Draw white "8" in the middle
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, blueDiameter / 2));
        FontMetrics fm = g2d.getFontMetrics();
        String text = "8";
        int textX = blueX + (blueDiameter - fm.stringWidth(text)) / 2;
        int textY = blueY + (blueDiameter + fm.getAscent() - fm.getDescent()) / 2;
        g2d.drawString(text, textX, textY);
    }
}