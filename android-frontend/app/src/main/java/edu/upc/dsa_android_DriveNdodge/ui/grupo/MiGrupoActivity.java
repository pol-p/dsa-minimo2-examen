package edu.upc.dsa_android_DriveNdodge.ui.grupo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.upc.dsa_android_DriveNdodge.R;
import edu.upc.dsa_android_DriveNdodge.api.GrupoService;
import edu.upc.dsa_android_DriveNdodge.api.RetrofitClient;
import edu.upc.dsa_android_DriveNdodge.models.UsrMinimo2;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MiGrupoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_migroup);

        recyclerView = findViewById(R.id.XReciclerView);
        progressBar = findViewById(R.id.progressBarX);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        obtenerUsuarioYListar();
    }

    private void obtenerUsuarioYListar() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", null);

        if (username != null) {
            Log.i("MiGrupoActivity", "Usuario encontrado: " + username);
            Log.e("*******", username);
            loadMyTeam(username);
        } else {
            Toast.makeText(this, "Error: No hay usuario logueado", Toast.LENGTH_LONG).show();
        }
    }

    private void loadMyTeam(String username) {
        progressBar.setVisibility(View.VISIBLE);

        GrupoService service = RetrofitClient.getClient().create(GrupoService.class);

        Call<List<UsrMinimo2>> call = service.getMyTeam(username);

        call.enqueue(new Callback<List<UsrMinimo2>>() {
            @Override
            public void onResponse(Call<List<UsrMinimo2>> call, Response<List<UsrMinimo2>> response) {
                progressBar.setVisibility(View.GONE);

                if (response.isSuccessful() && response.body() != null) {
                    List<UsrMinimo2> companeros = response.body();

                    GrupoAdapter adapter = new GrupoAdapter(companeros);
                    recyclerView.setAdapter(adapter);

                    if (companeros.isEmpty()) {
                        Toast.makeText(MiGrupoActivity.this, "Tu equipo no tiene más miembros", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Log.e("MiGrupoActivity", "Error en respuesta: " + response.code());
                    Toast.makeText(MiGrupoActivity.this, "No se encontró tu equipo", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<UsrMinimo2>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Log.e("MiGrupoActivity", "Fallo de red", t);
                Toast.makeText(MiGrupoActivity.this, "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }
}