package com.sellingperfume.services.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import com.sellingperfume.entity.UserEntity;
import com.sellingperfume.repositories.IRepositories;
@Repository
public class SecuritySpringBoot implements UserDetailsService {
  @Autowired
  private IRepositories iRepositories;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // TODO Auto-generated method stub
    UserEntity uEntity = iRepositories.FindUserByUS(username);
    List<String> roleNameList = iRepositories.GetRoleName(uEntity.getId());
    List<GrantedAuthority>gList = new ArrayList<GrantedAuthority>();
    for(String role : roleNameList) {
      GrantedAuthority authority = new SimpleGrantedAuthority(role);
      gList.add(authority);
    }
    UserDetails userDetails =
        (UserDetails) new User(uEntity.getUsername(), uEntity.getPassword(), gList);
    return userDetails;

  }

}
