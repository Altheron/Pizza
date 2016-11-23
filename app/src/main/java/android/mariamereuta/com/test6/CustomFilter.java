package android.mariamereuta.com.test6;

import android.widget.Filter;

import java.util.ArrayList;

/**
 * Created by Maria on 22-Nov-16.
 */
public class CustomFilter extends Filter {

    Adapter mAdapter;
    ArrayList<Data> filterList;


    public CustomFilter(ArrayList<Data> filterlist, Adapter adapter) {
        this.mAdapter = adapter;
        this.filterList = filterlist;
    }

    //Filtrarea incepe

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        //check CONSTRAINT VALIDITY

        if (constraint != null && constraint.length() > 0){

            //Change to upper
            constraint = constraint.toString().toUpperCase();
            //Store our filtered pizzerii
            ArrayList<Data> filteredPizzerii = new ArrayList<>();
            for (int i=0;i<filterList.size();i++)
            {
                //CHECK
                if(filterList.get(i).getFirma().toUpperCase().contains(constraint))
                {
                    //Add Pizzerie to filtered Pizzerii
                    filteredPizzerii.add(filterList.get(i));
                }
            }

            results.count=filteredPizzerii.size();
            results.values=filteredPizzerii;
        } else {
            results.count=filterList.size();
            results.values=filterList;

        }

        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        mAdapter.pizzerii = (ArrayList<Data>) results.values;

        //refresh
        mAdapter.notifyDataSetChanged();

    }
}
