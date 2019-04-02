package app.final_project.domain.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "fill_in_the_blanks_question")
public class FillInQuestion extends BaseEntity {
    private String question;
    private Set<String> correctOptions;

    @Column(name = "question", nullable = false, unique = true)
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @ElementCollection
    @CollectionTable(name = "question_options", joinColumns = @JoinColumn(name = "question_option_id"))
    public Set<String> getCorrectOptions() {
        return correctOptions;
    }

    public void setCorrectOptions(Set<String> correctOptions) {
        this.correctOptions = correctOptions;
    }
}
