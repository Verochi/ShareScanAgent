package com.google.android.material.slider;

/* loaded from: classes22.dex */
public final class BasicLabelFormatter implements com.google.android.material.slider.LabelFormatter {
    private static final int BILLION = 1000000000;
    private static final int MILLION = 1000000;
    private static final int THOUSAND = 1000;
    private static final long TRILLION = 1000000000000L;

    @Override // com.google.android.material.slider.LabelFormatter
    @androidx.annotation.NonNull
    public java.lang.String getFormattedValue(float f) {
        return f >= 1.0E12f ? java.lang.String.format(java.util.Locale.US, "%.1fT", java.lang.Float.valueOf(f / 1.0E12f)) : f >= 1.0E9f ? java.lang.String.format(java.util.Locale.US, "%.1fB", java.lang.Float.valueOf(f / 1.0E9f)) : f >= 1000000.0f ? java.lang.String.format(java.util.Locale.US, "%.1fM", java.lang.Float.valueOf(f / 1000000.0f)) : f >= 1000.0f ? java.lang.String.format(java.util.Locale.US, "%.1fK", java.lang.Float.valueOf(f / 1000.0f)) : java.lang.String.format(java.util.Locale.US, "%.0f", java.lang.Float.valueOf(f));
    }
}
