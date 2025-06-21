package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class LayoutHomepageFlowerDateBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView currentDateName;

    @androidx.annotation.NonNull
    public final android.widget.TextView currentDateTitle;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView nextDateExact;

    @androidx.annotation.NonNull
    public final android.widget.TextView nextDateName;

    @androidx.annotation.NonNull
    public final android.widget.TextView nextDateTitle;

    @androidx.annotation.NonNull
    public final android.view.View pickLine1;

    @androidx.annotation.NonNull
    public final android.view.View pickLine2;

    @androidx.annotation.NonNull
    public final android.widget.ImageView pinkCircle1;

    @androidx.annotation.NonNull
    public final android.widget.ImageView pinkCircle2;

    @androidx.annotation.NonNull
    public final android.widget.ImageView pinkCircle3;

    @androidx.annotation.NonNull
    public final android.widget.TextView preDateExact;

    @androidx.annotation.NonNull
    public final android.widget.TextView preDateName;

    @androidx.annotation.NonNull
    public final android.widget.TextView preDateTitle;

    public LayoutHomepageFlowerDateBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull android.widget.TextView textView6, @androidx.annotation.NonNull android.widget.TextView textView7, @androidx.annotation.NonNull android.widget.TextView textView8) {
        this.n = linearLayout;
        this.currentDateName = textView;
        this.currentDateTitle = textView2;
        this.nextDateExact = textView3;
        this.nextDateName = textView4;
        this.nextDateTitle = textView5;
        this.pickLine1 = view;
        this.pickLine2 = view2;
        this.pinkCircle1 = imageView;
        this.pinkCircle2 = imageView2;
        this.pinkCircle3 = imageView3;
        this.preDateExact = textView6;
        this.preDateName = textView7;
        this.preDateTitle = textView8;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.LayoutHomepageFlowerDateBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        android.view.View findChildViewById2;
        int i = moji.com.mjweatherservicebase.R.id.current_date_name;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = moji.com.mjweatherservicebase.R.id.current_date_title;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = moji.com.mjweatherservicebase.R.id.next_date_exact;
                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = moji.com.mjweatherservicebase.R.id.next_date_name;
                    android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = moji.com.mjweatherservicebase.R.id.next_date_title;
                        android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView5 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweatherservicebase.R.id.pick_line1))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweatherservicebase.R.id.pick_line2))) != null) {
                            i = moji.com.mjweatherservicebase.R.id.pink_circle1;
                            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                i = moji.com.mjweatherservicebase.R.id.pink_circle2;
                                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (imageView2 != null) {
                                    i = moji.com.mjweatherservicebase.R.id.pink_circle3;
                                    android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (imageView3 != null) {
                                        i = moji.com.mjweatherservicebase.R.id.pre_date_exact;
                                        android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView6 != null) {
                                            i = moji.com.mjweatherservicebase.R.id.pre_date_name;
                                            android.widget.TextView textView7 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView7 != null) {
                                                i = moji.com.mjweatherservicebase.R.id.pre_date_title;
                                                android.widget.TextView textView8 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (textView8 != null) {
                                                    return new moji.com.mjweatherservicebase.databinding.LayoutHomepageFlowerDateBinding((android.widget.LinearLayout) view, textView, textView2, textView3, textView4, textView5, findChildViewById, findChildViewById2, imageView, imageView2, imageView3, textView6, textView7, textView8);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.LayoutHomepageFlowerDateBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.LayoutHomepageFlowerDateBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.layout_homepage_flower_date, viewGroup, false);
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
