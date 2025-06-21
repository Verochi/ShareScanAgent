package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class ak {
    private java.lang.String a;
    private java.util.ArrayList<com.umeng.analytics.pro.al> b = new java.util.ArrayList<>();

    public ak(java.lang.String str) {
        this.a = "";
        this.a = str;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        a();
    }

    private void a() {
        try {
            if (!this.a.contains(",")) {
                java.lang.String str = this.a;
                if (android.text.TextUtils.isEmpty(str)) {
                    return;
                }
                java.lang.String trim = str.trim();
                if (this.b != null) {
                    this.b.add(new com.umeng.analytics.pro.al(trim));
                    return;
                }
                return;
            }
            for (java.lang.String str2 : this.a.split(",")) {
                if (!android.text.TextUtils.isEmpty(str2)) {
                    java.lang.String trim2 = str2.trim();
                    if (this.b != null) {
                        this.b.add(new com.umeng.analytics.pro.al(trim2));
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public boolean a(int i) {
        try {
            java.util.ArrayList<com.umeng.analytics.pro.al> arrayList = this.b;
            if (arrayList == null) {
                return false;
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.umeng.analytics.pro.al alVar = this.b.get(i2);
                if (alVar != null && alVar.a(i)) {
                    return true;
                }
            }
            return false;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }
}
