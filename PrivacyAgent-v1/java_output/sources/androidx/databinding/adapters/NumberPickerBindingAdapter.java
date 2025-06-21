package androidx.databinding.adapters;

@androidx.databinding.BindingMethods({@androidx.databinding.BindingMethod(attribute = "android:format", method = "setFormatter", type = android.widget.NumberPicker.class), @androidx.databinding.BindingMethod(attribute = "android:onScrollStateChange", method = "setOnScrollListener", type = android.widget.NumberPicker.class)})
@androidx.databinding.InverseBindingMethods({@androidx.databinding.InverseBindingMethod(attribute = "android:value", type = android.widget.NumberPicker.class)})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class NumberPickerBindingAdapter {

    /* renamed from: androidx.databinding.adapters.NumberPickerBindingAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.widget.NumberPicker.OnValueChangeListener {
        final /* synthetic */ androidx.databinding.InverseBindingListener val$attrChange;
        final /* synthetic */ android.widget.NumberPicker.OnValueChangeListener val$listener;

        public AnonymousClass1(android.widget.NumberPicker.OnValueChangeListener onValueChangeListener, androidx.databinding.InverseBindingListener inverseBindingListener) {
            this.val$listener = onValueChangeListener;
            this.val$attrChange = inverseBindingListener;
        }

        @Override // android.widget.NumberPicker.OnValueChangeListener
        public void onValueChange(android.widget.NumberPicker numberPicker, int i, int i2) {
            android.widget.NumberPicker.OnValueChangeListener onValueChangeListener = this.val$listener;
            if (onValueChangeListener != null) {
                onValueChangeListener.onValueChange(numberPicker, i, i2);
            }
            this.val$attrChange.onChange();
        }
    }

    @androidx.databinding.BindingAdapter(requireAll = false, value = {"android:onValueChange", "android:valueAttrChanged"})
    public static void setListeners(android.widget.NumberPicker numberPicker, android.widget.NumberPicker.OnValueChangeListener onValueChangeListener, androidx.databinding.InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            numberPicker.setOnValueChangedListener(onValueChangeListener);
        } else {
            numberPicker.setOnValueChangedListener(new androidx.databinding.adapters.NumberPickerBindingAdapter.AnonymousClass1(onValueChangeListener, inverseBindingListener));
        }
    }

    @androidx.databinding.BindingAdapter({"android:value"})
    public static void setValue(android.widget.NumberPicker numberPicker, int i) {
        if (numberPicker.getValue() != i) {
            numberPicker.setValue(i);
        }
    }
}
