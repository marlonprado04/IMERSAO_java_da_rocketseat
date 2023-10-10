package br.com.marlonprado.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserModel, UUID> {

  // Retorna usuário a partir da consulta pelo username
  UserModel findByUsername(String username);
}
