package com.aliyun.svideosdk.common.struct.asset;

/* loaded from: classes12.dex */
public class TypefaceConfig {
    public final boolean fakeBold;
    public final android.graphics.Typeface typeface;

    public TypefaceConfig() {
        this(null, false);
    }

    public TypefaceConfig(android.graphics.Typeface typeface) {
        this(typeface, false);
    }

    public TypefaceConfig(android.graphics.Typeface typeface, boolean z) {
        this.typeface = typeface;
        this.fakeBold = z;
    }
}
