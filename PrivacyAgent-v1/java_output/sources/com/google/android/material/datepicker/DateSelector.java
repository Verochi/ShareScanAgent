package com.google.android.material.datepicker;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public interface DateSelector<S> extends android.os.Parcelable {
    @androidx.annotation.StyleRes
    int getDefaultThemeResId(android.content.Context context);

    @androidx.annotation.StringRes
    int getDefaultTitleResId();

    @androidx.annotation.NonNull
    java.util.Collection<java.lang.Long> getSelectedDays();

    @androidx.annotation.NonNull
    java.util.Collection<androidx.core.util.Pair<java.lang.Long, java.lang.Long>> getSelectedRanges();

    @androidx.annotation.Nullable
    S getSelection();

    @androidx.annotation.NonNull
    java.lang.String getSelectionDisplayString(android.content.Context context);

    boolean isSelectionComplete();

    @androidx.annotation.NonNull
    android.view.View onCreateTextInputView(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, @androidx.annotation.Nullable android.os.Bundle bundle, @androidx.annotation.NonNull com.google.android.material.datepicker.CalendarConstraints calendarConstraints, @androidx.annotation.NonNull com.google.android.material.datepicker.OnSelectionChangedListener<S> onSelectionChangedListener);

    void select(long j);

    void setSelection(@androidx.annotation.NonNull S s2);
}
