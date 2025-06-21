package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LifeItemHorizontalItemMoreBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvText;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.feed.view.MoreArrowView vArrow;

    public LifeItemHorizontalItemMoreBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull com.moji.mjweather.feed.view.MoreArrowView moreArrowView) {
        this.n = frameLayout;
        this.tvText = textView;
        this.vArrow = moreArrowView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LifeItemHorizontalItemMoreBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjweather.feed.view.MoreArrowView findChildViewById;
        int i = moji.com.mjweather.R.id.tv_text;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.v_arrow))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.LifeItemHorizontalItemMoreBinding((android.widget.FrameLayout) view, textView, findChildViewById);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LifeItemHorizontalItemMoreBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LifeItemHorizontalItemMoreBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.life_item_horizontal_item_more, viewGroup, false);
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
