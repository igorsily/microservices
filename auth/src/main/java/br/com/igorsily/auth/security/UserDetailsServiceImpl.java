package br.com.igorsily.auth.security;

import br.com.igorsily.core.models.Users;
import br.com.igorsily.core.repositories.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsersRepository usersRepository;

    public UserDetailsServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = this.usersRepository.findByUsername(username);

        if(user == null) throw new UsernameNotFoundException(username);

        return new UserSecurity(user);
    }
}
