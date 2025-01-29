package fr.efrei.rag.domain;

import jakarta.persistence.*;

@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    private String title;

    // ✅ Add getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
