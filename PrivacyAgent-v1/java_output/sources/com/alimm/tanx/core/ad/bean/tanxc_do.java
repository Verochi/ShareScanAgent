package com.alimm.tanx.core.ad.bean;

/* loaded from: classes.dex */
public class tanxc_do implements com.alimm.tanx.core.ad.listener.bean.IClickBean {
    private java.lang.String tanxc_do;
    private int tanxc_for;
    private java.lang.String tanxc_if;
    private java.lang.Integer[] tanxc_int;

    @Override // com.alimm.tanx.core.ad.listener.bean.IClickBean
    public java.lang.String getClickThroughUrl() {
        return this.tanxc_do;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IClickBean
    public java.lang.String getDeepLinkUrl() {
        return this.tanxc_if;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IClickBean
    public boolean getInteractType(int i) {
        return getInteractType() != null && getInteractType().length > 0 && java.util.Arrays.binarySearch(getInteractType(), java.lang.Integer.valueOf(i)) >= 0;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IClickBean
    public java.lang.Integer[] getInteractType() {
        return this.tanxc_int;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IClickBean
    public int getInteractType2Int() {
        java.lang.Integer[] numArr = this.tanxc_int;
        if (numArr == null || numArr.length <= 0) {
            return -1;
        }
        return numArr[0].intValue();
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IClickBean
    public int getOpenType() {
        return this.tanxc_for;
    }

    public void tanxc_do(int i) {
        this.tanxc_for = i;
    }

    public void tanxc_do(java.lang.String str) {
        this.tanxc_do = str;
    }

    public void tanxc_do(java.lang.Integer[] numArr) {
        this.tanxc_int = numArr;
    }

    public void tanxc_if(java.lang.String str) {
        this.tanxc_if = str;
    }
}
