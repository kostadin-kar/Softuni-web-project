package app.final_project.domain.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "select_questions")
public class SelectQuestion extends BaseEntity {
    private String question;
    private Set<String> questionOptions;
    private String correctOption;

    @Column(name = "question", nullable = false, unique = true)
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @ElementCollection
    @CollectionTable(name = "question_options", joinColumns = @JoinColumn(name = "question_option_id",referencedColumnName = "id"))
    public Set<String> getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(Set<String> questionOptions) {
        this.questionOptions = questionOptions;
    }

    @Column(name = "correct_option", nullable = false, unique = true)
    public String getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }
}
