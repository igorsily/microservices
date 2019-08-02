package br.com.igorsily.core.services;

import br.com.igorsily.core.models.Users;
import br.com.igorsily.core.repositories.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users findByUsername(String username){

        return this.usersRepository.findByUsername(username);
    }
}
