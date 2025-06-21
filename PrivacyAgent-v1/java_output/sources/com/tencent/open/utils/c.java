package com.tencent.open.utils;

/* loaded from: classes19.dex */
public class c {
    private static java.lang.String c;
    private java.lang.String a;
    private com.tencent.open.utils.d b;
    private long d;
    private android.os.Handler e;
    private java.lang.ref.WeakReference<android.app.Activity> f;
    private java.lang.Runnable g = new com.tencent.open.utils.c.AnonymousClass2();

    /* renamed from: com.tencent.open.utils.c$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            com.tencent.open.log.SLog.v("AsynLoadImg", "handleMessage:" + message.arg1);
            if (message.arg1 == 0) {
                com.tencent.open.utils.c.this.b.a(message.arg1, (java.lang.String) message.obj);
            } else {
                com.tencent.open.utils.c.this.b.a(message.arg1, (java.lang.String) null);
            }
        }
    }

    /* renamed from: com.tencent.open.utils.c$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            com.tencent.open.log.SLog.v("AsynLoadImg", "saveFileRunnable:");
            java.lang.String str = "share_qq_" + com.tencent.open.utils.l.f(com.tencent.open.utils.c.this.a) + ".jpg";
            java.lang.String str2 = com.tencent.open.utils.c.c + str;
            java.io.File file = new java.io.File(str2);
            android.os.Message obtainMessage = com.tencent.open.utils.c.this.e.obtainMessage();
            if (file.exists()) {
                obtainMessage.arg1 = 0;
                obtainMessage.obj = str2;
                com.tencent.open.log.SLog.v("AsynLoadImg", "file exists: time:" + (java.lang.System.currentTimeMillis() - com.tencent.open.utils.c.this.d));
            } else {
                android.graphics.Bitmap a = com.tencent.open.utils.c.a(com.tencent.open.utils.c.this.a);
                if (a != null) {
                    z = com.tencent.open.utils.c.this.a(a, str);
                } else {
                    com.tencent.open.log.SLog.v("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                    z = false;
                }
                if (z) {
                    obtainMessage.arg1 = 0;
                    obtainMessage.obj = str2;
                } else {
                    obtainMessage.arg1 = 1;
                }
                com.tencent.open.log.SLog.v("AsynLoadImg", "file not exists: download time:" + (java.lang.System.currentTimeMillis() - com.tencent.open.utils.c.this.d));
            }
            com.tencent.open.utils.c.this.e.sendMessage(obtainMessage);
        }
    }

    public c(android.app.Activity activity) {
        this.f = new java.lang.ref.WeakReference<>(activity);
        this.e = new com.tencent.open.utils.c.AnonymousClass1(activity.getMainLooper());
    }

    public static android.graphics.Bitmap a(java.lang.String str) {
        com.tencent.open.log.SLog.v("AsynLoadImg", "getbitmap:" + str);
        try {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            java.io.InputStream inputStream = httpURLConnection.getInputStream();
            android.graphics.Bitmap decodeStream = android.graphics.BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            com.tencent.open.log.SLog.v("AsynLoadImg", "image download finished." + str);
            return decodeStream;
        } catch (java.io.IOException e) {
            e.printStackTrace();
            com.tencent.open.log.SLog.v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        } catch (java.lang.OutOfMemoryError e2) {
            e2.printStackTrace();
            com.tencent.open.log.SLog.v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        }
    }

    public void a(java.lang.String str, com.tencent.open.utils.d dVar) {
        com.tencent.open.log.SLog.v("AsynLoadImg", "--save---");
        if (str == null || str.equals("")) {
            dVar.a(1, (java.lang.String) null);
            return;
        }
        if (!com.tencent.open.utils.l.a()) {
            dVar.a(2, (java.lang.String) null);
            return;
        }
        if (this.f.get() != null) {
            android.app.Activity activity = this.f.get();
            java.io.File h = com.tencent.open.utils.l.h(activity, "Images");
            java.io.File externalStorageDirectory = android.os.Environment.getExternalStorageDirectory();
            if (h == null) {
                com.tencent.open.log.SLog.e("AsynLoadImg", "externalImageFile is null");
                dVar.a(2, (java.lang.String) null);
                return;
            } else {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(com.tencent.open.utils.i.c(activity) ? h.getAbsolutePath() : externalStorageDirectory.getAbsolutePath());
                sb.append("/tmp/");
                c = sb.toString();
            }
        }
        this.d = java.lang.System.currentTimeMillis();
        this.a = str;
        this.b = dVar;
        new java.lang.Thread(this.g).start();
    }

    public boolean a(android.graphics.Bitmap bitmap, java.lang.String str) {
        java.io.BufferedOutputStream bufferedOutputStream;
        java.lang.String str2 = c;
        java.io.BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                java.io.File file = new java.io.File(str2);
                if (!file.exists()) {
                    file.mkdir();
                }
                com.tencent.open.log.SLog.v("AsynLoadImg", "saveFile:" + str);
                bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(new java.io.File(str2 + str)));
            } catch (java.io.IOException e) {
                e = e;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
            bufferedOutputStream.flush();
            try {
                bufferedOutputStream.close();
                return true;
            } catch (java.io.IOException e2) {
                e2.printStackTrace();
                return true;
            }
        } catch (java.io.IOException e3) {
            e = e3;
            bufferedOutputStream2 = bufferedOutputStream;
            e.printStackTrace();
            com.tencent.open.log.SLog.e("AsynLoadImg", "saveFile bmp fail---", e);
            if (bufferedOutputStream2 == null) {
                return false;
            }
            try {
                bufferedOutputStream2.close();
                return false;
            } catch (java.io.IOException e4) {
                e4.printStackTrace();
                return false;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (java.io.IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }
}
