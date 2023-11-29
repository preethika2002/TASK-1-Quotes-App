package com.example.quotesapp.categories;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quotesapp.MainActivity;

import java.util.List;

import com.example.quotesapp.R;
import com.example.quotesapp.categories.categorieslist;
import com.example.quotesapp.quotes;

public class categoriesAdapter extends RecyclerView.Adapter<categoriesAdapter.MyViewHolder> {


    private final List<categorieslist> list;
    private final MainActivity context;

    public categoriesAdapter(List<categorieslist> list, MainActivity context) {
        this.list = list;
        this.context = context;
    }


    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public categoriesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_adapter_layout, null));
    }

    public void onBindViewHolder(@NonNull categoriesAdapter.MyViewHolder holder, int position) {
        categorieslist list2 = list.get(position);

        holder.categoryName.setText(list2.getCategoryName());
        holder.categoryImage.setImageResource(list2.getCategoryImg());

        holder.rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, quotes.class);

                intent.putExtra("name", list2.getCategoryName());

                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        private final TextView categoryName;
        private final ImageView categoryImage;
        private final CardView rootLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName= itemView.findViewById(R.id.categoryName);
            categoryImage= itemView.findViewById(R.id.categoryImage);
            rootLayout= itemView.findViewById(R.id.rootLayout);
        }
    }
}
