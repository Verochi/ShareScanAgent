package com.aliyun.svideo.base.databinding;

/* loaded from: classes.dex */
public final class ActivitySdkVersionBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.RadioButton btnDevelopUrl;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton btnPreReleaseUrl;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton btnReleaseUrl;

    @androidx.annotation.NonNull
    public final android.widget.TextView btnSure;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAlivcCommitId;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAndroidCommitId;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvBuildId;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvModule;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvSrcCommitId;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvVersion;

    private ActivitySdkVersionBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.RadioButton radioButton, @androidx.annotation.NonNull android.widget.RadioButton radioButton2, @androidx.annotation.NonNull android.widget.RadioButton radioButton3, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5, @androidx.annotation.NonNull android.widget.TextView textView6, @androidx.annotation.NonNull android.widget.TextView textView7) {
        this.rootView = linearLayout;
        this.btnDevelopUrl = radioButton;
        this.btnPreReleaseUrl = radioButton2;
        this.btnReleaseUrl = radioButton3;
        this.btnSure = textView;
        this.tvAlivcCommitId = textView2;
        this.tvAndroidCommitId = textView3;
        this.tvBuildId = textView4;
        this.tvModule = textView5;
        this.tvSrcCommitId = textView6;
        this.tvVersion = textView7;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.ActivitySdkVersionBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.base.R.id.btn_develop_url;
        android.widget.RadioButton radioButton = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (radioButton != null) {
            i = com.aliyun.svideo.base.R.id.btn_pre_release_url;
            android.widget.RadioButton radioButton2 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (radioButton2 != null) {
                i = com.aliyun.svideo.base.R.id.btn_release_url;
                android.widget.RadioButton radioButton3 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (radioButton3 != null) {
                    i = com.aliyun.svideo.base.R.id.btn_sure;
                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = com.aliyun.svideo.base.R.id.tv_alivc_commit_id;
                        android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = com.aliyun.svideo.base.R.id.tv_android_commit_id;
                            android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = com.aliyun.svideo.base.R.id.tv_build_id;
                                android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = com.aliyun.svideo.base.R.id.tv_module;
                                    android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = com.aliyun.svideo.base.R.id.tv_src_commit_id;
                                        android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView6 != null) {
                                            i = com.aliyun.svideo.base.R.id.tv_version;
                                            android.widget.TextView textView7 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView7 != null) {
                                                return new com.aliyun.svideo.base.databinding.ActivitySdkVersionBinding((android.widget.LinearLayout) view, radioButton, radioButton2, radioButton3, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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
    public static com.aliyun.svideo.base.databinding.ActivitySdkVersionBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.ActivitySdkVersionBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.base.R.layout.activity_sdk_version, viewGroup, false);
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
