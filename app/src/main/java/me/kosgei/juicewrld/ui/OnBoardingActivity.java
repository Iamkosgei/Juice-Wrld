package me.kosgei.juicewrld.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.chyrta.onboarder.OnboarderActivity;
import com.chyrta.onboarder.OnboarderPage;
import com.codemybrainsout.onboarder.AhoyOnboarderActivity;
import com.codemybrainsout.onboarder.AhoyOnboarderCard;

import java.util.ArrayList;
import java.util.List;

import me.kosgei.juicewrld.R;

public class OnBoardingActivity extends AppCompatActivity {
    List<OnboarderPage> onboarderPages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);


//        onboarderPages = new ArrayList<OnboarderPage>();
//
//
//        // Create your first page
//        OnboarderPage onboarderPage1 = new OnboarderPage("Title 1", "Description 1");
//        OnboarderPage onboarderPage2 = new OnboarderPage("Title z ", "blah blah blah", R.drawable.natural);
//
//        // You can define title and description colors (by default white)
//        onboarderPage1.setTitleColor(R.color.black);
//        onboarderPage1.setDescriptionColor(R.color.white);
//
//        // Don't forget to set background color for your page
//        onboarderPage1.setBackgroundColor(R.color.design_default_color_background);
//
//        // Add your pages to the list
//        onboarderPages.add(onboarderPage1);
//        onboarderPages.add(onboarderPage2);
//
//        // And pass your pages to 'setOnboardPagesReady' method
//        setOnboardPagesReady(onboarderPages);


//        AhoyOnboarderCard ahoyOnboarderCard1 = new AhoyOnboarderCard("Healthy", "Organic fruits", R.drawable.natural);
//        ahoyOnboarderCard1.setBackgroundColor(R.color.black_transparent);
//        ahoyOnboarderCard1.setTitleColor(R.color.white);
//        ahoyOnboarderCard1.setDescriptionColor(R.color.grey_200);
//        ahoyOnboarderCard1.setTitleTextSize(dpToPixels(10, this));
//        ahoyOnboarderCard1.setDescriptionTextSize(dpToPixels(8, this));
//        ahoyOnboarderCard1.setIconLayoutParams(100, 100, 50, 50, 50, 50);
//
//
//        AhoyOnboarderCard ahoyOnboarderCard2 = new AhoyOnboarderCard("Healthy", "Organic fruits", R.drawable.natural);
//        ahoyOnboarderCard2.setBackgroundColor(R.color.black_transparent);
//        ahoyOnboarderCard2.setTitleColor(R.color.white);
//        ahoyOnboarderCard2.setDescriptionColor(R.color.grey_200);
//        ahoyOnboarderCard2.setTitleTextSize(dpToPixels(10, this));
//        ahoyOnboarderCard2.setDescriptionTextSize(dpToPixels(8, this));
//        ahoyOnboarderCard2.setIconLayoutParams(100, 100, 50, 50, 50, 50);
//
//
//        AhoyOnboarderCard ahoyOnboarderCard3 = new AhoyOnboarderCard("Healthy", "Organic fruits", R.drawable.natural);
//        ahoyOnboarderCard3.setBackgroundColor(R.color.black_transparent);
//        ahoyOnboarderCard3.setTitleColor(R.color.white);
//        ahoyOnboarderCard3.setDescriptionColor(R.color.grey_200);
//        ahoyOnboarderCard3.setTitleTextSize(dpToPixels(10, this));
//        ahoyOnboarderCard3.setDescriptionTextSize(dpToPixels(8, this));
//        ahoyOnboarderCard3.setIconLayoutParams(100, 100, 50, 50, 50, 50);
//
//
//        List<AhoyOnboarderCard> pages = new ArrayList<>();
//        pages.add(ahoyOnboarderCard1);
//        pages.add(ahoyOnboarderCard2);
//        pages.add(ahoyOnboarderCard3);
//
//        setOnboardPages(pages);
//
//        setColorBackground(R.color.colorPrimary);



    }

//    @Override
//    public void onFinishButtonPressed() {
//        startActivity(new Intent(this, LoginSignUpActivity.class));
//
//    }

//    @Override
//    public void onFinishButtonPressed() {
//        startActivity(new Intent(this, LoginSignUpActivity.class));
//
//    }

}
