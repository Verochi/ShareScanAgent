package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class y1 extends org.json.JSONArray {
    public y1() {
    }

    public y1(java.lang.String str) throws org.json.JSONException {
        super(str);
    }

    public synchronized int a(java.lang.String str) throws org.json.JSONException {
        if (android.text.TextUtils.isEmpty(str)) {
            return -1;
        }
        for (int i = 0; i < length(); i++) {
            synchronized (this) {
                if (!super.getString(i).startsWith(str)) {
                }
            }
            return i;
        }
        return -1;
    }

    public synchronized void a(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            super.remove(0);
            com.zx.a.I8b7.r2.b("removeM ".concat(java.lang.String.valueOf(i2)));
        }
    }

    @Override // org.json.JSONArray
    public synchronized java.lang.String getString(int i) throws org.json.JSONException {
        return super.getString(i);
    }

    @Override // org.json.JSONArray
    public synchronized org.json.JSONArray put(int i, java.lang.Object obj) throws org.json.JSONException {
        return super.put(i, obj);
    }

    @Override // org.json.JSONArray
    public synchronized org.json.JSONArray put(java.lang.Object obj) {
        return super.put(obj);
    }

    @Override // org.json.JSONArray
    public synchronized org.json.JSONArray put(boolean z) {
        return super.put(z);
    }

    @Override // org.json.JSONArray
    public synchronized java.lang.Object remove(int i) {
        return super.remove(i);
    }

    @Override // org.json.JSONArray
    public synchronized java.lang.String toString() {
        return super.toString();
    }
}
