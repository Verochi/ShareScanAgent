package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorMediaBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.media.MutiMediaView mediaView;

    @androidx.annotation.NonNull
    private final com.aliyun.svideo.media.MutiMediaView rootView;

    private AlivcEditorMediaBinding(@androidx.annotation.NonNull com.aliyun.svideo.media.MutiMediaView mutiMediaView, @androidx.annotation.NonNull com.aliyun.svideo.media.MutiMediaView mutiMediaView2) {
        this.rootView = mutiMediaView;
        this.mediaView = mutiMediaView2;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorMediaBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        com.aliyun.svideo.media.MutiMediaView mutiMediaView = (com.aliyun.svideo.media.MutiMediaView) view;
        return new com.aliyun.svideo.editor.databinding.AlivcEditorMediaBinding(mutiMediaView, mutiMediaView);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorMediaBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorMediaBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_media, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.aliyun.svideo.media.MutiMediaView getRoot() {
        return this.rootView;
    }
}
