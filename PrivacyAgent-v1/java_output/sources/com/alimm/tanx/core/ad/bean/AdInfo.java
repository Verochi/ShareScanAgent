package com.alimm.tanx.core.ad.bean;

/* loaded from: classes.dex */
public class AdInfo extends com.alimm.tanx.core.ad.bean.BaseBean {
    private java.lang.String decrypt;

    @com.alibaba.fastjson.annotation.JSONField(name = "id")
    private java.lang.String requestId;

    @com.alibaba.fastjson.annotation.JSONField(name = "seat")
    private java.util.List<com.alimm.tanx.core.ad.bean.SeatInfo> seatList;

    @com.alibaba.fastjson.annotation.JSONField(name = "status")
    private int status;

    public int getAdCount() {
        java.util.List<com.alimm.tanx.core.ad.bean.SeatInfo> list = this.seatList;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        int i = 0;
        for (com.alimm.tanx.core.ad.bean.SeatInfo seatInfo : this.seatList) {
            i += seatInfo.getBidList() == null ? 0 : seatInfo.getBidList().size();
        }
        return i;
    }

    public java.util.List<com.alimm.tanx.core.ad.bean.BidInfo> getBidInfoList() {
        java.util.List<com.alimm.tanx.core.ad.bean.SeatInfo> list = this.seatList;
        if (list == null || list.size() <= 0 || this.seatList.get(0).getBidList() == null) {
            return null;
        }
        return this.seatList.get(0).getBidList();
    }

    public java.lang.String getDecrypt() {
        return this.decrypt;
    }

    public java.lang.String getRequestId() {
        return this.requestId;
    }

    public java.util.List<com.alimm.tanx.core.ad.bean.SeatInfo> getSeatList() {
        return this.seatList;
    }

    public int getStatus() {
        return this.status;
    }

    public void setDecrypt(java.lang.String str) {
        this.decrypt = str;
    }

    public void setRequestId(java.lang.String str) {
        this.requestId = str;
    }

    public void setSeatList(java.util.List<com.alimm.tanx.core.ad.bean.SeatInfo> list) {
        this.seatList = list;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
