package com.google.android.material.timepicker;

/* loaded from: classes22.dex */
interface TimePickerControls {

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ActiveSelection {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ClockPeriod {
    }

    void setActiveSelection(int i);

    void setHandRotation(float f);

    void setValues(java.lang.String[] strArr, @androidx.annotation.StringRes int i);

    void updateTime(int i, int i2, @androidx.annotation.IntRange(from = 0) int i3);
}
