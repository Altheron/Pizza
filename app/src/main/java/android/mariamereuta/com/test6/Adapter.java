package android.mariamereuta.com.test6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.Filter;

import java.util.ArrayList;

/**
 * Created by Maria on 22-Nov-16.
 */

public class Adapter extends RecyclerView.Adapter<Holder> implements Filterable {

    Context mContext;
    ArrayList<Data> pizzerii,filterlist;
    CustomFilter mFilter;

    public Adapter(Context context, ArrayList<Data> pizzerii) {
        this.mContext = context;
        this.pizzerii = pizzerii;
        this.filterlist = pizzerii;
    }




    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout, null);
        Holder holder = new Holder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.mImageView.setImageResource(pizzerii.get(position).getImg());
        holder.mMeniu.setText(pizzerii.get(position).getMenu());
        holder.mFirma.setText(pizzerii.get(position).getFirma());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                //Intent
            }
        });
    }


    @Override
    public int getItemCount() {
        return pizzerii.size();
    }

    @Override
    public Filter getFilter() {
        if (mFilter==null){
            mFilter=new CustomFilter(filterlist, this);
        }

        return mFilter;
    }
}
