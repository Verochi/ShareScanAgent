package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class DialogAddParamBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.EditText etKey;

    @androidx.annotation.NonNull
    public final android.widget.EditText etValue;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvResult;

    public DialogAddParamBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.EditText editText, @androidx.annotation.NonNull android.widget.EditText editText2, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = linearLayout;
        this.etKey = editText;
        this.etValue = editText2;
        this.tvResult = textView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogAddParamBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.et_key;
        android.widget.EditText editText = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (editText != null) {
            i = moji.com.mjweather.R.id.et_value;
            android.widget.EditText editText2 = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (editText2 != null) {
                i = moji.com.mjweather.R.id.tv_result;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new moji.com.mjweather.databinding.DialogAddParamBinding((android.widget.LinearLayout) view, editText, editText2, textView);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogAddParamBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogAddParamBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.dialog_add_param, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.LinearLayout getRoot() {
        return this.n;
    }
}
