package br.com.marlonprado.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    // Método para criar usuário através do corpo da requisição
    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) {

        // Buscando usuário no banco de dados pelo username
        var user = this.userRepository.findByUsername(userModel.getUsername());

        // Verifica se busca retornou algum usuário
        if(user != null){
            // Mensagem de erro no console se usuário existir
            System.out.println("Usuário já existe");

            // Retorno de bad_request para a requisição
            // E mensagem de erro no body da requisição
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        }

        // Salva usuário no banco de dados
        var userCreated = this.userRepository.save(userModel);

        // Retornando status de criado para a equisição
        // E retornando informações do usuário no body da requisição
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);

    }

}
