package androidx.databinding.adapters;

@androidx.databinding.InverseBindingMethods({@androidx.databinding.InverseBindingMethod(attribute = "android:checkedButton", method = "getCheckedRadioButtonId", type = android.widget.RadioGroup.class)})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class RadioGroupBindingAdapter {

    /* renamed from: androidx.databinding.adapters.RadioGroupBindingAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.widget.RadioGroup.OnCheckedChangeListener {
        final /* synthetic */ androidx.databinding.InverseBindingListener val$attrChange;
        final /* synthetic */ android.widget.RadioGroup.OnCheckedChangeListener val$listener;

        public AnonymousClass1(android.widget.RadioGroup.OnCheckedChangeListener onCheckedChangeListener, androidx.databinding.InverseBindingListener inverseBindingListener) {
            this.val$listener = onCheckedChangeListener;
            this.val$attrChange = inverseBindingListener;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(android.widget.RadioGroup radioGroup, int i) {
            android.widget.RadioGroup.OnCheckedChangeListener onCheckedChangeListener = this.val$listener;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(radioGroup, i);
            }
            this.val$attrChange.onChange();
        }
    }

    @androidx.databinding.BindingAdapter({"android:checkedButton"})
    public static void setCheckedButton(android.widget.RadioGroup radioGroup, int i) {
        if (i != radioGroup.getCheckedRadioButtonId()) {
            radioGroup.check(i);
        }
    }

    @androidx.databinding.BindingAdapter(requireAll = false, value = {"android:onCheckedChanged", "android:checkedButtonAttrChanged"})
    public static void setListeners(android.widget.RadioGroup radioGroup, android.widget.RadioGroup.OnCheckedChangeListener onCheckedChangeListener, androidx.databinding.InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
        } else {
            radioGroup.setOnCheckedChangeListener(new androidx.databinding.adapters.RadioGroupBindingAdapter.AnonymousClass1(onCheckedChangeListener, inverseBindingListener));
        }
    }
}
