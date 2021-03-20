package com.example.myapplication.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DriverList;
import com.example.myapplication.MapsActivity;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<DriverList> driverLists;
    double cuslat,cuslon;

    public ListAdapter(ArrayList<DriverList> driverLists, double cuslat, double cuslon) {
        this.driverLists = driverLists;
        this.cuslat = cuslat;
        this.cuslon = cuslon;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        final DriverList driverListData = driverLists.get(position);
        ViewHolder y = (ViewHolder)holder;
        y.driver_name.setText(driverLists.get(position).getName());
        y.distance.setText(driverLists.get(position).getDis());
        y.vehicle.setText(driverLists.get(position).getCar_type());
        if(driverLists.get(position).getCar_type().equals("Toto")) {
            y.img.setImageResource(R.drawable.toto);
        }
        else if(driverLists.get(position).getCar_type().equals("Van")) {
            y.img.setImageResource(R.drawable.van);
        }
        else if(driverLists.get(position).getCar_type().equals("Rickshaw")) {
            y.img.setImageResource(R.drawable.rickshaw);
        }
        else if(driverLists.get(position).getCar_type().equals("Magic Gaadi")){
            y.img.setImageResource(R.drawable.magic_gaadi);
        }
        else if(driverLists.get(position).getCar_type().equals("Chota Hathi")){
            y.img.setImageResource(R.drawable.chota_hathi);
        }
        else if(driverLists.get(position).getCar_type().equals("Taxi")){
            y.img.setImageResource(R.drawable.taxi);
        }

        final double drilat,drilon;
        drilat=driverLists.get(position).getLat();
        drilon=driverLists.get(position).getLon();
        final String phno=driverLists.get(position).getPhno();
        y.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Name : "+driverListData.getName()+"\nDistance = "+ driverListData.getDis(),Toast.LENGTH_LONG).show();
            }
        });
        y.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), MapsActivity.class);
                intent.putExtra("cuslat", cuslat);
                intent.putExtra("cuslong", cuslon);
                intent.putExtra("drilat",drilat);
                intent.putExtra("drilon",drilon);
                intent.putExtra("phno",phno);
                view.getContext().startActivity(intent); }
        });
    }

    @Override
    public int getItemCount() {
        return driverLists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView driver_name;
        public TextView distance;
        public TextView vehicle;
        public RelativeLayout relativeLayout;
        public ImageButton imageButton;
        public ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageButton = (ImageButton)itemView.findViewById(R.id.info_button);
            this.distance = (TextView) itemView.findViewById(R.id.distance);
            this.driver_name = (TextView) itemView.findViewById(R.id.driver_name);
            this.vehicle = (TextView)itemView.findViewById(R.id.class_of_vehicle_display);
            this.img = (ImageView) itemView.findViewById(R.id.car_img);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.list_item);
        }
    }
}
