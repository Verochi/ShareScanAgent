package com.bumptech.glide.util;

/* loaded from: classes.dex */
public class FixedPreloadSizeProvider<T> implements com.bumptech.glide.ListPreloader.PreloadSizeProvider<T> {
    private final int[] size;

    public FixedPreloadSizeProvider(int i, int i2) {
        this.size = new int[]{i, i2};
    }

    @Override // com.bumptech.glide.ListPreloader.PreloadSizeProvider
    @androidx.annotation.Nullable
    public int[] getPreloadSize(@androidx.annotation.NonNull T t, int i, int i2) {
        return this.size;
    }
}
