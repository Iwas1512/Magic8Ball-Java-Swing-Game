import java.util.Random;

/**
 * Magic8BallAnswers - Contains the logic for the Magic 8 Ball answers
 */
public class Magic8BallAnswers {
    // Standard Magic 8 Ball answers
    private final String[] ANSWERS = {
        // Positive answers
        "It is certain",
        "It is decidedly so",
        "Without a doubt",
        "Yes definitely",
        "You may rely on it",
        "As I see it, yes",
        "Most likely",
        "Outlook good",
        "Yes",
        "Signs point to yes",
        
        // Non-committal answers
        "Reply hazy, try again",
        "Ask again later",
        "Better not tell you now",
        "Cannot predict now",
        "Concentrate and ask again",
        
        // Negative answers
        "Don't count on it",
        "My reply is no",
        "My sources say no",
        "Outlook not so good",
        "Very doubtful"
    };
    
    private Random random;
    
    public Magic8BallAnswers() {
        random = new Random();
    }
    
    /**
     * Returns a random answer from the Magic 8 Ball
     * 
     * @return a random fortune/answer
     */
    public String getRandomAnswer() {
        int index = random.nextInt(ANSWERS.length);
        return ANSWERS[index];
    }
    
    /**
     * Returns all possible answers
     * 
     * @return array of all Magic 8 Ball answers
     */
    public String[] getAllAnswers() {
        return ANSWERS.clone();
    }
}