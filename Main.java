package Quest;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        Question goAway = new Question("Да будет так", null);
        AnswerFollowing goAwayFollow = new AnswerFollowing("нет", goAway);
        Question comeOn = new Question("Тогда, следуй за мной", null);
        AnswerFollowing comeOnFollow = new AnswerFollowing("да", comeOn);
        Question areYouSure = new Question("Как жаль, ты уверен в своем решении? \"да\" или \"нет\"", comeOnFollow, goAwayFollow);
        AnswerFollowing areYouSureFollow = new AnswerFollowing("нет", areYouSure);
        Question preparedness = new Question("Здраствуй путник, плевать как тебя зовут,ты готов к приключениям?" +
                " \"да\" или \"нет\"", comeOnFollow, areYouSureFollow);

        while(preparedness != null) {
            preparedness = preparedness.ask();
        }
    }
}
