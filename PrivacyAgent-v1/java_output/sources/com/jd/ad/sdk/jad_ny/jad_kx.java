package com.jd.ad.sdk.jad_ny;

/* loaded from: classes23.dex */
public class jad_kx implements com.jd.ad.sdk.jad_ny.jad_er {
    public static final android.graphics.Bitmap.Config jad_jw = android.graphics.Bitmap.Config.ARGB_8888;
    public final com.jd.ad.sdk.jad_ny.jad_ly jad_an;
    public final java.util.Set<android.graphics.Bitmap.Config> jad_bo;
    public final com.jd.ad.sdk.jad_ny.jad_kx.jad_an jad_cp = new com.jd.ad.sdk.jad_ny.jad_kx.jad_bo();
    public long jad_dq;
    public long jad_er;
    public int jad_fs;
    public int jad_hu;
    public int jad_iv;
    public int jad_jt;

    public interface jad_an {
    }

    public static final class jad_bo implements com.jd.ad.sdk.jad_ny.jad_kx.jad_an {
    }

    public jad_kx(long j, com.jd.ad.sdk.jad_ny.jad_ly jad_lyVar, java.util.Set<android.graphics.Bitmap.Config> set) {
        this.jad_dq = j;
        this.jad_an = jad_lyVar;
        this.jad_bo = set;
    }

    @android.annotation.TargetApi(26)
    public static java.util.Set<android.graphics.Bitmap.Config> jad_dq() {
        android.graphics.Bitmap.Config config;
        java.util.HashSet hashSet = new java.util.HashSet(java.util.Arrays.asList(android.graphics.Bitmap.Config.values()));
        int i = android.os.Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i >= 26) {
            config = android.graphics.Bitmap.Config.HARDWARE;
            hashSet.remove(config);
        }
        return java.util.Collections.unmodifiableSet(hashSet);
    }

    public static com.jd.ad.sdk.jad_ny.jad_ly jad_er() {
        return new com.jd.ad.sdk.jad_ny.jad_na();
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_er
    @androidx.annotation.NonNull
    public android.graphics.Bitmap jad_an(int i, int i2, android.graphics.Bitmap.Config config) {
        android.graphics.Bitmap jad_cp = jad_cp(i, i2, config);
        if (jad_cp != null) {
            jad_cp.eraseColor(0);
            return jad_cp;
        }
        if (config == null) {
            config = jad_jw;
        }
        return android.graphics.Bitmap.createBitmap(i, i2, config);
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_er
    public void jad_an() {
        if (android.util.Log.isLoggable("LruBitmapPool", 3)) {
            com.jd.ad.sdk.logger.Logger.d("LruBitmapPool", "clearMemory");
        }
        jad_an(0L);
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_er
    @android.annotation.SuppressLint({"InlinedApi"})
    public void jad_an(int i) {
        if (android.util.Log.isLoggable("LruBitmapPool", 3)) {
            com.jd.ad.sdk.logger.Logger.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 40 || (android.os.Build.VERSION.SDK_INT >= 23 && i >= 20)) {
            jad_an();
        } else if (i >= 20 || i == 15) {
            jad_an(this.jad_dq / 2);
        }
    }

    public final synchronized void jad_an(long j) {
        while (this.jad_er > j) {
            android.graphics.Bitmap jad_an2 = this.jad_an.jad_an();
            if (jad_an2 == null) {
                if (android.util.Log.isLoggable("LruBitmapPool", 5)) {
                    com.jd.ad.sdk.logger.Logger.w("LruBitmapPool", "Size mismatch, resetting");
                    jad_cp();
                }
                this.jad_er = 0L;
                return;
            }
            this.jad_cp.getClass();
            this.jad_er -= this.jad_an.jad_cp(jad_an2);
            this.jad_iv++;
            if (android.util.Log.isLoggable("LruBitmapPool", 3)) {
                java.lang.StringBuilder jad_an3 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Evicting bitmap=");
                jad_an3.append(this.jad_an.jad_bo(jad_an2));
                com.jd.ad.sdk.logger.Logger.d("LruBitmapPool", jad_an3.toString());
            }
            jad_bo();
            jad_an2.recycle();
        }
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_er
    public synchronized void jad_an(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            throw new java.lang.NullPointerException("Bitmap must not be null");
        }
        if (bitmap.isRecycled()) {
            throw new java.lang.IllegalStateException("Cannot pool recycled bitmap");
        }
        if (bitmap.isMutable() && this.jad_an.jad_cp(bitmap) <= this.jad_dq && this.jad_bo.contains(bitmap.getConfig())) {
            int jad_cp = this.jad_an.jad_cp(bitmap);
            this.jad_an.jad_an(bitmap);
            this.jad_cp.getClass();
            this.jad_hu++;
            this.jad_er += jad_cp;
            if (android.util.Log.isLoggable("LruBitmapPool", 2)) {
                java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Put bitmap in pool=");
                jad_an2.append(this.jad_an.jad_bo(bitmap));
                com.jd.ad.sdk.logger.Logger.v("LruBitmapPool", jad_an2.toString());
            }
            jad_bo();
            jad_an(this.jad_dq);
            return;
        }
        if (android.util.Log.isLoggable("LruBitmapPool", 2)) {
            java.lang.StringBuilder jad_an3 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Reject bitmap from pool, bitmap: ");
            jad_an3.append(this.jad_an.jad_bo(bitmap));
            jad_an3.append(", is mutable: ");
            jad_an3.append(bitmap.isMutable());
            jad_an3.append(", is allowed config: ");
            jad_an3.append(this.jad_bo.contains(bitmap.getConfig()));
            com.jd.ad.sdk.logger.Logger.v("LruBitmapPool", jad_an3.toString());
        }
        bitmap.recycle();
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_er
    @androidx.annotation.NonNull
    public android.graphics.Bitmap jad_bo(int i, int i2, android.graphics.Bitmap.Config config) {
        android.graphics.Bitmap jad_cp = jad_cp(i, i2, config);
        if (jad_cp != null) {
            return jad_cp;
        }
        if (config == null) {
            config = jad_jw;
        }
        return android.graphics.Bitmap.createBitmap(i, i2, config);
    }

    public final void jad_bo() {
        if (android.util.Log.isLoggable("LruBitmapPool", 2)) {
            jad_cp();
        }
    }

    @androidx.annotation.Nullable
    public final synchronized android.graphics.Bitmap jad_cp(int i, int i2, @androidx.annotation.Nullable android.graphics.Bitmap.Config config) {
        android.graphics.Bitmap.Config config2;
        android.graphics.Bitmap jad_an2;
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            config2 = android.graphics.Bitmap.Config.HARDWARE;
            if (config == config2) {
                throw new java.lang.IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            }
        }
        jad_an2 = this.jad_an.jad_an(i, i2, config != null ? config : jad_jw);
        if (jad_an2 == null) {
            if (android.util.Log.isLoggable("LruBitmapPool", 3)) {
                java.lang.StringBuilder jad_an3 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Missing bitmap=");
                jad_an3.append(this.jad_an.jad_bo(i, i2, config));
                com.jd.ad.sdk.logger.Logger.d("LruBitmapPool", jad_an3.toString());
            }
            this.jad_jt++;
        } else {
            this.jad_fs++;
            this.jad_er -= this.jad_an.jad_cp(jad_an2);
            this.jad_cp.getClass();
            jad_an2.setHasAlpha(true);
            jad_an2.setPremultiplied(true);
        }
        if (android.util.Log.isLoggable("LruBitmapPool", 2)) {
            java.lang.StringBuilder jad_an4 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Get bitmap=");
            jad_an4.append(this.jad_an.jad_bo(i, i2, config));
            com.jd.ad.sdk.logger.Logger.v("LruBitmapPool", jad_an4.toString());
        }
        jad_bo();
        return jad_an2;
    }

    public final void jad_cp() {
        java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Hits=");
        jad_an2.append(this.jad_fs);
        jad_an2.append(", misses=");
        jad_an2.append(this.jad_jt);
        jad_an2.append(", puts=");
        jad_an2.append(this.jad_hu);
        jad_an2.append(", evictions=");
        jad_an2.append(this.jad_iv);
        jad_an2.append(", currentSize=");
        jad_an2.append(this.jad_er);
        jad_an2.append(", maxSize=");
        jad_an2.append(this.jad_dq);
        jad_an2.append("\nStrategy=");
        jad_an2.append(this.jad_an);
        com.jd.ad.sdk.logger.Logger.v("LruBitmapPool", jad_an2.toString());
    }
}
