package com.android.khosbayar.favwebsbyhs.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.khosbayar.favwebsbyhs.R;
import com.android.khosbayar.favwebsbyhs.WebViewActivity;
import com.android.khosbayar.favwebsbyhs.model.ViewHolder;
import com.android.khosbayar.favwebsbyhs.model.WebLink;

import java.util.ArrayList;

/**
 * Created by khosbayar on 4/10/18.
 */

public class WebLinkAdapter extends BaseAdapter {
    private ArrayList<WebLink> webLinks;
    private Context mContext;
    private static LayoutInflater inflater = null;


    public WebLinkAdapter(Context context, ArrayList<WebLink> webLinks) {
        this.webLinks = webLinks;
        this.mContext = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return webLinks.size();
    }

    @Override
    public Object getItem(int position) {
        return webLinks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        View rowView;

        rowView = inflater.inflate(R.layout.row_weblink, null);

        holder.mWebLinkSrc = (ImageView) rowView.findViewById(R.id.ivLinkImg);
        holder.mWebLinkGo = (ImageView) rowView.findViewById(R.id.ivLinkGo);
        holder.mWebLinkTitle = (TextView) rowView.findViewById(R.id.tvLinkTitle);

        final WebLink webLink = webLinks.get(position);

        holder.mWebLinkSrc.setImageResource(webLink.getSrc());
        holder.mWebLinkTitle.setText(webLink.getTitle());
        holder.mWebLinkGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext.getApplicationContext(), WebViewActivity.class);
                intent.putExtra("weblink", webLink);
                mContext.startActivity(intent);
            }
        });


        return rowView;
    }
}
