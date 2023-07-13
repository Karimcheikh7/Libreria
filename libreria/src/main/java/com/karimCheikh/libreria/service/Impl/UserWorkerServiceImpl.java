package com.karimCheikh.libreria.service.Impl;

import com.karimCheikh.libreria.entity.UserWorker;
import com.karimCheikh.libreria.entity.UserWorkersRoles;
import com.karimCheikh.libreria.repository.RoleRepository;
import com.karimCheikh.libreria.repository.UserWorkerRepository;
import com.karimCheikh.libreria.service.UserWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserWorkerServiceImpl implements UserWorkerService {

    private UserWorkerRepository userWorkerRepository;

    private RoleRepository roleRepository;


    @Autowired
    public UserWorkerServiceImpl(UserWorkerRepository userWorkerRepository, RoleRepository roleRepository) {
        this.userWorkerRepository = userWorkerRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public UserWorker findByUserNameWorker(String userNameWorker) {
        Optional<UserWorker> userWorker = Optional.ofNullable(userWorkerRepository.findByUserNameWorker(userNameWorker));
        if (userWorker.isPresent()){
            return userWorker.get();
        }else {
            throw new RuntimeException("Non ho trovato l'userWorker con il nome: " + userNameWorker);
        }
    }

    @Override
    public List<UserWorker> findAll() {
        return userWorkerRepository.findAll();
    }

    @Override
    public UserWorker findById(Integer id) {
        Optional<UserWorker> userWorker = userWorkerRepository.findById(id);
        if (userWorker.isPresent()){
            return userWorker.get();
        }else {
            throw new RuntimeException("Non ho trovato l'userWorker con l'id: " + id);
        }
    }

    @Override
    public UserWorker save(UserWorker userWorker) {
        return userWorkerRepository.save(userWorker);
    }

    @Override
    public void deleteById(Integer id) {
        userWorkerRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String userNameWorker) throws UsernameNotFoundException {
        UserWorker userWorker = userWorkerRepository.findByUserNameWorker(userNameWorker);
        if (userWorker == null) {
            throw new UsernameNotFoundException("UsernameWorker o password non valida. ");
        }
        return new org.springframework.security.core.userdetails.User(userWorker.getUserNameWorker(), userWorker.getPassoword(),
                mapRolesToAuthorities(userWorker.getUserWorkersRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<UserWorkersRoles> roles) {
        return roles.stream().map(role ->  new SimpleGrantedAuthority(role.getRole().getName())).collect(Collectors.toList());
    }
}
