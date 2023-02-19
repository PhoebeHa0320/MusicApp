package com.example.myapplication.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ExploreFragment extends Fragment {
    ImageSlider imageSlider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_explore, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageSlider = view.findViewById(R.id.image_slider);
        LoadImageSlider();


    }
    private void LoadImageSlider() {
        //image slider
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.slide1, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.slide2, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.slide3, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.slide4, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.slide5, ScaleTypes.CENTER_CROP));
        imageSlider.setImageList(slideModels);
        Log.d("Hannh", "LoadImageSlider: "+ slideModels);
    }
}