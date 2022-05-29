package com.example.pdfbooks.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pdfbooks.R;
import com.example.pdfbooks.models.Product;
import com.example.pdfbooks.pdf;

import java.util.List;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private final Context mCtx;

    //we are storing all the products in a list
    private final List<Product> productList;

    //getting the context and product list with constructor
    public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.item_books, null);
        return new ProductViewHolder(view);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(ProductViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        //getting the product of the specified position
        final Product product = productList.get(position);

        //binding the data with the viewholder views

        holder.textViewTitle.setText(product.getTitle());


        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

        holder.imageView.setOnClickListener(v-> {

            Intent i = new Intent(v.getContext(), pdf.class);
            i.putExtra("title",productList.get(position).getTitle());
            i.putExtra("product",productList.get(position).getTitle());
            i.putExtra("link",productList.get(position).getLink());
            mCtx.startActivity(i)

            ;

        });
                }
       // holder.cardView.setOnClickListener(v -> {





    @Override
    public int getItemCount() {
        return productList.size();
    }


    static class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        ImageView imageView;
        CardView cardView;

        public ProductViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview2);       // card intial
            textViewTitle = itemView.findViewById(R.id.book_title);
            imageView = itemView.findViewById(R.id.book_cover);
        }
    }
}
