package google.my.myapplication.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import google.my.myapplication.R;
import google.my.myapplication.trip.TripDetails;

//create a class that extends RecyclerView.Adapter<GiftViewHolder>
public class HolidayAdapter extends RecyclerView.Adapter<HolidayViewHolder> {
    private List<Holiday> mHolidays;
    private Context mContext;

    public HolidayAdapter(List<Holiday> holidays, Context context) {
        mHolidays = holidays;
        mContext = context;
    }

    public HolidayAdapter(List<Holiday> holidays) {
        mHolidays = holidays;
    }

    @NonNull
    @Override
    public HolidayViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View holidayView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.holiday_item, viewGroup, false);
        return new HolidayViewHolder(holidayView);
    }

    @Override
    public void onBindViewHolder(@NonNull HolidayViewHolder holidayViewHolder, int i) {
        Holiday holiday = mHolidays.get(i);
        holidayViewHolder.mTextViewName.setText(holiday.getName());
        holidayViewHolder.mTextViewDestination.setText(holiday.getDestination());
        holidayViewHolder.mTextViewRating.setText(holiday.getRating());
        Picasso.get().load(holiday.getPicture())
                .into(holidayViewHolder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mHolidays.size();
    }
}
