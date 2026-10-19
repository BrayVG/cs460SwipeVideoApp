package com.example.swipevideoapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // the pager that lets the user swipe
        final ViewPager2 videoViewPager = findViewById(R.id.videosViewPager);

        // Build the list of videos to display
        List<VideoItem> videoItemsList = new ArrayList<>();

        VideoItem video1 = new VideoItem();
        video1.videoURL = "https://github.com/BrayVG/VideoDemo/raw/refs/heads/main/dogvideo.mp4";
        video1.videoTitle = "Playful dog!";
        video1.videoDescription = "He's just a dog!!";
        videoItemsList.add(video1);

        VideoItem video2 = new VideoItem();
        video2.videoURL = "https://github.com/BrayVG/VideoDemo/raw/refs/heads/main/dancedogvid.mp4";
        video2.videoTitle = "Dancing Dog!";
        video2.videoDescription = "not AI";
        videoItemsList.add(video2);

        VideoItem video3 = new VideoItem();
        video3.videoURL = "https://github.com/BrayVG/VideoDemo/raw/refs/heads/main/swimdogvid.mp4";
        video3.videoTitle = "Swim";
        video3.videoDescription = "Summer vibes!!";
        videoItemsList.add(video3);

        VideoItem video4 = new VideoItem();
        video4.videoURL = "https://github.com/BrayVG/VideoDemo/raw/refs/heads/main/dog2vid.mp4";
        video4.videoTitle = "Dog";
        video4.videoDescription = "happy dog, happy life";
        videoItemsList.add(video4);

        // connects the video list to the pager using the adapter
        videoViewPager.setAdapter(new VideoAdapter(videoItemsList));

    }
}