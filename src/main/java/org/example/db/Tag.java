package org.example.db;

import jakarta.persistence.*;

@Entity
@Table(name = "tags")
public class Tag {

    // id, name
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }
}
