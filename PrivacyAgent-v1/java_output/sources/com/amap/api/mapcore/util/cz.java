package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public class cz {
    private static boolean a;
    private static volatile com.amap.api.mapcore.util.cz d;
    private java.util.Hashtable<java.lang.String, java.lang.String> b = new java.util.Hashtable<>();
    private java.lang.ref.WeakReference<android.content.Context> c = null;

    private cz() {
    }

    public static com.amap.api.mapcore.util.cz a() {
        if (d == null) {
            synchronized (com.amap.api.mapcore.util.cz.class) {
                if (d == null) {
                    d = new com.amap.api.mapcore.util.cz();
                }
            }
        }
        return d;
    }

    private void a(java.lang.String str) {
        java.util.Hashtable<java.lang.String, java.lang.String> hashtable;
        if (str == null || (hashtable = this.b) == null) {
            return;
        }
        synchronized (hashtable) {
            java.lang.String b = com.amap.api.mapcore.util.fd.b(str);
            java.util.Hashtable<java.lang.String, java.lang.String> hashtable2 = this.b;
            if (hashtable2 != null && !hashtable2.contains(b)) {
                this.b.put(b, str);
            }
            if (e()) {
                d();
            }
        }
    }

    public static void a(boolean z) {
        a = z;
    }

    public static void b() {
        if (d != null) {
            if (d.b != null && d.b.size() > 0) {
                synchronized (d.b) {
                    d.d();
                    if (d.c != null) {
                        d.c.clear();
                    }
                }
            }
            d = null;
        }
        a(false);
    }

    public static boolean c() {
        return a;
    }

    private void d() {
        java.lang.ref.WeakReference<android.content.Context> weakReference;
        if (!a) {
            this.b.clear();
            return;
        }
        if (this.b != null) {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            int size = this.b.size();
            if (size > 0) {
                stringBuffer.append("[");
                java.util.Iterator<java.lang.String> it = this.b.values().iterator();
                int i = 0;
                while (it.hasNext()) {
                    i++;
                    stringBuffer.append(it.next());
                    if (i < size) {
                        stringBuffer.append(",");
                    }
                }
                stringBuffer.append("]");
                java.lang.String stringBuffer2 = stringBuffer.toString();
                if (!android.text.TextUtils.isEmpty(stringBuffer2) && (weakReference = this.c) != null && weakReference.get() != null) {
                    com.amap.api.mapcore.util.hn.a(stringBuffer2, this.c.get());
                }
            }
            this.b.clear();
        }
    }

    private boolean e() {
        java.util.Hashtable<java.lang.String, java.lang.String> hashtable = this.b;
        return hashtable != null && hashtable.size() > 20;
    }

    public final void a(android.content.Context context) {
        if (context != null) {
            this.c = new java.lang.ref.WeakReference<>(context);
        }
    }

    public final void a(com.amap.api.maps.model.LatLng latLng, java.lang.String str, java.lang.String str2) {
        if (!a) {
            this.b.clear();
            return;
        }
        if (latLng == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("\"lon\":");
        stringBuffer.append(latLng.longitude);
        stringBuffer.append(",");
        stringBuffer.append("\"lat\":");
        stringBuffer.append(latLng.latitude);
        stringBuffer.append(",");
        stringBuffer.append("\"title\":\"");
        stringBuffer.append(str);
        stringBuffer.append("\",");
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        stringBuffer.append("\"snippet\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\"");
        stringBuffer.append(com.alipay.sdk.m.u.i.d);
        a(stringBuffer.toString());
    }
}
