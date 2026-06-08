package com.cplovers.centrodepesquisa.User;

import com.cplovers.centrodepesquisa.User.dtos.CreateUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> postUsers(@RequestBody CreateUserDto dto) {
        try {
            userService.createUser(dto);
            return ResponseEntity.ok("Usuário criado com sucesso, com CPF: " + dto.cpf());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            // temporário para debug
            return ResponseEntity.internalServerError().body("Erro interno: " + e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<List<UserEntity>> getUsers() {
        var Users = userService.getUsers();

        return ResponseEntity.ok(Users);
    }

}
