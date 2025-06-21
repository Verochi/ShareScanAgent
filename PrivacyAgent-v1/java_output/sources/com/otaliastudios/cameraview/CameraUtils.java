package com.otaliastudios.cameraview;

/* loaded from: classes19.dex */
public class CameraUtils {
    public static final com.otaliastudios.cameraview.CameraLogger a = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.CameraUtils.class.getSimpleName());

    /* renamed from: com.otaliastudios.cameraview.CameraUtils$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ byte[] n;
        public final /* synthetic */ java.io.File t;
        public final /* synthetic */ android.os.Handler u;
        public final /* synthetic */ com.otaliastudios.cameraview.FileCallback v;

        /* renamed from: com.otaliastudios.cameraview.CameraUtils$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC04281 implements java.lang.Runnable {
            public final /* synthetic */ java.io.File n;

            public RunnableC04281(java.io.File file) {
                this.n = file;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.otaliastudios.cameraview.CameraUtils.AnonymousClass1.this.v.onFileReady(this.n);
            }
        }

        public AnonymousClass1(byte[] bArr, java.io.File file, android.os.Handler handler, com.otaliastudios.cameraview.FileCallback fileCallback) {
            this.n = bArr;
            this.t = file;
            this.u = handler;
            this.v = fileCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.u.post(new com.otaliastudios.cameraview.CameraUtils.AnonymousClass1.RunnableC04281(com.otaliastudios.cameraview.CameraUtils.writeToFile(this.n, this.t)));
        }
    }

    /* renamed from: com.otaliastudios.cameraview.CameraUtils$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.lang.Runnable {
        public final /* synthetic */ byte[] n;
        public final /* synthetic */ int t;
        public final /* synthetic */ int u;
        public final /* synthetic */ android.graphics.BitmapFactory.Options v;
        public final /* synthetic */ int w;
        public final /* synthetic */ android.os.Handler x;
        public final /* synthetic */ com.otaliastudios.cameraview.BitmapCallback y;

        /* renamed from: com.otaliastudios.cameraview.CameraUtils$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public final /* synthetic */ android.graphics.Bitmap n;

            public AnonymousClass1(android.graphics.Bitmap bitmap) {
                this.n = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.otaliastudios.cameraview.CameraUtils.AnonymousClass2.this.y.onBitmapReady(this.n);
            }
        }

        public AnonymousClass2(byte[] bArr, int i, int i2, android.graphics.BitmapFactory.Options options, int i3, android.os.Handler handler, com.otaliastudios.cameraview.BitmapCallback bitmapCallback) {
            this.n = bArr;
            this.t = i;
            this.u = i2;
            this.v = options;
            this.w = i3;
            this.x = handler;
            this.y = bitmapCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.x.post(new com.otaliastudios.cameraview.CameraUtils.AnonymousClass2.AnonymousClass1(com.otaliastudios.cameraview.CameraUtils.c(this.n, this.t, this.u, this.v, this.w)));
        }
    }

    public static int b(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 > i4 || i > i3) {
            while (true) {
                if (i2 / i5 < i4 && i / i5 < i3) {
                    break;
                }
                i5 *= 2;
            }
        }
        return i5;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:(4:30|31|32|33)|(5:42|43|44|45|46)|50|43|44|45|46) */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static android.graphics.Bitmap c(@androidx.annotation.NonNull byte[] bArr, int i, int i2, @androidx.annotation.NonNull android.graphics.BitmapFactory.Options options, int i3) {
        java.io.ByteArrayInputStream byteArrayInputStream;
        boolean z;
        int i4;
        int attributeInt;
        android.graphics.Bitmap decodeByteArray;
        int i5 = i <= 0 ? Integer.MAX_VALUE : i;
        int i6 = i2 <= 0 ? Integer.MAX_VALUE : i2;
        java.io.ByteArrayInputStream byteArrayInputStream2 = null;
        int i7 = i3;
        if (i7 == -1) {
            try {
                byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
                try {
                    try {
                        attributeInt = new androidx.exifinterface.media.ExifInterface(byteArrayInputStream).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
                        i4 = com.otaliastudios.cameraview.internal.ExifHelper.getOrientation(attributeInt);
                    } catch (java.io.IOException e) {
                        e = e;
                        a.e("decodeBitmap:", "could not get orientation from EXIF.", e);
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (java.lang.Exception unused) {
                            }
                        }
                        z = false;
                        i4 = 0;
                        i7 = i4;
                        if (i5 >= Integer.MAX_VALUE) {
                        }
                        options.inJustDecodeBounds = true;
                        android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        int i8 = options.outHeight;
                        int i9 = options.outWidth;
                        if (i7 % 180 != 0) {
                        }
                        options.inSampleSize = b(i8, i9, i5, i6);
                        options.inJustDecodeBounds = false;
                        decodeByteArray = android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        if (i7 == 0) {
                            return decodeByteArray;
                        }
                        android.graphics.Matrix matrix = new android.graphics.Matrix();
                        matrix.setRotate(i7);
                        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
                        decodeByteArray.recycle();
                        return createBitmap;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    byteArrayInputStream2 = byteArrayInputStream;
                    if (byteArrayInputStream2 != null) {
                        try {
                            byteArrayInputStream2.close();
                        } catch (java.lang.Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (java.io.IOException e2) {
                e = e2;
                byteArrayInputStream = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (byteArrayInputStream2 != null) {
                }
                throw th;
            }
            if (attributeInt != 2 && attributeInt != 4 && attributeInt != 5 && attributeInt != 7) {
                z = false;
                a.i("decodeBitmap:", "got orientation from EXIF.", java.lang.Integer.valueOf(i4));
                byteArrayInputStream.close();
                i7 = i4;
            }
            z = true;
            a.i("decodeBitmap:", "got orientation from EXIF.", java.lang.Integer.valueOf(i4));
            byteArrayInputStream.close();
            i7 = i4;
        } else {
            a.i("decodeBitmap:", "got orientation from constructor.", java.lang.Integer.valueOf(i3));
            z = false;
        }
        try {
            if (i5 >= Integer.MAX_VALUE || i6 < Integer.MAX_VALUE) {
                options.inJustDecodeBounds = true;
                android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                int i82 = options.outHeight;
                int i92 = options.outWidth;
                if (i7 % 180 != 0) {
                    i92 = i82;
                    i82 = i92;
                }
                options.inSampleSize = b(i82, i92, i5, i6);
                options.inJustDecodeBounds = false;
                decodeByteArray = android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            } else {
                decodeByteArray = android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            }
            if (i7 == 0 && !z) {
                return decodeByteArray;
            }
            android.graphics.Matrix matrix2 = new android.graphics.Matrix();
            matrix2.setRotate(i7);
            android.graphics.Bitmap createBitmap2 = android.graphics.Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix2, true);
            decodeByteArray.recycle();
            return createBitmap2;
        } catch (java.lang.OutOfMemoryError unused3) {
            return null;
        }
    }

    public static void d(@androidx.annotation.NonNull byte[] bArr, int i, int i2, @androidx.annotation.NonNull android.graphics.BitmapFactory.Options options, int i3, @androidx.annotation.NonNull com.otaliastudios.cameraview.BitmapCallback bitmapCallback) {
        com.otaliastudios.cameraview.internal.WorkerHandler.execute(new com.otaliastudios.cameraview.CameraUtils.AnonymousClass2(bArr, i, i2, options, i3, new android.os.Handler(), bitmapCallback));
    }

    @androidx.annotation.Nullable
    @androidx.annotation.WorkerThread
    public static android.graphics.Bitmap decodeBitmap(@androidx.annotation.NonNull byte[] bArr) {
        return decodeBitmap(bArr, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @androidx.annotation.Nullable
    @androidx.annotation.WorkerThread
    public static android.graphics.Bitmap decodeBitmap(@androidx.annotation.NonNull byte[] bArr, int i, int i2) {
        return decodeBitmap(bArr, i, i2, new android.graphics.BitmapFactory.Options());
    }

    @androidx.annotation.Nullable
    @androidx.annotation.WorkerThread
    public static android.graphics.Bitmap decodeBitmap(@androidx.annotation.NonNull byte[] bArr, int i, int i2, @androidx.annotation.NonNull android.graphics.BitmapFactory.Options options) {
        return c(bArr, i, i2, options, -1);
    }

    public static void decodeBitmap(@androidx.annotation.NonNull byte[] bArr, int i, int i2, @androidx.annotation.NonNull android.graphics.BitmapFactory.Options options, @androidx.annotation.NonNull com.otaliastudios.cameraview.BitmapCallback bitmapCallback) {
        d(bArr, i, i2, options, -1, bitmapCallback);
    }

    public static void decodeBitmap(@androidx.annotation.NonNull byte[] bArr, int i, int i2, @androidx.annotation.NonNull com.otaliastudios.cameraview.BitmapCallback bitmapCallback) {
        decodeBitmap(bArr, i, i2, new android.graphics.BitmapFactory.Options(), bitmapCallback);
    }

    public static void decodeBitmap(@androidx.annotation.NonNull byte[] bArr, @androidx.annotation.NonNull com.otaliastudios.cameraview.BitmapCallback bitmapCallback) {
        decodeBitmap(bArr, Integer.MAX_VALUE, Integer.MAX_VALUE, bitmapCallback);
    }

    public static boolean hasCameraFacing(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Facing facing) {
        int mapFacing = com.otaliastudios.cameraview.engine.mappers.Camera1Mapper.get().mapFacing(facing);
        android.hardware.Camera.CameraInfo cameraInfo = new android.hardware.Camera.CameraInfo();
        int numberOfCameras = android.hardware.Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            android.hardware.Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == mapFacing) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCameras(@androidx.annotation.NonNull android.content.Context context) {
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        return packageManager.hasSystemFeature("android.hardware.camera") || packageManager.hasSystemFeature("android.hardware.camera.front");
    }

    @androidx.annotation.Nullable
    @android.annotation.SuppressLint({"NewApi"})
    @androidx.annotation.WorkerThread
    public static java.io.File writeToFile(@androidx.annotation.NonNull byte[] bArr, @androidx.annotation.NonNull java.io.File file) {
        if (file.exists() && !file.delete()) {
            return null;
        }
        try {
            java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file));
            try {
                bufferedOutputStream.write(bArr);
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                return file;
            } finally {
            }
        } catch (java.io.IOException unused) {
            return null;
        }
    }

    public static void writeToFile(@androidx.annotation.NonNull byte[] bArr, @androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull com.otaliastudios.cameraview.FileCallback fileCallback) {
        com.otaliastudios.cameraview.internal.WorkerHandler.execute(new com.otaliastudios.cameraview.CameraUtils.AnonymousClass1(bArr, file, new android.os.Handler(), fileCallback));
    }
}
