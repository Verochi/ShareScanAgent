package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class da {
    private static int a(byte[] bArr, int i) {
        byte b = bArr[i + 0];
        byte b2 = bArr[i + 1];
        byte b3 = bArr[i + 2];
        return (bArr[i + 3] << com.google.common.base.Ascii.CAN) | (b & 255) | (b2 << 8) | (b3 << 16);
    }

    private static android.graphics.Bitmap a(java.io.InputStream inputStream) throws java.lang.Exception {
        android.graphics.Bitmap decodeStream = android.graphics.BitmapFactory.decodeStream(inputStream);
        byte[] a = a(decodeStream);
        if (!android.graphics.NinePatch.isNinePatchChunk(a)) {
            return decodeStream;
        }
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(decodeStream, 1, 1, decodeStream.getWidth() - 2, decodeStream.getHeight() - 2);
        com.amap.api.mapcore.util.dl.a(decodeStream);
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            java.lang.reflect.Method declaredMethod = createBitmap.getClass().getDeclaredMethod("setNinePatchChunk", byte[].class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(createBitmap, a);
        } else {
            java.lang.reflect.Field declaredField = createBitmap.getClass().getDeclaredField("mNinePatchChunk");
            declaredField.setAccessible(true);
            declaredField.set(createBitmap, a);
        }
        return createBitmap;
    }

    public static android.graphics.drawable.Drawable a(android.content.Context context, java.lang.String str) throws java.lang.Exception {
        android.graphics.Bitmap b = b(context, str);
        if (b.getNinePatchChunk() == null) {
            return new android.graphics.drawable.BitmapDrawable(context.getResources(), b);
        }
        android.graphics.Rect rect = new android.graphics.Rect();
        a(b.getNinePatchChunk(), rect);
        return new android.graphics.drawable.NinePatchDrawable(context.getResources(), b, b.getNinePatchChunk(), rect, null);
    }

    private static void a(android.graphics.Bitmap bitmap, byte[] bArr) {
        int width = bitmap.getWidth() - 2;
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, width, 1, bitmap.getHeight() - 1, width, 1);
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= width) {
                break;
            }
            if (-16777216 == iArr[i2]) {
                a(bArr, 12, i2);
                break;
            }
            i2++;
        }
        int i3 = width - 1;
        while (true) {
            if (i3 < 0) {
                break;
            }
            if (-16777216 == iArr[i3]) {
                a(bArr, 16, (width - i3) - 2);
                break;
            }
            i3--;
        }
        int height = bitmap.getHeight() - 2;
        int[] iArr2 = new int[height];
        bitmap.getPixels(iArr2, 0, 1, bitmap.getWidth() - 1, 0, 1, height);
        while (true) {
            if (i >= height) {
                break;
            }
            if (-16777216 == iArr2[i]) {
                a(bArr, 20, i);
                break;
            }
            i++;
        }
        for (int i4 = height - 1; i4 >= 0; i4--) {
            if (-16777216 == iArr2[i4]) {
                a(bArr, 24, (height - i4) - 2);
                return;
            }
        }
    }

    private static void a(java.io.OutputStream outputStream, int i) throws java.io.IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    private static void a(byte[] bArr, int i, int i2) {
        bArr[i + 0] = (byte) (i2 >> 0);
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >> 24);
    }

    private static void a(byte[] bArr, android.graphics.Rect rect) {
        rect.left = a(bArr, 12);
        rect.right = a(bArr, 16);
        rect.top = a(bArr, 20);
        rect.bottom = a(bArr, 24);
    }

    private static byte[] a(android.graphics.Bitmap bitmap) throws java.io.IOException {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        for (int i = 0; i < 32; i++) {
            byteArrayOutputStream.write(0);
        }
        int i2 = width - 2;
        int[] iArr = new int[i2];
        bitmap.getPixels(iArr, 0, width, 1, 0, i2, 1);
        boolean z = iArr[0] == -16777216;
        boolean z2 = iArr[i2 + (-1)] == -16777216;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            if (i3 != iArr[i5]) {
                i4++;
                a(byteArrayOutputStream, i5);
                i3 = iArr[i5];
            }
        }
        if (z2) {
            i4++;
            a(byteArrayOutputStream, i2);
        }
        int i6 = i4 + 1;
        if (z) {
            i6--;
        }
        if (z2) {
            i6--;
        }
        int i7 = height - 2;
        int[] iArr2 = new int[i7];
        bitmap.getPixels(iArr2, 0, 1, 0, 1, 1, i7);
        boolean z3 = iArr2[0] == -16777216;
        boolean z4 = iArr2[i7 + (-1)] == -16777216;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < i7; i10++) {
            if (i8 != iArr2[i10]) {
                i9++;
                a(byteArrayOutputStream, i10);
                i8 = iArr2[i10];
            }
        }
        if (z4) {
            i9++;
            a(byteArrayOutputStream, i7);
        }
        int i11 = i9 + 1;
        if (z3) {
            i11--;
        }
        if (z4) {
            i11--;
        }
        int i12 = 0;
        while (true) {
            int i13 = i6 * i11;
            if (i12 >= i13) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArray[0] = 1;
                byteArray[1] = (byte) i4;
                byteArray[2] = (byte) i9;
                byteArray[3] = (byte) i13;
                a(bitmap, byteArray);
                return byteArray;
            }
            a(byteArrayOutputStream, 1);
            i12++;
        }
    }

    private static android.graphics.Bitmap b(android.content.Context context, java.lang.String str) throws java.lang.Exception {
        java.io.InputStream open = com.amap.api.mapcore.util.df.a(context).open(str);
        android.graphics.Bitmap a = a(open);
        open.close();
        return a;
    }
}
