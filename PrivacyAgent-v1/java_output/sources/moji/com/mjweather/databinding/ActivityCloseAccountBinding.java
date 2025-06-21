package moji.com.mjweather.databinding;

/* loaded from: classes31.dex */
public final class ActivityCloseAccountBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivCloseBtnBg;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivHintBg;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivIconClose;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView rvCloseInfo;

    @androidx.annotation.NonNull
    public final android.widget.ScrollView svHint;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar titleBar;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCloseBtn;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvHintCloseBan;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvHintCloseInfo;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvReminder;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout viewStatusLayout;

    @androidx.annotation.NonNull
    public final android.view.ViewStub vsFail;

    public ActivityCloseAccountBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull android.widget.ScrollView scrollView, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout, @androidx.annotation.NonNull android.view.ViewStub viewStub) {
        this.n = constraintLayout;
        this.ivCloseBtnBg = imageView;
        this.ivHintBg = imageView2;
        this.ivIconClose = imageView3;
        this.rvCloseInfo = recyclerView;
        this.svHint = scrollView;
        this.titleBar = mJTitleBar;
        this.tvCloseBtn = textView;
        this.tvHintCloseBan = textView2;
        this.tvHintCloseInfo = textView3;
        this.tvReminder = textView4;
        this.viewStatusLayout = mJMultipleStatusLayout;
        this.vsFail = viewStub;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityCloseAccountBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.titlebar.MJTitleBar findChildViewById;
        com.moji.multiplestatuslayout.MJMultipleStatusLayout findChildViewById2;
        int i = moji.com.mjweather.R.id.iv_close_btn_bg;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweather.R.id.iv_hint_bg;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = moji.com.mjweather.R.id.iv_icon_close;
                android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = moji.com.mjweather.R.id.rv_close_info;
                    androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (recyclerView != null) {
                        i = moji.com.mjweather.R.id.sv_hint;
                        android.widget.ScrollView scrollView = (android.widget.ScrollView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (scrollView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.title_bar))) != null) {
                            i = moji.com.mjweather.R.id.tv_close_btn;
                            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = moji.com.mjweather.R.id.tv_hint_close_ban;
                                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = moji.com.mjweather.R.id.tv_hint_close_info;
                                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = moji.com.mjweather.R.id.tv_reminder;
                                        android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.view_status_layout))) != null) {
                                            i = moji.com.mjweather.R.id.vs_fail;
                                            android.view.ViewStub viewStub = (android.view.ViewStub) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (viewStub != null) {
                                                return new moji.com.mjweather.databinding.ActivityCloseAccountBinding((androidx.constraintlayout.widget.ConstraintLayout) view, imageView, imageView2, imageView3, recyclerView, scrollView, findChildViewById, textView, textView2, textView3, textView4, findChildViewById2, viewStub);
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
    public static moji.com.mjweather.databinding.ActivityCloseAccountBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityCloseAccountBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_close_account, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.n;
    }
}
