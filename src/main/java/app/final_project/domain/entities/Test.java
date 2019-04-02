package app.final_project.domain.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tests")
public class Test extends BaseEntity {
    private User user;
    private Date testStart;
    private Date testDuration;
    private Double testGrade;
    private Set<FillInQuestion> fillInQuestions;
    private Set<ReadQuestion> readQuestions;
    private Set<SelectQuestion> selectQuestions;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "test_start", nullable = false)
    public Date getTestStart() {
        return testStart;
    }

    public void setTestStart(Date testStart) {
        this.testStart = testStart;
    }

    @Column(name = "test_duration", nullable = false)
    public Date getTestDuration() {
        return testDuration;
    }

    public void setTestDuration(Date testDuration) {
        this.testDuration = testDuration;
    }

    @Column(name = "test_grade", nullable = false)
    public Double getTestGrade() {
        return testGrade;
    }

    public void setTestGrade(Double testGrade) {
        this.testGrade = testGrade;
    }

    @ManyToMany()
    @JoinTable(name = "test_fill_in_question",
            joinColumns = @JoinColumn(name = "test_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "fill_in_question_id", referencedColumnName = "id")
    )
    public Set<FillInQuestion> getFillInQuestions() {
        return fillInQuestions;
    }

    public void setFillInQuestions(Set<FillInQuestion> fillInQuestions) {
        this.fillInQuestions = fillInQuestions;
    }

    @ManyToMany()
    @JoinTable(name = "test_read_question",
            joinColumns = @JoinColumn(name = "test_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "read_question_id", referencedColumnName = "id")
    )  public Set<ReadQuestion> getReadQuestions() {
        return readQuestions;
    }

    public void setReadQuestions(Set<ReadQuestion> readQuestions) {
        this.readQuestions = readQuestions;
    }

    @ManyToMany()
    @JoinTable(name = "test_select_question",
            joinColumns = @JoinColumn(name = "test_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "select_question_id", referencedColumnName = "id")
    )   public Set<SelectQuestion> getSelectQuestions() {
        return selectQuestions;
    }

    public void setSelectQuestions(Set<SelectQuestion> selectQuestions) {
        this.selectQuestions = selectQuestions;
    }
}
