package com.tencent.connect.share;

/* loaded from: classes19.dex */
public class a {

    /* renamed from: com.tencent.connect.share.a$1, reason: invalid class name */
    public static class AnonymousClass1 extends android.os.Handler {
        final /* synthetic */ com.tencent.open.utils.d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(android.os.Looper looper, com.tencent.open.utils.d dVar) {
            super(looper);
            this.a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 101) {
                this.a.a(0, (java.util.ArrayList<java.lang.String>) message.obj);
            } else if (i != 102) {
                super.handleMessage(message);
            } else {
                this.a.a(message.arg1, (java.lang.String) null);
            }
        }
    }

    /* renamed from: com.tencent.connect.share.a$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ android.os.Handler b;
        final /* synthetic */ android.content.Context c;

        public AnonymousClass2(java.lang.String str, android.os.Handler handler, android.content.Context context) {
            this.a = str;
            this.b = handler;
            this.c = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.String str;
            java.lang.String str2;
            try {
                android.graphics.Bitmap a = com.tencent.connect.share.a.a(this.a, 840);
                if (a != null) {
                    java.io.File a2 = com.tencent.open.utils.f.a("Images");
                    java.lang.String str3 = null;
                    if (a2 != null) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(a2.getAbsolutePath());
                        java.lang.String str4 = java.io.File.separator;
                        sb.append(str4);
                        sb.append(com.tencent.connect.common.Constants.QQ_SHARE_TEMP_DIR);
                        sb.append(str4);
                        str2 = sb.toString();
                        str = null;
                    } else {
                        java.io.File d = com.tencent.open.utils.f.d();
                        if (d == null) {
                            com.tencent.open.log.SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() getCacheDir = null,return error");
                            android.os.Message obtainMessage = this.b.obtainMessage();
                            obtainMessage.arg1 = 102;
                            this.b.sendMessage(obtainMessage);
                            return;
                        }
                        java.lang.String absolutePath = d.getAbsolutePath();
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append(absolutePath);
                        java.lang.String str5 = java.io.File.separator;
                        sb2.append(str5);
                        sb2.append(com.tencent.connect.common.Constants.QQ_SHARE_TEMP_DIR);
                        sb2.append(str5);
                        java.lang.String sb3 = sb2.toString();
                        com.tencent.open.log.SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() use cache dir=" + sb3);
                        str = absolutePath;
                        str2 = sb3;
                    }
                    java.lang.String str6 = "share2qq_temp" + com.tencent.open.utils.l.f(this.a) + ".jpg";
                    java.lang.String str7 = this.a;
                    if (com.tencent.connect.share.a.b(str7, 840, 840)) {
                        com.tencent.open.log.SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() out of bound,compress!");
                        java.lang.String a3 = com.tencent.connect.share.a.a(a, str2, str6);
                        if (!android.text.TextUtils.isEmpty(a3)) {
                            str7 = a3;
                        }
                    } else {
                        com.tencent.open.log.SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() not out of bound,not compress!");
                    }
                    boolean n = com.tencent.open.utils.l.n(str7);
                    com.tencent.open.log.SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() check file isAppSpecificDir=" + n);
                    java.util.ArrayList arrayList = new java.util.ArrayList(2);
                    if (n) {
                        str3 = str7;
                    } else if (android.text.TextUtils.isEmpty(str)) {
                        java.lang.String str8 = str2 + str6;
                        boolean a4 = com.tencent.open.utils.l.a(this.c, str7, str8);
                        com.tencent.open.log.SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() sd permission not denied. copy to app sepcific:" + str8 + ",isSuccess=" + a4);
                        if (a4) {
                            str3 = str8;
                        }
                    }
                    arrayList.add(str7);
                    arrayList.add(str3);
                    if (arrayList.size() >= 2 && (arrayList.get(0) != null || arrayList.get(1) != null)) {
                        com.tencent.open.log.SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return success ! destFilePath=[" + ((java.lang.String) arrayList.get(0)) + "," + ((java.lang.String) arrayList.get(1)) + "]");
                        android.os.Message obtainMessage2 = this.b.obtainMessage(101);
                        obtainMessage2.obj = arrayList;
                        this.b.sendMessage(obtainMessage2);
                        return;
                    }
                }
            } catch (java.lang.Exception e) {
                com.tencent.open.log.SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage runnable exception e:", e);
            }
            com.tencent.open.log.SLog.d("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return failed!");
            android.os.Message obtainMessage3 = this.b.obtainMessage(102);
            obtainMessage3.arg1 = 3;
            this.b.sendMessage(obtainMessage3);
        }
    }

    public static final int a(android.graphics.BitmapFactory.Options options, int i, int i2) {
        int b = b(options, i, i2);
        if (b > 8) {
            return ((b + 7) / 8) * 8;
        }
        int i3 = 1;
        while (i3 < b) {
            i3 <<= 1;
        }
        return i3;
    }

    private static android.graphics.Bitmap a(android.graphics.Bitmap bitmap, int i) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            width = height;
        }
        float f = i / width;
        matrix.postScale(f, f);
        return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final android.graphics.Bitmap a(java.lang.String str, int i) {
        android.graphics.Bitmap bitmap;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            android.graphics.BitmapFactory.decodeFile(str, options);
        } catch (java.lang.OutOfMemoryError e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap exception1:", e);
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        if (options.mCancel || i2 == -1 || i3 == -1) {
            return null;
        }
        if (i2 <= i3) {
            i2 = i3;
        }
        options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
        if (i2 > i) {
            options.inSampleSize = a(options, -1, i * i);
        }
        options.inJustDecodeBounds = false;
        try {
            bitmap = android.graphics.BitmapFactory.decodeFile(str, options);
        } catch (java.lang.Exception e2) {
            com.tencent.open.log.SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap exception2:", e2);
            bitmap = null;
            if (bitmap == null) {
            }
        } catch (java.lang.OutOfMemoryError e3) {
            com.tencent.open.log.SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap OutOfMemoryError:", e3);
            bitmap = null;
            if (bitmap == null) {
            }
        }
        if (bitmap == null) {
            com.tencent.open.log.SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap return null");
            return null;
        }
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (i4 <= i5) {
            i4 = i5;
        }
        return i4 > i ? a(bitmap, i) : bitmap;
    }

    public static final java.lang.String a(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2) {
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(str);
        stringBuffer.append(str2);
        java.lang.String stringBuffer2 = stringBuffer.toString();
        java.io.File file2 = new java.io.File(stringBuffer2);
        if (file2.exists()) {
            file2.delete();
        }
        if (bitmap == null) {
            return null;
        }
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file2);
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            bitmap.recycle();
            return stringBuffer2;
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static final void a(android.content.Context context, java.lang.String str, com.tencent.open.utils.d dVar) {
        com.tencent.open.log.SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage()");
        if (android.text.TextUtils.isEmpty(str)) {
            dVar.a(1, (java.lang.String) null);
        } else if (com.tencent.open.utils.l.a()) {
            new java.lang.Thread(new com.tencent.connect.share.a.AnonymousClass2(str, new com.tencent.connect.share.a.AnonymousClass1(context.getMainLooper(), dVar), context)).start();
        } else {
            dVar.a(2, (java.lang.String) null);
        }
    }

    private static int b(android.graphics.BitmapFactory.Options options, int i, int i2) {
        int min;
        double d = options.outWidth;
        double d2 = options.outHeight;
        int ceil = i2 == -1 ? 1 : (int) java.lang.Math.ceil(java.lang.Math.sqrt((d * d2) / i2));
        if (i == -1) {
            min = 128;
        } else {
            double d3 = i;
            min = (int) java.lang.Math.min(java.lang.Math.floor(d / d3), java.lang.Math.floor(d2 / d3));
        }
        if (min < ceil) {
            return ceil;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        return i == -1 ? ceil : min;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(java.lang.String str, int i, int i2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            android.graphics.BitmapFactory.decodeFile(str, options);
        } catch (java.lang.OutOfMemoryError e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.AsynScaleCompressImage", "isBitMapNeedToCompress exception:", e);
        }
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (options.mCancel || i3 == -1 || i4 == -1) {
            return false;
        }
        int i5 = i3 > i4 ? i3 : i4;
        if (i3 >= i4) {
            i3 = i4;
        }
        com.tencent.open.log.SLog.d("openSDK_LOG.AsynScaleCompressImage", "longSide=" + i5 + "shortSide=" + i3);
        options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
        return i5 > i2 || i3 > i;
    }
}
