package com.translation.javajetpack;


import java.util.List;

/**
 * 商品详情 BaseModel
 *
 * Created by jiaowenzheng on 2017/9/20.
 */

public class ProductModel extends BaseBean {


    /**
     * item_types : [{"goodsTypeID":942,"goodsType":"默认款式","goodsPrice":"1","goodsStock":"15","unit":"件"}]
     * item_head : {"top":[{"img":"http://img8.ontheroadstore.com/iosupload/170912/bHdLNW8weXRBTE5hS216RXpLblZwZz09.jpg","url":"","type":0},{"img":"http://img8.ontheroadstore.com/iosupload/170912/VWcyOEJvZ09kcGFqSHRTK0R0S1FvUT09.jpg","url":"","type":0}],"intro":{"title":"犀牛黑洞 （单 ID:99）","praisenum":2,"price":[1],"fare":0}}
     * item_owner_info : {"id":99,"user_nicename":"坠落的天才少年酱哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈","avatar":"http://wx.qlogo.cn/mmopen/Q3auHgzwzM5KQJ5HwQYbW5TUnibucrJVeNeUGhkcaL3BAyUibAG80ibT9Y1icAibc6jo3WAzjYFayJQcoDFf5ticOsInf9zwrIvic3sJQq3okSgjfE/64","motto":"这家伙太懒了，啥都没写，没劲哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈hhhh","fansnum":7}
     * item_img : ["http://img8.ontheroadstore.com/iosupload/170912/bHdLNW8weXRBTE5hS216RXpLblZwZz09.jpg"]
     * like_info : {"like_num":2,"like_list":[{"uid":99,"avatar":"http://wx.qlogo.cn/mmopen/Q3auHgzwzM5KQJ5HwQYbW5TUnibucrJVeNeUGhkcaL3BAyUibAG80ibT9Y1icAibc6jo3WAzjYFayJQcoDFf5ticOsInf9zwrIvic3sJQq3okSgjfE/64"},{"uid":176,"avatar":"http://wx.qlogo.cn/mmopen/XhDicP4tEb7t5Wr1koOvaBdadeVVB1UlAtdu5YtwmGFbx2HeFibDgbXMqcKOnCqBheib5rKeXV4Ru3mKYHkyq7r9k54e6vias63Z/64"}]}
     * comment_list : [{"id":5322,"post_table":"posts","post_id":300758,"url":"Portal/HsArticle/index/id/300758.html","uid":64,"full_name":"德德","uid_img":"http://wx.qlogo.cn/mmopen/22YD2oBcVUakSF4O8JCmoxTvwDWqp5up7XJExnCnAyS0UDGhTICvicgraS5W3E2aCFKPQTHUtOmFdOjfrPvp9D9AJ89vEGEWg/64","to_uid":0,"be_commented_username":null,"content":"asdasdasd","parentid":0,"type":0,"createtime":"9月20日 17:42","path":"0-5322","status":1,"children_nums":4,"origincreatetime":"2017-09-20 17:42:50"},{"id":5321,"post_table":"posts","post_id":300758,"url":"Portal/HsArticle/index/id/300758.html","uid":97,"full_name":"老师666","uid_img":"http://img8.ontheroadstore.com/iosupload/170814/T1NwS0ZHYU00VlFweG15bkdTNk9pdz09.jpg/64","to_uid":99,"be_commented_username":"坠落的天才少年酱哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈","content":"234234234234234234","parentid":0,"type":1,"createtime":"9月20日 17:41","path":"0-5321","status":1,"children_nums":0,"origincreatetime":"2017-09-20 17:41:31"},{"id":5317,"post_table":"posts","post_id":300758,"url":"Portal/HsArticle/index/id/300758.html","uid":99,"full_name":"坠落的天才少年酱哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈","uid_img":"http://wx.qlogo.cn/mmopen/Q3auHgzwzM5KQJ5HwQYbW5TUnibucrJVeNeUGhkcaL3BAyUibAG80ibT9Y1icAibc6jo3WAzjYFayJQcoDFf5ticOsInf9zwrIvic3sJQq3okSgjfE/64","to_uid":99,"be_commented_username":"坠落的天才少年酱哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈","content":"http://img8.ontheroadstore.com/iosupload/170920/bHZNY0FabmJsbmpyR2FBanl5RkZaQT09.jpg","parentid":0,"type":4,"createtime":"9月20日 11:41","path":"0-5317","status":1,"children_nums":0,"origincreatetime":"2017-09-20 11:41:14"},{"id":5316,"post_table":"posts","post_id":300758,"url":"","uid":176,"full_name":"查无此人❌❌❌","uid_img":"http://wx.qlogo.cn/mmopen/XhDicP4tEb7t5Wr1koOvaBdadeVVB1UlAtdu5YtwmGFbx2HeFibDgbXMqcKOnCqBheib5rKeXV4Ru3mKYHkyq7r9k54e6vias63Z/64","to_uid":99,"be_commented_username":"坠落的天才少年酱哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈","content":"手一哆嗦抢购了 1 件","parentid":0,"type":2,"createtime":"9月20日 11:02","path":"0-5316","status":1,"children_nums":0,"origincreatetime":"2017-09-20 11:02:05"}]
     * content_url : https://apitest.ontheroadstore.com/appv2/itemcontent?item_id=300758
     * share_url : https://api..com/appv2/itemshare?item_id=300758
     * item_content : 单
     * has_liked : false
     * is_favourite : false
     * post_keywords :
     * alikes : [{"id":300763,"post_title":"黑库测试","post_keywords":"","image":"http://img8.ontheroadstore.com/upload/170913/063ea27aa5b3c4846c938c14fca57861.jpg"},{"id":300761,"post_title":"雕塑小熊酱（单 ID:163）","post_keywords":"","image":"http://img8.ontheroadstore.com/upload/170913/f4aa097efc202c390fbc4afc2783fdc0.jpg"},{"id":300760,"post_title":"银他妈～ （多 ID:163）","post_keywords":"","image":"http://img8.ontheroadstore.com/upload/170913/d58f1b961d6b3d39b79dda2fcf3dfac5.jpg"},{"id":300759,"post_title":"黑白 （多 ID:99）","post_keywords":"","image":"http://img8.ontheroadstore.com/iosupload/170912/dXBXWnpqVEs1Q3NIWHZFM1JOOFF1dz09.jpg"},{"id":300746,"post_title":"asd","post_keywords":"","image":"http://img8.ontheroadstore.com/upload/170901/25bd8eee704e922452a171b34869f983.png"}]
     * published : 1
     * short_of_stock : false
     */

    private ItemHeadBean item_head;
    private ItemOwnerInfoBean item_owner_info;
    private ConmmentInfoBean comment_info;
    private LikeInfoBean like_info;
    private String content_url;
    private String share_url;
    private String item_content;
    private boolean has_liked;
    private boolean is_favourite;
    private String post_keywords;
    private int published;
    private boolean short_of_stock;
    private List<ItemTypesBean> item_types;
    private List<String> item_img;
    private List<CommentListBean> comment_list;
    private List<AlikesBean> alikes;

    public ConmmentInfoBean getComment_info() {
        return comment_info;
    }

    public void setComment_info(ConmmentInfoBean comment_info) {
        this.comment_info = comment_info;
    }

    public ItemHeadBean getItem_head() {
        return item_head;
    }

    public void setItem_head(ItemHeadBean item_head) {
        this.item_head = item_head;
    }

    public ItemOwnerInfoBean getItem_owner_info() {
        return item_owner_info;
    }

    public void setItem_owner_info(ItemOwnerInfoBean item_owner_info) {
        this.item_owner_info = item_owner_info;
    }

    public LikeInfoBean getLike_info() {
        return like_info;
    }

    public void setLike_info(LikeInfoBean like_info) {
        this.like_info = like_info;
    }

    public String getContent_url() {
        return content_url;
    }

    public void setContent_url(String content_url) {
        this.content_url = content_url;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getItem_content() {
        return item_content;
    }

    public void setItem_content(String item_content) {
        this.item_content = item_content;
    }

    public boolean isHas_liked() {
        return has_liked;
    }

    public void setHas_liked(boolean has_liked) {
        this.has_liked = has_liked;
    }

    public boolean isIs_favourite() {
        return is_favourite;
    }

    public void setIs_favourite(boolean is_favourite) {
        this.is_favourite = is_favourite;
    }

    public String getPost_keywords() {
        return post_keywords;
    }

    public void setPost_keywords(String post_keywords) {
        this.post_keywords = post_keywords;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public boolean isShort_of_stock() {
        return short_of_stock;
    }

    public void setShort_of_stock(boolean short_of_stock) {
        this.short_of_stock = short_of_stock;
    }

    public List<ItemTypesBean> getItem_types() {
        return item_types;
    }

    public void setItem_types(List<ItemTypesBean> item_types) {
        this.item_types = item_types;
    }

    public List<String> getItem_img() {
        return item_img;
    }

    public void setItem_img(List<String> item_img) {
        this.item_img = item_img;
    }

    public List<CommentListBean> getComment_list() {
        return comment_list;
    }

    public void setComment_list(List<CommentListBean> comment_list) {
        this.comment_list = comment_list;
    }

    public List<AlikesBean> getAlikes() {
        return alikes;
    }

    public void setAlikes(List<AlikesBean> alikes) {
        this.alikes = alikes;
    }

    public static class ConmmentInfoBean extends BaseBean{
        public int total_count;
    }

    public static class ItemHeadBean extends BaseBean{
        /**
         * top : [{"img":"http://img8.ontheroadstore.com/iosupload/170912/bHdLNW8weXRBTE5hS216RXpLblZwZz09.jpg","url":"","type":0},{"img":"http://img8.ontheroadstore.com/iosupload/170912/VWcyOEJvZ09kcGFqSHRTK0R0S1FvUT09.jpg","url":"","type":0}]
         * intro : {"title":"犀牛黑洞 （单 ID:99）","praisenum":2,"price":[1],"fare":0}
         */

        private IntroBean intro;
        private List<TopBean> top;

        public IntroBean getIntro() {
            return intro;
        }

        public void setIntro(IntroBean intro) {
            this.intro = intro;
        }

        public List<TopBean> getTop() {
            return top;
        }

        public void setTop(List<TopBean> top) {
            this.top = top;
        }

        public static class IntroBean extends BaseBean{
            /**
             * title : 犀牛黑洞 （单 ID:99）
             * praisenum : 2
             * price : [1]
             * fare : 0
             */

            private String title;
            private int praisenum;
            private int fare;
            private List<Integer> price;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getPraisenum() {
                return praisenum;
            }

            public void setPraisenum(int praisenum) {
                this.praisenum = praisenum;
            }

            public int getFare() {
                return fare;
            }

            public void setFare(int fare) {
                this.fare = fare;
            }

            public List<Integer> getPrice() {
                return price;
            }

            public void setPrice(List<Integer> price) {
                this.price = price;
            }
        }

        public static class TopBean extends BaseBean{
            /**
             * img : http://img8.ontheroadstore.com/iosupload/170912/bHdLNW8weXRBTE5hS216RXpLblZwZz09.jpg
             * url :
             * type : 0
             */

            private String img;
            private String url;
            private int type;

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }

    public static class ItemOwnerInfoBean extends BaseBean{
        /**
         * id : 99
         * user_nicename : 坠落的天才少年酱哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈
         * avatar : http://wx.qlogo.cn/mmopen/Q3auHgzwzM5KQJ5HwQYbW5TUnibucrJVeNeUGhkcaL3BAyUibAG80ibT9Y1icAibc6jo3WAzjYFayJQcoDFf5ticOsInf9zwrIvic3sJQq3okSgjfE/64
         * motto : 这家伙太懒了，啥都没写，没劲哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈hhhh
         * fansnum : 7
         */

        private int id;
        private String user_nicename;
        private String avatar;
        private String motto;
        private int fansnum;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUser_nicename() {
            return user_nicename;
        }

        public void setUser_nicename(String user_nicename) {
            this.user_nicename = user_nicename;
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

        public int getFansnum() {
            return fansnum;
        }

        public void setFansnum(int fansnum) {
            this.fansnum = fansnum;
        }
    }

    public static class LikeInfoBean extends BaseBean{
        /**
         * like_num : 2
         * like_list : [{"uid":99,"avatar":"http://wx.qlogo.cn/mmopen/Q3auHgzwzM5KQJ5HwQYbW5TUnibucrJVeNeUGhkcaL3BAyUibAG80ibT9Y1icAibc6jo3WAzjYFayJQcoDFf5ticOsInf9zwrIvic3sJQq3okSgjfE/64"},{"uid":176,"avatar":"http://wx.qlogo.cn/mmopen/XhDicP4tEb7t5Wr1koOvaBdadeVVB1UlAtdu5YtwmGFbx2HeFibDgbXMqcKOnCqBheib5rKeXV4Ru3mKYHkyq7r9k54e6vias63Z/64"}]
         */

        private int like_num;
        private List<LikeListBean> like_list;

        public int getLike_num() {
            return like_num;
        }

        public void setLike_num(int like_num) {
            this.like_num = like_num;
        }

        public List<LikeListBean> getLike_list() {
            return like_list;
        }

        public void setLike_list(List<LikeListBean> like_list) {
            this.like_list = like_list;
        }

        public static class LikeListBean extends BaseBean{
            /**
             * uid : 99
             * avatar : http://wx.qlogo.cn/mmopen/Q3auHgzwzM5KQJ5HwQYbW5TUnibucrJVeNeUGhkcaL3BAyUibAG80ibT9Y1icAibc6jo3WAzjYFayJQcoDFf5ticOsInf9zwrIvic3sJQq3okSgjfE/64
             */

            private int uid;
            private String avatar;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }
        }
    }

    public static class ItemTypesBean extends BaseBean{
        /**
         * goodsTypeID : 942
         * goodsType : 默认款式
         * goodsPrice : 1
         * goodsStock : 15
         * unit : 件
         */

        private int goodsTypeID;
        private String goodsType;
        private String goodsPrice;
        private String goodsStock;
        private String unit;

        public int getGoodsTypeID() {
            return goodsTypeID;
        }

        public void setGoodsTypeID(int goodsTypeID) {
            this.goodsTypeID = goodsTypeID;
        }

        public String getGoodsType() {
            return goodsType;
        }

        public void setGoodsType(String goodsType) {
            this.goodsType = goodsType;
        }

        public String getGoodsPrice() {
            return goodsPrice;
        }

        public void setGoodsPrice(String goodsPrice) {
            this.goodsPrice = goodsPrice;
        }

        public String getGoodsStock() {
            return goodsStock;
        }

        public void setGoodsStock(String goodsStock) {
            this.goodsStock = goodsStock;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }
    }

    public static class CommentListBean extends BaseBean{
        /**
         * id : 5322
         * post_table : posts
         * post_id : 300758
         * url : Portal/HsArticle/index/id/300758.html
         * uid : 64
         * full_name : 德德
         * uid_img : http://wx.qlogo.cn/mmopen/22YD2oBcVUakSF4O8JCmoxTvwDWqp5up7XJExnCnAyS0UDGhTICvicgraS5W3E2aCFKPQTHUtOmFdOjfrPvp9D9AJ89vEGEWg/64
         * to_uid : 0
         * be_commented_username : null
         * content : asdasdasd
         * parentid : 0
         * type : 0
         * createtime : 9月20日 17:42
         * path : 0-5322
         * status : 1
         * children_nums : 4
         * origincreatetime : 2017-09-20 17:42:50
         */

        private int id;
        private String post_table;
        private int post_id;
        private String url;
        private int uid;
        private String full_name;
        private String uid_img;
        private int to_uid;
        private Object be_commented_username;
        private String content;
        private int parentid;
        private int type;
        private String createtime;
        private String path;
        private int status;
        private int children_nums;
        private String origincreatetime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPost_table() {
            return post_table;
        }

        public void setPost_table(String post_table) {
            this.post_table = post_table;
        }

        public int getPost_id() {
            return post_id;
        }

        public void setPost_id(int post_id) {
            this.post_id = post_id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getFull_name() {
            return full_name;
        }

        public void setFull_name(String full_name) {
            this.full_name = full_name;
        }

        public String getUid_img() {
            return uid_img;
        }

        public void setUid_img(String uid_img) {
            this.uid_img = uid_img;
        }

        public int getTo_uid() {
            return to_uid;
        }

        public void setTo_uid(int to_uid) {
            this.to_uid = to_uid;
        }

        public Object getBe_commented_username() {
            return be_commented_username;
        }

        public void setBe_commented_username(Object be_commented_username) {
            this.be_commented_username = be_commented_username;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getParentid() {
            return parentid;
        }

        public void setParentid(int parentid) {
            this.parentid = parentid;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getChildren_nums() {
            return children_nums;
        }

        public void setChildren_nums(int children_nums) {
            this.children_nums = children_nums;
        }

        public String getOrigincreatetime() {
            return origincreatetime;
        }

        public void setOrigincreatetime(String origincreatetime) {
            this.origincreatetime = origincreatetime;
        }
    }

    public static class AlikesBean extends BaseBean{
        /**
         * id : 300763
         * post_title : 黑库测试
         * post_keywords :
         * image : http://img8.ontheroadstore.com/upload/170913/063ea27aa5b3c4846c938c14fca57861.jpg
         */

        private long id;
        private String post_title;
        private String post_keywords;
        private String image;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getPost_title() {
            return post_title;
        }

        public void setPost_title(String post_title) {
            this.post_title = post_title;
        }

        public String getPost_keywords() {
            return post_keywords;
        }

        public void setPost_keywords(String post_keywords) {
            this.post_keywords = post_keywords;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
