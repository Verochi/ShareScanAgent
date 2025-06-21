package com.jd.ad.sdk.jad_rc;

@androidx.annotation.RequiresApi(29)
/* loaded from: classes23.dex */
public final class jad_dq<DataT> implements com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, DataT> {
    public final android.content.Context jad_an;
    public final com.jd.ad.sdk.jad_qb.jad_na<java.io.File, DataT> jad_bo;
    public final com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, DataT> jad_cp;
    public final java.lang.Class<DataT> jad_dq;

    public static abstract class jad_an<DataT> implements com.jd.ad.sdk.jad_qb.jad_ob<android.net.Uri, DataT> {
        public final android.content.Context jad_an;
        public final java.lang.Class<DataT> jad_bo;

        public jad_an(android.content.Context context, java.lang.Class<DataT> cls) {
            this.jad_an = context;
            this.jad_bo = cls;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @androidx.annotation.NonNull
        public final com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, DataT> jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_rc.jad_dq(this.jad_an, jad_reVar.jad_an(java.io.File.class, this.jad_bo), jad_reVar.jad_an(android.net.Uri.class, this.jad_bo), this.jad_bo);
        }
    }

    @androidx.annotation.RequiresApi(29)
    public static final class jad_bo extends com.jd.ad.sdk.jad_rc.jad_dq.jad_an<android.os.ParcelFileDescriptor> {
        public jad_bo(android.content.Context context) {
            super(context, android.os.ParcelFileDescriptor.class);
        }
    }

    @androidx.annotation.RequiresApi(29)
    public static final class jad_cp extends com.jd.ad.sdk.jad_rc.jad_dq.jad_an<java.io.InputStream> {
        public jad_cp(android.content.Context context) {
            super(context, java.io.InputStream.class);
        }
    }

    /* renamed from: com.jd.ad.sdk.jad_rc.jad_dq$jad_dq, reason: collision with other inner class name */
    public static final class C0408jad_dq<DataT> implements com.jd.ad.sdk.jad_kv.jad_dq<DataT> {
        public static final java.lang.String[] jad_kx = {"_data"};
        public final android.content.Context jad_an;
        public final com.jd.ad.sdk.jad_qb.jad_na<java.io.File, DataT> jad_bo;
        public final com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, DataT> jad_cp;
        public final android.net.Uri jad_dq;
        public final int jad_er;
        public final int jad_fs;
        public final java.lang.Class<DataT> jad_hu;
        public volatile boolean jad_iv;
        public final com.jd.ad.sdk.jad_ju.jad_jw jad_jt;

        @androidx.annotation.Nullable
        public volatile com.jd.ad.sdk.jad_kv.jad_dq<DataT> jad_jw;

        public C0408jad_dq(android.content.Context context, com.jd.ad.sdk.jad_qb.jad_na<java.io.File, DataT> jad_naVar, com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, DataT> jad_naVar2, android.net.Uri uri, int i, int i2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar, java.lang.Class<DataT> cls) {
            this.jad_an = context.getApplicationContext();
            this.jad_bo = jad_naVar;
            this.jad_cp = jad_naVar2;
            this.jad_dq = uri;
            this.jad_er = i;
            this.jad_fs = i2;
            this.jad_jt = jad_jwVar;
            this.jad_hu = cls;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        @androidx.annotation.NonNull
        public java.lang.Class<DataT> jad_an() {
            return this.jad_hu;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super DataT> jad_anVar) {
            try {
                com.jd.ad.sdk.jad_kv.jad_dq<DataT> jad_er = jad_er();
                if (jad_er == null) {
                    jad_anVar.jad_an((java.lang.Exception) new java.lang.IllegalArgumentException("Failed to build fetcher for: " + this.jad_dq));
                    return;
                }
                this.jad_jw = jad_er;
                if (this.jad_iv) {
                    jad_cp();
                } else {
                    jad_er.jad_an(jad_jtVar, jad_anVar);
                }
            } catch (java.io.FileNotFoundException e) {
                jad_anVar.jad_an((java.lang.Exception) e);
            }
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_bo() {
            com.jd.ad.sdk.jad_kv.jad_dq<DataT> jad_dqVar = this.jad_jw;
            if (jad_dqVar != null) {
                jad_dqVar.jad_bo();
            }
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_cp() {
            this.jad_iv = true;
            com.jd.ad.sdk.jad_kv.jad_dq<DataT> jad_dqVar = this.jad_jw;
            if (jad_dqVar != null) {
                jad_dqVar.jad_cp();
            }
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_ju.jad_an jad_dq() {
            return com.jd.ad.sdk.jad_ju.jad_an.LOCAL;
        }

        @androidx.annotation.Nullable
        public final com.jd.ad.sdk.jad_kv.jad_dq<DataT> jad_er() {
            boolean isExternalStorageLegacy;
            com.jd.ad.sdk.jad_qb.jad_na.jad_an<DataT> jad_an;
            isExternalStorageLegacy = android.os.Environment.isExternalStorageLegacy();
            android.database.Cursor cursor = null;
            if (isExternalStorageLegacy) {
                com.jd.ad.sdk.jad_qb.jad_na<java.io.File, DataT> jad_naVar = this.jad_bo;
                android.net.Uri uri = this.jad_dq;
                try {
                    android.database.Cursor query = this.jad_an.getContentResolver().query(uri, jad_kx, null, null, null);
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                java.lang.String string = query.getString(query.getColumnIndexOrThrow("_data"));
                                if (android.text.TextUtils.isEmpty(string)) {
                                    throw new java.io.FileNotFoundException("File path was empty in media store for: " + uri);
                                }
                                java.io.File file = new java.io.File(string);
                                query.close();
                                jad_an = jad_naVar.jad_an(file, this.jad_er, this.jad_fs, this.jad_jt);
                            }
                        } catch (java.lang.Throwable th) {
                            th = th;
                            cursor = query;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                    throw new java.io.FileNotFoundException("Failed to media store entry for: " + uri);
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } else {
                jad_an = this.jad_cp.jad_an(this.jad_dq, this.jad_er, this.jad_fs, this.jad_jt);
            }
            if (jad_an != null) {
                return jad_an.jad_cp;
            }
            return null;
        }
    }

    public jad_dq(android.content.Context context, com.jd.ad.sdk.jad_qb.jad_na<java.io.File, DataT> jad_naVar, com.jd.ad.sdk.jad_qb.jad_na<android.net.Uri, DataT> jad_naVar2, java.lang.Class<DataT> cls) {
        this.jad_an = context.getApplicationContext();
        this.jad_bo = jad_naVar;
        this.jad_cp = jad_naVar2;
        this.jad_dq = cls;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public com.jd.ad.sdk.jad_qb.jad_na.jad_an jad_an(@androidx.annotation.NonNull android.net.Uri uri, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        android.net.Uri uri2 = uri;
        return new com.jd.ad.sdk.jad_qb.jad_na.jad_an(new com.jd.ad.sdk.jad_hq.jad_bo(uri2), java.util.Collections.emptyList(), new com.jd.ad.sdk.jad_rc.jad_dq.C0408jad_dq(this.jad_an, this.jad_bo, this.jad_cp, uri2, i, i2, jad_jwVar, this.jad_dq));
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public boolean jad_an(@androidx.annotation.NonNull android.net.Uri uri) {
        return android.os.Build.VERSION.SDK_INT >= 29 && com.jd.ad.sdk.jad_lw.jad_bo.jad_an(uri);
    }
}
