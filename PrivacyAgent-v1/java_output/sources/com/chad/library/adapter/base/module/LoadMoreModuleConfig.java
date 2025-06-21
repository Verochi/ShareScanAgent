package com.chad.library.adapter.base.module;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\nR(\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/chad/library/adapter/base/module/LoadMoreModuleConfig;", "", "Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;", "a", "Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;", "getDefLoadMoreView", "()Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;", "setDefLoadMoreView", "(Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;)V", "getDefLoadMoreView$annotations", "()V", "defLoadMoreView", "<init>", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes22.dex */
public final class LoadMoreModuleConfig {

    @org.jetbrains.annotations.NotNull
    public static final com.chad.library.adapter.base.module.LoadMoreModuleConfig INSTANCE = new com.chad.library.adapter.base.module.LoadMoreModuleConfig();

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static com.chad.library.adapter.base.loadmore.BaseLoadMoreView defLoadMoreView = new com.chad.library.adapter.base.loadmore.SimpleLoadMoreView();

    @org.jetbrains.annotations.NotNull
    public static final com.chad.library.adapter.base.loadmore.BaseLoadMoreView getDefLoadMoreView() {
        return defLoadMoreView;
    }

    @kotlin.jvm.JvmStatic
    public static /* synthetic */ void getDefLoadMoreView$annotations() {
    }

    public static final void setDefLoadMoreView(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.loadmore.BaseLoadMoreView baseLoadMoreView) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(baseLoadMoreView, "<set-?>");
        defLoadMoreView = baseLoadMoreView;
    }
}
