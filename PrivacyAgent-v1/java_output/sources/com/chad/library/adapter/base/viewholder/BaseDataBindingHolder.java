package com.chad.library.adapter.base.viewholder;

@kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\b\u001a\u0004\u0018\u00018\u00008\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Landroidx/databinding/ViewDataBinding;", com.qq.e.comm.managers.setting.GlobalSetting.BD_SDK_WRAPPER, "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Landroidx/databinding/ViewDataBinding;", "getDataBinding", "()Landroidx/databinding/ViewDataBinding;", "dataBinding", "Landroid/view/View;", com.anythink.expressad.a.B, "<init>", "(Landroid/view/View;)V", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes22.dex */
public class BaseDataBindingHolder<BD extends androidx.databinding.ViewDataBinding> extends com.chad.library.adapter.base.viewholder.BaseViewHolder {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final BD dataBinding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseDataBindingHolder(@org.jetbrains.annotations.NotNull android.view.View view) {
        super(view);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        this.dataBinding = (BD) androidx.databinding.DataBindingUtil.bind(view);
    }

    @org.jetbrains.annotations.Nullable
    public final BD getDataBinding() {
        return this.dataBinding;
    }
}
