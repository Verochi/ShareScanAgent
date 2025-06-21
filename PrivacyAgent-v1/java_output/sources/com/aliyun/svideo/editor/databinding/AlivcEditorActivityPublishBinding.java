package com.aliyun.svideo.editor.databinding;

/* loaded from: classes31.dex */
public final class AlivcEditorActivityPublishBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding actionBar;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout activityPublish;

    @androidx.annotation.NonNull
    public final android.widget.TextView btnTemplateBuild;

    @androidx.annotation.NonNull
    public final android.widget.TextView composeProgressText;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout composeProgressView;

    @androidx.annotation.NonNull
    public final android.widget.TextView composeStatusText;

    @androidx.annotation.NonNull
    public final android.widget.TextView composeStatusTip;

    @androidx.annotation.NonNull
    public final android.widget.ImageView imageComposeIndicator;

    @androidx.annotation.NonNull
    public final android.widget.ImageView publishCoverBlur;

    @androidx.annotation.NonNull
    public final android.widget.ImageView publishCoverImage;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout publishCoverSelect;

    @androidx.annotation.NonNull
    public final android.widget.EditText publishDesc;

    @androidx.annotation.NonNull
    public final android.widget.ProgressBar publishProgress;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    private AlivcEditorActivityPublishBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding alivcEditorIncludeActionBarProfileBinding, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout4, @androidx.annotation.NonNull android.widget.EditText editText, @androidx.annotation.NonNull android.widget.ProgressBar progressBar) {
        this.rootView = linearLayout;
        this.actionBar = alivcEditorIncludeActionBarProfileBinding;
        this.activityPublish = linearLayout2;
        this.btnTemplateBuild = textView;
        this.composeProgressText = textView2;
        this.composeProgressView = linearLayout3;
        this.composeStatusText = textView3;
        this.composeStatusTip = textView4;
        this.imageComposeIndicator = imageView;
        this.publishCoverBlur = imageView2;
        this.publishCoverImage = imageView3;
        this.publishCoverSelect = linearLayout4;
        this.publishDesc = editText;
        this.publishProgress = progressBar;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorActivityPublishBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.action_bar;
        android.view.View findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding bind = com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding.bind(findChildViewById);
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) view;
            i = com.aliyun.svideo.editor.R.id.btn_template_build;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = com.aliyun.svideo.editor.R.id.compose_progress_text;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = com.aliyun.svideo.editor.R.id.compose_progress_view;
                    android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = com.aliyun.svideo.editor.R.id.compose_status_text;
                        android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = com.aliyun.svideo.editor.R.id.compose_status_tip;
                            android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = com.aliyun.svideo.editor.R.id.image_compose_indicator;
                                android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (imageView != null) {
                                    i = com.aliyun.svideo.editor.R.id.publish_cover_blur;
                                    android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (imageView2 != null) {
                                        i = com.aliyun.svideo.editor.R.id.publish_cover_image;
                                        android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (imageView3 != null) {
                                            i = com.aliyun.svideo.editor.R.id.publish_cover_select;
                                            android.widget.LinearLayout linearLayout3 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (linearLayout3 != null) {
                                                i = com.aliyun.svideo.editor.R.id.publish_desc;
                                                android.widget.EditText editText = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (editText != null) {
                                                    i = com.aliyun.svideo.editor.R.id.publish_progress;
                                                    android.widget.ProgressBar progressBar = (android.widget.ProgressBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (progressBar != null) {
                                                        return new com.aliyun.svideo.editor.databinding.AlivcEditorActivityPublishBinding(linearLayout, bind, linearLayout, textView, textView2, linearLayout2, textView3, textView4, imageView, imageView2, imageView3, linearLayout3, editText, progressBar);
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
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorActivityPublishBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorActivityPublishBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_activity_publish, viewGroup, false);
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
