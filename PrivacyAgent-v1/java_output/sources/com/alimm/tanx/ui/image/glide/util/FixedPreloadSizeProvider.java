package com.alimm.tanx.ui.image.glide.util;

/* loaded from: classes.dex */
public class FixedPreloadSizeProvider<T> implements com.alimm.tanx.ui.image.glide.ListPreloader.PreloadSizeProvider<T> {
    private final int[] size;

    public FixedPreloadSizeProvider(int i, int i2) {
        this.size = new int[]{i, i2};
    }

    @Override // com.alimm.tanx.ui.image.glide.ListPreloader.PreloadSizeProvider
    public int[] getPreloadSize(T t, int i, int i2) {
        int[] iArr = this.size;
        return java.util.Arrays.copyOf(iArr, iArr.length);
    }
}
