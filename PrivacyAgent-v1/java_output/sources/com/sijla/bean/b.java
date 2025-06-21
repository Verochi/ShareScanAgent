package com.sijla.bean;

/* loaded from: classes19.dex */
public final class b extends org.json.JSONObject {
    private java.util.List<java.lang.String> a = new java.util.ArrayList();

    public final java.lang.String a() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (this.a != null) {
            for (int i = 0; i < this.a.size(); i++) {
                sb.append(this.a.get(i));
                if (i != this.a.size() - 1) {
                    sb.append("\t");
                }
            }
        }
        return sb.toString();
    }

    public final org.json.JSONObject a(java.lang.String str, java.lang.String str2) {
        this.a.add(str2);
        return super.put(str, str2);
    }
}
