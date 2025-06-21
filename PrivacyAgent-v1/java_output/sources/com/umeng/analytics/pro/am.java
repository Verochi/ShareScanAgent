package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class am implements com.umeng.analytics.pro.ac {
    private java.util.Set<java.lang.Integer> a;

    public am(java.util.Set<java.lang.Integer> set) {
        this.a = null;
        this.a = new java.util.HashSet(set);
    }

    @Override // com.umeng.analytics.pro.ac
    public boolean a() {
        try {
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.setTimeInMillis(java.lang.System.currentTimeMillis());
            int i = 7;
            int i2 = calendar.get(7) - 1;
            if (i2 != 0) {
                i = i2;
            }
            java.util.Set<java.lang.Integer> set = this.a;
            if (set != null && set.contains(java.lang.Integer.valueOf(i))) {
                return true;
            }
            java.lang.String str = "";
            java.util.Iterator<java.lang.Integer> it = this.a.iterator();
            while (it.hasNext()) {
                str = str + it.next() + ",";
            }
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "WeekOn skipped. day of week: " + i + "; config: " + str);
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
