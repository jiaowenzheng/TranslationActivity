package com.translation.javajetpack;

import android.os.Parcel;
import android.os.Parcelable;

class DouSuoModel extends BaseBean implements Parcelable {
    /**
     * show_duosuo_id : 792
     * goods_id : 1096096
     * user_id : 163
     * user_nickname : 喵喵喵？？？
     * user_img : http://img8.ontheroadstore.com/iosupload/20190626/Mk1oVnZ1QUVkRXpXdGg1eTNKTktrdz09.jpg
     * created_at : 1577083965
     */

    private long show_duosuo_id;
    private int goods_id;
    private long user_id;
    private String user_nickname;
    private String signature;
    private String user_img;
    private String created_at;
    private String desc;

    public DouSuoModel() {
    }

    protected DouSuoModel(Parcel in) {
        show_duosuo_id = in.readLong();
        goods_id = in.readInt();
        user_id = in.readLong();
        user_nickname = in.readString();
        user_img = in.readString();
        created_at = in.readString();
        signature = in.readString();
        desc = in.readString();
    }

    public static final Creator<DouSuoModel> CREATOR = new Creator<DouSuoModel>() {
        @Override
        public DouSuoModel createFromParcel(Parcel in) {
            return new DouSuoModel(in);
        }

        @Override
        public DouSuoModel[] newArray(int size) {
            return new DouSuoModel[size];
        }
    };

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public long getShow_duosuo_id() {
        return show_duosuo_id;
    }

    public void setShow_duosuo_id(long show_duosuo_id) {
        this.show_duosuo_id = show_duosuo_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(show_duosuo_id);
        dest.writeInt(goods_id);
        dest.writeLong(user_id);
        dest.writeString(user_nickname);
        dest.writeString(user_img);
        dest.writeString(created_at);
        dest.writeString(signature);
        dest.writeString(desc);
    }
}
