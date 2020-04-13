package com.proyecto.sistemainventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText usuario, pass;
    private TextView resp;
    private RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = (EditText) findViewById(R.id.txtUser);
        pass = (EditText) findViewById(R.id.txtPass);
        rq = Volley.newRequestQueue(getApplicationContext());

        Button fab = (Button) findViewById(R.id.btnIngresar);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultar(v);
            }
        });
    }

    @Override
    public void onBackPressed() {
    }

    public void Login(){
        usuario.setText("");
        pass.setText("");
        Intent log = new Intent(this,Principal.class);
        startActivity(log);
    }
//login&user=juan&pass=s34
    private void consultar(final View view){
        StringRequest str = new StringRequest(Request.Method.POST, "http://192.168.1.10:8080/ProyectoUtec/login",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                        if(response.equals("true")){
                            Login();
                        }else {
                            Toast.makeText(getApplicationContext(), "Usuario o Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("Error->",error.toString());
                }
        }){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError{
                Map<String,String> parametros = new HashMap<>();
                parametros.put("action","login");
                parametros.put("user",usuario.getText().toString());
                parametros.put("pass",pass.getText().toString());

                return  parametros;
            }
        };
        rq.add(str);
    }

}
