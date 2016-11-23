package android.mariamereuta.com.test6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SearchView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchView = (SearchView) findViewById(R.id.action_search);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        //Set its properties
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //Adapter
        final Adapter adapter = new Adapter(this, getPizzerii());
        recyclerView.setAdapter(adapter);

        //Search
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                //Filter as you type
                adapter.getFilter().filter(query);
                return false;
            }
        });
    }


    //Add Pizzerii to ArrayList
    private ArrayList<Data> getPizzerii(){
        ArrayList<Data> pizzerii = new ArrayList<>();
        Data pizza = new Data();
        pizza.setFirma("Pronto Pizza");
        pizza.setMenu("Vezi meniu");
      //  pizza.setImg(R.drawable.ProntoPizza);
        pizzerii.add(pizza);


        return pizzerii;
    }


}
