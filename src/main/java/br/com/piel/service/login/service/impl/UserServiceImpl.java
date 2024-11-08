package br.com.piel.service.login.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.piel.service.login.dto.UserDto;
import br.com.piel.service.login.entity.UserEntity;
import br.com.piel.service.login.repository.UserRepository;
import br.com.piel.service.login.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final ModelMapper modelMapper;

	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.modelMapper = modelMapper;
	}

	@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o email: " + email));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                new ArrayList<>() // Aqui você pode adicionar as authorities se necessário
        );
    }

	@Override
	public UserDto saveUser(UserDto user) {
		if (userRepository.findByEmail(user.getEmail()).isPresent()) {
			throw new RuntimeException("Email já registrado");
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		UserEntity userEntity = userRepository.save(modelMapper.map(user, UserEntity.class));
		return modelMapper.map(userEntity, UserDto.class);
	}

	@Override
	public UserDto findByEmail(String email) {
		Optional<UserEntity> user = userRepository.findByEmail(email);
		return modelMapper.map(user, UserDto.class);
	}
}
