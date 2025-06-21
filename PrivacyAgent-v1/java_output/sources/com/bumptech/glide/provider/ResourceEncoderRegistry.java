package com.bumptech.glide.provider;

/* loaded from: classes.dex */
public class ResourceEncoderRegistry {
    private final java.util.List<com.bumptech.glide.provider.ResourceEncoderRegistry.Entry<?>> encoders = new java.util.ArrayList();

    public static final class Entry<T> {
        final com.bumptech.glide.load.ResourceEncoder<T> encoder;
        private final java.lang.Class<T> resourceClass;

        public Entry(@androidx.annotation.NonNull java.lang.Class<T> cls, @androidx.annotation.NonNull com.bumptech.glide.load.ResourceEncoder<T> resourceEncoder) {
            this.resourceClass = cls;
            this.encoder = resourceEncoder;
        }

        public boolean handles(@androidx.annotation.NonNull java.lang.Class<?> cls) {
            return this.resourceClass.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void append(@androidx.annotation.NonNull java.lang.Class<Z> cls, @androidx.annotation.NonNull com.bumptech.glide.load.ResourceEncoder<Z> resourceEncoder) {
        this.encoders.add(new com.bumptech.glide.provider.ResourceEncoderRegistry.Entry<>(cls, resourceEncoder));
    }

    @androidx.annotation.Nullable
    public synchronized <Z> com.bumptech.glide.load.ResourceEncoder<Z> get(@androidx.annotation.NonNull java.lang.Class<Z> cls) {
        int size = this.encoders.size();
        for (int i = 0; i < size; i++) {
            com.bumptech.glide.provider.ResourceEncoderRegistry.Entry<?> entry = this.encoders.get(i);
            if (entry.handles(cls)) {
                return (com.bumptech.glide.load.ResourceEncoder<Z>) entry.encoder;
            }
        }
        return null;
    }

    public synchronized <Z> void prepend(@androidx.annotation.NonNull java.lang.Class<Z> cls, @androidx.annotation.NonNull com.bumptech.glide.load.ResourceEncoder<Z> resourceEncoder) {
        this.encoders.add(0, new com.bumptech.glide.provider.ResourceEncoderRegistry.Entry<>(cls, resourceEncoder));
    }
}
