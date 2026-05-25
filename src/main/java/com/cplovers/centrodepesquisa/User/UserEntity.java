package com.cplovers.centrodepesquisa.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table("tb_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements UserDetails, Persistable<String> {

    @Id
    @Column("cpf")
    private String cpf;

    @Column("nome")
    private String name;

    @Column("nome_social")
    private String socialName;

    @Column("email")
    private String email;

    @Column("password")
    private String password;

    @Column("campus")
    private String campus;

    @Column("formacao")
    private String formacao;

    @Column("titulacao")
    private String titulacao;

    @Column("sexo")
    private String sexo;

    @Column("lattes")
    private String lattes;

    @Column("telefone")
    private String telefone;

    @Transient
    private boolean isNew = true;

    @MappedCollection(idColumn = "user_cpf")
    private Set<UserRole> roles = new HashSet<>();

    @Override
    public @Nullable String getId() {
        return cpf;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    @Override
    public String getUsername() { return name; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(r -> (GrantedAuthority) () -> "ROLE_" + r.roleId())
                .toList();
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}