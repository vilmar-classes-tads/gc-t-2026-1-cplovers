package com.cplovers.centrodepesquisa.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "nome_social")
    private String socialName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "campus", nullable = false)
    private String campus;

    @Column(name = "formacao", nullable = false)
    private String formacao;

    @Column(name = "titulacao", nullable = false)
    private String titulacao;

    @Column(name =  "sexo")
    private String sexo;

    @Column(name = "lattes")
    private String lattes;

    @Column(name = "telefone")
    private String telefone;

    @ManyToMany
    @JoinTable(
         name = "tb_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roles = new HashSet<>();

    @Transient
    private boolean isNew = true;

}