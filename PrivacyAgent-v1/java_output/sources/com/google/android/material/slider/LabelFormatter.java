package com.google.android.material.slider;

/* loaded from: classes22.dex */
public interface LabelFormatter {
    public static final int LABEL_FLOATING = 0;
    public static final int LABEL_GONE = 2;
    public static final int LABEL_WITHIN_BOUNDS = 1;

    @androidx.annotation.NonNull
    java.lang.String getFormattedValue(float f);
}
