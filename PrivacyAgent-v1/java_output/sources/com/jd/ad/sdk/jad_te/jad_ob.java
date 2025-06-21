package com.jd.ad.sdk.jad_te;

/* loaded from: classes23.dex */
public interface jad_ob {

    public static final class jad_an implements com.jd.ad.sdk.jad_te.jad_ob {
        public final java.nio.ByteBuffer jad_an;
        public final java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> jad_bo;
        public final com.jd.ad.sdk.jad_ny.jad_bo jad_cp;

        public jad_an(java.nio.ByteBuffer byteBuffer, java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> list, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
            this.jad_an = byteBuffer;
            this.jad_bo = list;
            this.jad_cp = jad_boVar;
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        @androidx.annotation.Nullable
        public android.graphics.Bitmap jad_an(android.graphics.BitmapFactory.Options options) {
            return android.graphics.BitmapFactory.decodeStream(new com.jd.ad.sdk.jad_ir.jad_an.C0381jad_an(com.jd.ad.sdk.jad_ir.jad_an.jad_an(this.jad_an)), null, options);
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        public com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an() {
            return com.jd.ad.sdk.jad_ju.jad_jt.jad_an(this.jad_bo, com.jd.ad.sdk.jad_ir.jad_an.jad_an(this.jad_an));
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        public void jad_bo() {
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        public int jad_cp() {
            java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> list = this.jad_bo;
            java.nio.ByteBuffer jad_an = com.jd.ad.sdk.jad_ir.jad_an.jad_an(this.jad_an);
            com.jd.ad.sdk.jad_ny.jad_bo jad_boVar = this.jad_cp;
            if (jad_an == null) {
                return -1;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int jad_an2 = list.get(i).jad_an(jad_an, jad_boVar);
                if (jad_an2 != -1) {
                    return jad_an2;
                }
            }
            return -1;
        }
    }

    public static final class jad_bo implements com.jd.ad.sdk.jad_te.jad_ob {
        public final com.jd.ad.sdk.jad_kv.jad_kx jad_an;
        public final com.jd.ad.sdk.jad_ny.jad_bo jad_bo;
        public final java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> jad_cp;

        public jad_bo(java.io.InputStream inputStream, java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> list, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
            this.jad_bo = (com.jd.ad.sdk.jad_ny.jad_bo) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_boVar);
            this.jad_cp = (java.util.List) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(list);
            this.jad_an = new com.jd.ad.sdk.jad_kv.jad_kx(inputStream, jad_boVar);
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        @androidx.annotation.Nullable
        public android.graphics.Bitmap jad_an(android.graphics.BitmapFactory.Options options) {
            return android.graphics.BitmapFactory.decodeStream(this.jad_an.jad_an(), null, options);
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        public com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an() {
            return com.jd.ad.sdk.jad_ju.jad_jt.jad_bo(this.jad_cp, this.jad_an.jad_an(), this.jad_bo);
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        public void jad_bo() {
            com.jd.ad.sdk.jad_te.jad_sf jad_sfVar = this.jad_an.jad_an;
            synchronized (jad_sfVar) {
                jad_sfVar.jad_cp = jad_sfVar.jad_an.length;
            }
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        public int jad_cp() {
            return com.jd.ad.sdk.jad_ju.jad_jt.jad_an(this.jad_cp, this.jad_an.jad_an(), this.jad_bo);
        }
    }

    @androidx.annotation.RequiresApi(21)
    public static final class jad_cp implements com.jd.ad.sdk.jad_te.jad_ob {
        public final com.jd.ad.sdk.jad_ny.jad_bo jad_an;
        public final java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> jad_bo;
        public final com.jd.ad.sdk.jad_kv.jad_mz jad_cp;

        public jad_cp(android.os.ParcelFileDescriptor parcelFileDescriptor, java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> list, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
            this.jad_an = (com.jd.ad.sdk.jad_ny.jad_bo) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_boVar);
            this.jad_bo = (java.util.List) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(list);
            this.jad_cp = new com.jd.ad.sdk.jad_kv.jad_mz(parcelFileDescriptor);
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        @androidx.annotation.Nullable
        public android.graphics.Bitmap jad_an(android.graphics.BitmapFactory.Options options) {
            return android.graphics.BitmapFactory.decodeFileDescriptor(this.jad_cp.jad_an.jad_an().getFileDescriptor(), null, options);
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        public com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an() {
            com.jd.ad.sdk.jad_te.jad_sf jad_sfVar;
            java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> list = this.jad_bo;
            com.jd.ad.sdk.jad_kv.jad_mz jad_mzVar = this.jad_cp;
            com.jd.ad.sdk.jad_ny.jad_bo jad_boVar = this.jad_an;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.jd.ad.sdk.jad_ju.jad_fs jad_fsVar = list.get(i);
                try {
                    jad_sfVar = new com.jd.ad.sdk.jad_te.jad_sf(new java.io.FileInputStream(jad_mzVar.jad_an.jad_an().getFileDescriptor()), jad_boVar, 65536);
                } catch (java.lang.Throwable th) {
                    th = th;
                    jad_sfVar = null;
                }
                try {
                    com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an = jad_fsVar.jad_an(jad_sfVar);
                    try {
                        jad_sfVar.close();
                    } catch (java.io.IOException unused) {
                    }
                    jad_mzVar.jad_an.jad_an();
                    if (jad_an != com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.UNKNOWN) {
                        return jad_an;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (jad_sfVar != null) {
                        try {
                            jad_sfVar.close();
                        } catch (java.io.IOException unused2) {
                        }
                    }
                    jad_mzVar.jad_an.jad_an();
                    throw th;
                }
            }
            return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.UNKNOWN;
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        public void jad_bo() {
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        public int jad_cp() {
            com.jd.ad.sdk.jad_te.jad_sf jad_sfVar;
            java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> list = this.jad_bo;
            com.jd.ad.sdk.jad_kv.jad_mz jad_mzVar = this.jad_cp;
            com.jd.ad.sdk.jad_ny.jad_bo jad_boVar = this.jad_an;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.jd.ad.sdk.jad_ju.jad_fs jad_fsVar = list.get(i);
                try {
                    jad_sfVar = new com.jd.ad.sdk.jad_te.jad_sf(new java.io.FileInputStream(jad_mzVar.jad_an.jad_an().getFileDescriptor()), jad_boVar, 65536);
                } catch (java.lang.Throwable th) {
                    th = th;
                    jad_sfVar = null;
                }
                try {
                    int jad_an = jad_fsVar.jad_an(jad_sfVar, jad_boVar);
                    try {
                        jad_sfVar.close();
                    } catch (java.io.IOException unused) {
                    }
                    jad_mzVar.jad_an.jad_an();
                    if (jad_an != -1) {
                        return jad_an;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (jad_sfVar != null) {
                        try {
                            jad_sfVar.close();
                        } catch (java.io.IOException unused2) {
                        }
                    }
                    jad_mzVar.jad_an.jad_an();
                    throw th;
                }
            }
            return -1;
        }
    }

    @androidx.annotation.Nullable
    android.graphics.Bitmap jad_an(android.graphics.BitmapFactory.Options options);

    com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an();

    void jad_bo();

    int jad_cp();
}
