package com.jsfood;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.jsfood.adapter.RestaurantAdapter;
import com.jsfood.database.RestaurantDB;
import com.jsfood.model.Restaurant;
import java.util.ArrayList;

public class RestaurantFragment extends Fragment  {
    private ListView lsvRestaurantView = null;
    private RestaurantAdapter adapter  = null;
    private RestaurantDB restaurantDB  = null;
    private SQLiteDatabase db          = null;
    private ArrayList<Restaurant> listRestaurant = null;
    private String categori;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view   = inflater.inflate(R.layout.restaurant_fragment, container, false);
        lsvRestaurantView = (ListView) view.findViewById(R.id.lsvListRestaurant);
        categori          = getArguments().getString("categori");

        refreshListAdapter(categori);

        lsvRestaurantView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String txtId      = ((TextView) view.findViewById(R.id.txtIdOfRestorant)).getText().toString();
                String txtName    = ((TextView) view.findViewById(R.id.txtNameOfRestorant)).getText().toString();
                String txtAddress = ((TextView) view.findViewById(R.id.txtAddressOfRestorant)).getText().toString();
                String txtDetail  = ((TextView) view.findViewById(R.id.txtDetailOfRestorant)).getText().toString();
                String txtPic     = ((TextView) view.findViewById(R.id.txtPicOfRestorant)).getText().toString();

                RestaurantDetailFragment restaurantDetailFragment = new RestaurantDetailFragment();
                Bundle arguments = new Bundle();
                arguments.putString("Id", txtId);
                arguments.putString("Name", txtName);
                arguments.putString("Address", txtAddress);
                arguments.putString("Detail", txtDetail);
                arguments.putString("Pic", txtPic);
                restaurantDetailFragment.setArguments(arguments);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.activityslidein, R.anim.activityslideinout, R.anim.activityslideoutpop, R.anim.activityslideout)
                        .add(R.id.container, restaurantDetailFragment, "restaurantdetailfragment")
                        .addToBackStack("restaurantdetailfragment")
                        .commit();
            }
        });

        return view;
    }

    // Get data from database SQLite
    private void getListRestaurant() {
        restaurantDB = new RestaurantDB(getActivity().getApplicationContext());
        adapter      = new RestaurantAdapter(getActivity());
        db 			 = restaurantDB.getWritableDatabase();
        restaurantDB.createTable(db, getActivity().getBaseContext());
    }

    // We need to refresh adapter for every data update. Without it, ListView will never be refreshed
    protected void refreshListAdapter(String categori) {
        try {
            getListRestaurant();
        } catch(Exception e) {
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        } finally {
            listRestaurant = restaurantDB.toArray(categori);
            adapter.updatelistRestaurant(listRestaurant);
            lsvRestaurantView.setAdapter(adapter);
        }
    }

}