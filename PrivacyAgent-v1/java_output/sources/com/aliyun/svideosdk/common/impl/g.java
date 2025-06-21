package com.aliyun.svideosdk.common.impl;

/* loaded from: classes12.dex */
public class g {
    private static int g = 17;
    private static int h = -17;
    private final int a;
    private final int b;
    private com.aliyun.svideosdk.common.b.e.a<java.lang.String> c;
    private volatile boolean d;
    private com.aliyun.svideosdk.common.impl.g.a e;
    private java.lang.String f;

    public class a extends android.os.Handler {
        public a(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            java.lang.String a;
            super.handleMessage(message);
            if (message.what != com.aliyun.svideosdk.common.impl.g.this.a) {
                if (message.what == com.aliyun.svideosdk.common.impl.g.this.b) {
                    com.aliyun.svideosdk.common.impl.g.this.c.a();
                    com.aliyun.common.utils.FileUtils.deleteDirectory(new java.io.File(com.aliyun.svideosdk.common.impl.g.this.f));
                    com.aliyun.svideosdk.common.impl.g.this.e = null;
                    return;
                }
                return;
            }
            android.graphics.Bitmap bitmap = (android.graphics.Bitmap) message.obj;
            if (bitmap.isRecycled()) {
                return;
            }
            java.lang.String string = message.getData().getString("time_key");
            if (!com.aliyun.svideosdk.common.impl.g.this.d && !android.text.TextUtils.isEmpty(string) && (a = com.aliyun.svideosdk.common.impl.g.this.c.a(java.lang.String.valueOf(string), bitmap)) != null && string != null) {
                com.aliyun.svideosdk.common.impl.g.this.c.a((com.aliyun.svideosdk.common.b.e.a) string, a);
            }
            bitmap.recycle();
        }
    }

    public g(java.lang.String str, android.os.Looper looper) {
        int i = g;
        g = i + 1;
        this.a = i;
        int i2 = h;
        h = i2 - 1;
        this.b = i2;
        this.c = null;
        this.d = false;
        this.f = str;
        this.c = new com.aliyun.svideosdk.common.b.e.a<>(str);
        a();
        this.e = new com.aliyun.svideosdk.common.impl.g.a(looper);
    }

    private void a() {
        java.io.File[] listFiles;
        java.io.File file = new java.io.File(this.f);
        if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (java.io.File file2 : listFiles) {
            try {
                this.c.a((com.aliyun.svideosdk.common.b.e.a<java.lang.String>) file2.getName(), file2.getAbsolutePath());
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public android.graphics.Bitmap a(java.lang.String str) {
        com.aliyun.svideosdk.common.b.e.a<java.lang.String> aVar = this.c;
        if (aVar != null) {
            return aVar.b(str);
        }
        return null;
    }

    public void a(android.graphics.Bitmap bitmap, java.lang.String str) {
        if (bitmap == null) {
            return;
        }
        if (!this.d && this.c.a(str)) {
            bitmap.recycle();
            return;
        }
        if (this.e != null) {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("time_key", str);
            android.os.Message obtainMessage = this.e.obtainMessage(this.a);
            obtainMessage.obj = bitmap;
            obtainMessage.setData(bundle);
            this.e.sendMessage(obtainMessage);
        }
    }

    public void b() {
        com.aliyun.svideosdk.common.impl.g.a aVar = this.e;
        if (aVar != null) {
            aVar.sendEmptyMessage(this.b);
        }
        this.d = true;
    }
}
