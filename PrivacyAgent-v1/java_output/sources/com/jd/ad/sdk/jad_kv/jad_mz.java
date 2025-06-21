package com.jd.ad.sdk.jad_kv;

/* loaded from: classes23.dex */
public final class jad_mz implements com.jd.ad.sdk.jad_kv.jad_er<android.os.ParcelFileDescriptor> {
    public final com.jd.ad.sdk.jad_kv.jad_mz.jad_bo jad_an;

    @androidx.annotation.RequiresApi(21)
    public static final class jad_an implements com.jd.ad.sdk.jad_kv.jad_er.jad_an<android.os.ParcelFileDescriptor> {
        @Override // com.jd.ad.sdk.jad_kv.jad_er.jad_an
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_kv.jad_er<android.os.ParcelFileDescriptor> jad_an(@androidx.annotation.NonNull android.os.ParcelFileDescriptor parcelFileDescriptor) {
            return new com.jd.ad.sdk.jad_kv.jad_mz(parcelFileDescriptor);
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_er.jad_an
        @androidx.annotation.NonNull
        public java.lang.Class<android.os.ParcelFileDescriptor> jad_an() {
            return android.os.ParcelFileDescriptor.class;
        }
    }

    @androidx.annotation.RequiresApi(21)
    public static final class jad_bo {
        public final android.os.ParcelFileDescriptor jad_an;

        public jad_bo(android.os.ParcelFileDescriptor parcelFileDescriptor) {
            this.jad_an = parcelFileDescriptor;
        }

        public android.os.ParcelFileDescriptor jad_an() {
            try {
                android.system.Os.lseek(this.jad_an.getFileDescriptor(), 0L, android.system.OsConstants.SEEK_SET);
                return this.jad_an;
            } catch (android.system.ErrnoException e) {
                throw new java.io.IOException(e);
            }
        }
    }

    @androidx.annotation.RequiresApi(21)
    public jad_mz(android.os.ParcelFileDescriptor parcelFileDescriptor) {
        this.jad_an = new com.jd.ad.sdk.jad_kv.jad_mz.jad_bo(parcelFileDescriptor);
    }

    public static boolean jad_cp() {
        return true;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_er
    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(21)
    public android.os.ParcelFileDescriptor jad_an() {
        return this.jad_an.jad_an();
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_er
    public void jad_bo() {
    }
}
