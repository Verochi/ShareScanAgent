package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class DialogFeedTopTipsBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    public DialogFeedTopTipsBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout) {
        this.n = frameLayout;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogFeedTopTipsBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view != null) {
            return new moji.com.mjweather.databinding.DialogFeedTopTipsBinding((android.widget.FrameLayout) view);
        }
        throw new java.lang.NullPointerException("rootView");
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogFeedTopTipsBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogFeedTopTipsBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.dialog_feed_top_tips, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.FrameLayout getRoot() {
        return this.n;
    }
}
