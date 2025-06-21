package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public class AdSlot implements com.bytedance.sdk.openadsdk.SlotType {
    private boolean bt;
    private int cp;
    private boolean d;
    private java.lang.String es;
    private java.lang.String h;
    private com.bytedance.sdk.openadsdk.TTAdLoadType iq;
    private int iz;
    private int[] j;
    private int k;
    private int kz;
    private java.lang.String n;
    private boolean o;
    private java.lang.String q;
    private java.lang.String qm;
    private int t;
    private java.lang.String te;
    private java.lang.String tj;
    private java.lang.String tq;
    private int u;
    private float v;
    private int vl;
    private java.lang.String vw;
    private int wg;
    private boolean x;
    private float yl;
    private java.lang.String z;

    public static class Builder {
        private float cp;
        private java.lang.String h;
        private java.lang.String iq;
        private int iz;
        private int[] j;
        private int k;
        private java.lang.String n;
        private java.lang.String o;
        private java.lang.String q;
        private java.lang.String te;
        private java.lang.String tj;
        private java.lang.String tq;
        private float u;
        private int vl;
        private java.lang.String vw;
        private int z;
        private int wg = com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH;
        private int t = 320;
        private boolean v = true;
        private boolean yl = false;
        private boolean kz = false;
        private int bt = 1;
        private java.lang.String x = "defaultUser";
        private int es = 2;
        private boolean d = true;
        private com.bytedance.sdk.openadsdk.TTAdLoadType qm = com.bytedance.sdk.openadsdk.TTAdLoadType.UNKNOWN;

        public com.bytedance.sdk.openadsdk.AdSlot build() {
            com.bytedance.sdk.openadsdk.AdSlot adSlot = new com.bytedance.sdk.openadsdk.AdSlot(null);
            adSlot.vw = this.vw;
            adSlot.kz = this.bt;
            adSlot.bt = this.v;
            adSlot.o = this.yl;
            adSlot.x = this.kz;
            adSlot.wg = this.wg;
            adSlot.t = this.t;
            adSlot.v = this.u;
            adSlot.yl = this.cp;
            adSlot.es = this.o;
            adSlot.z = this.x;
            adSlot.vl = this.es;
            adSlot.cp = this.z;
            adSlot.d = this.d;
            adSlot.j = this.j;
            adSlot.k = this.k;
            adSlot.te = this.te;
            adSlot.q = this.n;
            adSlot.qm = this.h;
            adSlot.n = this.iq;
            adSlot.u = this.vl;
            adSlot.tq = this.tq;
            adSlot.h = this.q;
            adSlot.iq = this.qm;
            adSlot.tj = this.tj;
            adSlot.iz = this.iz;
            return adSlot;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder setAdCount(int i) {
            if (i <= 0) {
                i = 1;
            }
            if (i > 20) {
                i = 20;
            }
            this.bt = i;
            return this;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder setAdId(java.lang.String str) {
            this.n = str;
            return this;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder setAdLoadType(com.bytedance.sdk.openadsdk.TTAdLoadType tTAdLoadType) {
            this.qm = tTAdLoadType;
            return this;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder setAdType(int i) {
            this.vl = i;
            return this;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder setAdloadSeq(int i) {
            this.k = i;
            return this;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder setCodeId(java.lang.String str) {
            this.vw = str;
            return this;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder setCreativeId(java.lang.String str) {
            this.h = str;
            return this;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder setExpressViewAcceptedSize(float f, float f2) {
            this.u = f;
            this.cp = f2;
            return this;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder setExt(java.lang.String str) {
            this.iq = str;
            return this;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder setExternalABVid(int... iArr) {
            this.j = iArr;
            return this;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder setImageAcceptedSize(int i, int i2) {
            this.wg = i;
            this.t = i2;
            return this;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder setIsAutoPlay(boolean z) {
            this.d = z;
            return this;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder setMediaExtra(java.lang.String str) {
            this.o = str;
            return this;
        }

        @java.lang.Deprecated
        public com.bytedance.sdk.openadsdk.AdSlot.Builder setNativeAdType(int i) {
            this.z = i;
            return this;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder setOrientation(int i) {
            this.es = i;
            return this;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder setPrimeRit(java.lang.String str) {
            this.te = str;
            return this;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder setRewardAmount(int i) {
            this.iz = i;
            return this;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder setRewardName(java.lang.String str) {
            this.tj = str;
            return this;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder setSupportDeepLink(boolean z) {
            this.v = z;
            return this;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder setUserData(java.lang.String str) {
            this.q = str;
            return this;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder setUserID(java.lang.String str) {
            this.x = str;
            return this;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder supportIconStyle() {
            this.kz = true;
            return this;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder supportRenderControl() {
            this.yl = true;
            return this;
        }

        public com.bytedance.sdk.openadsdk.AdSlot.Builder withBid(java.lang.String str) {
            if (str == null) {
                return this;
            }
            this.tq = str;
            return this;
        }
    }

    private AdSlot() {
        this.vl = 2;
        this.d = true;
    }

    public /* synthetic */ AdSlot(com.bytedance.sdk.openadsdk.AdSlot.AnonymousClass1 anonymousClass1) {
        this();
    }

    private java.lang.String vw(java.lang.String str, int i) {
        if (i <= 0) {
            return str;
        }
        try {
            org.json.JSONObject jSONObject = android.text.TextUtils.isEmpty(str) ? new org.json.JSONObject() : new org.json.JSONObject(str);
            jSONObject.put("_tt_group_load_more", i);
            return jSONObject.toString();
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return str;
        }
    }

    public int getAdCount() {
        return this.kz;
    }

    public java.lang.String getAdId() {
        return this.q;
    }

    public com.bytedance.sdk.openadsdk.TTAdLoadType getAdLoadType() {
        return this.iq;
    }

    public int getAdType() {
        return this.u;
    }

    public int getAdloadSeq() {
        return this.k;
    }

    public java.lang.String getBidAdm() {
        return this.tq;
    }

    public java.lang.String getCodeId() {
        return this.vw;
    }

    public java.lang.String getCreativeId() {
        return this.qm;
    }

    public float getExpressViewAcceptedHeight() {
        return this.yl;
    }

    public float getExpressViewAcceptedWidth() {
        return this.v;
    }

    public java.lang.String getExt() {
        return this.n;
    }

    public int[] getExternalABVid() {
        return this.j;
    }

    public int getImgAcceptedHeight() {
        return this.t;
    }

    public int getImgAcceptedWidth() {
        return this.wg;
    }

    public java.lang.String getMediaExtra() {
        return this.es;
    }

    @java.lang.Deprecated
    public int getNativeAdType() {
        return this.cp;
    }

    public int getOrientation() {
        return this.vl;
    }

    public java.lang.String getPrimeRit() {
        java.lang.String str = this.te;
        return str == null ? "" : str;
    }

    public int getRewardAmount() {
        return this.iz;
    }

    public java.lang.String getRewardName() {
        return this.tj;
    }

    public java.lang.String getUserData() {
        return this.h;
    }

    public java.lang.String getUserID() {
        return this.z;
    }

    public boolean isAutoPlay() {
        return this.d;
    }

    public boolean isSupportDeepLink() {
        return this.bt;
    }

    public boolean isSupportIconStyle() {
        return this.x;
    }

    public boolean isSupportRenderConrol() {
        return this.o;
    }

    public void setAdCount(int i) {
        this.kz = i;
    }

    public void setAdLoadType(com.bytedance.sdk.openadsdk.TTAdLoadType tTAdLoadType) {
        this.iq = tTAdLoadType;
    }

    public void setExternalABVid(int... iArr) {
        this.j = iArr;
    }

    public void setGroupLoadMore(int i) {
        this.es = vw(this.es, i);
    }

    public void setNativeAdType(int i) {
        this.cp = i;
    }

    public void setUserData(java.lang.String str) {
        this.h = str;
    }

    public org.json.JSONObject toJsonObj() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("mCodeId", this.vw);
            jSONObject.put("mIsAutoPlay", this.d);
            jSONObject.put("mImgAcceptedWidth", this.wg);
            jSONObject.put("mImgAcceptedHeight", this.t);
            jSONObject.put("mExpressViewAcceptedWidth", this.v);
            jSONObject.put("mExpressViewAcceptedHeight", this.yl);
            jSONObject.put("mAdCount", this.kz);
            jSONObject.put("mSupportDeepLink", this.bt);
            jSONObject.put("mSupportRenderControl", this.o);
            jSONObject.put("mSupportIconStyle", this.x);
            jSONObject.put("mMediaExtra", this.es);
            jSONObject.put("mUserID", this.z);
            jSONObject.put("mOrientation", this.vl);
            jSONObject.put("mNativeAdType", this.cp);
            jSONObject.put("mAdloadSeq", this.k);
            jSONObject.put("mPrimeRit", this.te);
            jSONObject.put("mAdId", this.q);
            jSONObject.put("mCreativeId", this.qm);
            jSONObject.put("mExt", this.n);
            jSONObject.put("mBidAdm", this.tq);
            jSONObject.put("mUserData", this.h);
            jSONObject.put("mAdLoadType", this.iq);
        } catch (java.lang.Exception unused) {
        }
        return jSONObject;
    }

    public java.lang.String toString() {
        return "AdSlot{mCodeId='" + this.vw + "', mImgAcceptedWidth=" + this.wg + ", mImgAcceptedHeight=" + this.t + ", mExpressViewAcceptedWidth=" + this.v + ", mExpressViewAcceptedHeight=" + this.yl + ", mAdCount=" + this.kz + ", mSupportDeepLink=" + this.bt + ", mSupportRenderControl=" + this.o + ", mSupportIconStyle=" + this.x + ", mMediaExtra='" + this.es + "', mUserID='" + this.z + "', mOrientation=" + this.vl + ", mNativeAdType=" + this.cp + ", mIsAutoPlay=" + this.d + ", mPrimeRit" + this.te + ", mAdloadSeq" + this.k + ", mAdId" + this.q + ", mCreativeId" + this.qm + ", mExt" + this.n + ", mUserData" + this.h + ", mAdLoadType" + this.iq + '}';
    }
}
