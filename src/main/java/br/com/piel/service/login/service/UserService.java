package br.com.piel.service.login.service;

import br.com.piel.service.login.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {

    UserDto saveUser(UserDto user);

    UserDto findByEmail(String email);

    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
