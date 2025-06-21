package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutMoMsgDialogBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.EditText etMoMsgAddress;

    @androidx.annotation.NonNull
    public final android.widget.EditText etMoMsgName;

    @androidx.annotation.NonNull
    public final android.widget.EditText etMoMsgPhone;

    @androidx.annotation.NonNull
    public final android.widget.EditText etMoMsgQq;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivBottomLine;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMoMsgCommit;

    public LayoutMoMsgDialogBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.EditText editText, @androidx.annotation.NonNull android.widget.EditText editText2, @androidx.annotation.NonNull android.widget.EditText editText3, @androidx.annotation.NonNull android.widget.EditText editText4, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = linearLayout;
        this.etMoMsgAddress = editText;
        this.etMoMsgName = editText2;
        this.etMoMsgPhone = editText3;
        this.etMoMsgQq = editText4;
        this.ivBottomLine = imageView;
        this.tvMoMsgCommit = textView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutMoMsgDialogBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.et_mo_msg_address;
        android.widget.EditText editText = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (editText != null) {
            i = moji.com.mjweather.R.id.et_mo_msg_name;
            android.widget.EditText editText2 = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (editText2 != null) {
                i = moji.com.mjweather.R.id.et_mo_msg_phone;
                android.widget.EditText editText3 = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (editText3 != null) {
                    i = moji.com.mjweather.R.id.et_mo_msg_qq;
                    android.widget.EditText editText4 = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (editText4 != null) {
                        i = moji.com.mjweather.R.id.iv_bottom_line;
                        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = moji.com.mjweather.R.id.tv_mo_msg_commit;
                            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                return new moji.com.mjweather.databinding.LayoutMoMsgDialogBinding((android.widget.LinearLayout) view, editText, editText2, editText3, editText4, imageView, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutMoMsgDialogBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutMoMsgDialogBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.layout_mo_msg_dialog, viewGroup, false);
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
