package com.google.android.material.progressindicator;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class AnimatorDurationScaleProvider {
    private static float defaultSystemAnimatorDurationScale = 1.0f;

    @androidx.annotation.VisibleForTesting
    public static void setDefaultSystemAnimatorDurationScale(float f) {
        defaultSystemAnimatorDurationScale = f;
    }

    public float getSystemAnimatorDurationScale(@androidx.annotation.NonNull android.content.ContentResolver contentResolver) {
        return android.provider.Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
    }
}
