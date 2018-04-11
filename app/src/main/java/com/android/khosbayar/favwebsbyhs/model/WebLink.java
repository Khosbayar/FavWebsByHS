package com.android.khosbayar.favwebsbyhs.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by khosbayar on 4/10/18.
 */

public class WebLink implements Parcelable {
    private String title, link;
    private int src;

    public WebLink(String title, String link, int src) {
        this.title = title;
        this.link = link;
        this.src = src;
    }

    public WebLink(Parcel in) {
        this.title = in.readString();
        this.link = in.readString();
        this.src = in.readInt();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public WebLink createFromParcel(Parcel in) {
            return new WebLink(in);
        }

        public WebLink[] newArray(int size) {
            return new WebLink[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.link);
        dest.writeInt(this.src);
    }
}
