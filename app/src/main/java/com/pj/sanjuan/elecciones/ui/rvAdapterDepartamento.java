package com.pj.sanjuan.elecciones.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pj.sanjuan.elecciones.model.DepartamentoModel;
import com.pj.sanjuan.elecciones.R;
import com.pj.sanjuan.elecciones.model.DepartamentoModel;

import java.util.List;

/**
 * Created by JuanManuel on 20/6/2018.
 */

public class rvAdapterDepartamento extends RecyclerView.Adapter<rvAdapterDepartamento.ViewHolder> {

    private List<DepartamentoModel> listaDepartamentos;

    public rvAdapterDepartamento(List<DepartamentoModel> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_departamento,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.id.setText(listaDepartamentos.get(position).getID().toString());
        holder.zona.setText(listaDepartamentos.get(position).getZona().toString());
        holder.nombre.setText(listaDepartamentos.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return listaDepartamentos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView id, zona, nombre;
        public ViewHolder(View itemView) {
            super(itemView);
            id=(TextView) itemView.findViewById(R.id.tvID);
            zona=(TextView) itemView.findViewById(R.id.tvZona);
            nombre=(TextView) itemView.findViewById(R.id.tvNombre);

        }
    }

}
