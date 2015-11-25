package com.jsfood.adapter;

import java.util.ArrayList;

import com.jsfood.FontCache;
import com.jsfood.R;
import com.jsfood.model.Restaurant;
import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RestaurantAdapter extends BaseAdapter {
	private ArrayList<Restaurant> listRestaurant = null;
	private static LayoutInflater inflater = null;
	private Context context;
    private Typeface fontLemonMilk, fontHabibi;
	
	public RestaurantAdapter(Activity activity) {
		inflater      = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		context       = activity.getApplicationContext();
        fontLemonMilk = FontCache.get(this.context, "LemonMilk");
        fontHabibi    = FontCache.get(this.context, "Habibi-Regular");
	}

	public void updatelistRestaurant(ArrayList<Restaurant> newListBook) {
		this.listRestaurant = newListBook;
	}

	@Override
	public int getCount() {
		return this.listRestaurant.size();
	}

	@Override
	public Restaurant getItem(int position) {
		return this.listRestaurant.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		View vi = view;
		if (vi == null) {
			vi = inflater.inflate(R.layout.list_item, null);
		}

		Restaurant psn = this.listRestaurant.get(position);

        TextView txtPic     = (TextView) vi.findViewById(R.id.txtPicOfRestorant);
		TextView txtName    = (TextView) vi.findViewById(R.id.txtNameOfRestorant);
		TextView txtAddress = (TextView) vi.findViewById(R.id.txtAddressOfRestorant);
		TextView txtDetail  = (TextView) vi.findViewById(R.id.txtDetailOfRestorant);
		TextView txtId      = (TextView) vi.findViewById(R.id.txtIdOfRestorant);
		ImageView imgPic    = (ImageView) vi.findViewById(R.id.picOfRestorant);

        txtName.setTypeface(fontLemonMilk);
        txtAddress.setTypeface(fontHabibi);

        txtPic.setText(psn.getPic());
		txtName.setText(psn.getName());
		txtAddress.setText(psn.getAddress());
		txtDetail.setText(psn.getDetail());
		txtId.setText(psn.getId());
		
		String PACKAGE_NAME = context.getPackageName();
		int imgId = context.getResources().getIdentifier(PACKAGE_NAME+":drawable/"+psn.getPic() , null, null);
		imgPic.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), imgId));
			
		return vi;
	}
}