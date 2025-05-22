import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Magic8BallFrame - Main JFrame class for the Magic 8 Ball application
 */
public class Magic8BallFrame extends JFrame {
    private JTextField questionField;
    private JLabel answerLabel;
    private JButton askButton;
    private Magic8BallPanel ballPanel;
    private Magic8BallAnswers answers;
    
    public Magic8BallFrame() {
        // Set up the main frame
        super("Magic 8 Ball");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLayout(new BorderLayout());
        
        // Initialize the answers logic
        answers = new Magic8BallAnswers();
        
        // Create components
        initializeComponents();
        
        // Add action listener to the ask button
        askButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String question = questionField.getText().trim();
                if (question.isEmpty()) {
                    answerLabel.setText("Please enter a question first!");
                    return;
                }
                
                // Get random answer and display it
                String answer = answers.getRandomAnswer();
                answerLabel.setText(answer);
                
                // Shake animation could be implemented here
                
                // Clear the question field for next question
                questionField.setText("");
            }
        });
        
        // Make the frame visible
        setLocationRelativeTo(null); // Center on screen
    }
    
    private void initializeComponents() {
        // Top panel with title
        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Magic 8 Ball", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        topPanel.add(titleLabel, BorderLayout.NORTH);
        
        // Question panel
        JPanel questionPanel = new JPanel(new BorderLayout(10, 10));
        questionPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        JLabel questionLabel = new JLabel("Enter your question:", JLabel.CENTER);
        questionField = new JTextField(20);
        askButton = new JButton("Ask");
        
        questionPanel.add(questionLabel, BorderLayout.NORTH);
        questionPanel.add(questionField, BorderLayout.CENTER);
        questionPanel.add(askButton, BorderLayout.SOUTH);
        
        topPanel.add(questionPanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);
        
        // Create the 8 ball panel
        ballPanel = new Magic8BallPanel();
        add(ballPanel, BorderLayout.CENTER);
        
        // Answer panel
        JPanel answerPanel = new JPanel(new BorderLayout());
        answerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        
        answerLabel = new JLabel("Ask a question to see your fortune...", JLabel.CENTER);
        answerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        answerPanel.add(answerLabel, BorderLayout.CENTER);
        add(answerPanel, BorderLayout.SOUTH);
    }
}