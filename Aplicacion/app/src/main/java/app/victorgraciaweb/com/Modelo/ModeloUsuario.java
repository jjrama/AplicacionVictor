package app.victorgraciaweb.com.Modelo;

import android.content.Intent;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.victorgraciaweb.com.DAO.UsuarioDAO;
import app.victorgraciaweb.com.aplicacion.ListadoUsuariosActivity;
import app.victorgraciaweb.com.aplicacion.LoginActivity;
import app.victorgraciaweb.com.bean.Usuario;
import app.victorgraciaweb.com.utils.DataAplication;
import app.victorgraciaweb.com.utils.ParseJson;
import app.victorgraciaweb.com.utils.VolleySingleton;

public class ModeloUsuario implements UsuarioDAO
{
    private static JsonArrayRequest jsArrayRequest;
    private static List<Usuario> listaUsuarios;

    @Override
    public List<Usuario> getAllUsuarios()
    {
        final String URL = "/getAllUsuarios";

        // Nueva petición JSONObject
        jsArrayRequest = new JsonArrayRequest(DataAplication.URL_BASE + URL,new Response.Listener<JSONArray>()
        {
            @Override
            public void onResponse(JSONArray response)
            {
                listaUsuarios = ParseJson.usuarios(response);
            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.d("Error", "Error Respuesta en JSON: " + error.getMessage());
            }

        });

        // Añadir petición a la cola
        VolleySingleton.getInstance(ListadoUsuariosActivity.getInstance().getBaseContext()).addToRequestQueue(jsArrayRequest);

        return listaUsuarios;
    }

    @Override
    public Usuario getUsuario(int idUsuario)
    {
        return null;
    }

    @Override
    public List<Usuario> loginUsuario(Usuario usuario)
    {
        final String URL = "/loginUsuario?email="+usuario.getEmail()+"&password="+usuario.getPassword();

        jsArrayRequest = new JsonArrayRequest(DataAplication.URL_BASE + URL, new Response.Listener<JSONArray>()
        {
            @Override
            public void onResponse(JSONArray response)
            {
                listaUsuarios = ParseJson.usuarios(response);
            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.d("Error", "Error Respuesta en JSON: " + error.getMessage());
            }

        });

        // Añadir petición a la cola
        VolleySingleton.getInstance(LoginActivity.getInstance().getBaseContext()).addToRequestQueue(jsArrayRequest);

        return listaUsuarios;
    }

    @Override
    public void updateUsuario(Usuario usuario)
    {

    }

    @Override
    public void deleteUsuario(int idUsuario)
    {

    }
}
