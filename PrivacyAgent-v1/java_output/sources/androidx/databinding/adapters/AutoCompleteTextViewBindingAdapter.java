package androidx.databinding.adapters;

@androidx.databinding.BindingMethods({@androidx.databinding.BindingMethod(attribute = "android:completionThreshold", method = "setThreshold", type = android.widget.AutoCompleteTextView.class), @androidx.databinding.BindingMethod(attribute = "android:popupBackground", method = "setDropDownBackgroundDrawable", type = android.widget.AutoCompleteTextView.class), @androidx.databinding.BindingMethod(attribute = "android:onDismiss", method = "setOnDismissListener", type = android.widget.AutoCompleteTextView.class), @androidx.databinding.BindingMethod(attribute = "android:onItemClick", method = "setOnItemClickListener", type = android.widget.AutoCompleteTextView.class)})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class AutoCompleteTextViewBindingAdapter {

    /* renamed from: androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.widget.AutoCompleteTextView.Validator {
        final /* synthetic */ androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter.FixText val$fixText;
        final /* synthetic */ androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter.IsValid val$isValid;

        public AnonymousClass1(androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter.IsValid isValid, androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter.FixText fixText) {
            this.val$isValid = isValid;
            this.val$fixText = fixText;
        }

        @Override // android.widget.AutoCompleteTextView.Validator
        public java.lang.CharSequence fixText(java.lang.CharSequence charSequence) {
            androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter.FixText fixText = this.val$fixText;
            return fixText != null ? fixText.fixText(charSequence) : charSequence;
        }

        @Override // android.widget.AutoCompleteTextView.Validator
        public boolean isValid(java.lang.CharSequence charSequence) {
            androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter.IsValid isValid = this.val$isValid;
            if (isValid != null) {
                return isValid.isValid(charSequence);
            }
            return true;
        }
    }

    public interface FixText {
        java.lang.CharSequence fixText(java.lang.CharSequence charSequence);
    }

    public interface IsValid {
        boolean isValid(java.lang.CharSequence charSequence);
    }

    @androidx.databinding.BindingAdapter(requireAll = false, value = {"android:onItemSelected", "android:onNothingSelected"})
    public static void setOnItemSelectedListener(android.widget.AutoCompleteTextView autoCompleteTextView, androidx.databinding.adapters.AdapterViewBindingAdapter.OnItemSelected onItemSelected, androidx.databinding.adapters.AdapterViewBindingAdapter.OnNothingSelected onNothingSelected) {
        if (onItemSelected == null && onNothingSelected == null) {
            autoCompleteTextView.setOnItemSelectedListener(null);
        } else {
            autoCompleteTextView.setOnItemSelectedListener(new androidx.databinding.adapters.AdapterViewBindingAdapter.OnItemSelectedComponentListener(onItemSelected, onNothingSelected, null));
        }
    }

    @androidx.databinding.BindingAdapter(requireAll = false, value = {"android:fixText", "android:isValid"})
    public static void setValidator(android.widget.AutoCompleteTextView autoCompleteTextView, androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter.FixText fixText, androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter.IsValid isValid) {
        if (fixText == null && isValid == null) {
            autoCompleteTextView.setValidator(null);
        } else {
            autoCompleteTextView.setValidator(new androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter.AnonymousClass1(isValid, fixText));
        }
    }
}
