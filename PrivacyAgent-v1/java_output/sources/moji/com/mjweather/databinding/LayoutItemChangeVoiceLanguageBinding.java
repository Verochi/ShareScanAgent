package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutItemChangeVoiceLanguageBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.setting.view.CheckedRelativeLayout n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView title;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.setting.view.CheckedRelativeLayout voiceLanguageView;

    public LayoutItemChangeVoiceLanguageBinding(@androidx.annotation.NonNull com.moji.mjweather.setting.view.CheckedRelativeLayout checkedRelativeLayout, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.mjweather.setting.view.CheckedRelativeLayout checkedRelativeLayout2) {
        this.n = checkedRelativeLayout;
        this.title = mJTextView;
        this.voiceLanguageView = checkedRelativeLayout2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutItemChangeVoiceLanguageBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.textview.MJTextView findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, android.R.id.title);
        if (findChildViewById == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(android.R.id.title)));
        }
        com.moji.mjweather.setting.view.CheckedRelativeLayout checkedRelativeLayout = (com.moji.mjweather.setting.view.CheckedRelativeLayout) view;
        return new moji.com.mjweather.databinding.LayoutItemChangeVoiceLanguageBinding(checkedRelativeLayout, findChildViewById, checkedRelativeLayout);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutItemChangeVoiceLanguageBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutItemChangeVoiceLanguageBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.layout_item_change_voice_language, viewGroup, false);
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
