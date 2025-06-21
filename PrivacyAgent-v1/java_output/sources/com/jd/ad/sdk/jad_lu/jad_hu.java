package com.jd.ad.sdk.jad_lu;

/* loaded from: classes23.dex */
public class jad_hu {
    public static final java.util.Map<java.lang.String, com.jd.ad.sdk.jad_lu.jad_uh<com.jd.ad.sdk.jad_lu.jad_jt>> jad_an = new java.util.HashMap();
    public static final byte[] jad_bo = {80, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, 3, 4};

    public class jad_an implements com.jd.ad.sdk.jad_lu.jad_ob<com.jd.ad.sdk.jad_lu.jad_jt> {
        public final /* synthetic */ java.lang.String jad_an;

        public jad_an(java.lang.String str) {
            this.jad_an = str;
        }

        @Override // com.jd.ad.sdk.jad_lu.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
            ((java.util.HashMap) com.jd.ad.sdk.jad_lu.jad_hu.jad_an).remove(this.jad_an);
        }
    }

    public class jad_bo implements com.jd.ad.sdk.jad_lu.jad_ob<java.lang.Throwable> {
        public final /* synthetic */ java.lang.String jad_an;

        public jad_bo(java.lang.String str) {
            this.jad_an = str;
        }

        @Override // com.jd.ad.sdk.jad_lu.jad_ob
        public void jad_an(java.lang.Throwable th) {
            ((java.util.HashMap) com.jd.ad.sdk.jad_lu.jad_hu.jad_an).remove(this.jad_an);
        }
    }

    public class jad_cp implements java.util.concurrent.Callable<com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt>> {
        public final /* synthetic */ com.jd.ad.sdk.jad_lu.jad_jt jad_an;

        public jad_cp(com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
            this.jad_an = jad_jtVar;
        }

        @Override // java.util.concurrent.Callable
        public com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt> call() {
            return new com.jd.ad.sdk.jad_lu.jad_sf<>(this.jad_an);
        }
    }

    @androidx.annotation.WorkerThread
    public static com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt> jad_an(android.content.Context context, @androidx.annotation.RawRes int i, @androidx.annotation.Nullable java.lang.String str) {
        java.lang.Boolean bool;
        try {
            com.jd.ad.sdk.jad_hk.jad_iv jad_ivVar = new com.jd.ad.sdk.jad_hk.jad_iv(com.jd.ad.sdk.jad_hk.jad_er.jad_an(context.getResources().openRawResource(i)));
            try {
                com.jd.ad.sdk.jad_hk.jad_bo jad_bo2 = jad_ivVar.jad_bo();
                byte[] bArr = jad_bo;
                int length = bArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        ((com.jd.ad.sdk.jad_hk.jad_iv) jad_bo2).close();
                        bool = java.lang.Boolean.TRUE;
                        break;
                    }
                    if (((com.jd.ad.sdk.jad_hk.jad_iv) jad_bo2).jad_cp() != bArr[i2]) {
                        bool = java.lang.Boolean.FALSE;
                        break;
                    }
                    i2++;
                }
            } catch (java.lang.Exception unused) {
                com.jd.ad.sdk.jad_xg.jad_dq.jad_an.getClass();
                bool = java.lang.Boolean.FALSE;
            }
            return bool.booleanValue() ? jad_an(new java.util.zip.ZipInputStream(new com.jd.ad.sdk.jad_hk.jad_hu(jad_ivVar)), str) : jad_an(new com.jd.ad.sdk.jad_hk.jad_hu(jad_ivVar), str);
        } catch (android.content.res.Resources.NotFoundException e) {
            return new com.jd.ad.sdk.jad_lu.jad_sf<>((java.lang.Throwable) e);
        }
    }

    @androidx.annotation.WorkerThread
    public static com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt> jad_an(android.content.Context context, java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return jad_an(context.getAssets().open(str), str2);
            }
            return jad_an(new java.util.zip.ZipInputStream(context.getAssets().open(str)), str2);
        } catch (java.io.IOException e) {
            return new com.jd.ad.sdk.jad_lu.jad_sf<>((java.lang.Throwable) e);
        }
    }

    public static com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt> jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, @androidx.annotation.Nullable java.lang.String str, boolean z) {
        try {
            try {
                com.jd.ad.sdk.jad_lu.jad_jt jad_an2 = com.jd.ad.sdk.jad_ve.jad_wj.jad_an(jad_cpVar);
                if (str != null) {
                    com.jd.ad.sdk.jad_qz.jad_jt.jad_bo.jad_an(str, jad_an2);
                }
                com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt> jad_sfVar = new com.jd.ad.sdk.jad_lu.jad_sf<>(jad_an2);
                if (z) {
                    com.jd.ad.sdk.jad_xg.jad_hu.jad_an(jad_cpVar);
                }
                return jad_sfVar;
            } catch (java.lang.Exception e) {
                com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt> jad_sfVar2 = new com.jd.ad.sdk.jad_lu.jad_sf<>(e);
                if (z) {
                    com.jd.ad.sdk.jad_xg.jad_hu.jad_an(jad_cpVar);
                }
                return jad_sfVar2;
            }
        } catch (java.lang.Throwable th) {
            if (z) {
                com.jd.ad.sdk.jad_xg.jad_hu.jad_an(jad_cpVar);
            }
            throw th;
        }
    }

    @androidx.annotation.WorkerThread
    public static com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt> jad_an(java.io.InputStream inputStream, @androidx.annotation.Nullable java.lang.String str) {
        try {
            com.jd.ad.sdk.jad_hk.jad_iv jad_ivVar = new com.jd.ad.sdk.jad_hk.jad_iv(com.jd.ad.sdk.jad_hk.jad_er.jad_an(inputStream));
            java.lang.String[] strArr = com.jd.ad.sdk.jad_wf.jad_cp.jad_er;
            return jad_an((com.jd.ad.sdk.jad_wf.jad_cp) new com.jd.ad.sdk.jad_wf.jad_fs(jad_ivVar), str, true);
        } finally {
            com.jd.ad.sdk.jad_xg.jad_hu.jad_an(inputStream);
        }
    }

    @androidx.annotation.WorkerThread
    public static com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt> jad_an(java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        com.jd.ad.sdk.jad_hk.jad_iv jad_ivVar = new com.jd.ad.sdk.jad_hk.jad_iv(com.jd.ad.sdk.jad_hk.jad_er.jad_an(new java.io.ByteArrayInputStream(str.getBytes())));
        java.lang.String[] strArr = com.jd.ad.sdk.jad_wf.jad_cp.jad_er;
        return jad_an((com.jd.ad.sdk.jad_wf.jad_cp) new com.jd.ad.sdk.jad_wf.jad_fs(jad_ivVar), (java.lang.String) null, true);
    }

    @androidx.annotation.WorkerThread
    public static com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt> jad_an(java.util.zip.ZipInputStream zipInputStream, @androidx.annotation.Nullable java.lang.String str) {
        try {
            return jad_bo(zipInputStream, str);
        } finally {
            com.jd.ad.sdk.jad_xg.jad_hu.jad_an(zipInputStream);
        }
    }

    public static com.jd.ad.sdk.jad_lu.jad_uh<com.jd.ad.sdk.jad_lu.jad_jt> jad_an(@androidx.annotation.Nullable java.lang.String str, java.util.concurrent.Callable<com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt>> callable) {
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar;
        if (str == null) {
            jad_jtVar = null;
        } else {
            com.jd.ad.sdk.jad_qz.jad_jt jad_jtVar2 = com.jd.ad.sdk.jad_qz.jad_jt.jad_bo;
            jad_jtVar2.getClass();
            jad_jtVar = jad_jtVar2.jad_an.get(str);
        }
        if (jad_jtVar != null) {
            return new com.jd.ad.sdk.jad_lu.jad_uh<>(new com.jd.ad.sdk.jad_lu.jad_hu.jad_cp(jad_jtVar), false);
        }
        if (str != null) {
            java.util.HashMap hashMap = (java.util.HashMap) jad_an;
            if (hashMap.containsKey(str)) {
                return (com.jd.ad.sdk.jad_lu.jad_uh) hashMap.get(str);
            }
        }
        com.jd.ad.sdk.jad_lu.jad_uh<com.jd.ad.sdk.jad_lu.jad_jt> jad_uhVar = new com.jd.ad.sdk.jad_lu.jad_uh<>(callable, false);
        if (str != null) {
            jad_uhVar.jad_bo(new com.jd.ad.sdk.jad_lu.jad_hu.jad_an(str));
            jad_uhVar.jad_an(new com.jd.ad.sdk.jad_lu.jad_hu.jad_bo(str));
            ((java.util.HashMap) jad_an).put(str, jad_uhVar);
        }
        return jad_uhVar;
    }

    public static java.lang.String jad_an(android.content.Context context, @androidx.annotation.RawRes int i) {
        java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("rawRes");
        jad_an2.append((context.getResources().getConfiguration().uiMode & 48) == 32 ? "_night_" : "_day_");
        jad_an2.append(i);
        return jad_an2.toString();
    }

    @androidx.annotation.WorkerThread
    public static com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt> jad_bo(java.util.zip.ZipInputStream zipInputStream, @androidx.annotation.Nullable java.lang.String str) {
        com.jd.ad.sdk.jad_lu.jad_na jad_naVar;
        java.util.HashMap hashMap = new java.util.HashMap();
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = null;
        while (true) {
            try {
                java.util.zip.ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    break;
                }
                java.lang.String name = nextEntry.getName();
                if (!name.startsWith("../") && !name.contains("__MACOSX") && !nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    if (nextEntry.getName().contains(".json")) {
                        com.jd.ad.sdk.jad_hk.jad_iv jad_ivVar = new com.jd.ad.sdk.jad_hk.jad_iv(com.jd.ad.sdk.jad_hk.jad_er.jad_an(zipInputStream));
                        java.lang.String[] strArr = com.jd.ad.sdk.jad_wf.jad_cp.jad_er;
                        jad_jtVar = jad_an((com.jd.ad.sdk.jad_wf.jad_cp) new com.jd.ad.sdk.jad_wf.jad_fs(jad_ivVar), (java.lang.String) null, false).jad_an;
                    } else {
                        if (!name.contains(".png") && !name.contains(".webp") && !name.contains(".jpg") && !name.contains(".jpeg")) {
                        }
                        java.lang.String[] split = name.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                        hashMap.put(split[split.length - 1], android.graphics.BitmapFactory.decodeStream(zipInputStream));
                    }
                }
                zipInputStream.closeEntry();
            } catch (java.io.IOException e) {
                return new com.jd.ad.sdk.jad_lu.jad_sf<>((java.lang.Throwable) e);
            }
        }
        if (jad_jtVar == null) {
            return new com.jd.ad.sdk.jad_lu.jad_sf<>((java.lang.Throwable) new java.lang.IllegalArgumentException("Unable to parse composition"));
        }
        for (java.util.Map.Entry entry : hashMap.entrySet()) {
            java.lang.String str2 = (java.lang.String) entry.getKey();
            java.util.Iterator<com.jd.ad.sdk.jad_lu.jad_na> it = jad_jtVar.jad_dq.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    jad_naVar = null;
                    break;
                }
                jad_naVar = it.next();
                if (jad_naVar.jad_dq.equals(str2)) {
                    break;
                }
            }
            if (jad_naVar != null) {
                android.graphics.Bitmap bitmap = (android.graphics.Bitmap) entry.getValue();
                int i = jad_naVar.jad_an;
                int i2 = jad_naVar.jad_bo;
                java.lang.ThreadLocal<android.graphics.PathMeasure> threadLocal = com.jd.ad.sdk.jad_xg.jad_hu.jad_an;
                if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
                    android.graphics.Bitmap createScaledBitmap = android.graphics.Bitmap.createScaledBitmap(bitmap, i, i2, true);
                    bitmap.recycle();
                    bitmap = createScaledBitmap;
                }
                jad_naVar.jad_er = bitmap;
            }
        }
        for (java.util.Map.Entry<java.lang.String, com.jd.ad.sdk.jad_lu.jad_na> entry2 : jad_jtVar.jad_dq.entrySet()) {
            if (entry2.getValue().jad_er == null) {
                java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("There is no image for ");
                jad_an2.append(entry2.getValue().jad_dq);
                return new com.jd.ad.sdk.jad_lu.jad_sf<>((java.lang.Throwable) new java.lang.IllegalStateException(jad_an2.toString()));
            }
        }
        if (str != null) {
            com.jd.ad.sdk.jad_qz.jad_jt.jad_bo.jad_an(str, jad_jtVar);
        }
        return new com.jd.ad.sdk.jad_lu.jad_sf<>(jad_jtVar);
    }
}
