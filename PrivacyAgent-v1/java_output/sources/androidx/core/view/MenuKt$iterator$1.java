package androidx.core.view;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0096\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"androidx/core/view/MenuKt$iterator$1", "", "Landroid/view/MenuItem;", "index", "", "hasNext", "", "next", "remove", "", "core-ktx_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class MenuKt$iterator$1 implements java.util.Iterator<android.view.MenuItem>, kotlin.jvm.internal.markers.KMutableIterator {
    final /* synthetic */ android.view.Menu $this_iterator;
    private int index;

    public MenuKt$iterator$1(android.view.Menu menu) {
        this.$this_iterator = menu;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.$this_iterator.size();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @org.jetbrains.annotations.NotNull
    public android.view.MenuItem next() {
        android.view.Menu menu = this.$this_iterator;
        int i = this.index;
        this.index = i + 1;
        android.view.MenuItem item = menu.getItem(i);
        if (item != null) {
            return item;
        }
        throw new java.lang.IndexOutOfBoundsException();
    }

    @Override // java.util.Iterator
    public void remove() {
        android.view.Menu menu = this.$this_iterator;
        int i = this.index - 1;
        this.index = i;
        menu.removeItem(i);
    }
}
