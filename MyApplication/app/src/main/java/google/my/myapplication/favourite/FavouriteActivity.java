package google.my.myapplication.favourite;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import google.my.myapplication.R;
import google.my.myapplication.home.Holiday;
import google.my.myapplication.home.HolidayAdapter;
import google.my.myapplication.trip.TripDetails;

public class FavouriteActivity extends Fragment {


    private List<Holiday> mHolidays= new ArrayList<>();

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Task mQuery=db.collection("favourite")
            .get()
            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            // Trip trip=  (Trip)document.getData();
                            //mTrips.add(trip);
                            String nume=document.getString("tripName");
                            String location=document.getString("destination");
                            String picture=document.getString("image");
                            String enddate = document.getString("endDate");
                            String startdate = document.getString("startDate");
                            String raiting = document.getString("raiting");
                            String triptype = document.getString("tripType");
                            double price=document.getDouble("price");
                           // TripDetails trip = new TripDetails(nume, location, startdate, enddate, triptype, raiting, price, picture );
                            Holiday holiday = new Holiday(nume, location, raiting, picture);
                            mHolidays.add(holiday);


                        }
                    }
                }
            });

    public static Fragment newInstance(){
        FavouriteActivity fav = new FavouriteActivity();
        return fav;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View rootView=inflater.inflate(R.layout.activity_favourite,null);
        RecyclerView rv=(RecyclerView) rootView.findViewById(R.id.favourite_recyclerview);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new HolidayAdapter(mHolidays,getActivity()));
        return rootView;

    }
    public String toString(){
        return "FavouriteFragment";
    }

}
