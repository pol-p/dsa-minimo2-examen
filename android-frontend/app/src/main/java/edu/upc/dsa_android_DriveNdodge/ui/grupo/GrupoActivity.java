package edu.upc.dsa_android_DriveNdodge.ui.grupo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class GrupoActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private Button botonEnviar;
    private EditText textGrupoName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setear el activity_X.xml
        setContentView(R.layout.activity_group);

        //setear el recyclerView y progressBar
        recyclerView = findViewById(R.id.XReciclerView);
        progressBar = findViewById(R.id.progressBarX);
        botonEnviar = findViewById(R.id.btnEnviar);
        textGrupoName = findViewById(R.id.textUsrname);

        botonEnviar.setOnClickListener(v -> {
            loadX();
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadX() {
        progressBar.setVisibility(View.VISIBLE);

        GrupoService service = RetrofitClient.getClient().create(GrupoService.class);
        Call<List<UsrMinimo2>> call = service.getUsrMinimo2(textGrupoName.getText().toString());

        call.enqueue(new Callback<List<UsrMinimo2>>(){
            @Override
            public void onResponse(Call<List<UsrMinimo2>> call, Response<List<UsrMinimo2>> response) {
                progressBar.setVisibility(View.GONE);

                if (response.isSuccessful() && response.body() != null){
                    List<UsrMinimo2> preguntas = response.body();

                    GrupoAdapter adapter = new GrupoAdapter(preguntas);
                    recyclerView.setAdapter(adapter);

                } else{
                    Toast.makeText(GrupoActivity.this, "Error al cargar el grupo", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<UsrMinimo2>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(GrupoActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
            }
        });
    }
}