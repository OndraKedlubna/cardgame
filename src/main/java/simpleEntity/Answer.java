package simpleEntity;

import enums.AnswerType;

/**
 * Trida pro jednoduchou odpoved
 *
 */
public class Answer {
	private final AnswerType type;
    private final String text;
    private String cardAnswer;

    public Answer(AnswerType type, String text) {
        this.type = type;
        this.text = text;
    }

    public AnswerType getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public String getCardAnswer() {
        return cardAnswer;
    }

    public void setCardAnswer(String cardAnswer) {
        this.cardAnswer = cardAnswer;
    }
}
