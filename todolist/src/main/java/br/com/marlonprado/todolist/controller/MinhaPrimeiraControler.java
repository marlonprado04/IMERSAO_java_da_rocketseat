package br.com.marlonprado.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeiraRota")
public class MinhaPrimeiraControler {

    /**
     * Métodos de requisição HTTP:
     * 
     * GET - Buscar dado
     * POST - Adicionar dado
     * PUT - Alterar dado
     * DELETE - Remover dado
     * PATCH - Alterar somente um dado
     * 
     */

    // Annotation para passar método Get
    @GetMapping("/")
    public String primeiraMensagem() {

        return "Funcionou";

    }

}
