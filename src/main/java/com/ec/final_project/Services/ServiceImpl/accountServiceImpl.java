package com.ec.final_project.Services.ServiceImpl;

import com.ec.final_project.Entity.useraccount;
import com.ec.final_project.Repositories.accountRepository;
import com.ec.final_project.Services.Services.accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class accountServiceImpl implements accountService, UserDetailsService {

    private final accountRepository acc_repo;

    @Autowired
    public accountServiceImpl(accountRepository acc_repo) {
        this.acc_repo = acc_repo;
    }

    @Override
    public boolean CheckExist(useraccount tk) {
        return acc_repo.checkExists(tk.getUsername(), tk.getPhone(), tk.getEmail(), tk.getIdentity_number()) != null;
    }

    @Override
    public void Create(useraccount tk) {
        tk.setPassword(new BCryptPasswordEncoder().encode(tk.getPassword()));
        acc_repo.saveAndFlush(tk);
    }

    @Override
    public List<useraccount> getAll() {
        return acc_repo.findAll();
    }

    @Override
    public void delete_Acc(int id) {
        acc_repo.deleteById(id);
    }

    @Override
    public useraccount validate(String username, String password) {
        return acc_repo.validate(username, password);
    }

    @Override
    public useraccount FindByEmail(String email) {
        return acc_repo.FindByEmail(email);
    }

    @Override
    public Object findByIdentityNumber(String identityNumber) {
        return acc_repo.findByIdentityNumber(identityNumber);
    }

    @Override
    public void UpdatePassword(int acc_id, String newPassword) {
        acc_repo.UpdatePassword(acc_id, newPassword);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        useraccount u = acc_repo.findByUsername(username);
        if (u == null) {
            System.out.println("user not found "+username);
            throw new UsernameNotFoundException("User not in db");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), authorities);
    }
}
