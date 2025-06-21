package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class FragmentSetttingLanguageBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ListView languageList;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar languageTitle;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    public FragmentSetttingLanguageBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.ListView listView, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar) {
        this.n = relativeLayout;
        this.languageList = listView;
        this.languageTitle = mJTitleBar;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentSetttingLanguageBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.titlebar.MJTitleBar findChildViewById;
        int i = moji.com.mjweather.R.id.language_list;
        android.widget.ListView listView = (android.widget.ListView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (listView == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.language_title))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.FragmentSetttingLanguageBinding((android.widget.RelativeLayout) view, listView, findChildViewById);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentSetttingLanguageBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentSetttingLanguageBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.fragment_settting_language, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.RelativeLayout getRoot() {
        return this.n;
    }
}
