package androidx.core.view;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", com.anythink.expressad.a.B, "Landroid/view/View;", com.sensorsdata.sf.ui.view.UIProperty.left, "", com.sensorsdata.sf.ui.view.UIProperty.top, com.sensorsdata.sf.ui.view.UIProperty.right, com.sensorsdata.sf.ui.view.UIProperty.bottom, "oldLeft", "oldTop", "oldRight", "oldBottom", "core-ktx_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class ViewKt$doOnNextLayout$1 implements android.view.View.OnLayoutChangeListener {
    final /* synthetic */ kotlin.jvm.functions.Function1 $action;

    public ViewKt$doOnNextLayout$1(kotlin.jvm.functions.Function1 function1) {
        this.$action = function1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(@org.jetbrains.annotations.NotNull android.view.View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(view, "view");
        view.removeOnLayoutChangeListener(this);
        this.$action.invoke(view);
    }
}
