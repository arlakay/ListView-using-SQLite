package com.jsfood;

import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RestaurantDetailFragment extends Fragment  {

    private Typeface fontLemonMilk, fontHabibi;
    private String Id, Name, Address, Detail, Pic;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view     = inflater.inflate(R.layout.restaurant_detail_fragment, container, false);

        fontLemonMilk       = FontCache.get(getActivity().getApplicationContext(), "LemonMilk");
        fontHabibi          = FontCache.get(getActivity().getApplicationContext(), "Habibi-Regular");
        Id                  = getArguments().getString("Id");
        Name                = getArguments().getString("Name");
        Address             = getArguments().getString("Address");
        Detail              = getArguments().getString("Detail");
        Pic                 = getArguments().getString("Pic");

        TextView txtName    = (TextView) view.findViewById(R.id.txtNameOfRestorant);
        TextView txtAddress = (TextView) view.findViewById(R.id.txtAddressOfRestorant);
        TextView txtDetail  = (TextView) view.findViewById(R.id.txtDetailOfRestorant);
        ImageView imgPic    = (ImageView) view.findViewById(R.id.picOfRestorant);

        txtName.setTypeface(fontLemonMilk);
        txtAddress.setTypeface(fontHabibi);
        txtDetail.setTypeface(fontHabibi);

        txtName.setText(Name);
        txtAddress.setText(Address);
        txtDetail.setText(Detail);

        String PACKAGE_NAME = getActivity().getApplicationContext().getPackageName();
        int imgId = getActivity().getApplicationContext().getResources().getIdentifier(PACKAGE_NAME+":drawable/"+Pic , null, null);
        imgPic.setImageBitmap(BitmapFactory.decodeResource(getActivity().getApplicationContext().getResources(), imgId));

        return view;
    }

}