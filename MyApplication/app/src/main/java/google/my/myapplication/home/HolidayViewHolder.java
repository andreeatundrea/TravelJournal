package google.my.myapplication.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import google.my.myapplication.R;

//create a class ViewHolder that extends RecyclerView.ViewHolder
//this class is associated to the item
public class HolidayViewHolder extends RecyclerView.ViewHolder {

    public ImageView mImageView;
    public TextView mTextViewName;
    public TextView mTextViewDestination;
    public TextView mTextViewRating;

    public HolidayViewHolder(@NonNull View itemView) {
        super(itemView);

        mImageView = itemView.findViewById(R.id.imageview_picture);
        mTextViewName = itemView.findViewById(R.id.textview_name);
        mTextViewDestination = itemView.findViewById(R.id.textview_destination);
        mTextViewRating = itemView.findViewById(R.id.textview_rating);
    }
}
