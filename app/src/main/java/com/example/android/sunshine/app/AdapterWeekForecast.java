package com.example.android.sunshine.app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pro on 02/06/16.
 */
public class AdapterWeekForecast extends RecyclerView.Adapter<AdapterWeekForecast.ViewHolder> {

    private Context context;
    private List<String> lstData;
    private View.OnClickListener listener;

    /**
     * Constructor para recibir los parametros a llenar de la lista
     * @param context Actividad
     * @param lstData Data
     */
    public AdapterWeekForecast(Context context, List<String> lstData,View.OnClickListener listener){
        this.context = context;
        this.lstData = lstData;
        this.listener = listener;
    }

    public AdapterWeekForecast(Context context, List<String> lstData){
        this.context = context;
        this.lstData = lstData;
    }

    /**
     * Clase que nos permite retener los valores de cada vista y pintarlos
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtForecast;

        public ViewHolder(View itemView) {
            super(itemView);
            txtForecast = (TextView) itemView.findViewById(R.id.list_item_forecast_textview);
        }

    }

    /**
     *
     * @param parent Grupo de vistas
     * @param viewType Tipo de vista
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_forecast,parent,false);

        view.setOnClickListener(listener);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtForecast.setText(lstData.get(position));
    }

    @Override
    public int getItemCount() {
        return lstData.size();
    }

}
