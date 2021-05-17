package Quest;

public class AnswerFollowing {

    private String answer;
    public Question question;

    public AnswerFollowing(String answer, Question question) {
        this.answer = answer;
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public Question getQuestion() {
        return question;
    }
}
