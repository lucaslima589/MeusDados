package com.example.meusdados;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "usuarios")
public class User {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    public String nome;

    @NonNull
    public String email;

    @NonNull
    public String dataNascimento;

    public User(@NonNull String nome,
                @NonNull String email,
                @NonNull String dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }
}

