package androidx.core.view;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0096\u0002¨\u0006\u0005"}, d2 = {"androidx/core/view/MenuKt$children$1", "Lkotlin/sequences/Sequence;", "Landroid/view/MenuItem;", "iterator", "", "core-ktx_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class MenuKt$children$1 implements kotlin.sequences.Sequence<android.view.MenuItem> {
    final /* synthetic */ android.view.Menu $this_children;

    public MenuKt$children$1(android.view.Menu menu) {
        this.$this_children = menu;
    }

    @Override // kotlin.sequences.Sequence
    @org.jetbrains.annotations.NotNull
    public java.util.Iterator<android.view.MenuItem> iterator() {
        return androidx.core.view.MenuKt.iterator(this.$this_children);
    }
}
