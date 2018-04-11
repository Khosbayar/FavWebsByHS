package com.android.khosbayar.favwebsbyhs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.khosbayar.favwebsbyhs.adapter.WebLinkAdapter;
import com.android.khosbayar.favwebsbyhs.model.WebLink;

import java.util.ArrayList;

public class WebViewFragment extends Fragment {

    private ArrayList<WebLink> webLinks;
    private ListView mWebLinks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        webLinks = new ArrayList<>();

        String cat = "";
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            cat = bundle.getString("category");
        }
        if (cat.equals("personal")) {
            populatePersonalWebLinks();
        } else if (cat.equals("music")) {
            populateMusicWebLinks();
        } else if (cat.equals("software")) {
            populateSoftwareWebLinks();
        }

        View view = inflater.inflate(R.layout.fragment_personal, container, false);


        mWebLinks = (ListView) view.findViewById(R.id.lvWebLinks);
        mWebLinks.setAdapter(new WebLinkAdapter(getContext(), webLinks));

        return view;
    }

    private void populateMusicWebLinks() {
        webLinks.add(new WebLink("Spotify - Music for everyone", "https://www.spotify.com", R.drawable.spotify));
        webLinks.add(new WebLink("Youtube - Enjoy the videos and music you love", "https://www.youtube.com", R.drawable.youtube));
        webLinks.add(new WebLink("Soundcloud - Listen to free music and postcast", "https://www.soundcloud.com", R.drawable.soundcloud));
    }

    private void populateSoftwareWebLinks() {
        webLinks.add(new WebLink("Best Buy - Expert Service. Unbeatable Price", "https://www.bestbuy.com", R.drawable.bestbuy));
        webLinks.add(new WebLink("FileHippo.com - Download Free Software", "https://www.filehippo.com", R.drawable.filehippo));
        webLinks.add(new WebLink("Microsoft - Store & Support. Account profile · Download Center · Sales & support", "https://www.microsoft.com/en-us/software-download/", R.drawable.microsoft));
    }


    private void populatePersonalWebLinks() {
        webLinks.add(new WebLink("Android Hive - Android development tutorials", "https://www.androidhive.com", R.drawable.androidhive));
        webLinks.add(new WebLink("Hacker Rank - Practice coding. Compete. Find jobs", "https://www.hackerrank.com", R.drawable.hackerrank));
        webLinks.add(new WebLink("Leetcode - A New Way to Learn", "https://www.leetcode.com", R.drawable.leetcode));
    }
}
