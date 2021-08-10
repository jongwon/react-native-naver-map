package com.github.quadflask.react.navermap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.naver.maps.map.overlay.InfoWindow;

public class BowlingPlaceMarker extends InfoWindow.ViewAdapter{

    Context context;
    MPlaceVO vo;

    public BowlingPlaceMarker(Context context, MPlaceVO vo) {
        this.context = context;
        this.vo = vo;
    }

    @NonNull
    @Override
    public View getView(@NonNull InfoWindow infoWindow) {
        LayoutInflater li = LayoutInflater.from(context);
        View view = li.inflate(R.layout.bowling_place_marker, null);
        LinearLayout linearLayout = view.findViewById(R.id.place_marker_background);
        if("Y".equals(vo.getFranchisee())) {
            linearLayout.setBackgroundResource(R.drawable.box_on_109x72);
        }else{
            linearLayout.setBackgroundResource(R.drawable.box_off_109x72);
        }
        ((TextView)view.findViewById(R.id.placeTitle)).setText(vo.getName());
        ((TextView)view.findViewById(R.id.bookingTimeCount)).setText(""+vo.getBookingTimeCount());
        ((TextView)view.findViewById(R.id.laneCounts)).setText(vo.getLanes() + " 레인");

        // TODO : 주차장 여부
        if(vo.getParking()<1){
            view.findViewById(R.id.parkingImage).setVisibility(View.GONE);
        }else{
            view.findViewById(R.id.parkingImage).setVisibility(View.VISIBLE);
        }

        return view;
    }

}
