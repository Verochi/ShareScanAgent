package com.google.android.material.datepicker;

/* loaded from: classes22.dex */
abstract class PickerFragment<S> extends androidx.fragment.app.Fragment {
    protected final java.util.LinkedHashSet<com.google.android.material.datepicker.OnSelectionChangedListener<S>> onSelectionChangedListeners = new java.util.LinkedHashSet<>();

    public boolean addOnSelectionChangedListener(com.google.android.material.datepicker.OnSelectionChangedListener<S> onSelectionChangedListener) {
        return this.onSelectionChangedListeners.add(onSelectionChangedListener);
    }

    public void clearOnSelectionChangedListeners() {
        this.onSelectionChangedListeners.clear();
    }

    public abstract com.google.android.material.datepicker.DateSelector<S> getDateSelector();

    public boolean removeOnSelectionChangedListener(com.google.android.material.datepicker.OnSelectionChangedListener<S> onSelectionChangedListener) {
        return this.onSelectionChangedListeners.remove(onSelectionChangedListener);
    }
}
