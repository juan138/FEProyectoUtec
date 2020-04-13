package com.proyecto.sistemainventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Principal extends AppCompatActivity {

    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    /**
     * mostrar y ocultar menu
     * @param menu
     * @return
     */
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.drawermenu,menu);
        return true;
    }

    /**
     *  metodo para asignar funcion a las opciones del menu
     * @param mt
     * @return MenuItem
     */
    public boolean onOptionsItemSelected(MenuItem mt){
        int idItem = mt.getItemId();
        Intent log =null;
        switch (idItem){
            case R.id.index:
                // inicio
                break;
            case R.id.p:
                // perfil
                break;
            case R.id.lst:
                // tabla de productos
                log = new Intent(this, ProducTable.class);
                startActivity(log);
                break;
            case R.id.sl:
                // solicitar
                break;
            case R.id.np:
                // nuevo producto
                break;
            case R.id.closed:
                // salir
                Toast.makeText(getApplicationContext(), "Saliendo...", Toast.LENGTH_SHORT).show();
                log = new Intent(this, MainActivity.class);
                startActivity(log);
                break;
        }
        return super.onOptionsItemSelected(mt);
    }

    /**
     * evita retroceder
     */
    @Override
    public void onBackPressed() {

    }


}
