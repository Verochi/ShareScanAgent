package com.chad.library.adapter.base.binder;

@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u00028\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u0011"}, d2 = {"Lcom/chad/library/adapter/base/binder/QuickViewBindingItemBinder;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/chad/library/adapter/base/binder/BaseItemBinder;", "Lcom/chad/library/adapter/base/binder/QuickViewBindingItemBinder$BinderVBHolder;", "()V", "onCreateViewBinding", "layoutInflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;I)Landroidx/viewbinding/ViewBinding;", "onCreateViewHolder", "BinderVBHolder", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes22.dex */
public abstract class QuickViewBindingItemBinder<T, VB extends androidx.viewbinding.ViewBinding> extends com.chad.library.adapter.base.binder.BaseItemBinder<T, com.chad.library.adapter.base.binder.QuickViewBindingItemBinder.BinderVBHolder<VB>> {

    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\b\u001a\u00028\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\b\u001a\u00028\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/chad/library/adapter/base/binder/QuickViewBindingItemBinder$BinderVBHolder;", "Landroidx/viewbinding/ViewBinding;", "VB", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Landroidx/viewbinding/ViewBinding;", "getViewBinding", "()Landroidx/viewbinding/ViewBinding;", "viewBinding", "<init>", "(Landroidx/viewbinding/ViewBinding;)V", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0})
    public static final class BinderVBHolder<VB extends androidx.viewbinding.ViewBinding> extends com.chad.library.adapter.base.viewholder.BaseViewHolder {

        /* renamed from: n, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final VB viewBinding;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public BinderVBHolder(@org.jetbrains.annotations.NotNull VB viewBinding) {
            super(r0);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
            android.view.View root = viewBinding.getRoot();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
            this.viewBinding = viewBinding;
        }

        @org.jetbrains.annotations.NotNull
        public final VB getViewBinding() {
            return this.viewBinding;
        }
    }

    @org.jetbrains.annotations.NotNull
    public abstract VB onCreateViewBinding(@org.jetbrains.annotations.NotNull android.view.LayoutInflater layoutInflater, @org.jetbrains.annotations.NotNull android.view.ViewGroup parent, int viewType);

    @Override // com.chad.library.adapter.base.binder.BaseItemBinder
    @org.jetbrains.annotations.NotNull
    public com.chad.library.adapter.base.binder.QuickViewBindingItemBinder.BinderVBHolder<VB> onCreateViewHolder(@org.jetbrains.annotations.NotNull android.view.ViewGroup parent, int viewType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parent, "parent");
        android.view.LayoutInflater from = android.view.LayoutInflater.from(parent.getContext());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(from, "from(parent.context)");
        return new com.chad.library.adapter.base.binder.QuickViewBindingItemBinder.BinderVBHolder<>(onCreateViewBinding(from, parent, viewType));
    }
}
