package ru.invbeans.model.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "option_table")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_table")
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "correct")
    private boolean correct;
}
