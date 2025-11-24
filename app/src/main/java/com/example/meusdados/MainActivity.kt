package com.example.meusdados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = AppDatabase.getInstance(this)
        userDao = db.userDao()

        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtData = findViewById<EditText>(R.id.edtData)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        atualizarLista(txtResultado)

        btnSalvar.setOnClickListener {
            val nome = edtNome.text.toString().trim()
            val email = edtEmail.text.toString().trim()
            val data = edtData.text.toString().trim()

            if (nome.isEmpty() || email.isEmpty() || data.isEmpty()) {
                txtResultado.text = "Preencha todos os campos!"
                return@setOnClickListener
            }

            // cria o usuário e salva
            val user = User(nome, email, data)
            userDao.inserir(user)

            // limpa campos
            edtNome.setText("")
            edtEmail.setText("")
            edtData.setText("")

            // atualiza a lista
            atualizarLista(txtResultado)
        }
    }

    private fun atualizarLista(txt: TextView) {
        val lista = userDao.listar()
        val builder = StringBuilder("Usuários cadastrados:\n\n")
        for (u in lista) {
            builder.append("Nome: ${u.nome}\n")
            builder.append("Email: ${u.email}\n")
            builder.append("Data: ${u.dataNascimento}\n\n")
        }
        txt.text = builder.toString()
    }
}


