package com.aliyun.svideo.media.databinding;

/* loaded from: classes12.dex */
public final class AlivcMeidaPpwContainerGalleryDirBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    private final androidx.recyclerview.widget.RecyclerView rootView;

    private AlivcMeidaPpwContainerGalleryDirBinding(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView) {
        this.rootView = recyclerView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.media.databinding.AlivcMeidaPpwContainerGalleryDirBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view != null) {
            return new com.aliyun.svideo.media.databinding.AlivcMeidaPpwContainerGalleryDirBinding((androidx.recyclerview.widget.RecyclerView) view);
        }
        throw new java.lang.NullPointerException("rootView");
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.media.databinding.AlivcMeidaPpwContainerGalleryDirBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.media.databinding.AlivcMeidaPpwContainerGalleryDirBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.media.R.layout.alivc_meida_ppw_container_gallery_dir, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public androidx.recyclerview.widget.RecyclerView getRoot() {
        return this.rootView;
    }
}
