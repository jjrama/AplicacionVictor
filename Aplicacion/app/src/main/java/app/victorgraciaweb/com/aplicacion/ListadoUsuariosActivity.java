package app.victorgraciaweb.com.aplicacion;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import app.victorgraciaweb.com.adapter.AdaptadorUsuarios;
import app.victorgraciaweb.com.bean.Usuario;
import app.victorgraciaweb.com.controlador.ControladorUsuario;

public class ListadoUsuariosActivity extends ActionBarActivity
{
    // Atributos
    ListView listView;
    ArrayAdapter adapter;
    List<Usuario> listaUsuarios;

    private static ListadoUsuariosActivity listadoUsuariosActivity;
    public static ListadoUsuariosActivity getInstance(){
        return listadoUsuariosActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_usuarios);

        listadoUsuariosActivity = this;

        // Obtener instancia de la lista
        listView = (ListView) findViewById(R.id.listView);

        //Obtengo los USUARIOS de la database
        listaUsuarios = ControladorUsuario.accionMostrarUsuarios();

        // Crear y setear adaptador
        adapter = new AdaptadorUsuarios(this, listaUsuarios);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_listado_usuarios, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
