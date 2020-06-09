package com.example.appaluno;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase bd = openOrCreateDatabase("dbAlunosCriar", MODE_PRIVATE, null);

            bd.execSQL("CREATE TABLE IF NOT EXISTS tbPessoas (nome VARCHAR,email VARCHAR, telefone VARCHAR)");

            bd.execSQL("INSERT INTO tbPessoas(nome,email,telefone)VALUES('Marcos','marcos@gmail.com','(98)28341168')");
            bd.execSQL("INSERT INTO tbPessoas(nome,email,telefone)VALUES('Joquin','joaquin@gmail.com','(31)23673642')");
            bd.execSQL("INSERT INTO tbPessoas(nome,email,telefone)VALUES('Weverton','weverton@gmail.com','(11)21212673')");
            bd.execSQL("INSERT INTO tbPessoas(nome,email,telefone)VALUES('Cleverson','cleverson@gmail.com','(19)64005959')");
            bd.execSQL("INSERT INTO tbPessoas(nome,email,telefone)VALUES('Emerson','emerson@gmail.com','(63)76115413')");
            bd.execSQL("INSERT INTO tbPessoas(nome,email,telefone)VALUES('Jose','jose@gmail.com','(21)94643556')");
            bd.execSQL("INSERT INTO tbPessoas(nome,email,telefone)VALUES('Robson','robson@gmail.com','(15)76326103')");
            bd.execSQL("INSERT INTO tbPessoas(nome,email,telefone)VALUES('Flavio','flavio@gmail.com','(61)99273568')");
            bd.execSQL("INSERT INTO tbPessoas(nome,email,telefone)VALUES('Shaolin','shaolin@gmail.com','(81)53299490')");
            bd.execSQL("INSERT INTO tbPessoas(nome,email,telefone)VALUES('Joao','joao@gmail.com','(94)86618817')");


            Cursor cursor = bd.rawQuery("SELECT nome, email, telefone FROM tbAlunos", null);

            int indiceNome = cursor.getColumnIndex("nome");
            int indiceEmail = cursor.getColumnIndex("email");
            int indiceTelefone = cursor.getColumnIndex("telefone");

            cursor.moveToFirst();

            while (cursor != null) {
                Log.i("Resultado - nome", cursor.getString(indiceNome));
                Log.i("Resultado - email", cursor.getString(indiceEmail));
                Log.i("Resultado - telefone", cursor.getString(indiceTelefone));

                cursor.moveToNext();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}