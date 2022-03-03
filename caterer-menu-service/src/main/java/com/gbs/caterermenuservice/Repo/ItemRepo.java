package com.gbs.caterermenuservice.Repo;

import com.gbs.caterermenuservice.Model.Item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Integer> {
    
}
