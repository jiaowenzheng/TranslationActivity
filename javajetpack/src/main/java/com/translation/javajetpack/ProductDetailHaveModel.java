package com.translation.javajetpack;

import android.os.Parcel;
import android.os.Parcelable;

import com.alibaba.fastjson.annotation.JSONField;


import java.util.List;

public class ProductDetailHaveModel extends BaseBean implements Parcelable {

    private int is_have;
    @JSONField(name = "have_count")
    private int haveCount;
    @JSONField(name = "have_list")
    private List<DouSuoModel> haveList;

    public ProductDetailHaveModel() {
    }

    protected ProductDetailHaveModel(Parcel in) {
        is_have = in.readInt();
        haveCount = in.readInt();
        haveList = in.createTypedArrayList(DouSuoModel.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(is_have);
        dest.writeInt(haveCount);
        dest.writeTypedList(haveList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProductDetailHaveModel> CREATOR = new Creator<ProductDetailHaveModel>() {
        @Override
        public ProductDetailHaveModel createFromParcel(Parcel in) {
            return new ProductDetailHaveModel(in);
        }

        @Override
        public ProductDetailHaveModel[] newArray(int size) {
            return new ProductDetailHaveModel[size];
        }
    };

    public int getIs_have() {
        return is_have;
    }

    public void setIs_have(int is_have) {
        this.is_have = is_have;
    }

    public int getHaveCount() {
        return haveCount;
    }

    public void setHaveCount(int haveCount) {
        this.haveCount = haveCount;
    }

    public List<DouSuoModel> getHaveList() {
        return haveList;
    }

    public void setHaveList(List<DouSuoModel> haveList) {
        this.haveList = haveList;
    }
}
