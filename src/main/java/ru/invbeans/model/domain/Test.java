package ru.invbeans.model.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "test_table")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id", nullable = false)
    private Long id;

    @Column(name = "name", length = 150)
    private String name;

    @Column(name = "oneAnswer")
    private boolean oneAnswer;

    @OneToMany(mappedBy = "test")
    private List<Question> questions;
}
