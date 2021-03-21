package com.translation.javajetpack;

import android.os.Parcel;
import android.os.Parcelable;

import com.alibaba.fastjson.annotation.JSONField;


import java.util.List;

public class ProductDetailModel extends BaseBean implements Parcelable {


    /**
     * post : {"id":"1096087","title":"测试会员商品","desc":"减肥减肥就减肥发减肥就减肥的决定\n家的将错就错监督检查家酒店的家的家酒店\n家的疾风劲草家的家的家附近飞机疾风劲草会非常家的交界处减肥减肥减肥减肥家减肥减肥减肥发好减肥减肥发家的交界处就行家附近飞机减肥就行发家减肥减肥就像将错就错的经济学基础家的家的家吃减肥坚持家想念那些曾经坚持","content":"别把描述不当会回事\n","post_excerpt":"别把描述不当会回事<img_5410233_524_828><img_5410234_505_828><img_5410235_544_828><img_5410236_538_828><img_5410237_464_828>\n","is_buy_available":1,"is_buy_notice":"请至WEB客户端购买此商品！","server_time":1568105487,"banner":["http://img8.ontheroadstore.com/iosupload/20190806/VCtFVlRPcVk1VnZsUE9jWHJjZ2RQdz09.jpg"],"images":["http://img8.ontheroadstore.com/iosupload/20190806/d3hRY0cxMnUraTNGcUZWaHpUZDdaQT09.jpg","http://img8.ontheroadstore.com/iosupload/20190806/TFI3eDBKcmVWdHgxSE9kZnE0LzJ5dz09.jpg","http://img8.ontheroadstore.com/iosupload/20190806/djEyTmhVbmZ0Z0lXKzM5WWtmelB6dz09.jpg","http://img8.ontheroadstore.com/iosupload/20190806/MUxLWUVoVWpzZGNnYWZGUVU1Y0k1dz09.jpg","http://img8.ontheroadstore.com/iosupload/20190806/RnJScGk5NXNJSmZpZVFwN2JlcWFQQT09.jpg"],"video":null,"post_keywords":"话题,众筹,美好而操蛋","post_type":1,"image_text":["http://img8.ontheroadstore.com/iosupload/20190806/d3hRY0cxMnUraTNGcUZWaHpUZDdaQT09.jpg","http://img8.ontheroadstore.com/iosupload/20190806/TFI3eDBKcmVWdHgxSE9kZnE0LzJ5dz09.jpg","http://img8.ontheroadstore.com/iosupload/20190806/djEyTmhVbmZ0Z0lXKzM5WWtmelB6dz09.jpg","http://img8.ontheroadstore.com/iosupload/20190806/MUxLWUVoVWpzZGNnYWZGUVU1Y0k1dz09.jpg","http://img8.ontheroadstore.com/iosupload/20190806/RnJScGk5NXNJSmZpZVFwN2JlcWFQQT09.jpg"],"require_duty":0,"post_author":599,"sale_count":"9","is_only_app_sale":0,"is_lottery":0,"is_favorited":0,"default_type":null,"price":[1,10]}
     * seller_related_goods : {"id":599,"name":"逗逗","avatar":"http://img8.ontheroadstore.com/androidupload/20190712/UXZBWUdDS0IxblVZdW41MCtqN05QQT09.png","motto":"不知道写什么 呵呵哒","signature":"不知道写什么 呵呵哒","announcement":"商品、发货、物流有问题直接私信问我","goodscount":4,"goodslist":[{"id":1096082,"title":"注册卖家","cover":"http://img8.ontheroadstore.com/androidupload/20190712/c25LWm1uQzJVUkhPUzYzdzgrdjJwdz09.jpg","price":[1]},{"id":1096085,"title":"测试商品啊勒","cover":"http://img8.ontheroadstore.com/androidupload/20190719/dFFWbmlUTVZYRFV5RmpyR0FCZU9ZQT09.jpg","price":[1]},{"id":1096088,"title":"会员商品详情页面","cover":"http://img8.ontheroadstore.com/iosupload/20190806/d3hRY0cxMnUraTNGcUZWaHpUZDdaQT09.jpg","price":[10]}]}
     * related_goods : [{"id":300801,"title":"异形超大本原版漫画，重现外星生物降临的恐惧","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/171018/ec3088e2509714c3220fd07c03f30253.jpeg","author":176,"type":1},{"id":300756,"title":"asas","price":[12],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170912/25bd8eee704e922452a171b34869f983.png","author":64,"type":1},{"id":300736,"title":"asd","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170901/ddea58bdb9679a2b825fc589571b03f0.jpg","author":64,"type":1},{"id":300732,"title":"新闻君","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/iosupload/170901/RkRtdFJPWmRMU21uUjl2aVJyOVpqdz09.jpg","author":176,"type":1},{"id":300730,"title":"计算机","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/iosupload/170825/R3NUMzJnVEdTaTd0bXhmZ0huWWgxUT09.jpg","author":99,"type":1},{"id":300729,"title":"回答","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170817/e9e0be62406b0c61b8d29dae98d5f82d.gif","author":99,"type":1},{"id":300717,"title":"没没没毛病吧","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/iosupload/170810/a243WnBXVDZmd2RMdkdqcXJVVEVGZz09.jpg","author":176,"type":1},{"id":300645,"title":"啊啊啊啊啊啊啊啊啊啊！！n","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/iosupload/170623/OXF0OE15eWQxUm1pcmx3eDlQVGhSZz09.jpg","author":99,"type":1},{"id":300641,"title":"卖啥不比搬砖强啊","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/iosupload/170621/UklTYnhkRFVMSTdyYkJCNnhlSzE2Zz09.jpg","author":99,"type":1},{"id":300623,"title":"再看眼珠子就要掉出来了","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/iosupload/170613/Q0lsZW9TMFhTNk1LeXlBT3FXRXEwZz09.jpg","author":176,"type":1},{"id":300612,"title":"testtitle你好02","price":[12],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170605/522f47b32dbbd0bae04f9d529dc15e3b.jpg","author":99,"type":1},{"id":300601,"title":"测试&amp;quot;&amp;amp;","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170609/c03a93423b066e88142dcd45de4ee4c6.png","author":99,"type":1},{"id":300550,"title":"哈哈哈哈","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170427/eb51cf6106caca7aa4ebb69d59554993.jpg","author":64,"type":1},{"id":300538,"title":"阿姨还是一个好爸爸","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170425/2c2ff5ec88e56160497522d77fbec4d4.jpeg","author":112,"type":1},{"id":300537,"title":"阿姨是个好爸爸","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170425/72b37b4cfe80f03eb944d40c9dc96ed4.jpeg","author":112,"type":1},{"id":300536,"title":"最早的hiphop组织Zulu朗克斯最原始街头","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170425/f7f8769b835cf69442b15596ec036224.png","author":64,"type":1},{"id":300531,"title":"手握理发师套的血腥剃刀","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170421/cc30417038b7a49450389261dcaf0ceb.jpg","author":83,"type":1},{"id":300530,"title":"购物车2","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170414/7efa8653d0a5f8fca56696df06134b8c.jpg","author":63,"type":1},{"id":300529,"title":"购物车1","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170414/784bf5c671b71f811bd1fc751a629131.jpg","author":63,"type":1},{"id":300526,"title":"测试邮费2","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170401/0bc085c17995fe261ed0d9dfaf9b4039.jpg","author":63,"type":1},{"id":300525,"title":"测试邮费","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170401/4c01147379c994d76e2f36aedc772fd8.jpg","author":63,"type":1},{"id":300523,"title":"测试购买11","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170401/e390a747bab2accde35ff75c2a754f8d.jpg","author":161,"type":1},{"id":300522,"title":"哈哈哈吧","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170401/dde595d9fdd67cd33d05075a9d67b35f.png","author":83,"type":1},{"id":300521,"title":"测试3","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170331/da748426f7bccc7b537c49a95e751744.png","author":64,"type":1},{"id":300520,"title":"测试2","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170331/da748426f7bccc7b537c49a95e751744.png","author":64,"type":1},{"id":300519,"title":"测试1","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170331/4a64a6813a4f0d46c4e33185ef3f57c9.png","author":64,"type":1},{"id":300509,"title":"操就是干","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170307/c650d5f8ffe4fefb95ccb7f704fb943b.jpeg","author":11,"type":1},{"id":300508,"title":"哈哈","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170307/9c8d5142a4080c243a4c187a115140af.jpg","author":68,"type":1},{"id":300507,"title":"啊啊啊啊啊","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170307/2b50e1e4c41e58a514829e7ecbd0788b.jpeg","author":112,"type":1},{"id":300506,"title":"活生生","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170307/199b82cadf51c586dec70104274331d7.png","author":83,"type":1},{"id":300504,"title":"阿萨德撒","price":[16],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170303/6e0e1affa804d0a4512193f726687a6c.png","author":64,"type":1},{"id":300503,"title":"送OMG","price":[99],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170303/71d4d2f133d256078cb34f94143757a9.png","author":64,"type":1},{"id":300502,"title":"按时打算","price":[999999],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170303/c1d4163ba7eb421c77636f07110e37f6.png","author":64,"type":1},{"id":300500,"title":"asd","price":[10000000],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170303/c1d4163ba7eb421c77636f07110e37f6.png","author":64,"type":1},{"id":300499,"title":"阿萨德撒大杀手","price":[10000000],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170303/17493c713cb8f4797cad452362b0471a.png","author":64,"type":1},{"id":300497,"title":"都不会是你","price":[14558],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/iosupload/170303/dzNzYmNRTzcvenFGajJFUVBtb3VZdz09.jpg","author":83,"type":1},{"id":300496,"title":"高规格","price":[1],"score":10.548494338989,"cover":"http://img8.ontheroadstore.com/upload/170303/046bc05d7d8f4cd3c131c913e503a4d0.jpg","author":83,"type":1}]
     * type : [{"id":869803,"object_id":1096087,"name":"蓝色","price":10,"postage":"40","stock":179,"special_offer_price":5,"special_offer_start":1566871200,"special_offer_end":1567216800,"estimated_delivery_date":null,"overseas_delivery":0,"limited_edition":1,"freight_id":138,"expected_delivery_cycle":7,"tags":[]},{"id":869809,"object_id":1096087,"name":"白黑色","price":1,"postage":"0","stock":94,"special_offer_price":0,"special_offer_start":null,"special_offer_end":null,"estimated_delivery_date":null,"overseas_delivery":0,"limited_edition":0,"freight_id":134,"expected_delivery_cycle":0,"tags":["包邮"]}]
     */

    private PostBean post;
    private SellerRelatedGoodsBean seller_related_goods;
    private List<RelatedGoodsBean> related_goods;
    private List<TypeBean> type;

    private List<BuyerOrderShowListModel.ShowListBean> showList;
    @JSONField(name = "have_post")
    private ProductDetailHaveModel havePost;

    public ProductDetailHaveModel getHavePost() {
        return havePost;
    }

    public void setHavePost(ProductDetailHaveModel havePost) {
        this.havePost = havePost;
    }

    public ProductDetailModel() {
    }

    protected ProductDetailModel(Parcel in) {
        post = in.readParcelable(PostBean.class.getClassLoader());
        seller_related_goods = in.readParcelable(SellerRelatedGoodsBean.class.getClassLoader());
        related_goods = in.createTypedArrayList(RelatedGoodsBean.CREATOR);
        type = in.createTypedArrayList(TypeBean.CREATOR);
    }

    public static final Creator<ProductDetailModel> CREATOR = new Creator<ProductDetailModel>() {
        @Override
        public ProductDetailModel createFromParcel(Parcel in) {
            return new ProductDetailModel(in);
        }

        @Override
        public ProductDetailModel[] newArray(int size) {
            return new ProductDetailModel[size];
        }
    };

    public List<BuyerOrderShowListModel.ShowListBean> getShowList() {
        return showList;
    }

    public void setShowList(List<BuyerOrderShowListModel.ShowListBean> showList) {
        this.showList = showList;
    }

    public PostBean getPost() {
        return post;
    }

    public void setPost(PostBean post) {
        this.post = post;
    }

    public SellerRelatedGoodsBean getSeller_related_goods() {
        return seller_related_goods;
    }

    public void setSeller_related_goods(SellerRelatedGoodsBean seller_related_goods) {
        this.seller_related_goods = seller_related_goods;
    }

    public List<RelatedGoodsBean> getRelated_goods() {
        return related_goods;
    }

    public void setRelated_goods(List<RelatedGoodsBean> related_goods) {
        this.related_goods = related_goods;
    }

    public List<TypeBean> getType() {
        return type;
    }

    public void setType(List<TypeBean> type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(post, flags);
        dest.writeParcelable(seller_related_goods, flags);
        dest.writeTypedList(related_goods);
        dest.writeTypedList(type);
    }

    public static class PostBean extends BaseBean implements Parcelable{
        /**
         * id : 1096087
         * title : 测试会员商品
         * desc : 减肥减肥就减肥发减肥就减肥的决定
         家的将错就错监督检查家酒店的家的家酒店
         家的疾风劲草家的家的家附近飞机疾风劲草会非常家的交界处减肥减肥减肥减肥家减肥减肥减肥发好减肥减肥发家的交界处就行家附近飞机减肥就行发家减肥减肥就像将错就错的经济学基础家的家的家吃减肥坚持家想念那些曾经坚持
         * content : 别把描述不当会回事
         * post_excerpt : 别把描述不当会回事<img_5410233_524_828><img_5410234_505_828><img_5410235_544_828><img_5410236_538_828><img_5410237_464_828>
         * is_buy_available : 1
         * is_buy_notice : 请至WEB客户端购买此商品！
         * server_time : 1568105487
         * banner : ["http://img8.ontheroadstore.com/iosupload/20190806/VCtFVlRPcVk1VnZsUE9jWHJjZ2RQdz09.jpg"]
         * images : ["http://img8.ontheroadstore.com/iosupload/20190806/d3hRY0cxMnUraTNGcUZWaHpUZDdaQT09.jpg","http://img8.ontheroadstore.com/iosupload/20190806/TFI3eDBKcmVWdHgxSE9kZnE0LzJ5dz09.jpg","http://img8.ontheroadstore.com/iosupload/20190806/djEyTmhVbmZ0Z0lXKzM5WWtmelB6dz09.jpg","http://img8.ontheroadstore.com/iosupload/20190806/MUxLWUVoVWpzZGNnYWZGUVU1Y0k1dz09.jpg","http://img8.ontheroadstore.com/iosupload/20190806/RnJScGk5NXNJSmZpZVFwN2JlcWFQQT09.jpg"]
         * video : null
         * post_keywords : 话题,众筹,美好而操蛋
         * post_type : 1
         * image_text : ["http://img8.ontheroadstore.com/iosupload/20190806/d3hRY0cxMnUraTNGcUZWaHpUZDdaQT09.jpg","http://img8.ontheroadstore.com/iosupload/20190806/TFI3eDBKcmVWdHgxSE9kZnE0LzJ5dz09.jpg","http://img8.ontheroadstore.com/iosupload/20190806/djEyTmhVbmZ0Z0lXKzM5WWtmelB6dz09.jpg","http://img8.ontheroadstore.com/iosupload/20190806/MUxLWUVoVWpzZGNnYWZGUVU1Y0k1dz09.jpg","http://img8.ontheroadstore.com/iosupload/20190806/RnJScGk5NXNJSmZpZVFwN2JlcWFQQT09.jpg"]
         * require_duty : 0
         * post_author : 599
         * sale_count : 9
         * is_only_app_sale : 0
         * is_lottery : 0
         * is_favorited : 0
         * default_type : null
         * price : [1,10]
         */

        private String maidian;
        private String post_html;
        private String id;
        private String title;
        private String post_subtitle;
        private String desc;
        private String content;
        private String post_excerpt;
        private int is_buy_available;
        private String is_buy_notice;
        private int server_time;
        private String video;
        private String post_keywords;
        private int post_type;
        private int require_duty;
        private int post_author;
        private String sale_count;
        private int is_only_app_sale;
        private int is_lottery;
        private int is_favorited;
        private int default_type;
        private int is_proprietary = -1;
        private List<String> banner;
        private List<String> images;
        private List<String> image_text;
        private List<Integer> price;
        private List<GoodsFeatureBean> goods_feature;
        private List<AdListBean> adList;

        private int is_quanyi;
        private String quanyi_describe;

        private ProductSalePromotionModel salePromotion;

        public PostBean() {
        }

        protected PostBean(Parcel in) {
            maidian = in.readString();
            post_html = in.readString();
            id = in.readString();
            title = in.readString();
            post_subtitle = in.readString();
            desc = in.readString();
            content = in.readString();
            post_excerpt = in.readString();
            is_buy_available = in.readInt();
            is_buy_notice = in.readString();
            server_time = in.readInt();
            video = in.readString();
            post_keywords = in.readString();
            post_type = in.readInt();
            require_duty = in.readInt();
            post_author = in.readInt();
            sale_count = in.readString();
            is_only_app_sale = in.readInt();
            is_lottery = in.readInt();
            is_favorited = in.readInt();
            default_type = in.readInt();
            banner = in.createStringArrayList();
            images = in.createStringArrayList();
            image_text = in.createStringArrayList();
            is_quanyi = in.readInt();
            quanyi_describe = in.readString();
            salePromotion = in.readParcelable(ProductSalePromotionModel.class.getClassLoader());
            is_proprietary = in.readInt();
        }

        public static final Creator<PostBean> CREATOR = new Creator<PostBean>() {
            @Override
            public PostBean createFromParcel(Parcel in) {
                return new PostBean(in);
            }

            @Override
            public PostBean[] newArray(int size) {
                return new PostBean[size];
            }
        };

        public int getIs_quanyi() {
            return is_quanyi;
        }

        public void setIs_quanyi(int is_quanyi) {
            this.is_quanyi = is_quanyi;
        }

        public String getQuanyi_describe() {
            return quanyi_describe;
        }

        public void setQuanyi_describe(String quanyi_describe) {
            this.quanyi_describe = quanyi_describe;
        }

        @JSONField(name="sale_promotion")
        public ProductSalePromotionModel getSalePromotion() {
            return salePromotion;
        }
        @JSONField(name="sale_promotion")
        public void setSalePromotion(ProductSalePromotionModel sale_promotion) {
            this.salePromotion = sale_promotion;
        }

        public String getPost_subtitle() {
            return post_subtitle;
        }

        public void setPost_subtitle(String post_subtitle) {
            this.post_subtitle = post_subtitle;
        }

        public List<AdListBean> getAdList() {
            return adList;
        }

        public void setAdList(List<AdListBean> adList) {
            this.adList = adList;
        }

        public List<GoodsFeatureBean> getGoods_feature() {
            return goods_feature;
        }

        public void setGoods_feature(List<GoodsFeatureBean> goods_feature) {
            this.goods_feature = goods_feature;
        }

        public String getMaidian() {
            return maidian;
        }

        public void setMaidian(String maidian) {
            this.maidian = maidian;
        }

        public String getPost_html() {
            return post_html;
        }

        public void setPost_html(String post_html) {
            this.post_html = post_html;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPost_excerpt() {
            return post_excerpt;
        }

        public void setPost_excerpt(String post_excerpt) {
            this.post_excerpt = post_excerpt;
        }

        public int getIs_buy_available() {
            return is_buy_available;
        }

        public void setIs_buy_available(int is_buy_available) {
            this.is_buy_available = is_buy_available;
        }

        public String getIs_buy_notice() {
            return is_buy_notice;
        }

        public void setIs_buy_notice(String is_buy_notice) {
            this.is_buy_notice = is_buy_notice;
        }

        public int getServer_time() {
            return server_time;
        }

        public void setServer_time(int server_time) {
            this.server_time = server_time;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public String getPost_keywords() {
            return post_keywords;
        }

        public void setPost_keywords(String post_keywords) {
            this.post_keywords = post_keywords;
        }

        public int getPost_type() {
            return post_type;
        }

        public void setPost_type(int post_type) {
            this.post_type = post_type;
        }

        public int getRequire_duty() {
            return require_duty;
        }

        public void setRequire_duty(int require_duty) {
            this.require_duty = require_duty;
        }

        public int getPost_author() {
            return post_author;
        }

        public void setPost_author(int post_author) {
            this.post_author = post_author;
        }

        public String getSale_count() {
            return sale_count;
        }

        public void setSale_count(String sale_count) {
            this.sale_count = sale_count;
        }

        public int getIs_only_app_sale() {
            return is_only_app_sale;
        }

        public void setIs_only_app_sale(int is_only_app_sale) {
            this.is_only_app_sale = is_only_app_sale;
        }

        public int getIs_lottery() {
            return is_lottery;
        }

        public void setIs_lottery(int is_lottery) {
            this.is_lottery = is_lottery;
        }

        public int getIs_favorited() {
            return is_favorited;
        }

        public void setIs_favorited(int is_favorited) {
            this.is_favorited = is_favorited;
        }

        public int getDefault_type() {
            return default_type;
        }

        public void setDefault_type(int default_type) {
            this.default_type = default_type;
        }

        public List<String> getBanner() {
            return banner;
        }

        public void setBanner(List<String> banner) {
            this.banner = banner;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public List<String> getImage_text() {
            return image_text;
        }

        public void setImage_text(List<String> image_text) {
            this.image_text = image_text;
        }

        public List<Integer> getPrice() {
            return price;
        }

        public void setPrice(List<Integer> price) {
            this.price = price;
        }

        public int getIs_proprietary() {
            return is_proprietary;
        }

        public void setIs_proprietary(int is_proprietary) {
            this.is_proprietary = is_proprietary;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(maidian);
            dest.writeString(post_html);
            dest.writeString(id);
            dest.writeString(title);
            dest.writeString(post_subtitle);
            dest.writeString(desc);
            dest.writeString(content);
            dest.writeString(post_excerpt);
            dest.writeInt(is_buy_available);
            dest.writeString(is_buy_notice);
            dest.writeInt(server_time);
            dest.writeString(video);
            dest.writeString(post_keywords);
            dest.writeInt(post_type);
            dest.writeInt(require_duty);
            dest.writeInt(post_author);
            dest.writeString(sale_count);
            dest.writeInt(is_only_app_sale);
            dest.writeInt(is_lottery);
            dest.writeInt(is_favorited);
            dest.writeInt(default_type);
            dest.writeStringList(banner);
            dest.writeStringList(images);
            dest.writeStringList(image_text);
            dest.writeInt(is_quanyi);
            dest.writeString(quanyi_describe);
            dest.writeParcelable(salePromotion, flags);
            dest.writeInt(is_proprietary);
        }
    }

    public static class AdListBean extends BaseBean{

        /**
         * id : 1
         * img : http://img8.ontheroadstore.com/upload/170921/83de264b2cf6eef2a49445483007d70b.gif
         * url : 51
         * url_type : 1
         * description : ceshi
         * type : 2
         */

        private int id;
        private String image;
        private String url;
        private int url_type;
        private String description;
        private int type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getUrl_type() {
            return url_type;
        }

        public void setUrl_type(int url_type) {
            this.url_type = url_type;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }

    public static class GoodsFeatureBean extends BaseBean{
        private int id;
        private String title;

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
    }

    public static class SellerRelatedGoodsBean extends BaseBean implements Parcelable{
        /**
         * id : 599
         * name : 逗逗
         * avatar : http://img8.ontheroadstore.com/androidupload/20190712/UXZBWUdDS0IxblVZdW41MCtqN05QQT09.png
         * motto : 不知道写什么 呵呵哒
         * signature : 不知道写什么 呵呵哒
         * announcement : 商品、发货、物流有问题直接私信问我
         * goodscount : 4
         * goodslist : [{"id":1096082,"title":"注册卖家","cover":"http://img8.ontheroadstore.com/androidupload/20190712/c25LWm1uQzJVUkhPUzYzdzgrdjJwdz09.jpg","price":[1]},{"id":1096085,"title":"测试商品啊勒","cover":"http://img8.ontheroadstore.com/androidupload/20190719/dFFWbmlUTVZYRFV5RmpyR0FCZU9ZQT09.jpg","price":[1]},{"id":1096088,"title":"会员商品详情页面","cover":"http://img8.ontheroadstore.com/iosupload/20190806/d3hRY0cxMnUraTNGcUZWaHpUZDdaQT09.jpg","price":[10]}]
         */

        private int id;
        private String name;
        private String avatar;
        private String motto;
        private String signature;
        private String announcement;
        private int goodscount;
        private List<GoodsListBean> goodslist;

        public SellerRelatedGoodsBean() {
        }

        protected SellerRelatedGoodsBean(Parcel in) {
            id = in.readInt();
            name = in.readString();
            avatar = in.readString();
            motto = in.readString();
            signature = in.readString();
            announcement = in.readString();
            goodscount = in.readInt();
        }

        public static final Creator<SellerRelatedGoodsBean> CREATOR = new Creator<SellerRelatedGoodsBean>() {
            @Override
            public SellerRelatedGoodsBean createFromParcel(Parcel in) {
                return new SellerRelatedGoodsBean(in);
            }

            @Override
            public SellerRelatedGoodsBean[] newArray(int size) {
                return new SellerRelatedGoodsBean[size];
            }
        };

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getMotto() {
            return motto;
        }

        public void setMotto(String motto) {
            this.motto = motto;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getAnnouncement() {
            return announcement;
        }

        public void setAnnouncement(String announcement) {
            this.announcement = announcement;
        }

        public int getGoodscount() {
            return goodscount;
        }

        public void setGoodscount(int goodscount) {
            this.goodscount = goodscount;
        }

        public List<GoodsListBean> getGoodslist() {
            return goodslist;
        }

        public void setGoodslist(List<GoodsListBean> goodslist) {
            this.goodslist = goodslist;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeString(name);
            dest.writeString(avatar);
            dest.writeString(motto);
            dest.writeString(signature);
            dest.writeString(announcement);
            dest.writeInt(goodscount);
        }

        public static class GoodsListBean extends BaseBean{
            /**
             * id : 1096082
             * title : 注册卖家
             * cover : http://img8.ontheroadstore.com/androidupload/20190712/c25LWm1uQzJVUkhPUzYzdzgrdjJwdz09.jpg
             * price : [1]
             */

            private int id;
            private String title;
            private String subTitle;
            private String post_subtitle;
            private String cover;
            private List<Integer> price;

            public String getPost_subtitle() {
                return post_subtitle;
            }

            public void setPost_subtitle(String post_subtitle) {
                this.post_subtitle = post_subtitle;
            }

            public String getSubTitle() {
                return subTitle;
            }

            public void setSubTitle(String subTitle) {
                this.subTitle = subTitle;
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

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public List<Integer> getPrice() {
                return price;
            }

            public void setPrice(List<Integer> price) {
                this.price = price;
            }
        }
    }

    public static class RelatedGoodsBean extends BaseBean implements Parcelable {
        /**
         * id : 300801
         * title : 异形超大本原版漫画，重现外星生物降临的恐惧
         * price : [1]
         * score : 10.548494338989
         * cover : http://img8.ontheroadstore.com/upload/171018/ec3088e2509714c3220fd07c03f30253.jpeg
         * author : 176
         * type : 1
         */

        private int id;
        private String title;
        private double score;
        private String cover;
        private String post_subtitle;
        private String author;
        private int type;
        private List<Integer> price;

        private String image;
        private String url;
        private String description;
        private int url_type;

        private String cover_fang;

        private List<HomeTagModel> tagList;

        public RelatedGoodsBean() {
        }

        protected RelatedGoodsBean(Parcel in) {
            id = in.readInt();
            title = in.readString();
            score = in.readDouble();
            cover = in.readString();
            post_subtitle = in.readString();
            author = in.readString();
            type = in.readInt();
            image = in.readString();
            url = in.readString();
            description = in.readString();
            url_type = in.readInt();
            tagList = in.createTypedArrayList(HomeTagModel.CREATOR);
            cover_fang = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeString(title);
            dest.writeDouble(score);
            dest.writeString(cover);
            dest.writeString(post_subtitle);
            dest.writeString(author);
            dest.writeInt(type);
            dest.writeString(image);
            dest.writeString(url);
            dest.writeString(description);
            dest.writeInt(url_type);
            dest.writeTypedList(tagList);
            dest.writeString(cover_fang);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<RelatedGoodsBean> CREATOR = new Creator<RelatedGoodsBean>() {
            @Override
            public RelatedGoodsBean createFromParcel(Parcel in) {
                return new RelatedGoodsBean(in);
            }

            @Override
            public RelatedGoodsBean[] newArray(int size) {
                return new RelatedGoodsBean[size];
            }
        };

        public String getCover_fang() {
            return cover_fang;
        }

        public void setCover_fang(String cover_fang) {
            this.cover_fang = cover_fang;
        }

        @JSONField(name = "tag_list")
        public List<HomeTagModel> getTagList() {
            return tagList;
        }

        @JSONField(name = "tag_list")
        public void setTagList(List<HomeTagModel> tagList) {
            this.tagList = tagList;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getUrl_type() {
            return url_type;
        }

        public void setUrl_type(int url_type) {
            this.url_type = url_type;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getPost_subtitle() {
            return post_subtitle;
        }

        public void setPost_subtitle(String post_subtitle) {
            this.post_subtitle = post_subtitle;
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

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public List<Integer> getPrice() {
            return price;
        }

        public void setPrice(List<Integer> price) {
            this.price = price;
        }

    }

    public static class TypeBean extends BaseBean implements Parcelable{
        /**
         * id : 869803
         * object_id : 1096087
         * name : 蓝色
         * price : 10
         * postage : 40
         * stock : 179
         * special_offer_price : 5
         * special_offer_start : 1566871200
         * special_offer_end : 1567216800
         * estimated_delivery_date : null
         * overseas_delivery : 0
         * limited_edition : 1
         * freight_id : 138
         * expected_delivery_cycle : 7
         * tags : []
         */

        private int id;
        private int object_id;
        private String name;
        private String price;
        private String postage;
        private int stock;
        private String special_offer_price;
        private Long special_offer_start;
        private Long special_offer_end;
        private Long estimated_delivery_date;
        private int overseas_delivery;
        private int limited_edition;
        private int freight_id;
        private int expected_delivery_cycle;
        private List<String> tags;
        //限购字段
        private int postsAlreadyNumber;
        private int postsRestrictionNumber;
        private int goodsAlreadyNumber;
        private int goodsRestrictionNumber;

        private int require_duty;
        private int token_expired;
        private int is_lottery;
        private int quanyi_price;

        //会员商品字段
        private int vip_id;
        private int vip_price;
        private int vip_status;
        private int vip_only;

        public TypeBean() {
        }

        protected TypeBean(Parcel in) {
            id = in.readInt();
            object_id = in.readInt();
            name = in.readString();
            price = in.readString();
            postage = in.readString();
            stock = in.readInt();
            special_offer_price = in.readString();
            if (in.readByte() == 0) {
                special_offer_start = null;
            } else {
                special_offer_start = in.readLong();
            }
            if (in.readByte() == 0) {
                special_offer_end = null;
            } else {
                special_offer_end = in.readLong();
            }
            if (in.readByte() == 0) {
                estimated_delivery_date = null;
            } else {
                estimated_delivery_date = in.readLong();
            }
            overseas_delivery = in.readInt();
            limited_edition = in.readInt();
            freight_id = in.readInt();
            expected_delivery_cycle = in.readInt();
            tags = in.createStringArrayList();
            postsAlreadyNumber = in.readInt();
            postsRestrictionNumber = in.readInt();
            goodsAlreadyNumber = in.readInt();
            goodsRestrictionNumber = in.readInt();
            require_duty = in.readInt();
            token_expired = in.readInt();
            is_lottery = in.readInt();
            quanyi_price = in.readInt();
            vip_id = in.readInt();
            vip_price = in.readInt();
            vip_status = in.readInt();
            vip_only = in.readInt();
        }

        public static final Creator<TypeBean> CREATOR = new Creator<TypeBean>() {
            @Override
            public TypeBean createFromParcel(Parcel in) {
                return new TypeBean(in);
            }

            @Override
            public TypeBean[] newArray(int size) {
                return new TypeBean[size];
            }
        };

        public int getRequire_duty() {
            return require_duty;
        }

        public void setRequire_duty(int require_duty) {
            this.require_duty = require_duty;
        }

        public int getToken_expired() {
            return token_expired;
        }

        public void setToken_expired(int token_expired) {
            this.token_expired = token_expired;
        }

        public int getIs_lottery() {
            return is_lottery;
        }

        public void setIs_lottery(int is_lottery) {
            this.is_lottery = is_lottery;
        }

        public int getQuanyi_price() {
            return quanyi_price;
        }

        public void setQuanyi_price(int quanyi_price) {
            this.quanyi_price = quanyi_price;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public List<String> getTags() {
            return tags;
        }

        public int getPostsAlreadyNumber() {
            return postsAlreadyNumber;
        }

        public void setPostsAlreadyNumber(int postsAlreadyNumber) {
            this.postsAlreadyNumber = postsAlreadyNumber;
        }

        public int getPostsRestrictionNumber() {
            return postsRestrictionNumber;
        }

        public void setPostsRestrictionNumber(int postsRestrictionNumber) {
            this.postsRestrictionNumber = postsRestrictionNumber;
        }

        public int getGoodsAlreadyNumber() {
            return goodsAlreadyNumber;
        }

        public void setGoodsAlreadyNumber(int goodsAlreadyNumber) {
            this.goodsAlreadyNumber = goodsAlreadyNumber;
        }

        public int getGoodsRestrictionNumber() {
            return goodsRestrictionNumber;
        }

        public void setGoodsRestrictionNumber(int goodsRestrictionNumber) {
            this.goodsRestrictionNumber = goodsRestrictionNumber;
        }

        public int getVip_id() {
            return vip_id;
        }

        public void setVip_id(int vip_id) {
            this.vip_id = vip_id;
        }

        public int getVip_price() {
            return vip_price;
        }

        public void setVip_price(int vip_price) {
            this.vip_price = vip_price;
        }

        public int getVip_status() {
            return vip_status;
        }

        public void setVip_status(int vip_status) {
            this.vip_status = vip_status;
        }

        public int getVip_only() {
            return vip_only;
        }

        public void setVip_only(int vip_only) {
            this.vip_only = vip_only;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getObject_id() {
            return object_id;
        }

        public void setObject_id(int object_id) {
            this.object_id = object_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPostage() {
            return postage;
        }

        public void setPostage(String postage) {
            this.postage = postage;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public String getSpecial_offer_price() {
            return special_offer_price;
        }

        public void setSpecial_offer_price(String special_offer_price) {
            this.special_offer_price = special_offer_price;
        }

        public Long getSpecial_offer_start() {
            return special_offer_start;
        }

        public void setSpecial_offer_start(Long special_offer_start) {
            this.special_offer_start = special_offer_start;
        }

        public Long getSpecial_offer_end() {
            return special_offer_end;
        }

        public void setSpecial_offer_end(Long special_offer_end) {
            this.special_offer_end = special_offer_end;
        }

        public Long getEstimated_delivery_date() {
            return estimated_delivery_date;
        }

        public void setEstimated_delivery_date(Long estimated_delivery_date) {
            this.estimated_delivery_date = estimated_delivery_date;
        }

        public int getOverseas_delivery() {
            return overseas_delivery;
        }

        public void setOverseas_delivery(int overseas_delivery) {
            this.overseas_delivery = overseas_delivery;
        }

        public int getLimited_edition() {
            return limited_edition;
        }

        public void setLimited_edition(int limited_edition) {
            this.limited_edition = limited_edition;
        }

        public int getFreight_id() {
            return freight_id;
        }

        public void setFreight_id(int freight_id) {
            this.freight_id = freight_id;
        }

        public int getExpected_delivery_cycle() {
            return expected_delivery_cycle;
        }

        public void setExpected_delivery_cycle(int expected_delivery_cycle) {
            this.expected_delivery_cycle = expected_delivery_cycle;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeInt(object_id);
            dest.writeString(name);
            dest.writeString(price);
            dest.writeString(postage);
            dest.writeInt(stock);
            dest.writeString(special_offer_price);
            if (special_offer_start == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeLong(special_offer_start);
            }
            if (special_offer_end == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeLong(special_offer_end);
            }
            if (estimated_delivery_date == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeLong(estimated_delivery_date);
            }
            dest.writeInt(overseas_delivery);
            dest.writeInt(limited_edition);
            dest.writeInt(freight_id);
            dest.writeInt(expected_delivery_cycle);
            dest.writeStringList(tags);
            dest.writeInt(postsAlreadyNumber);
            dest.writeInt(postsRestrictionNumber);
            dest.writeInt(goodsAlreadyNumber);
            dest.writeInt(goodsRestrictionNumber);
            dest.writeInt(require_duty);
            dest.writeInt(token_expired);
            dest.writeInt(is_lottery);
            dest.writeInt(quanyi_price);
            dest.writeInt(vip_id);
            dest.writeInt(vip_price);
            dest.writeInt(vip_status);
            dest.writeInt(vip_only);
        }
    }

    public static class BuyerShowBean extends BaseBean{

        private List<BuyerOrderShowListModel.ShowListBean.VideoListBean> imageList;
        private List<BuyerOrderShowListModel.ShowListBean> showList;

        @JSONField(name = "image_list")
        public List<BuyerOrderShowListModel.ShowListBean.VideoListBean> getImageList() {
            return imageList;
        }

        @JSONField(name = "image_list")
        public void setImageList(List<BuyerOrderShowListModel.ShowListBean.VideoListBean> imageList) {
            this.imageList = imageList;
        }

//        @JSONField(name = "show_list")
//        public List<BuyerOrderShowListModel.ShowListBean> getShowList() {
//            return showList;
//        }
//
//        @JSONField(name = "show_list")
//        public void setShowList(List<BuyerOrderShowListModel.ShowListBean> showList) {
//            this.showList = showList;
//        }
    }

//    public static class BuyerShowListBean extends BaseBean implements ExpandableStatusFix {
//
//        /**
//         * show_id : 398
//         * order_goods_count : 1
//         * user_id : 554
//         * user_nickname : 黑客
//         * user_img : http://img8.ontheroadstore.com/iosupload/20190626/RjFzZlM0L29wcG1mZWM2V25vbW4zdz09.jpg
//         * show_text : 第一版这个特别好哦
//         * is_video : 0
//         * count_zan : 16549889
//         * count_reply : 24
//         * created_at : 2019-12-06
//         * is_zan : 0
//         */
//        private StatusType status;
//
//        private int ratio;
//        private int show_id;
//        private int order_goods_count;
//        private int user_id;
//        private String user_nickname;
//        private String user_img;
//        private String show_text;
//        private int is_video;
//        private int count_zan;
//        private int count_reply;
//        private String created_at;
//        private int is_zan;
//        private List<BuyerOrderShowListModel.ShowListBean.VideoListBean> videoList;
//        private List<String> imageList;
//
//        public int getRatio() {
//            return ratio;
//        }
//
//        public void setRatio(int ratio) {
//            this.ratio = ratio;
//        }
//
//        @JSONField(name = "image_list")
//        public List<String> getImageList() {
//            return imageList;
//        }
//
//        @JSONField(name = "image_list")
//        public void setImageList(List<String> imageList) {
//            this.imageList = imageList;
//        }
//        @JSONField(name = "video_list")
//        public List<BuyerOrderShowListModel.ShowListBean.VideoListBean> getVideoList() {
//            return videoList;
//        }
//
//        @JSONField(name = "video_list")
//        public void setVideoList(List<BuyerOrderShowListModel.ShowListBean.VideoListBean> videoList) {
//            this.videoList = videoList;
//        }
//
//        public int getShow_id() {
//            return show_id;
//        }
//
//        public void setShow_id(int show_id) {
//            this.show_id = show_id;
//        }
//
//        public int getOrder_goods_count() {
//            return order_goods_count;
//        }
//
//        public void setOrder_goods_count(int order_goods_count) {
//            this.order_goods_count = order_goods_count;
//        }
//
//        public int getUser_id() {
//            return user_id;
//        }
//
//        public void setUser_id(int user_id) {
//            this.user_id = user_id;
//        }
//
//        public String getUser_nickname() {
//            return user_nickname;
//        }
//
//        public void setUser_nickname(String user_nickname) {
//            this.user_nickname = user_nickname;
//        }
//
//        public String getUser_img() {
//            return user_img;
//        }
//
//        public void setUser_img(String user_img) {
//            this.user_img = user_img;
//        }
//
//        public String getShow_text() {
//            return show_text;
//        }
//
//        public void setShow_text(String show_text) {
//            this.show_text = show_text;
//        }
//
//        public int getIs_video() {
//            return is_video;
//        }
//
//        public void setIs_video(int is_video) {
//            this.is_video = is_video;
//        }
//
//        public int getCount_zan() {
//            return count_zan;
//        }
//
//        public void setCount_zan(int count_zan) {
//            this.count_zan = count_zan;
//        }
//
//        public int getCount_reply() {
//            return count_reply;
//        }
//
//        public void setCount_reply(int count_reply) {
//            this.count_reply = count_reply;
//        }
//
//        public String getCreated_at() {
//            return created_at;
//        }
//
//        public void setCreated_at(String created_at) {
//            this.created_at = created_at;
//        }
//
//        public int getIs_zan() {
//            return is_zan;
//        }
//
//        public void setIs_zan(int is_zan) {
//            this.is_zan = is_zan;
//        }
//
//        @Override
//        public void setStatus(StatusType status) {
//            this.status = status;
//        }
//
//        @Override
//        public StatusType getStatus() {
//            return status;
//        }
//    }
}
