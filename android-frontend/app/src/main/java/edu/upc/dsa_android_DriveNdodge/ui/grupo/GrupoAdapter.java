package edu.upc.dsa_android_DriveNdodge.ui.grupo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import edu.upc.dsa_android_DriveNdodge.R;
import edu.upc.dsa_android_DriveNdodge.models.UsrMinimo2;

public class GrupoAdapter extends RecyclerView.Adapter<GrupoAdapter.ViewHolder>{
    private List<UsrMinimo2> lsitaX;
    public GrupoAdapter(List<UsrMinimo2> preguntas) {
        this.lsitaX = preguntas;
    }

    @NonNull
    @Override
    public GrupoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflar el ROW.xml
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_usr_grupo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GrupoAdapter.ViewHolder holder, int position) {
        UsrMinimo2 preg = lsitaX.get(position); //Coger el objeto entero de la lista

        holder.name.setText("Name: " + preg.getName());
        holder.points.setText("Points: " + preg.getPoints());
        Picasso.get().load(preg.getAvatarUrl()).into(holder.imagen);
    }

    @Override
    public int getItemCount() {
        return lsitaX.size();
    }

    //Info sobre el ROW.xml
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, points;
        ImageView imagen;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.tvName);
            imagen = view.findViewById(R.id.ivIcono);
            points = view.findViewById(R.id.tvPoints);
        }
    }
}

