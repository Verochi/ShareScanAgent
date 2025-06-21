package androidx.core.view;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class ViewKt$doOnPreDraw$1 implements java.lang.Runnable {
    final /* synthetic */ kotlin.jvm.functions.Function1 $action;
    final /* synthetic */ android.view.View $this_doOnPreDraw;

    public ViewKt$doOnPreDraw$1(android.view.View view, kotlin.jvm.functions.Function1 function1) {
        this.$this_doOnPreDraw = view;
        this.$action = function1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke(this.$this_doOnPreDraw);
    }
}
