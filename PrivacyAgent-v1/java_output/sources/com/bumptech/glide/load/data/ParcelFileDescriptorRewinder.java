package com.bumptech.glide.load.data;

/* loaded from: classes.dex */
public final class ParcelFileDescriptorRewinder implements com.bumptech.glide.load.data.DataRewinder<android.os.ParcelFileDescriptor> {
    private final com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.InternalRewinder rewinder;

    @androidx.annotation.RequiresApi(21)
    public static final class Factory implements com.bumptech.glide.load.data.DataRewinder.Factory<android.os.ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @androidx.annotation.NonNull
        public com.bumptech.glide.load.data.DataRewinder<android.os.ParcelFileDescriptor> build(@androidx.annotation.NonNull android.os.ParcelFileDescriptor parcelFileDescriptor) {
            return new com.bumptech.glide.load.data.ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @androidx.annotation.NonNull
        public java.lang.Class<android.os.ParcelFileDescriptor> getDataClass() {
            return android.os.ParcelFileDescriptor.class;
        }
    }

    @androidx.annotation.RequiresApi(21)
    public static final class InternalRewinder {
        private final android.os.ParcelFileDescriptor parcelFileDescriptor;

        public InternalRewinder(android.os.ParcelFileDescriptor parcelFileDescriptor) {
            this.parcelFileDescriptor = parcelFileDescriptor;
        }

        public android.os.ParcelFileDescriptor rewind() throws java.io.IOException {
            try {
                android.system.Os.lseek(this.parcelFileDescriptor.getFileDescriptor(), 0L, android.system.OsConstants.SEEK_SET);
                return this.parcelFileDescriptor;
            } catch (android.system.ErrnoException e) {
                throw new java.io.IOException(e);
            }
        }
    }

    @androidx.annotation.RequiresApi(21)
    public ParcelFileDescriptorRewinder(android.os.ParcelFileDescriptor parcelFileDescriptor) {
        this.rewinder = new com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.InternalRewinder(parcelFileDescriptor);
    }

    public static boolean isSupported() {
        return true;
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public void cleanup() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.DataRewinder
    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(21)
    public android.os.ParcelFileDescriptor rewindAndGet() throws java.io.IOException {
        return this.rewinder.rewind();
    }
}
