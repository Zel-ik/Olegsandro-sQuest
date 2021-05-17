package Quest;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Question{

    ScheduledExecutorService timer = new ScheduledThreadPoolExecutor(1);

    String answer = null;
    private String questionText;
    AnswerFollowing[] answerFollowing;


    public Question(String questionText, AnswerFollowing... answerFollowing) {
        this.questionText = questionText;
        this.answerFollowing = answerFollowing;
    }




    public Question ask() throws InterruptedException {
        System.out.println(questionText);

        ConsoleInput con = new ConsoleInput(3, 5,10, TimeUnit.SECONDS);
        answer = con.readLine();

        if(answerFollowing != null) {
            for (int count = 0; answerFollowing.length > count; count++) {
                if (answer.equals(answerFollowing[count].getAnswer())) {
                    return answerFollowing[count].getQuestion();
                }
            }
        }
        return null;
    }
}
