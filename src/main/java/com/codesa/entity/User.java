package com.codesa.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private long id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role", nullable = false, foreignKey = @ForeignKey(name = "fk_id_role"))
    private Role role;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private char active;
}
