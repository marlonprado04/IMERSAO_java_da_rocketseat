package br.com.marlonprado.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_users")
public class UserModel {

  // Informando que a variável id será o ID do banco de dados 
  @Id
  // Solicitando que o Spring Data gere a UUID automaticamente
  @GeneratedValue(generator = "UUID")
  private UUID id;

  // Bloqueia username para valores únicos em tabela
  @Column(unique = true)
  private String username;
  private String name;
  private String password;


  @CreationTimestamp
  private LocalDateTime createdAt;

}
