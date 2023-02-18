package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    ImageSlider imageSlider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        imageSlider = view.findViewById(R.id.image_slider);
        LoadImageSlider();
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        MusicFragment musicFragment = new MusicFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("TypeMusic", 0);

        musicFragment.setArguments(bundle);
        ft.replace(R.id.fragmentBaihat, musicFragment);
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the changes added above
        ft.commit();
        // Inflate the layout for this fragment
        return view;

    }

    @Override
    public void onDestroyView() {
        FragmentManager mFragmentMgr = getChildFragmentManager();
        FragmentTransaction mTransaction = mFragmentMgr.beginTransaction();
        Fragment childFragment = mFragmentMgr.findFragmentById(R.id.fragmentBaihat);
        assert childFragment != null;
        mTransaction.remove(childFragment);
        mTransaction.commit();
        super.onDestroyView();
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