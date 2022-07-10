package ru.invbeans.model.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "done_question_table")
public class DoneQuestion {
    @Id
    @Column(name = "done_question_id")
    private Long id;

    @Column(name = "question_id")
    private Long question;

    @Column(name = "chosen")
    private int[] chosen;
}
