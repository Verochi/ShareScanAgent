package com.aliyun.svideo.base.databinding;

/* loaded from: classes.dex */
public final class ActivityCopyrightWebBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.webkit.WebView alivcCopyrightWebview;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout galleryActionBar;

    @androidx.annotation.NonNull
    public final android.widget.TextView galleryTitle;

    @androidx.annotation.NonNull
    public final android.widget.ImageButton ibBack;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    private ActivityCopyrightWebBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.webkit.WebView webView, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.ImageButton imageButton) {
        this.rootView = linearLayout;
        this.alivcCopyrightWebview = webView;
        this.galleryActionBar = frameLayout;
        this.galleryTitle = textView;
        this.ibBack = imageButton;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.ActivityCopyrightWebBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.base.R.id.alivc_copyright_webview;
        android.webkit.WebView webView = (android.webkit.WebView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (webView != null) {
            i = com.aliyun.svideo.base.R.id.gallery_actionBar;
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = com.aliyun.svideo.base.R.id.gallery_title;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = com.aliyun.svideo.base.R.id.ib_back;
                    android.widget.ImageButton imageButton = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageButton != null) {
                        return new com.aliyun.svideo.base.databinding.ActivityCopyrightWebBinding((android.widget.LinearLayout) view, webView, frameLayout, textView, imageButton);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.ActivityCopyrightWebBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.ActivityCopyrightWebBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.base.R.layout.activity_copyright_web, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.LinearLayout getRoot() {
        return this.rootView;
    }
}
