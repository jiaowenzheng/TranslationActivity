package com.translation.javajetpack;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class ProductSalePromotionModel extends BaseBean implements Parcelable {

    private long id;
    private String title;
    private String discountContent;
    private String time;

    private List<CouponInfo> couponInfo;

    public ProductSalePromotionModel() {
    }


    protected ProductSalePromotionModel(Parcel in) {
        id = in.readLong();
        title = in.readString();
        discountContent = in.readString();
        time = in.readString();
        couponInfo = in.createTypedArrayList(CouponInfo.CREATOR);
    }

    public static final Creator<ProductSalePromotionModel> CREATOR = new Creator<ProductSalePromotionModel>() {
        @Override
        public ProductSalePromotionModel createFromParcel(Parcel in) {
            return new ProductSalePromotionModel(in);
        }

        @Override
        public ProductSalePromotionModel[] newArray(int size) {
            return new ProductSalePromotionModel[size];
        }
    };

    @JSONField(name="sp_id")
    public long getId() {
        return id;
    }
    @JSONField(name="sp_id")
    public void setId(long id) {
        this.id = id;
    }
    @JSONField(name="sp_title")
    public String getTitle() {
        return title;
    }
    @JSONField(name="sp_title")
    public void setTitle(String title) {
        this.title = title;
    }
    @JSONField(name="sp_name")
    public String getDiscountContent() {
        return discountContent;
    }
    @JSONField(name="sp_name")
    public void setDiscountContent(String discountContent) {
        this.discountContent = discountContent;
    }
    @JSONField(name="sp_time")
    public String getTime() {
        return time;
    }
    @JSONField(name="sp_time")
    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(title);
        dest.writeString(discountContent);
        dest.writeString(time);
        dest.writeTypedList(couponInfo);
    }

    @JSONField(name = "sp_level")
    public List<CouponInfo> getCouponInfo() {
        return couponInfo;
    }

    @JSONField(name = "sp_level")
    public void setCouponInfo(List<CouponInfo> couponInfo) {
        this.couponInfo = couponInfo;
    }

    public static class CouponInfo extends BaseBean implements Parcelable, Comparable<CouponInfo> {

        /**
         * title : 满88减80
         * coupon_price : 80
         * min_price : 88
         * coupon_id : 2019101613574864432
         */

        private String title;
        private int couponPrice;
        private int minPrice;

        public CouponInfo() {
        }

        protected CouponInfo(Parcel in) {
            title = in.readString();
            couponPrice = in.readInt();
            minPrice = in.readInt();
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(title);
            dest.writeInt(couponPrice);
            dest.writeInt(minPrice);
        }

        public static final Creator<CouponInfo> CREATOR = new Creator<CouponInfo>() {
            @Override
            public CouponInfo createFromParcel(Parcel in) {
                return new CouponInfo(in);
            }

            @Override
            public CouponInfo[] newArray(int size) {
                return new CouponInfo[size];
            }
        };

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @JSONField(name = "coupon_price")
        public int getCouponPrice() {
            return couponPrice;
        }

        @JSONField(name = "coupon_price")
        public void setCouponPrice(int couponPrice) {
            this.couponPrice = couponPrice;
        }

        @JSONField(name = "min_price")
        public int getMinPrice() {
            return minPrice;
        }

        @JSONField(name = "min_price")
        public void setMinPrice(int minPrice) {
            this.minPrice = minPrice;
        }

        @Override
        public int compareTo(@NonNull CouponInfo info) {
            if(minPrice > info.minPrice){
                return -1;
            }
            return 1;
        }
    }
}
