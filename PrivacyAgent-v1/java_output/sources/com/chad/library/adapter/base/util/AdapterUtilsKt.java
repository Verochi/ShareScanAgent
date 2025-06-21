package com.chad.library.adapter.base.util;

@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"getItemView", "Landroid/view/View;", "Landroid/view/ViewGroup;", "layoutResId", "", "com.github.CymChad.brvah"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes22.dex */
public final class AdapterUtilsKt {
    @org.jetbrains.annotations.NotNull
    public static final android.view.View getItemView(@org.jetbrains.annotations.NotNull android.view.ViewGroup viewGroup, @androidx.annotation.LayoutRes int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        android.view.View inflate = android.view.LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inflate, "from(this.context).infla…layoutResId, this, false)");
        return inflate;
    }
}
