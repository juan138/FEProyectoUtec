package com.proyecto.sistemainventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.proyecto.sistemainventario.Dto.ProductoDto;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProducTable extends AppCompatActivity {

    private RequestQueue rq;
    private TableLayout tabLayout;
    private EditText txtName,txtCant;
    private String[] header = {"id","nombre","cantidad"};
    private ArrayList<String[]> rows = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_produc_table);
            tabLayout = (TableLayout) findViewById(R.id.tblProductos);
            txtName = (EditText) findViewById(R.id.txtName);
            txtCant = (EditText) findViewById(R.id.txtCantidad);

            TablaDinamica td = new TablaDinamica(tabLayout,getApplicationContext());
            td.addHeader(header);
            td.addData(getProductos());
            //listar();
    }

    private ArrayList<String[]>  getProductos(){
        rows.add(new String[] {"1","llaves","15"} );
        rows.add(new String[] {"2","pinsas","5"} );
        return  rows;
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

    // metodo para asignar funcion a las opciones del menu
    public boolean onOptionsItemSelected(MenuItem mt){
        int idItem = mt.getItemId();
        Intent log=null;
        switch (idItem){
            case R.id.index:
                // tabla de productos
                log = new Intent(this, Principal.class);
                startActivity(log);
                break;
            case R.id.p:
                // perfil
                break;
            case R.id.lst:
                // tabla de productos
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
     * listar todos los productos
     */
    public void listar(){
        StringRequest str = new StringRequest(Request.Method.POST, "http://192.168.1.10:8080/ProyectoUtec/productos",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                       /* try {
                            JSONArray jsonarray = new JSONArray(response);
                            for(int i=0; i<jsonarray.length(); i++){
                                JSONObject obj = jsonarray.getJSONObject(i);

                                String name = obj.getString("name");
                                String url = obj.getString("url");

                                //rows.add(new String[] {obj.getString("id"),obj.getString("nombre"),obj.getString("cantidad")} );
                            }
                        }catch (Exception ex){}*/
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error->",error.toString());
            }
        }){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<>();
                parametros.put("action","lista");

                return  parametros;
            }
        };
        rq.add(str);
    }

    /**
     * evita retroceder
     */
    @Override
    public void onBackPressed() {

    }
}
