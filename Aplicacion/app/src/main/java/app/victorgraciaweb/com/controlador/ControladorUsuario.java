package app.victorgraciaweb.com.controlador;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.victorgraciaweb.com.Modelo.ModeloUsuario;
import app.victorgraciaweb.com.aplicacion.ListadoUsuariosActivity;
import app.victorgraciaweb.com.aplicacion.LoginActivity;
import app.victorgraciaweb.com.bean.Usuario;
import app.victorgraciaweb.com.utils.DataAplication;
import app.victorgraciaweb.com.utils.VolleySingleton;

public class ControladorUsuario
{
    static ModeloUsuario modeloUsuario = new ModeloUsuario();

    public static List<Usuario> accionLogin(final String email, final String password)
    {
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setPassword(password);
        List<Usuario> listaUsuarios = modeloUsuario.loginUsuario(usuario);
        return listaUsuarios;
    }

    public static List<Usuario> accionMostrarUsuarios()
    {
        List<Usuario> listaUsuarios = modeloUsuario.getAllUsuarios();
        return listaUsuarios;
    }
}
