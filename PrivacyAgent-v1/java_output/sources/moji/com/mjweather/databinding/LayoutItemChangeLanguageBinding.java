package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutItemChangeLanguageBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.setting.view.CheckedRelativeLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView title;

    public LayoutItemChangeLanguageBinding(@androidx.annotation.NonNull com.moji.mjweather.setting.view.CheckedRelativeLayout checkedRelativeLayout, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = checkedRelativeLayout;
        this.title = textView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutItemChangeLanguageBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, android.R.id.title);
        if (textView != null) {
            return new moji.com.mjweather.databinding.LayoutItemChangeLanguageBinding((com.moji.mjweather.setting.view.CheckedRelativeLayout) view, textView);
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(android.R.id.title)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutItemChangeLanguageBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutItemChangeLanguageBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.layout_item_change_language, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.moji.mjweather.setting.view.CheckedRelativeLayout getRoot() {
        return this.n;
    }
}
