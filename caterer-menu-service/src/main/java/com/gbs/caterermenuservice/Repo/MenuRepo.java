package com.gbs.caterermenuservice.Repo;

import com.gbs.caterermenuservice.Model.Menu;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepo extends JpaRepository<Menu,Integer> {
    
}
