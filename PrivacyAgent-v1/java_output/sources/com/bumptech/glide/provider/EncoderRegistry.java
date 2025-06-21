package com.bumptech.glide.provider;

/* loaded from: classes.dex */
public class EncoderRegistry {
    private final java.util.List<com.bumptech.glide.provider.EncoderRegistry.Entry<?>> encoders = new java.util.ArrayList();

    public static final class Entry<T> {
        private final java.lang.Class<T> dataClass;
        final com.bumptech.glide.load.Encoder<T> encoder;

        public Entry(@androidx.annotation.NonNull java.lang.Class<T> cls, @androidx.annotation.NonNull com.bumptech.glide.load.Encoder<T> encoder) {
            this.dataClass = cls;
            this.encoder = encoder;
        }

        public boolean handles(@androidx.annotation.NonNull java.lang.Class<?> cls) {
            return this.dataClass.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void append(@androidx.annotation.NonNull java.lang.Class<T> cls, @androidx.annotation.NonNull com.bumptech.glide.load.Encoder<T> encoder) {
        this.encoders.add(new com.bumptech.glide.provider.EncoderRegistry.Entry<>(cls, encoder));
    }

    @androidx.annotation.Nullable
    public synchronized <T> com.bumptech.glide.load.Encoder<T> getEncoder(@androidx.annotation.NonNull java.lang.Class<T> cls) {
        for (com.bumptech.glide.provider.EncoderRegistry.Entry<?> entry : this.encoders) {
            if (entry.handles(cls)) {
                return (com.bumptech.glide.load.Encoder<T>) entry.encoder;
            }
        }
        return null;
    }

    public synchronized <T> void prepend(@androidx.annotation.NonNull java.lang.Class<T> cls, @androidx.annotation.NonNull com.bumptech.glide.load.Encoder<T> encoder) {
        this.encoders.add(0, new com.bumptech.glide.provider.EncoderRegistry.Entry<>(cls, encoder));
    }
}
