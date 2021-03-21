package com.translation.javajetpack;

import android.os.Parcel;
import android.os.Parcelable;

public class HomeTagModel extends BaseBean implements Parcelable {


    /**
     * id : 1
     * title : 限时
     * count_down : 1581645600
     * icon : http://img8.ontheroadstore.com/static/tags/2.gif
     */

    private int id;
    private String title;
    private long count_down;
    private String icon;

    public HomeTagModel() {
    }

    protected HomeTagModel(Parcel in) {
        id = in.readInt();
        title = in.readString();
        count_down = in.readLong();
        icon = in.readString();
    }

    public static final Creator<HomeTagModel> CREATOR = new Creator<HomeTagModel>() {
        @Override
        public HomeTagModel createFromParcel(Parcel in) {
            return new HomeTagModel(in);
        }

        @Override
        public HomeTagModel[] newArray(int size) {
            return new HomeTagModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCount_down() {
        return count_down;
    }

    public void setCount_down(long count_down) {
        this.count_down = count_down;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeLong(count_down);
        dest.writeString(icon);
    }
}
