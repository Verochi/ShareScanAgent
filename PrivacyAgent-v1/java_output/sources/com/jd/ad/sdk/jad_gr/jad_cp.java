package com.jd.ad.sdk.jad_gr;

/* loaded from: classes23.dex */
public class jad_cp implements android.content.ComponentCallbacks2 {

    @androidx.annotation.GuardedBy("Glide.class")
    public static volatile com.jd.ad.sdk.jad_gr.jad_cp jad_iv;
    public static volatile boolean jad_jw;
    public final com.jd.ad.sdk.jad_ny.jad_er jad_an;
    public final com.jd.ad.sdk.jad_oz.jad_hu jad_bo;
    public final com.jd.ad.sdk.jad_gr.jad_er jad_cp;
    public final com.jd.ad.sdk.jad_gr.jad_hu jad_dq;
    public final com.jd.ad.sdk.jad_ny.jad_bo jad_er;
    public final com.jd.ad.sdk.jad_zk.jad_pc jad_fs;

    @androidx.annotation.GuardedBy("managers")
    public final java.util.List<com.jd.ad.sdk.jad_gr.jad_jw> jad_hu = new java.util.ArrayList();
    public final com.jd.ad.sdk.jad_zk.jad_dq jad_jt;

    public interface jad_an {
    }

    public jad_cp(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.jd.ad.sdk.jad_mx.jad_mz jad_mzVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_oz.jad_hu jad_huVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ny.jad_er jad_erVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ny.jad_bo jad_boVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_zk.jad_pc jad_pcVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_zk.jad_dq jad_dqVar, int i, @androidx.annotation.NonNull com.jd.ad.sdk.jad_gr.jad_cp.jad_an jad_anVar, @androidx.annotation.NonNull java.util.Map<java.lang.Class<?>, com.jd.ad.sdk.jad_gr.jad_kx<?, ?>> map, @androidx.annotation.NonNull java.util.List<com.jd.ad.sdk.jad_en.jad_jt<java.lang.Object>> list, com.jd.ad.sdk.jad_gr.jad_fs jad_fsVar) {
        com.jd.ad.sdk.jad_ju.jad_ly jad_fsVar2;
        com.jd.ad.sdk.jad_ju.jad_ly jad_uhVar;
        com.jd.ad.sdk.jad_gr.jad_hu jad_huVar2;
        this.jad_an = jad_erVar;
        this.jad_er = jad_boVar;
        this.jad_bo = jad_huVar;
        this.jad_fs = jad_pcVar;
        this.jad_jt = jad_dqVar;
        android.content.res.Resources resources = context.getResources();
        com.jd.ad.sdk.jad_gr.jad_hu jad_huVar3 = new com.jd.ad.sdk.jad_gr.jad_hu();
        this.jad_dq = jad_huVar3;
        jad_huVar3.jad_an((com.jd.ad.sdk.jad_ju.jad_fs) new com.jd.ad.sdk.jad_te.jad_hu());
        int i2 = android.os.Build.VERSION.SDK_INT;
        if (i2 >= 27) {
            jad_huVar3.jad_an((com.jd.ad.sdk.jad_ju.jad_fs) new com.jd.ad.sdk.jad_te.jad_mz());
        }
        java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> jad_an2 = jad_huVar3.jad_an();
        com.jd.ad.sdk.jad_xi.jad_an jad_anVar2 = new com.jd.ad.sdk.jad_xi.jad_an(context, jad_an2, jad_erVar, jad_boVar);
        com.jd.ad.sdk.jad_ju.jad_ly<android.os.ParcelFileDescriptor, android.graphics.Bitmap> jad_cp = com.jd.ad.sdk.jad_te.jad_xk.jad_cp(jad_erVar);
        com.jd.ad.sdk.jad_te.jad_jw jad_jwVar = new com.jd.ad.sdk.jad_te.jad_jw(jad_huVar3.jad_an(), resources.getDisplayMetrics(), jad_erVar, jad_boVar);
        if (i2 < 28 || !jad_fsVar.jad_an(com.jd.ad.sdk.jad_gr.jad_dq.jad_cp.class)) {
            jad_fsVar2 = new com.jd.ad.sdk.jad_te.jad_fs(jad_jwVar);
            jad_uhVar = new com.jd.ad.sdk.jad_te.jad_uh(jad_jwVar, jad_boVar);
        } else {
            jad_uhVar = new com.jd.ad.sdk.jad_te.jad_pc();
            jad_fsVar2 = new com.jd.ad.sdk.jad_te.jad_jt();
        }
        if (i2 >= 28 && jad_fsVar.jad_an(com.jd.ad.sdk.jad_gr.jad_dq.jad_bo.class)) {
            jad_huVar3.jad_an("Animation", java.io.InputStream.class, android.graphics.drawable.Drawable.class, com.jd.ad.sdk.jad_vg.jad_an.jad_bo(jad_an2, jad_boVar));
            jad_huVar3.jad_an("Animation", java.nio.ByteBuffer.class, android.graphics.drawable.Drawable.class, com.jd.ad.sdk.jad_vg.jad_an.jad_an(jad_an2, jad_boVar));
        }
        com.jd.ad.sdk.jad_vg.jad_er jad_erVar2 = new com.jd.ad.sdk.jad_vg.jad_er(context);
        com.jd.ad.sdk.jad_qb.jad_sf.jad_cp jad_cpVar = new com.jd.ad.sdk.jad_qb.jad_sf.jad_cp(resources);
        com.jd.ad.sdk.jad_qb.jad_sf.jad_dq jad_dqVar2 = new com.jd.ad.sdk.jad_qb.jad_sf.jad_dq(resources);
        com.jd.ad.sdk.jad_qb.jad_sf.jad_bo jad_boVar2 = new com.jd.ad.sdk.jad_qb.jad_sf.jad_bo(resources);
        com.jd.ad.sdk.jad_qb.jad_sf.jad_an jad_anVar3 = new com.jd.ad.sdk.jad_qb.jad_sf.jad_an(resources);
        com.jd.ad.sdk.jad_te.jad_cp jad_cpVar2 = new com.jd.ad.sdk.jad_te.jad_cp(jad_boVar);
        com.jd.ad.sdk.jad_yj.jad_an jad_anVar4 = new com.jd.ad.sdk.jad_yj.jad_an();
        com.jd.ad.sdk.jad_yj.jad_dq jad_dqVar3 = new com.jd.ad.sdk.jad_yj.jad_dq();
        android.content.ContentResolver contentResolver = context.getContentResolver();
        jad_huVar3.jad_an(java.nio.ByteBuffer.class, new com.jd.ad.sdk.jad_qb.jad_cp()).jad_an(java.io.InputStream.class, new com.jd.ad.sdk.jad_qb.jad_tg(jad_boVar)).jad_an(com.bumptech.glide.Registry.BUCKET_BITMAP, java.nio.ByteBuffer.class, android.graphics.Bitmap.class, jad_fsVar2).jad_an(com.bumptech.glide.Registry.BUCKET_BITMAP, java.io.InputStream.class, android.graphics.Bitmap.class, jad_uhVar);
        if (com.jd.ad.sdk.jad_kv.jad_mz.jad_cp()) {
            jad_huVar3.jad_an(com.bumptech.glide.Registry.BUCKET_BITMAP, android.os.ParcelFileDescriptor.class, android.graphics.Bitmap.class, new com.jd.ad.sdk.jad_te.jad_re(jad_jwVar));
        }
        com.jd.ad.sdk.jad_gr.jad_hu jad_an3 = jad_huVar3.jad_an(com.bumptech.glide.Registry.BUCKET_BITMAP, android.os.ParcelFileDescriptor.class, android.graphics.Bitmap.class, jad_cp).jad_an(com.bumptech.glide.Registry.BUCKET_BITMAP, android.content.res.AssetFileDescriptor.class, android.graphics.Bitmap.class, com.jd.ad.sdk.jad_te.jad_xk.jad_an(jad_erVar));
        com.jd.ad.sdk.jad_qb.jad_vi.jad_an<?> jad_anVar5 = com.jd.ad.sdk.jad_qb.jad_vi.jad_an.jad_an;
        jad_an3.jad_an(android.graphics.Bitmap.class, android.graphics.Bitmap.class, jad_anVar5).jad_an(com.bumptech.glide.Registry.BUCKET_BITMAP, android.graphics.Bitmap.class, android.graphics.Bitmap.class, new com.jd.ad.sdk.jad_te.jad_wj()).jad_an(android.graphics.Bitmap.class, (com.jd.ad.sdk.jad_ju.jad_mz) jad_cpVar2).jad_an(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, java.nio.ByteBuffer.class, android.graphics.drawable.BitmapDrawable.class, new com.jd.ad.sdk.jad_te.jad_an(resources, jad_fsVar2)).jad_an(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, java.io.InputStream.class, android.graphics.drawable.BitmapDrawable.class, new com.jd.ad.sdk.jad_te.jad_an(resources, jad_uhVar)).jad_an(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, android.os.ParcelFileDescriptor.class, android.graphics.drawable.BitmapDrawable.class, new com.jd.ad.sdk.jad_te.jad_an(resources, jad_cp)).jad_an(android.graphics.drawable.BitmapDrawable.class, (com.jd.ad.sdk.jad_ju.jad_mz) new com.jd.ad.sdk.jad_te.jad_bo(jad_erVar, jad_cpVar2)).jad_an("Animation", java.io.InputStream.class, com.jd.ad.sdk.jad_xi.jad_cp.class, new com.jd.ad.sdk.jad_xi.jad_jw(jad_an2, jad_anVar2, jad_boVar)).jad_an("Animation", java.nio.ByteBuffer.class, com.jd.ad.sdk.jad_xi.jad_cp.class, jad_anVar2).jad_an(com.jd.ad.sdk.jad_xi.jad_cp.class, (com.jd.ad.sdk.jad_ju.jad_mz) new com.jd.ad.sdk.jad_xi.jad_dq()).jad_an(com.jd.ad.sdk.jad_it.jad_an.class, com.jd.ad.sdk.jad_it.jad_an.class, jad_anVar5).jad_an(com.bumptech.glide.Registry.BUCKET_BITMAP, com.jd.ad.sdk.jad_it.jad_an.class, android.graphics.Bitmap.class, new com.jd.ad.sdk.jad_xi.jad_hu(jad_erVar)).jad_an(android.net.Uri.class, android.graphics.drawable.Drawable.class, jad_erVar2).jad_an(android.net.Uri.class, android.graphics.Bitmap.class, new com.jd.ad.sdk.jad_te.jad_tg(jad_erVar2, jad_erVar)).jad_an((com.jd.ad.sdk.jad_kv.jad_er.jad_an<?>) new com.jd.ad.sdk.jad_uf.jad_an.C0411jad_an()).jad_an(java.io.File.class, java.nio.ByteBuffer.class, new com.jd.ad.sdk.jad_qb.jad_dq.jad_bo()).jad_an(java.io.File.class, java.io.InputStream.class, new com.jd.ad.sdk.jad_qb.jad_fs.jad_er()).jad_an(java.io.File.class, java.io.File.class, new com.jd.ad.sdk.jad_wh.jad_an()).jad_an(java.io.File.class, android.os.ParcelFileDescriptor.class, new com.jd.ad.sdk.jad_qb.jad_fs.jad_bo()).jad_an(java.io.File.class, java.io.File.class, jad_anVar5).jad_an((com.jd.ad.sdk.jad_kv.jad_er.jad_an<?>) new com.jd.ad.sdk.jad_kv.jad_kx.jad_an(jad_boVar));
        if (com.jd.ad.sdk.jad_kv.jad_mz.jad_cp()) {
            jad_huVar2 = jad_huVar3;
            jad_huVar2.jad_an((com.jd.ad.sdk.jad_kv.jad_er.jad_an<?>) new com.jd.ad.sdk.jad_kv.jad_mz.jad_an());
        } else {
            jad_huVar2 = jad_huVar3;
        }
        java.lang.Class cls = java.lang.Integer.TYPE;
        jad_huVar2.jad_an(cls, java.io.InputStream.class, jad_cpVar).jad_an(cls, android.os.ParcelFileDescriptor.class, jad_boVar2).jad_an(java.lang.Integer.class, java.io.InputStream.class, jad_cpVar).jad_an(java.lang.Integer.class, android.os.ParcelFileDescriptor.class, jad_boVar2).jad_an(java.lang.Integer.class, android.net.Uri.class, jad_dqVar2).jad_an(cls, android.content.res.AssetFileDescriptor.class, jad_anVar3).jad_an(java.lang.Integer.class, android.content.res.AssetFileDescriptor.class, jad_anVar3).jad_an(cls, android.net.Uri.class, jad_dqVar2).jad_an(java.lang.String.class, java.io.InputStream.class, new com.jd.ad.sdk.jad_qb.jad_er.jad_cp()).jad_an(android.net.Uri.class, java.io.InputStream.class, new com.jd.ad.sdk.jad_qb.jad_er.jad_cp()).jad_an(java.lang.String.class, java.io.InputStream.class, new com.jd.ad.sdk.jad_qb.jad_uh.jad_cp()).jad_an(java.lang.String.class, android.os.ParcelFileDescriptor.class, new com.jd.ad.sdk.jad_qb.jad_uh.jad_bo()).jad_an(java.lang.String.class, android.content.res.AssetFileDescriptor.class, new com.jd.ad.sdk.jad_qb.jad_uh.jad_an()).jad_an(android.net.Uri.class, java.io.InputStream.class, new com.jd.ad.sdk.jad_qb.jad_an.jad_cp(context.getAssets())).jad_an(android.net.Uri.class, android.content.res.AssetFileDescriptor.class, new com.jd.ad.sdk.jad_qb.jad_an.jad_bo(context.getAssets())).jad_an(android.net.Uri.class, java.io.InputStream.class, new com.jd.ad.sdk.jad_rc.jad_bo.jad_an(context)).jad_an(android.net.Uri.class, java.io.InputStream.class, new com.jd.ad.sdk.jad_rc.jad_cp.jad_an(context));
        if (i2 >= 29) {
            jad_huVar2.jad_an(android.net.Uri.class, java.io.InputStream.class, new com.jd.ad.sdk.jad_rc.jad_dq.jad_cp(context));
            jad_huVar2.jad_an(android.net.Uri.class, android.os.ParcelFileDescriptor.class, new com.jd.ad.sdk.jad_rc.jad_dq.jad_bo(context));
        }
        jad_huVar2.jad_an(android.net.Uri.class, java.io.InputStream.class, new com.jd.ad.sdk.jad_qb.jad_wj.jad_dq(contentResolver)).jad_an(android.net.Uri.class, android.os.ParcelFileDescriptor.class, new com.jd.ad.sdk.jad_qb.jad_wj.jad_bo(contentResolver)).jad_an(android.net.Uri.class, android.content.res.AssetFileDescriptor.class, new com.jd.ad.sdk.jad_qb.jad_wj.jad_an(contentResolver)).jad_an(android.net.Uri.class, java.io.InputStream.class, new com.jd.ad.sdk.jad_qb.jad_xk.jad_an()).jad_an(java.net.URL.class, java.io.InputStream.class, new com.jd.ad.sdk.jad_rc.jad_er.jad_an()).jad_an(android.net.Uri.class, java.io.File.class, new com.jd.ad.sdk.jad_qb.jad_kx.jad_an(context)).jad_an(com.jd.ad.sdk.jad_qb.jad_jt.class, java.io.InputStream.class, new com.jd.ad.sdk.jad_rc.jad_an.C0407jad_an()).jad_an(byte[].class, java.nio.ByteBuffer.class, new com.jd.ad.sdk.jad_qb.jad_bo.jad_an()).jad_an(byte[].class, java.io.InputStream.class, new com.jd.ad.sdk.jad_qb.jad_bo.jad_dq()).jad_an(android.net.Uri.class, android.net.Uri.class, jad_anVar5).jad_an(android.graphics.drawable.Drawable.class, android.graphics.drawable.Drawable.class, jad_anVar5).jad_an(android.graphics.drawable.Drawable.class, android.graphics.drawable.Drawable.class, new com.jd.ad.sdk.jad_vg.jad_fs()).jad_an(android.graphics.Bitmap.class, android.graphics.drawable.BitmapDrawable.class, new com.jd.ad.sdk.jad_yj.jad_bo(resources)).jad_an(android.graphics.Bitmap.class, byte[].class, jad_anVar4).jad_an(android.graphics.drawable.Drawable.class, byte[].class, new com.jd.ad.sdk.jad_yj.jad_cp(jad_erVar, jad_anVar4, jad_dqVar3)).jad_an(com.jd.ad.sdk.jad_xi.jad_cp.class, byte[].class, jad_dqVar3);
        if (i2 >= 23) {
            com.jd.ad.sdk.jad_ju.jad_ly<java.nio.ByteBuffer, android.graphics.Bitmap> jad_bo = com.jd.ad.sdk.jad_te.jad_xk.jad_bo(jad_erVar);
            jad_huVar2.jad_an(java.nio.ByteBuffer.class, android.graphics.Bitmap.class, jad_bo);
            jad_huVar2.jad_an(java.nio.ByteBuffer.class, android.graphics.drawable.BitmapDrawable.class, new com.jd.ad.sdk.jad_te.jad_an(resources, jad_bo));
        }
        this.jad_cp = new com.jd.ad.sdk.jad_gr.jad_er(context, jad_boVar, jad_huVar2, new com.jd.ad.sdk.jad_fo.jad_bo(), jad_anVar, map, list, jad_mzVar, jad_fsVar, i);
    }

    @androidx.annotation.NonNull
    public static com.jd.ad.sdk.jad_gr.jad_cp jad_an(@androidx.annotation.NonNull android.content.Context context) {
        if (jad_iv == null) {
            com.jd.ad.sdk.jad_gr.jad_an jad_anVar = null;
            try {
                jad_anVar = (com.jd.ad.sdk.jad_gr.jad_an) java.lang.Class.forName("com.jd.ad.sdk.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(android.content.Context.class).newInstance(context.getApplicationContext().getApplicationContext());
            } catch (java.lang.ClassNotFoundException unused) {
                if (android.util.Log.isLoggable("Glide", 5)) {
                    com.jd.ad.sdk.logger.Logger.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
                }
            } catch (java.lang.IllegalAccessException e) {
                jad_an(e);
                throw null;
            } catch (java.lang.InstantiationException e2) {
                jad_an(e2);
                throw null;
            } catch (java.lang.NoSuchMethodException e3) {
                jad_an(e3);
                throw null;
            } catch (java.lang.reflect.InvocationTargetException e4) {
                jad_an(e4);
                throw null;
            }
            synchronized (com.jd.ad.sdk.jad_gr.jad_cp.class) {
                if (jad_iv == null) {
                    jad_an(context, jad_anVar);
                }
            }
        }
        return jad_iv;
    }

    @androidx.annotation.GuardedBy("Glide.class")
    public static void jad_an(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable com.jd.ad.sdk.jad_gr.jad_an jad_anVar) {
        if (jad_jw) {
            throw new java.lang.IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        jad_jw = true;
        com.jd.ad.sdk.jad_gr.jad_dq jad_dqVar = new com.jd.ad.sdk.jad_gr.jad_dq();
        android.content.Context applicationContext = context.getApplicationContext();
        java.util.List<com.jd.ad.sdk.jad_al.jad_bo> emptyList = java.util.Collections.emptyList();
        if (jad_anVar != null && !jad_anVar.jad_an().isEmpty()) {
            java.util.Set<java.lang.Class<?>> jad_an2 = jad_anVar.jad_an();
            java.util.Iterator it = emptyList.iterator();
            while (it.hasNext()) {
                com.jd.ad.sdk.jad_al.jad_bo jad_boVar = (com.jd.ad.sdk.jad_al.jad_bo) it.next();
                if (jad_an2.contains(jad_boVar.getClass())) {
                    if (android.util.Log.isLoggable("Glide", 3)) {
                        com.jd.ad.sdk.logger.Logger.d("Glide", "AppGlideModule excludes manifest GlideModule: " + jad_boVar);
                    }
                    it.remove();
                }
            }
        }
        if (android.util.Log.isLoggable("Glide", 3)) {
            for (com.jd.ad.sdk.jad_al.jad_bo jad_boVar2 : emptyList) {
                java.lang.StringBuilder jad_an3 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Discovered GlideModule from manifest: ");
                jad_an3.append(jad_boVar2.getClass());
                com.jd.ad.sdk.logger.Logger.d("Glide", jad_an3.toString());
            }
        }
        jad_dqVar.jad_na = null;
        java.util.Iterator it2 = emptyList.iterator();
        while (it2.hasNext()) {
            ((com.jd.ad.sdk.jad_al.jad_bo) it2.next()).jad_an(applicationContext, jad_dqVar);
        }
        if (jad_dqVar.jad_jt == null) {
            com.jd.ad.sdk.jad_pa.jad_an.ThreadFactoryC0399jad_an threadFactoryC0399jad_an = new com.jd.ad.sdk.jad_pa.jad_an.ThreadFactoryC0399jad_an();
            int jad_an4 = com.jd.ad.sdk.jad_pa.jad_an.jad_an();
            if (android.text.TextUtils.isEmpty(com.tencent.open.SocialConstants.PARAM_SOURCE)) {
                java.lang.StringBuilder jad_an5 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Name must be non-null and non-empty, but given: ");
                jad_an5.append(com.tencent.open.SocialConstants.PARAM_SOURCE);
                throw new java.lang.IllegalArgumentException(jad_an5.toString());
            }
            jad_dqVar.jad_jt = new com.jd.ad.sdk.jad_pa.jad_an(new java.util.concurrent.ThreadPoolExecutor(jad_an4, jad_an4, 0L, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.PriorityBlockingQueue(), new com.jd.ad.sdk.jad_pa.jad_an.jad_bo(threadFactoryC0399jad_an, com.tencent.open.SocialConstants.PARAM_SOURCE, com.jd.ad.sdk.jad_pa.jad_an.jad_cp.jad_an, false)));
        }
        if (jad_dqVar.jad_hu == null) {
            int i = com.jd.ad.sdk.jad_pa.jad_an.jad_cp;
            com.jd.ad.sdk.jad_pa.jad_an.ThreadFactoryC0399jad_an threadFactoryC0399jad_an2 = new com.jd.ad.sdk.jad_pa.jad_an.ThreadFactoryC0399jad_an();
            if (android.text.TextUtils.isEmpty("disk-cache")) {
                java.lang.StringBuilder jad_an6 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Name must be non-null and non-empty, but given: ");
                jad_an6.append("disk-cache");
                throw new java.lang.IllegalArgumentException(jad_an6.toString());
            }
            jad_dqVar.jad_hu = new com.jd.ad.sdk.jad_pa.jad_an(new java.util.concurrent.ThreadPoolExecutor(1, 1, 0L, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.PriorityBlockingQueue(), new com.jd.ad.sdk.jad_pa.jad_an.jad_bo(threadFactoryC0399jad_an2, "disk-cache", com.jd.ad.sdk.jad_pa.jad_an.jad_cp.jad_an, true)));
        }
        if (jad_dqVar.jad_ob == null) {
            int i2 = com.jd.ad.sdk.jad_pa.jad_an.jad_an() >= 4 ? 2 : 1;
            com.jd.ad.sdk.jad_pa.jad_an.ThreadFactoryC0399jad_an threadFactoryC0399jad_an3 = new com.jd.ad.sdk.jad_pa.jad_an.ThreadFactoryC0399jad_an();
            if (android.text.TextUtils.isEmpty("animation")) {
                java.lang.StringBuilder jad_an7 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Name must be non-null and non-empty, but given: ");
                jad_an7.append("animation");
                throw new java.lang.IllegalArgumentException(jad_an7.toString());
            }
            jad_dqVar.jad_ob = new com.jd.ad.sdk.jad_pa.jad_an(new java.util.concurrent.ThreadPoolExecutor(i2, i2, 0L, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.PriorityBlockingQueue(), new com.jd.ad.sdk.jad_pa.jad_an.jad_bo(threadFactoryC0399jad_an3, "animation", com.jd.ad.sdk.jad_pa.jad_an.jad_cp.jad_an, true)));
        }
        if (jad_dqVar.jad_jw == null) {
            jad_dqVar.jad_jw = new com.jd.ad.sdk.jad_oz.jad_iv(new com.jd.ad.sdk.jad_oz.jad_iv.jad_an(applicationContext));
        }
        if (jad_dqVar.jad_kx == null) {
            jad_dqVar.jad_kx = new com.jd.ad.sdk.jad_zk.jad_fs();
        }
        if (jad_dqVar.jad_dq == null) {
            int i3 = jad_dqVar.jad_jw.jad_an;
            if (i3 > 0) {
                jad_dqVar.jad_dq = new com.jd.ad.sdk.jad_ny.jad_kx(i3, com.jd.ad.sdk.jad_ny.jad_kx.jad_er(), com.jd.ad.sdk.jad_ny.jad_kx.jad_dq());
            } else {
                jad_dqVar.jad_dq = new com.jd.ad.sdk.jad_ny.jad_fs();
            }
        }
        if (jad_dqVar.jad_er == null) {
            jad_dqVar.jad_er = new com.jd.ad.sdk.jad_ny.jad_jw(jad_dqVar.jad_jw.jad_dq);
        }
        if (jad_dqVar.jad_fs == null) {
            jad_dqVar.jad_fs = new com.jd.ad.sdk.jad_oz.jad_jt(jad_dqVar.jad_jw.jad_bo);
        }
        if (jad_dqVar.jad_iv == null) {
            jad_dqVar.jad_iv = new com.jd.ad.sdk.jad_oz.jad_fs(applicationContext, "image_manager_disk_cache", 262144000L);
        }
        if (jad_dqVar.jad_cp == null) {
            jad_dqVar.jad_cp = new com.jd.ad.sdk.jad_mx.jad_mz(jad_dqVar.jad_fs, jad_dqVar.jad_iv, jad_dqVar.jad_hu, jad_dqVar.jad_jt, new com.jd.ad.sdk.jad_pa.jad_an(new java.util.concurrent.ThreadPoolExecutor(0, Integer.MAX_VALUE, com.jd.ad.sdk.jad_pa.jad_an.jad_bo, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.SynchronousQueue(), new com.jd.ad.sdk.jad_pa.jad_an.jad_bo(new com.jd.ad.sdk.jad_pa.jad_an.ThreadFactoryC0399jad_an(), "source-unlimited", com.jd.ad.sdk.jad_pa.jad_an.jad_cp.jad_an, false))), jad_dqVar.jad_ob, null, null, null, null, null, null, false);
        }
        java.util.List<com.jd.ad.sdk.jad_en.jad_jt<java.lang.Object>> list = jad_dqVar.jad_pc;
        jad_dqVar.jad_pc = list == null ? java.util.Collections.emptyList() : java.util.Collections.unmodifiableList(list);
        com.jd.ad.sdk.jad_gr.jad_fs.jad_an jad_anVar2 = jad_dqVar.jad_bo;
        jad_anVar2.getClass();
        com.jd.ad.sdk.jad_gr.jad_fs jad_fsVar = new com.jd.ad.sdk.jad_gr.jad_fs(jad_anVar2);
        com.jd.ad.sdk.jad_gr.jad_cp jad_cpVar = new com.jd.ad.sdk.jad_gr.jad_cp(applicationContext, jad_dqVar.jad_cp, jad_dqVar.jad_fs, jad_dqVar.jad_dq, jad_dqVar.jad_er, new com.jd.ad.sdk.jad_zk.jad_pc(jad_dqVar.jad_na, jad_fsVar), jad_dqVar.jad_kx, jad_dqVar.jad_ly, jad_dqVar.jad_mz, jad_dqVar.jad_an, jad_dqVar.jad_pc, jad_fsVar);
        for (com.jd.ad.sdk.jad_al.jad_bo jad_boVar3 : emptyList) {
            try {
                jad_boVar3.jad_an(applicationContext, jad_cpVar, jad_cpVar.jad_dq);
            } catch (java.lang.AbstractMethodError e) {
                java.lang.StringBuilder jad_an8 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ");
                jad_an8.append(jad_boVar3.getClass().getName());
                throw new java.lang.IllegalStateException(jad_an8.toString(), e);
            }
        }
        applicationContext.registerComponentCallbacks(jad_cpVar);
        jad_iv = jad_cpVar;
        jad_jw = false;
    }

    public static void jad_an(java.lang.Exception exc) {
        throw new java.lang.IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    @androidx.annotation.NonNull
    public static com.jd.ad.sdk.jad_gr.jad_jw jad_bo(@androidx.annotation.NonNull android.content.Context context) {
        if (context != null) {
            return jad_an(context).jad_fs.jad_bo(context);
        }
        throw new java.lang.NullPointerException("You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
    }

    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_ny.jad_er jad_an() {
        return this.jad_an;
    }

    public void jad_an(com.jd.ad.sdk.jad_gr.jad_jw jad_jwVar) {
        synchronized (this.jad_hu) {
            if (this.jad_hu.contains(jad_jwVar)) {
                throw new java.lang.IllegalStateException("Cannot register already registered manager");
            }
            this.jad_hu.add(jad_jwVar);
        }
    }

    public com.jd.ad.sdk.jad_zk.jad_dq jad_bo() {
        return this.jad_jt;
    }

    @androidx.annotation.NonNull
    public android.content.Context jad_cp() {
        return this.jad_cp.getBaseContext();
    }

    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_gr.jad_er jad_dq() {
        return this.jad_cp;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        com.jd.ad.sdk.jad_ir.jad_ly.jad_an();
        ((com.jd.ad.sdk.jad_ir.jad_hu) this.jad_bo).jad_an(0L);
        this.jad_an.jad_an();
        this.jad_er.jad_an();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        long j;
        com.jd.ad.sdk.jad_ir.jad_ly.jad_an();
        synchronized (this.jad_hu) {
            java.util.Iterator<com.jd.ad.sdk.jad_gr.jad_jw> it = this.jad_hu.iterator();
            while (it.hasNext()) {
                it.next().getClass();
            }
        }
        com.jd.ad.sdk.jad_oz.jad_jt jad_jtVar = (com.jd.ad.sdk.jad_oz.jad_jt) this.jad_bo;
        jad_jtVar.getClass();
        if (i >= 40) {
            jad_jtVar.jad_an(0L);
        } else if (i >= 20 || i == 15) {
            synchronized (jad_jtVar) {
                j = jad_jtVar.jad_bo;
            }
            jad_jtVar.jad_an(j / 2);
        }
        this.jad_an.jad_an(i);
        this.jad_er.jad_an(i);
    }
}
