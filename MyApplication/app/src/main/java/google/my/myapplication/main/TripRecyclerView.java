package google.my.myapplication.main;

import android.support.v4.app.Fragment;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import google.my.myapplication.R;
import google.my.myapplication.home.Holiday;
import google.my.myapplication.home.HolidayAdapter;
import google.my.myapplication.trip.TripDetails;

public class TripRecyclerView extends Fragment {

    private List<Holiday> mTrips = new ArrayList<>();
    public static TripRecyclerView newInstance(){
        TripRecyclerView trip = new TripRecyclerView();
        return trip;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View rootView=inflater.inflate(R.layout.activity_trip_recycler_view,null);
        RecyclerView rv=(RecyclerView) rootView.findViewById(R.id.list_recyclerview);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new HolidayAdapter(getHolidaysList(),getActivity()));


        return rootView;

    }
    public String toString(){
        return "TripRecyclerViewActivity";
    }

    private List<Holiday> getHolidaysList() {
        List<Holiday> holidays = new ArrayList<>();
        Holiday holiday1 = new Holiday("Spring 2015", "Italy", "4.0/5.0",
                "https://images.unsplash.com/photo-1510546462255-979b0e0ca1b5?w=800&q=60");
        Holiday holiday2 = new Holiday("Summer 2015", "Bora Bora", "5.0/5.0",
                "https://images.unsplash.com/photo-1510546462255-979b0e0ca1b5?w=800&q=60");
        Holiday holiday3 = new Holiday("Winter 2015", "Switzerland", "4.5/5.0",
                "https://images.unsplash.com/photo-1510546462255-979b0e0ca1b5?w=800&q=60");
        Holiday holiday4 = new Holiday("Summer 2016", "Italy", "3.0/5.0",
                "https://images.unsplash.com/photo-1510546462255-979b0e0ca1b5?w=800&q=60");
        Holiday holiday5 = new Holiday("Winter 2016", "Romania", "4.0/5.0",
                "https://images.unsplash.com/photo-1510546462255-979b0e0ca1b5?w=800&q=60");
        Holiday holiday6 = new Holiday("Summer 2017", "Spain", "5.0/5.0",
                "https://images.unsplash.com/photo-1510546462255-979b0e0ca1b5?w=800&q=60");
        Holiday holiday7 = new Holiday("Winter 2017", "USA", "5.0/5.0",
                "https://images.unsplash.com/photo-1510546462255-979b0e0ca1b5?w=800&q=60");
        Holiday holiday8 = new Holiday("Spring 2018", "Greece", "4.0/5.0",
                "https://images.unsplash.com/photo-1510546462255-979b0e0ca1b5?w=800&q=60");
        Holiday holiday9 = new Holiday("Summer 2018", "Bulgaria", "3.0/5.0",
                "https://images.unsplash.com/photo-1510546462255-979b0e0ca1b5?w=800&q=60");
        Holiday holiday10 = new Holiday("Winter 2018", "Poland", "3.0/5.0",
                "https://images.unsplash.com/photo-1510546462255-979b0e0ca1b5?w=800&q=60");
        holidays.add(holiday1);
        holidays.add(holiday2);
        holidays.add(holiday3);
        holidays.add(holiday4);
        holidays.add(holiday5);
        holidays.add(holiday6);
        holidays.add(holiday7);
        holidays.add(holiday8);
        holidays.add(holiday9);
        holidays.add(holiday10);
        return holidays;
    }
}
