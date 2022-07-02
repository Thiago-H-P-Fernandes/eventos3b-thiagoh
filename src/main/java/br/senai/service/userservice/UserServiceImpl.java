package br.senai.service.userservice;

import br.senai.model.Role;
import br.senai.model.Usuario;
import br.senai.repository.RoleRepository;
import br.senai.repository.UserRepository;
import br.senai.service.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean createUsuario(Usuario usuario) {
        boolean isCreated = false;
        try {
            Usuario user_data = usuarioRepository.findUserByUsername(usuario.getUsername());
            if (user_data == null){
//                String userPassword = usuario.getUser_password();
//                String userPasswordEncoded = passwordEncoder.encode(userPassword);
//                usuario.setUser_password(userPasswordEncoded);
                usuario.setPermissions(Arrays.asList(roleRepository.findByNome("USER")));
                System.out.println("PASSOU");
                usuarioRepository.save(usuario);
                isCreated = true;

            }

        }catch (Exception e){
            throw new IllegalStateException("User already exists");
        }
        return isCreated;
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user_data = usuarioRepository.findUserByUsername(username);
        if(user_data == null){
            throw new UsernameNotFoundException("Usuario não encontrado");
        }

        CustomUser customUser = new CustomUser(username, user_data.getPassword(),
                true, true,true, true,
                authorities(user_data), user_data.getInventory(), user_data.getEmail());

        return customUser;
    }

    public Collection<GrantedAuthority> authorities(Usuario usuario){
        Collection<GrantedAuthority> permissoes = new ArrayDeque<>();
        List<Role> roles = roleRepository.findByUsuariosIn(usuario);
        for (Role role : roles){
            permissoes.add(new SimpleGrantedAuthority(("ROLE_" + role.getNome())));
        }
        return permissoes;

    }







}