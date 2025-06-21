package com.aliyun.svideo.crop.databinding;

/* loaded from: classes.dex */
public final class AlivcCropActivityMediaBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.media.MutiMediaView cropMediaview;

    @androidx.annotation.NonNull
    private final com.aliyun.svideo.media.MutiMediaView rootView;

    private AlivcCropActivityMediaBinding(@androidx.annotation.NonNull com.aliyun.svideo.media.MutiMediaView mutiMediaView, @androidx.annotation.NonNull com.aliyun.svideo.media.MutiMediaView mutiMediaView2) {
        this.rootView = mutiMediaView;
        this.cropMediaview = mutiMediaView2;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.crop.databinding.AlivcCropActivityMediaBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        com.aliyun.svideo.media.MutiMediaView mutiMediaView = (com.aliyun.svideo.media.MutiMediaView) view;
        return new com.aliyun.svideo.crop.databinding.AlivcCropActivityMediaBinding(mutiMediaView, mutiMediaView);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.crop.databinding.AlivcCropActivityMediaBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.crop.databinding.AlivcCropActivityMediaBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.crop.R.layout.alivc_crop_activity_media, viewGroup, false);
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
