package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutAlarmAlertFragmentBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout btnLayout;

    @androidx.annotation.NonNull
    public final android.widget.Button buttonConceal;

    @androidx.annotation.NonNull
    public final android.widget.Button buttonStop;

    @androidx.annotation.NonNull
    public final android.widget.TextView dialogtextTitle;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout viewLayout;

    public LayoutAlarmAlertFragmentBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.Button button, @androidx.annotation.NonNull android.widget.Button button2, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3) {
        this.n = linearLayout;
        this.btnLayout = linearLayout2;
        this.buttonConceal = button;
        this.buttonStop = button2;
        this.dialogtextTitle = textView;
        this.viewLayout = linearLayout3;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutAlarmAlertFragmentBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.btnLayout;
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = moji.com.mjweather.R.id.button_conceal;
            android.widget.Button button = (android.widget.Button) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (button != null) {
                i = moji.com.mjweather.R.id.button_stop;
                android.widget.Button button2 = (android.widget.Button) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (button2 != null) {
                    i = moji.com.mjweather.R.id.dialogtext_title;
                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = moji.com.mjweather.R.id.viewLayout;
                        android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            return new moji.com.mjweather.databinding.LayoutAlarmAlertFragmentBinding((android.widget.LinearLayout) view, linearLayout, button, button2, textView, linearLayout2);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutAlarmAlertFragmentBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutAlarmAlertFragmentBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.layout_alarm_alert_fragment, viewGroup, false);
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
