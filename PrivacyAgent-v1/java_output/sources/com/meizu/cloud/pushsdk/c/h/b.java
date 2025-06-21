package com.meizu.cloud.pushsdk.c.h;

/* loaded from: classes23.dex */
public class b {
    public static int a(int i, int i2, int i3, int i4) {
        double min = java.lang.Math.min(i / i3, i2 / i4);
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (f2 > min) {
                return (int) f;
            }
            f = f2;
        }
    }

    private static int a(int i, int i2, int i3, int i4, android.widget.ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == android.widget.ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        }
        if (i == 0) {
            return (int) (i3 * (i2 / i4));
        }
        if (i2 == 0) {
            return i;
        }
        double d = i4 / i3;
        if (scaleType == android.widget.ImageView.ScaleType.CENTER_CROP) {
            double d2 = i2;
            return ((double) i) * d < d2 ? (int) (d2 / d) : i;
        }
        double d3 = i2;
        return ((double) i) * d > d3 ? (int) (d3 / d) : i;
    }

    public static com.meizu.cloud.pushsdk.c.a.c<android.graphics.Bitmap> a(com.meizu.cloud.pushsdk.c.c.k kVar, int i, int i2, android.graphics.Bitmap.Config config, android.widget.ImageView.ScaleType scaleType) {
        android.graphics.Bitmap bitmap;
        byte[] bArr = new byte[0];
        try {
            bArr = com.meizu.cloud.pushsdk.c.g.g.a(kVar.b().a()).i();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        if (i == 0 && i2 == 0) {
            options.inPreferredConfig = config;
            bitmap = android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i3 = options.outWidth;
            int i4 = options.outHeight;
            int a = a(i, i2, i3, i4, scaleType);
            int a2 = a(i2, i, i4, i3, scaleType);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i3, i4, a, a2);
            android.graphics.Bitmap decodeByteArray = android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (a(decodeByteArray, a, a2)) {
                bitmap = android.graphics.Bitmap.createScaledBitmap(decodeByteArray, a, a2, true);
                decodeByteArray.recycle();
            } else {
                bitmap = decodeByteArray;
            }
        }
        return bitmap == null ? com.meizu.cloud.pushsdk.c.a.c.a(b(new com.meizu.cloud.pushsdk.c.b.a(kVar))) : com.meizu.cloud.pushsdk.c.a.c.a(bitmap);
    }

    public static com.meizu.cloud.pushsdk.c.b.a a(com.meizu.cloud.pushsdk.c.b.a aVar) {
        aVar.a("connectionError");
        aVar.a(0);
        aVar.b(aVar.getMessage());
        return aVar;
    }

    public static com.meizu.cloud.pushsdk.c.b.a a(com.meizu.cloud.pushsdk.c.b.a aVar, com.meizu.cloud.pushsdk.c.a.b bVar, int i) {
        com.meizu.cloud.pushsdk.c.b.a a = bVar.a(aVar);
        a.a(i);
        a.a("responseFromServerError");
        return a;
    }

    public static com.meizu.cloud.pushsdk.c.b.a a(java.lang.Exception exc) {
        com.meizu.cloud.pushsdk.c.b.a aVar = new com.meizu.cloud.pushsdk.c.b.a(exc);
        aVar.a(exc instanceof android.os.NetworkOnMainThreadException ? "networkOnMainThreadError" : "connectionError");
        aVar.a(0);
        return aVar;
    }

    public static java.lang.String a(java.lang.String str) {
        java.lang.String contentTypeFor = java.net.URLConnection.getFileNameMap().getContentTypeFor(str);
        return contentTypeFor == null ? com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE : contentTypeFor;
    }

    public static void a(com.meizu.cloud.pushsdk.c.c.k kVar, java.lang.String str, java.lang.String str2) throws java.io.IOException {
        java.io.FileOutputStream fileOutputStream;
        byte[] bArr = new byte[2048];
        java.io.InputStream inputStream = null;
        try {
            java.io.InputStream b = kVar.b().b();
            try {
                java.io.File file = new java.io.File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                fileOutputStream = new java.io.FileOutputStream(new java.io.File(file, str2));
                while (true) {
                    try {
                        int read = b.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        inputStream = b;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.io.IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (fileOutputStream == null) {
                            throw th;
                        }
                        try {
                            fileOutputStream.close();
                            throw th;
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                            throw th;
                        }
                    }
                }
                fileOutputStream.flush();
                try {
                    b.close();
                } catch (java.io.IOException e3) {
                    e3.printStackTrace();
                }
                try {
                    fileOutputStream.close();
                } catch (java.io.IOException e4) {
                    e4.printStackTrace();
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    private static boolean a(android.graphics.Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return false;
        }
        return bitmap.getWidth() > i || bitmap.getHeight() > i2;
    }

    public static com.meizu.cloud.pushsdk.c.b.a b(com.meizu.cloud.pushsdk.c.b.a aVar) {
        aVar.a(0);
        aVar.a("parseError");
        aVar.b(aVar.getMessage());
        return aVar;
    }
}
