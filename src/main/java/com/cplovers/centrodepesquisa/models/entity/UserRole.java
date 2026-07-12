package com.cplovers.centrodepesquisa.models.entity;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("tb_user_role")
public record UserRole(
        @Column("role_id") Integer roleId
) { }
