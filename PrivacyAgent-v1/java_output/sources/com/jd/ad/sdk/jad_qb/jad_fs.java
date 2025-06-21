package com.jd.ad.sdk.jad_qb;

/* loaded from: classes23.dex */
public class jad_fs<Data> implements com.jd.ad.sdk.jad_qb.jad_na<java.io.File, Data> {
    public final com.jd.ad.sdk.jad_qb.jad_fs.jad_dq<Data> jad_an;

    public static class jad_an<Data> implements com.jd.ad.sdk.jad_qb.jad_ob<java.io.File, Data> {
        public final com.jd.ad.sdk.jad_qb.jad_fs.jad_dq<Data> jad_an;

        public jad_an(com.jd.ad.sdk.jad_qb.jad_fs.jad_dq<Data> jad_dqVar) {
            this.jad_an = jad_dqVar;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @androidx.annotation.NonNull
        public final com.jd.ad.sdk.jad_qb.jad_na<java.io.File, Data> jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_qb.jad_re jad_reVar) {
            return new com.jd.ad.sdk.jad_qb.jad_fs(this.jad_an);
        }
    }

    public static class jad_bo extends com.jd.ad.sdk.jad_qb.jad_fs.jad_an<android.os.ParcelFileDescriptor> {

        public class jad_an implements com.jd.ad.sdk.jad_qb.jad_fs.jad_dq<android.os.ParcelFileDescriptor> {
            @Override // com.jd.ad.sdk.jad_qb.jad_fs.jad_dq
            public java.lang.Class<android.os.ParcelFileDescriptor> jad_an() {
                return android.os.ParcelFileDescriptor.class;
            }

            @Override // com.jd.ad.sdk.jad_qb.jad_fs.jad_dq
            public android.os.ParcelFileDescriptor jad_an(java.io.File file) {
                return android.os.ParcelFileDescriptor.open(file, 268435456);
            }

            @Override // com.jd.ad.sdk.jad_qb.jad_fs.jad_dq
            public void jad_an(android.os.ParcelFileDescriptor parcelFileDescriptor) {
                parcelFileDescriptor.close();
            }
        }

        public jad_bo() {
            super(new com.jd.ad.sdk.jad_qb.jad_fs.jad_bo.jad_an());
        }
    }

    public static final class jad_cp<Data> implements com.jd.ad.sdk.jad_kv.jad_dq<Data> {
        public final java.io.File jad_an;
        public final com.jd.ad.sdk.jad_qb.jad_fs.jad_dq<Data> jad_bo;
        public Data jad_cp;

        public jad_cp(java.io.File file, com.jd.ad.sdk.jad_qb.jad_fs.jad_dq<Data> jad_dqVar) {
            this.jad_an = file;
            this.jad_bo = jad_dqVar;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        @androidx.annotation.NonNull
        public java.lang.Class<Data> jad_an() {
            return this.jad_bo.jad_an();
        }

        /* JADX WARN: Type inference failed for: r5v3, types: [Data, java.lang.Object] */
        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super Data> jad_anVar) {
            try {
                Data jad_an = this.jad_bo.jad_an(this.jad_an);
                this.jad_cp = jad_an;
                jad_anVar.jad_an((com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super Data>) jad_an);
            } catch (java.io.FileNotFoundException e) {
                if (android.util.Log.isLoggable("FileLoader", 3)) {
                    com.jd.ad.sdk.logger.Logger.d("FileLoader", "Failed to open file", e);
                }
                jad_anVar.jad_an((java.lang.Exception) e);
            }
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_bo() {
            Data data = this.jad_cp;
            if (data != null) {
                try {
                    this.jad_bo.jad_an((com.jd.ad.sdk.jad_qb.jad_fs.jad_dq<Data>) data);
                } catch (java.io.IOException unused) {
                }
            }
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_cp() {
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_ju.jad_an jad_dq() {
            return com.jd.ad.sdk.jad_ju.jad_an.LOCAL;
        }
    }

    public interface jad_dq<Data> {
        java.lang.Class<Data> jad_an();

        Data jad_an(java.io.File file);

        void jad_an(Data data);
    }

    public static class jad_er extends com.jd.ad.sdk.jad_qb.jad_fs.jad_an<java.io.InputStream> {

        public class jad_an implements com.jd.ad.sdk.jad_qb.jad_fs.jad_dq<java.io.InputStream> {
            @Override // com.jd.ad.sdk.jad_qb.jad_fs.jad_dq
            public java.lang.Class<java.io.InputStream> jad_an() {
                return java.io.InputStream.class;
            }

            @Override // com.jd.ad.sdk.jad_qb.jad_fs.jad_dq
            public java.io.InputStream jad_an(java.io.File file) {
                return new java.io.FileInputStream(file);
            }

            @Override // com.jd.ad.sdk.jad_qb.jad_fs.jad_dq
            public void jad_an(java.io.InputStream inputStream) {
                inputStream.close();
            }
        }

        public jad_er() {
            super(new com.jd.ad.sdk.jad_qb.jad_fs.jad_er.jad_an());
        }
    }

    public jad_fs(com.jd.ad.sdk.jad_qb.jad_fs.jad_dq<Data> jad_dqVar) {
        this.jad_an = jad_dqVar;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public com.jd.ad.sdk.jad_qb.jad_na.jad_an jad_an(@androidx.annotation.NonNull java.io.File file, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        java.io.File file2 = file;
        return new com.jd.ad.sdk.jad_qb.jad_na.jad_an(new com.jd.ad.sdk.jad_hq.jad_bo(file2), java.util.Collections.emptyList(), new com.jd.ad.sdk.jad_qb.jad_fs.jad_cp(file2, this.jad_an));
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public /* bridge */ /* synthetic */ boolean jad_an(@androidx.annotation.NonNull java.io.File file) {
        return true;
    }
}
