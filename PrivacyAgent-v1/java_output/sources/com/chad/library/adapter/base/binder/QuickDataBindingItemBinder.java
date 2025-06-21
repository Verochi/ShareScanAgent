package com.chad.library.adapter.base.binder;

@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u00028\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u0011"}, d2 = {"Lcom/chad/library/adapter/base/binder/QuickDataBindingItemBinder;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "DB", "Landroidx/databinding/ViewDataBinding;", "Lcom/chad/library/adapter/base/binder/BaseItemBinder;", "Lcom/chad/library/adapter/base/binder/QuickDataBindingItemBinder$BinderDataBindingHolder;", "()V", "onCreateDataBinding", "layoutInflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;I)Landroidx/databinding/ViewDataBinding;", "onCreateViewHolder", "BinderDataBindingHolder", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes22.dex */
public abstract class QuickDataBindingItemBinder<T, DB extends androidx.databinding.ViewDataBinding> extends com.chad.library.adapter.base.binder.BaseItemBinder<T, com.chad.library.adapter.base.binder.QuickDataBindingItemBinder.BinderDataBindingHolder<DB>> {

    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\b\u001a\u00028\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\b\u001a\u00028\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/chad/library/adapter/base/binder/QuickDataBindingItemBinder$BinderDataBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "DB", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Landroidx/databinding/ViewDataBinding;", "getDataBinding", "()Landroidx/databinding/ViewDataBinding;", "dataBinding", "<init>", "(Landroidx/databinding/ViewDataBinding;)V", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0})
    public static final class BinderDataBindingHolder<DB extends androidx.databinding.ViewDataBinding> extends com.chad.library.adapter.base.viewholder.BaseViewHolder {

        /* renamed from: n, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final DB dataBinding;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public BinderDataBindingHolder(@org.jetbrains.annotations.NotNull DB dataBinding) {
            super(r0);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dataBinding, "dataBinding");
            android.view.View root = dataBinding.getRoot();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(root, "dataBinding.root");
            this.dataBinding = dataBinding;
        }

        @org.jetbrains.annotations.NotNull
        public final DB getDataBinding() {
            return this.dataBinding;
        }
    }

    @org.jetbrains.annotations.NotNull
    public abstract DB onCreateDataBinding(@org.jetbrains.annotations.NotNull android.view.LayoutInflater layoutInflater, @org.jetbrains.annotations.NotNull android.view.ViewGroup parent, int viewType);

    @Override // com.chad.library.adapter.base.binder.BaseItemBinder
    @org.jetbrains.annotations.NotNull
    public com.chad.library.adapter.base.binder.QuickDataBindingItemBinder.BinderDataBindingHolder<DB> onCreateViewHolder(@org.jetbrains.annotations.NotNull android.view.ViewGroup parent, int viewType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parent, "parent");
        android.view.LayoutInflater from = android.view.LayoutInflater.from(parent.getContext());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(from, "from(parent.context)");
        return new com.chad.library.adapter.base.binder.QuickDataBindingItemBinder.BinderDataBindingHolder<>(onCreateDataBinding(from, parent, viewType));
    }
}
