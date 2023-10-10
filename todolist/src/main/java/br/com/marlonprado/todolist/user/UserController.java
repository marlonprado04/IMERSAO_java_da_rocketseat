package br.com.marlonprado.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
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
    public UserModel create(@RequestBody UserModel userModel) {

        // Buscando usuário no banco de dados pelo username
        var user = this.userRepository.findByUsername(userModel.getUsername());

        // Verifica se busca retornou algum usuário
        if(user != null){
            System.out.println("Usuário já existe");
            return null;
        }

        // Salva usuário no banco de dados
        var userCreated = this.userRepository.save(userModel);

        // Retornando usuário após salvar ele no banco de dados
        return userCreated;

    }

}
