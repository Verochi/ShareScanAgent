package com.aliyun.svideosdk.common.b.e;

/* loaded from: classes12.dex */
public class a<K> {
    private java.util.Hashtable<K, java.lang.String> a = new java.util.Hashtable<>();
    private java.lang.String b;

    public a(java.lang.String str) {
        this.b = str;
    }

    public synchronized java.lang.String a(java.lang.String str, android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(this.b);
        sb.append(java.io.File.separator);
        sb.append(str);
        sb.append(".jpeg");
        try {
            com.aliyun.common.utils.BitmapUtil.generateFileFromBitmap(bitmap, sb.toString(), "image/jpeg");
            return sb.toString();
        } catch (java.io.IOException unused) {
            return null;
        }
    }

    public synchronized void a() {
        java.util.Hashtable<K, java.lang.String> hashtable = this.a;
        if (hashtable != null) {
            for (java.util.Map.Entry<K, java.lang.String> entry : hashtable.entrySet()) {
                if (!android.text.TextUtils.isEmpty(entry.getValue())) {
                    com.aliyun.common.utils.FileUtils.deleteFile(entry.getValue());
                }
            }
            this.a.clear();
        }
    }

    public synchronized void a(K k, java.lang.String str) {
        if (str != null) {
            if (!this.a.containsKey(k)) {
                this.a.put(k, str);
            }
        }
    }

    public synchronized boolean a(K k) {
        return this.a.containsKey(k);
    }

    public synchronized android.graphics.Bitmap b(K k) {
        java.lang.String str = this.a.get(k);
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.io.File file = new java.io.File(str);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        return com.aliyun.common.utils.BitmapUtil.safeDecodeFile(str, null);
    }
}
