package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class ag implements com.umeng.analytics.pro.ac {
    private java.util.Set<java.lang.Integer> a;

    public ag(java.util.Set<java.lang.Integer> set) {
        this.a = null;
        this.a = new java.util.HashSet(set);
    }

    @Override // com.umeng.analytics.pro.ac
    public boolean a() {
        try {
            int i = java.util.Calendar.getInstance().get(11);
            java.util.Set<java.lang.Integer> set = this.a;
            if (set != null && set.contains(java.lang.Integer.valueOf(i))) {
                return true;
            }
            java.lang.String str = "";
            java.util.Iterator<java.lang.Integer> it = this.a.iterator();
            while (it.hasNext()) {
                str = str + it.next() + ",";
            }
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "HourOn skipped. hour of day: " + i + "; config: " + str);
            return false;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    @Override // com.umeng.analytics.pro.ac
    public boolean b() {
        return !a();
    }

    @Override // com.umeng.analytics.pro.ac
    public long c() {
        return 0L;
    }
}
