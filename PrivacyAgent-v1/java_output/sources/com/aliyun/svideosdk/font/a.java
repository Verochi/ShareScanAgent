package com.aliyun.svideosdk.font;

/* loaded from: classes12.dex */
class a {
    private static final java.lang.Object a = new java.lang.Object();
    private static final android.util.LruCache<java.lang.String, android.graphics.Typeface> b = new android.util.LruCache<>(8);
    private static final java.util.concurrent.locks.ReentrantReadWriteLock c = new java.util.concurrent.locks.ReentrantReadWriteLock();

    private static int a(int i, boolean z) {
        int i2 = i > 500 ? 1 : 0;
        return z ? i2 | 2 : i2;
    }

    public static android.graphics.Typeface a(android.content.Context context, java.lang.String str, int i, boolean z) {
        android.graphics.Typeface b2;
        android.graphics.Typeface create;
        if (str != null) {
            try {
                if (!str.isEmpty() && (b2 = b(context, str, i, z)) != null) {
                    return b2;
                }
            } catch (java.lang.Exception e) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("");
                sb.append(e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
        if (android.os.Build.VERSION.SDK_INT < 28 || a()) {
            return android.graphics.Typeface.create(str, a(i, z));
        }
        create = android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, i, z);
        return create;
    }

    public static android.text.TextPaint a(android.graphics.Typeface typeface, float f, int i, boolean z, float f2) {
        try {
            android.text.TextPaint textPaint = new android.text.TextPaint();
            textPaint.setHinting(0);
            textPaint.setTypeface(typeface);
            textPaint.setTextSize(f);
            textPaint.setElegantTextHeight(true);
            if (i > 500 && !typeface.isBold()) {
                textPaint.setFakeBoldText(true);
            }
            if (z && !typeface.isItalic()) {
                textPaint.setTextSkewX(-0.25f);
            }
            if (f2 != 0.0f) {
                textPaint.setLetterSpacing(f2);
            }
            return textPaint;
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("");
            sb.append(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private static boolean a() {
        java.lang.String str = android.os.Build.MANUFACTURER;
        if (str.equals("OnePlus")) {
            java.lang.String str2 = android.os.Build.MODEL;
            return str2.equals("IN2010") || str2.equals("A5010") || str2.equals("A6000");
        }
        if (!str.equals(com.ss.android.download.api.constant.BaseConstants.ROM_OPPO_UPPER_CONSTANT)) {
            return str.equalsIgnoreCase("Xiaomi") && android.os.Build.VERSION.SDK_INT >= 30;
        }
        java.lang.String str3 = android.os.Build.MODEL;
        return str3.equals("PBCM30") || str3.equals("PCGM00") || str3.equals("A92s");
    }

    public static android.graphics.Typeface b(android.content.Context context, java.lang.String str, int i, boolean z) {
        android.graphics.Typeface create;
        android.graphics.Typeface create2;
        try {
            java.util.concurrent.locks.ReentrantReadWriteLock reentrantReadWriteLock = c;
            reentrantReadWriteLock.readLock().lock();
            android.util.LruCache<java.lang.String, android.graphics.Typeface> lruCache = b;
            android.graphics.Typeface typeface = lruCache.get(str);
            reentrantReadWriteLock.readLock().unlock();
            if (typeface == null) {
                typeface = (context == null || !str.startsWith("assets:/")) ? android.graphics.Typeface.createFromFile(str) : android.graphics.Typeface.createFromAsset(context.getAssets(), str.substring(8));
                if (typeface != null) {
                    reentrantReadWriteLock.writeLock().lock();
                    lruCache.put(str, typeface);
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            if (android.os.Build.VERSION.SDK_INT >= 28 && !a()) {
                create2 = android.graphics.Typeface.create(typeface, i, z);
                return create2;
            }
            int a2 = a(i, z);
            synchronized (a) {
                create = android.graphics.Typeface.create(typeface, a2);
            }
            return create;
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("fontPath:");
            sb.append(str);
            sb.append(",msg:");
            sb.append(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
