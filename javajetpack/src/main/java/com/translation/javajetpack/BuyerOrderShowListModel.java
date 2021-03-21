package com.translation.javajetpack;

import android.os.Parcel;
import android.os.Parcelable;

import com.alibaba.fastjson.annotation.JSONField;


import java.io.Serializable;
import java.util.List;

public class BuyerOrderShowListModel extends BaseBean {


    /**
     * show_list : [{"order_id":18679,"show_id":767,"created_at":"2019-12-10","show_text":"路X5KKK","maijiashow":1,"count_zan":0,"count_reply":0,"goods_id":1095911,"zhuiping_id":0,"video_list":[{"cover":"http://video1.ontheroadstore.com//show/cover/6ffc4dae-0920-4a92-b137-2d1e898a3038.jpg","video":"http://video1.ontheroadstore.com/show/m3u8/640/6ffc4dae-0920-4a92-b137-2d1e898a3038.m3u8"}],"is_video":1}]
     * goods_info : {"id":1095911,"cover":"http://img8.ontheroadstore.com/upload/190110/aad142525d09d0007b1b3dc8c3d387b3.jpg","title":"55555555554","post_subtitle":""}
     * user_info : {"user_nickname":"黑客","user_id":554,"user_img":"http://img8.ontheroadstore.com/iosupload/20190626/RjFzZlM0L29wcG1mZWM2V25vbW4zdz09.jpg"}
     */

    private GoodsInfoBean goodsInfo;
    private UserInfoBean userInfo;
    private List<ShowListBean> showList;

    @JSONField(name = "goods_info")
    public GoodsInfoBean getGoodsInfo() {
        return goodsInfo;
    }

    @JSONField(name = "goods_info")
    public void setGoodsInfo(GoodsInfoBean goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    @JSONField(name = "user_info")
    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    @JSONField(name = "user_info")
    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    @JSONField(name = "show_list")
    public List<ShowListBean> getShowList() {
        return showList;
    }

    @JSONField(name = "show_list")
    public void setShowList(List<ShowListBean> showList) {
        this.showList = showList;
    }

    public static class GoodsInfoBean extends BaseBean implements Parcelable{
        /**
         * id : 1095911
         * cover : http://img8.ontheroadstore.com/upload/190110/aad142525d09d0007b1b3dc8c3d387b3.jpg
         * title : 55555555554
         * post_subtitle :
         */

        private int id;
        private String cover;
        private String title;
        private String post_subtitle;
        private List<Integer> price;
        private boolean isChecked;

        public GoodsInfoBean() {
        }

        protected GoodsInfoBean(Parcel in) {
            id = in.readInt();
            cover = in.readString();
            title = in.readString();
            post_subtitle = in.readString();
            isChecked = in.readByte() != 0;
            price = (List<Integer>) in.readSerializable();
        }

        public static final Creator<GoodsInfoBean> CREATOR = new Creator<GoodsInfoBean>() {
            @Override
            public GoodsInfoBean createFromParcel(Parcel in) {
                return new GoodsInfoBean(in);
            }

            @Override
            public GoodsInfoBean[] newArray(int size) {
                return new GoodsInfoBean[size];
            }
        };

        public boolean isChecked() {
            return isChecked;
        }

        public void setChecked(boolean checked) {
            isChecked = checked;
        }

        public List<Integer> getPrice() {
            return price;
        }

        public void setPrice(List<Integer> price) {
            this.price = price;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPost_subtitle() {
            return post_subtitle;
        }

        public void setPost_subtitle(String post_subtitle) {
            this.post_subtitle = post_subtitle;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeString(cover);
            dest.writeString(title);
            dest.writeString(post_subtitle);
            dest.writeByte((byte) (isChecked ? 1 : 0));
            dest.writeSerializable((Serializable) price);
        }
    }

    public static class UserInfoBean extends BaseBean{
        /**
         * user_nickname : 黑客
         * user_id : 554
         * user_img : http://img8.ontheroadstore.com/iosupload/20190626/RjFzZlM0L29wcG1mZWM2V25vbW4zdz09.jpg
         */

        private String user_nickname;
        private int user_id;
        private String user_img;

        public String getUser_nickname() {
            return user_nickname;
        }

        public void setUser_nickname(String user_nickname) {
            this.user_nickname = user_nickname;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getUser_img() {
            return user_img;
        }

        public void setUser_img(String user_img) {
            this.user_img = user_img;
        }
    }

    public static class ShowListBean extends BaseBean  {
        /**
         * order_id : 18679
         * show_id : 767
         * created_at : 2019-12-10
         * show_text : 路X5KKK
         * maijiashow : 1
         * count_zan : 0
         * count_reply : 0
         * goods_id : 1095911
         * zhuiping_id : 0
         * video_list : [{"cover":"http://video1.ontheroadstore.com//show/cover/6ffc4dae-0920-4a92-b137-2d1e898a3038.jpg","video":"http://video1.ontheroadstore.com/show/m3u8/640/6ffc4dae-0920-4a92-b137-2d1e898a3038.m3u8"}]
         * is_video : 1
         */
        private int ratio;
        private int order_id;
        private int show_id;
        private String created_at;
        private String show_text;
        private int maijiashow;
        private int count_zan;
        private int count_reply;
        private int goods_id;
        private int zhuiping_id;
        private int is_video;
        private int is_zan;
        private int is_anonymous;
        private List<VideoListBean> videoList;
        private List<String> imageList;


        private int order_goods_count;
        private int user_id;
        private String user_nickname;
        private String user_img;

        public int getOrder_goods_count() {
            return order_goods_count;
        }

        public void setOrder_goods_count(int order_goods_count) {
            this.order_goods_count = order_goods_count;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
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

        public int getIs_anonymous() {
            return is_anonymous;
        }

        public void setIs_anonymous(int is_anonymous) {
            this.is_anonymous = is_anonymous;
        }

        public int getRatio() {
            return ratio;
        }

        public void setRatio(int ratio) {
            this.ratio = ratio;
        }

        public int getIs_zan() {
            return is_zan;
        }

        public void setIs_zan(int is_zan) {
            this.is_zan = is_zan;
        }

        @JSONField(name = "video_list")
        public List<VideoListBean> getVideoList() {
            return videoList;
        }

        @JSONField(name = "video_list")
        public void setVideoList(List<VideoListBean> videoList) {
            this.videoList = videoList;
        }

        @JSONField(name = "image_list")
        public List<String> getImageList() {
            return imageList;
        }

        @JSONField(name = "image_list")
        public void setImageList(List<String> imageList) {
            this.imageList = imageList;
        }

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public int getShow_id() {
            return show_id;
        }

        public void setShow_id(int show_id) {
            this.show_id = show_id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getShow_text() {
            return show_text;
        }

        public void setShow_text(String show_text) {
            this.show_text = show_text;
        }

        public int getMaijiashow() {
            return maijiashow;
        }

        public void setMaijiashow(int maijiashow) {
            this.maijiashow = maijiashow;
        }

        public int getCount_zan() {
            return count_zan;
        }

        public void setCount_zan(int count_zan) {
            this.count_zan = count_zan;
        }

        public int getCount_reply() {
            return count_reply;
        }

        public void setCount_reply(int count_reply) {
            this.count_reply = count_reply;
        }

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public int getZhuiping_id() {
            return zhuiping_id;
        }

        public void setZhuiping_id(int zhuiping_id) {
            this.zhuiping_id = zhuiping_id;
        }

        public int getIs_video() {
            return is_video;
        }

        public void setIs_video(int is_video) {
            this.is_video = is_video;
        }


        public static class VideoListBean extends BaseBean implements Parcelable {
            /**
             * cover : http://video1.ontheroadstore.com//show/cover/6ffc4dae-0920-4a92-b137-2d1e898a3038.jpg
             * video : http://video1.ontheroadstore.com/show/m3u8/640/6ffc4dae-0920-4a92-b137-2d1e898a3038.m3u8
             */

            private int id;
            private int is_video;
            private String cover;
            private String video;
            private String video_HD;
            private String title;

            private String videoTotalTime;
            private String createdTime;
            private String videoSource;

            private int video_width;
            private int video_height;

            public VideoListBean() {
            }

            protected VideoListBean(Parcel in) {
                is_video = in.readInt();
                cover = in.readString();
                video = in.readString();
                video_HD = in.readString();
                video_width = in.readInt();
                video_height = in.readInt();
                id = in.readInt();
                title = in.readString();
                videoTotalTime = in.readString();
                createdTime = in.readString();
                videoSource = in.readString();
            }

            public static final Creator<VideoListBean> CREATOR = new Creator<VideoListBean>() {
                @Override
                public VideoListBean createFromParcel(Parcel in) {
                    return new VideoListBean(in);
                }

                @Override
                public VideoListBean[] newArray(int size) {
                    return new VideoListBean[size];
                }
            };

            @JSONField(name = "total_time")
            public String getVideoTotalTime() {
                return videoTotalTime;
            }

            @JSONField(name = "total_time")
            public void setVideoTotalTime(String videoTotalTime) {
                this.videoTotalTime = videoTotalTime;
            }

            @JSONField(name = "created_at")
            public String getCreatedTime() {
                return createdTime;
            }

            @JSONField(name = "created_at")
            public void setCreatedTime(String createdTime) {
                this.createdTime = createdTime;
            }

            @JSONField(name = "video_source")
            public String getVideoSource() {
                return videoSource;
            }

            @JSONField(name = "video_source")
            public void setVideoSource(String videoSource) {
                this.videoSource = videoSource;
            }

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

            public int getIs_video() {
                return is_video;
            }

            public void setIs_video(int is_video) {
                this.is_video = is_video;
            }

            public int getVideo_width() {
                return video_width;
            }

            public void setVideo_width(int video_width) {
                this.video_width = video_width;
            }

            public int getVideo_height() {
                return video_height;
            }

            public void setVideo_height(int video_height) {
                this.video_height = video_height;
            }

            public String getVideo_HD() {
                return video_HD;
            }

            public void setVideo_HD(String video_HD) {
                this.video_HD = video_HD;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getVideo() {
                return video;
            }

            public void setVideo(String video) {
                this.video = video;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(is_video);
                dest.writeString(cover);
                dest.writeString(video);
                dest.writeString(video_HD);
                dest.writeInt(video_width);
                dest.writeInt(video_height);
                dest.writeInt(id);
                dest.writeString(title);
                dest.writeString(videoTotalTime);
                dest.writeString(createdTime);
                dest.writeString(videoSource);
            }
        }
    }
}
