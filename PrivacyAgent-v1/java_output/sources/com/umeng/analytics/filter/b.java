package com.umeng.analytics.filter;

/* loaded from: classes19.dex */
public class b extends com.umeng.analytics.filter.EventList {
    private com.umeng.analytics.filter.d a;
    private java.lang.Object b;

    public b(java.lang.String str, java.lang.String str2) {
        super(str, str2);
        this.b = new java.lang.Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    public void eventListChange() {
        if (android.text.TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.b) {
            this.a = null;
            this.a = new com.umeng.analytics.filter.d(true, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(java.lang.String str) {
        boolean a;
        if (android.text.TextUtils.isEmpty(this.mEventList)) {
            return true;
        }
        synchronized (this.b) {
            if (this.a == null) {
                this.a = new com.umeng.analytics.filter.d(true, this.mEventList);
            }
            a = this.a.a(str);
        }
        return a;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z) {
        com.umeng.analytics.AnalyticsConfig.CLEAR_EKV_WL = z;
    }
}
