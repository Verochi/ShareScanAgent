package com.alimm.tanx.core.request;

/* loaded from: classes.dex */
public class tanxc_do {
    public static com.alimm.tanx.core.ad.bean.AdInfo tanxc_do(com.alimm.tanx.core.ad.bean.AdInfo adInfo) {
        if (adInfo != null) {
            try {
                if ((adInfo.getStatus() == 0 || adInfo.getStatus() == 1) && adInfo.getSeatList() != null && adInfo.getSeatList().size() > 0) {
                    for (int i = 0; i < adInfo.getSeatList().size(); i++) {
                        java.util.List<java.lang.String> rawBidList = adInfo.getSeatList().get(i).getRawBidList();
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        if (rawBidList != null && rawBidList.size() > 0) {
                            for (int i2 = 0; i2 < rawBidList.size(); i2++) {
                                com.alimm.tanx.core.ad.bean.BidInfo bidInfo = (com.alimm.tanx.core.ad.bean.BidInfo) com.alibaba.fastjson.JSON.parseObject(rawBidList.get(i2), com.alimm.tanx.core.ad.bean.BidInfo.class);
                                bidInfo.setRawJsonStr(tanxc_do(rawBidList.get(i2)));
                                arrayList.add(bidInfo);
                            }
                        }
                        adInfo.getSeatList().get(i).setBidList(arrayList);
                    }
                }
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e(e);
            }
        }
        return adInfo;
    }

    private static java.lang.String tanxc_do(java.lang.String str) {
        try {
            com.alibaba.fastjson.JSONObject parseObject = com.alibaba.fastjson.JSON.parseObject(str);
            parseObject.remove("impression_tracking_url");
            parseObject.remove("click_tracking_url");
            parseObject.remove("winnotice_url");
            return com.alibaba.fastjson.JSON.toJSONString(parseObject);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
            return str;
        }
    }
}
