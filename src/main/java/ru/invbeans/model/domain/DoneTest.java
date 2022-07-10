package ru.invbeans.model.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "done_test_table")
public class DoneTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "done_test_id", nullable = false)
    private Long id;

    @Column(name = "test_id")
    private Long test;

    @Column(name = "user_id")
    private Long user;

    @Column(name = "score")
    private int score;
}
