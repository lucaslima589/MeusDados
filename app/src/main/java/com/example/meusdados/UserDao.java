package com.example.meusdados;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void inserir(User user);

    @Query("SELECT * FROM usuarios")
    List<User> listar();
}

