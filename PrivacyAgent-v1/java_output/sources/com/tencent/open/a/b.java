package com.tencent.open.a;

/* loaded from: classes19.dex */
public class b implements java.io.Serializable {
    public final java.util.HashMap<java.lang.String, java.lang.String> a = new java.util.HashMap<>();

    public b(android.os.Bundle bundle) {
        if (bundle != null) {
            for (java.lang.String str : bundle.keySet()) {
                this.a.put(str, bundle.getString(str));
            }
        }
    }
}
