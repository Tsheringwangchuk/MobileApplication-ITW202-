package edu.gcit.to_do_18;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class sportsAdapter extends RecyclerView.Adapter<sportsAdapter.ViewHolder> {
    private ArrayList<sports> mSportsData;
    private Context mContext;

    sportsAdapter(Context context, ArrayList<sports> sportsData)
    {
        this.mSportsData = sportsData;
        this.mContext = context;
    }

    @Override
    public sportsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.listitem, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull sportsAdapter.ViewHolder holder, int position) {
        //get current sports
        sports currentsport = mSportsData.get(position);
        //populate the textview with data
        holder.bindTo(currentsport);


    }

    @Override
    public int getItemCount() {
        return mSportsData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mimageView;

         ViewHolder(@NonNull View itemView) {
            super(itemView);

            //initialize the view
            mTitleText = itemView.findViewById(R.id.title);
            mInfoText = itemView.findViewById(R.id.subtitle);
            mimageView = itemView.findViewById(R.id.imagesports);
        }

        void bindTo(sports CurrentSport)
        {

            mTitleText.setText(CurrentSport.getTitle());
            mInfoText.setText(CurrentSport.getInfo());
            Glide.with(mContext).load(CurrentSport.getImageResources()).into(mimageView);

        }

    }
}
