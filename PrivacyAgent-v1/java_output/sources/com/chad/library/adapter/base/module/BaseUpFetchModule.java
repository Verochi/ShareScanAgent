package com.chad.library.adapter.base.module;

@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u001c\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010\u0006¨\u0006$"}, d2 = {"Lcom/chad/library/adapter/base/module/BaseUpFetchModule;", "Lcom/chad/library/adapter/base/listener/UpFetchListenerImp;", "", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "", "autoUpFetch$com_github_CymChad_brvah", "(I)V", "autoUpFetch", "Lcom/chad/library/adapter/base/listener/OnUpFetchListener;", com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnUpFetchListener", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "a", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "baseQuickAdapter", "b", "Lcom/chad/library/adapter/base/listener/OnUpFetchListener;", "mUpFetchListener", "", "c", "Z", "isUpFetchEnable", "()Z", "setUpFetchEnable", "(Z)V", "d", "isUpFetching", "setUpFetching", "e", "I", "getStartUpFetchPosition", "()I", "setStartUpFetchPosition", "startUpFetchPosition", "<init>", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;)V", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes22.dex */
public class BaseUpFetchModule implements com.chad.library.adapter.base.listener.UpFetchListenerImp {

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final com.chad.library.adapter.base.BaseQuickAdapter<?, ?> baseQuickAdapter;

    /* renamed from: b, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public com.chad.library.adapter.base.listener.OnUpFetchListener mUpFetchListener;

    /* renamed from: c, reason: from kotlin metadata */
    public boolean isUpFetchEnable;

    /* renamed from: d, reason: from kotlin metadata */
    public boolean isUpFetching;

    /* renamed from: e, reason: from kotlin metadata */
    public int startUpFetchPosition;

    public BaseUpFetchModule(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.BaseQuickAdapter<?, ?> baseQuickAdapter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(baseQuickAdapter, "baseQuickAdapter");
        this.baseQuickAdapter = baseQuickAdapter;
        this.startUpFetchPosition = 1;
    }

    public final void autoUpFetch$com_github_CymChad_brvah(int position) {
        com.chad.library.adapter.base.listener.OnUpFetchListener onUpFetchListener;
        if (!this.isUpFetchEnable || this.isUpFetching || position > this.startUpFetchPosition || (onUpFetchListener = this.mUpFetchListener) == null) {
            return;
        }
        onUpFetchListener.onUpFetch();
    }

    public final int getStartUpFetchPosition() {
        return this.startUpFetchPosition;
    }

    /* renamed from: isUpFetchEnable, reason: from getter */
    public final boolean getIsUpFetchEnable() {
        return this.isUpFetchEnable;
    }

    /* renamed from: isUpFetching, reason: from getter */
    public final boolean getIsUpFetching() {
        return this.isUpFetching;
    }

    @Override // com.chad.library.adapter.base.listener.UpFetchListenerImp
    public void setOnUpFetchListener(@org.jetbrains.annotations.Nullable com.chad.library.adapter.base.listener.OnUpFetchListener listener) {
        this.mUpFetchListener = listener;
    }

    public final void setStartUpFetchPosition(int i) {
        this.startUpFetchPosition = i;
    }

    public final void setUpFetchEnable(boolean z) {
        this.isUpFetchEnable = z;
    }

    public final void setUpFetching(boolean z) {
        this.isUpFetching = z;
    }
}
