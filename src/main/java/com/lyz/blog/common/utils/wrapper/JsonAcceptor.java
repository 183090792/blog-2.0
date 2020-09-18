package com.lyz.blog.common.utils.wrapper;

/**
 * Created by Administrator on 2018/4/9 0009.
 */
public class JsonAcceptor<T> {

    /**
     * result : {"resultCode":"8888","body":{"total":0,"totalPage":0,"pageSize":5,"page":1,"rows":[{"good_price":11,"down_time":"0314","rate_plan_type":2,"activity_platform":2,"useable_conditions":0,"pageSize":5,"remark":"asd","audit_status":1,"coupon_total":500,"title":"哈哈","self_picture_url":"<%=path%>/static/img/invite_wx.png","audit_time":"14","coupon_begin_time":"0312","taobao_good_id":0,"taobao_good_picture_url":"<%=path%>/static/img/invite_wx.png","coupon_price":12,"video_click_url":"asd","create_time":"12","startRow":0,"market_word":"12","auditor":0,"release_type":2,"good_rate":13,"coupon_click_url":"http://uland.taobao.com/quan/detail?sellerId=3716124988&activityId=fbaf263610484c5c85d09c8d6221daec","zs_good_id":2,"user_id":2,"good_click_url":"asd","audit_comment":"16","up_time":"31","commission_rate":12,"page":1,"coupon_end_time":"0","good_category":3},{"good_price":20,"down_time":"2018-03-21-2","rate_plan_type":0,"activity_platform":2,"useable_conditions":20,"pageSize":5,"audit_status":1,"coupon_total":20,"title":"qweqwe,qweqwe","self_picture_url":"<%=path%>/static/img/invite_wx.png","taobao_good_id":0,"taobao_good_picture_url":"<%=path%>/static/img/invite_wx.png","coupon_price":20,"video_click_url":"qwe","startRow":0,"market_word":"qweqwe","auditor":0,"release_type":0,"good_rate":0,"coupon_click_url":"1","zs_good_id":28,"user_id":2,"good_click_url":"qwe","audit_comment":"weqwe","up_time":"2018-03-07-1","commission_rate":0,"page":1,"good_category":5},{"good_price":20,"down_time":"2018-03-21-2","rate_plan_type":0,"activity_platform":2,"useable_conditions":20,"pageSize":5,"audit_status":3,"coupon_total":20,"title":"qweqwe,qweqwe","self_picture_url":"<%=path%>/static/img/invite_wx.png","taobao_good_id":0,"taobao_good_picture_url":"<%=path%>/static/img/invite_wx.png","coupon_price":20,"video_click_url":"qwe","startRow":0,"market_word":"qweqwe","auditor":0,"release_type":0,"good_rate":0,"coupon_click_url":"qweqwe","zs_good_id":29,"user_id":2,"good_click_url":"qwe","audit_comment":"weqwe","up_time":"2018-03-07-1","commission_rate":0,"page":1,"good_category":3},{"good_price":20,"down_time":"2018-03-21-3","rate_plan_type":0,"activity_platform":2,"useable_conditions":20,"pageSize":5,"audit_status":4,"coupon_total":20,"title":"qweqwe,qweqwe","self_picture_url":"<%=path%>/static/img/invite_wx.png","taobao_good_id":0,"taobao_good_picture_url":"<%=path%>/static/img/invite_wx.png","coupon_price":20,"video_click_url":"qwe","startRow":0,"market_word":"qweqwe","auditor":0,"release_type":0,"good_rate":0,"coupon_click_url":"qweqwe","zs_good_id":30,"user_id":2,"good_click_url":"qwe","audit_comment":"weqwe","up_time":"2018-03-07-2","commission_rate":0,"page":1,"good_category":4},{"good_price":20,"down_time":"2018-03-21-1","rate_plan_type":0,"activity_platform":2,"useable_conditions":20,"pageSize":5,"audit_status":5,"coupon_total":20,"title":"qweqwe,qweqwe","self_picture_url":"<%=path%>/static/img/invite_wx.png","taobao_good_id":0,"taobao_good_picture_url":"<%=path%>/static/img/invite_wx.png","coupon_price":20,"video_click_url":"qwe","startRow":0,"market_word":"qweqwe","auditor":0,"release_type":0,"good_rate":0,"coupon_click_url":"qweqwe","zs_good_id":31,"user_id":2,"good_click_url":"qwe","audit_comment":"weqwe","up_time":"2018-03-07-1","commission_rate":0,"page":1,"good_category":4}]},"resultMsg":"操作成功"}
     */
    private ResultEntity result;

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public ResultEntity getResult() {
        return result;
    }

    public class ResultEntity {
        /**
         * resultCode : 8888
         * body : {"total":0,"totalPage":0,"pageSize":5,"page":1,"rows":[{"good_price":11,"down_time":"0314","rate_plan_type":2,"activity_platform":2,"useable_conditions":0,"pageSize":5,"remark":"asd","audit_status":1,"coupon_total":500,"title":"哈哈","self_picture_url":"<%=path%>/static/img/invite_wx.png","audit_time":"14","coupon_begin_time":"0312","taobao_good_id":0,"taobao_good_picture_url":"<%=path%>/static/img/invite_wx.png","coupon_price":12,"video_click_url":"asd","create_time":"12","startRow":0,"market_word":"12","auditor":0,"release_type":2,"good_rate":13,"coupon_click_url":"http://uland.taobao.com/quan/detail?sellerId=3716124988&activityId=fbaf263610484c5c85d09c8d6221daec","zs_good_id":2,"user_id":2,"good_click_url":"asd","audit_comment":"16","up_time":"31","commission_rate":12,"page":1,"coupon_end_time":"0","good_category":3},{"good_price":20,"down_time":"2018-03-21-2","rate_plan_type":0,"activity_platform":2,"useable_conditions":20,"pageSize":5,"audit_status":1,"coupon_total":20,"title":"qweqwe,qweqwe","self_picture_url":"<%=path%>/static/img/invite_wx.png","taobao_good_id":0,"taobao_good_picture_url":"<%=path%>/static/img/invite_wx.png","coupon_price":20,"video_click_url":"qwe","startRow":0,"market_word":"qweqwe","auditor":0,"release_type":0,"good_rate":0,"coupon_click_url":"1","zs_good_id":28,"user_id":2,"good_click_url":"qwe","audit_comment":"weqwe","up_time":"2018-03-07-1","commission_rate":0,"page":1,"good_category":5},{"good_price":20,"down_time":"2018-03-21-2","rate_plan_type":0,"activity_platform":2,"useable_conditions":20,"pageSize":5,"audit_status":3,"coupon_total":20,"title":"qweqwe,qweqwe","self_picture_url":"<%=path%>/static/img/invite_wx.png","taobao_good_id":0,"taobao_good_picture_url":"<%=path%>/static/img/invite_wx.png","coupon_price":20,"video_click_url":"qwe","startRow":0,"market_word":"qweqwe","auditor":0,"release_type":0,"good_rate":0,"coupon_click_url":"qweqwe","zs_good_id":29,"user_id":2,"good_click_url":"qwe","audit_comment":"weqwe","up_time":"2018-03-07-1","commission_rate":0,"page":1,"good_category":3},{"good_price":20,"down_time":"2018-03-21-3","rate_plan_type":0,"activity_platform":2,"useable_conditions":20,"pageSize":5,"audit_status":4,"coupon_total":20,"title":"qweqwe,qweqwe","self_picture_url":"<%=path%>/static/img/invite_wx.png","taobao_good_id":0,"taobao_good_picture_url":"<%=path%>/static/img/invite_wx.png","coupon_price":20,"video_click_url":"qwe","startRow":0,"market_word":"qweqwe","auditor":0,"release_type":0,"good_rate":0,"coupon_click_url":"qweqwe","zs_good_id":30,"user_id":2,"good_click_url":"qwe","audit_comment":"weqwe","up_time":"2018-03-07-2","commission_rate":0,"page":1,"good_category":4},{"good_price":20,"down_time":"2018-03-21-1","rate_plan_type":0,"activity_platform":2,"useable_conditions":20,"pageSize":5,"audit_status":5,"coupon_total":20,"title":"qweqwe,qweqwe","self_picture_url":"<%=path%>/static/img/invite_wx.png","taobao_good_id":0,"taobao_good_picture_url":"<%=path%>/static/img/invite_wx.png","coupon_price":20,"video_click_url":"qwe","startRow":0,"market_word":"qweqwe","auditor":0,"release_type":0,"good_rate":0,"coupon_click_url":"qweqwe","zs_good_id":31,"user_id":2,"good_click_url":"qwe","audit_comment":"weqwe","up_time":"2018-03-07-1","commission_rate":0,"page":1,"good_category":4}]}
         * resultMsg : 操作成功
         */
        private String resultCode;
        private T body;
        private String resultMsg;

        public void setResultCode(String resultCode) {
            this.resultCode = resultCode;
        }

        public void setBody(T body) {
            this.body = body;
        }

        public void setResultMsg(String resultMsg) {
            this.resultMsg = resultMsg;
        }

        public String getResultCode() {
            return resultCode;
        }

        public T getBody() {
            return body;
        }

        public String getResultMsg() {
            return resultMsg;
        }


    }
}
