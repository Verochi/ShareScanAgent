package androidx.databinding.adapters;

@androidx.databinding.BindingMethods({@androidx.databinding.BindingMethod(attribute = "android:buttonTint", method = "setButtonTintList", type = android.widget.CompoundButton.class), @androidx.databinding.BindingMethod(attribute = "android:onCheckedChanged", method = "setOnCheckedChangeListener", type = android.widget.CompoundButton.class)})
@androidx.databinding.InverseBindingMethods({@androidx.databinding.InverseBindingMethod(attribute = "android:checked", type = android.widget.CompoundButton.class)})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class CompoundButtonBindingAdapter {

    /* renamed from: androidx.databinding.adapters.CompoundButtonBindingAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.widget.CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ androidx.databinding.InverseBindingListener val$attrChange;
        final /* synthetic */ android.widget.CompoundButton.OnCheckedChangeListener val$listener;

        public AnonymousClass1(android.widget.CompoundButton.OnCheckedChangeListener onCheckedChangeListener, androidx.databinding.InverseBindingListener inverseBindingListener) {
            this.val$listener = onCheckedChangeListener;
            this.val$attrChange = inverseBindingListener;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
            android.widget.CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.val$listener;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(compoundButton, z);
            }
            this.val$attrChange.onChange();
        }
    }

    @androidx.databinding.BindingAdapter({"android:checked"})
    public static void setChecked(android.widget.CompoundButton compoundButton, boolean z) {
        if (compoundButton.isChecked() != z) {
            compoundButton.setChecked(z);
        }
    }

    @androidx.databinding.BindingAdapter(requireAll = false, value = {"android:onCheckedChanged", "android:checkedAttrChanged"})
    public static void setListeners(android.widget.CompoundButton compoundButton, android.widget.CompoundButton.OnCheckedChangeListener onCheckedChangeListener, androidx.databinding.InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            compoundButton.setOnCheckedChangeListener(onCheckedChangeListener);
        } else {
            compoundButton.setOnCheckedChangeListener(new androidx.databinding.adapters.CompoundButtonBindingAdapter.AnonymousClass1(onCheckedChangeListener, inverseBindingListener));
        }
    }
}
