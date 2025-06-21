package androidx.core.view;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0002\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\u0002\u001a0\u0010\r\u001a\u00020\u000e*\u00020\u00032!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\b\u001aE\u0010\u0013\u001a\u00020\u000e*\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0014H\u0086\b\u001a\u0015\u0010\u0016\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\n\u001a\r\u0010\u0017\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a*\u00020\u0003H\u0086\u0002\u001a\u0015\u0010\u001b\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"children", "Lkotlin/sequences/Sequence;", "Landroid/view/MenuItem;", "Landroid/view/Menu;", "getChildren", "(Landroid/view/Menu;)Lkotlin/sequences/Sequence;", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "", "getSize", "(Landroid/view/Menu;)I", "contains", "", "item", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "index", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class MenuKt {
    public static final boolean contains(@org.jetbrains.annotations.NotNull android.view.Menu contains, @org.jetbrains.annotations.NotNull android.view.MenuItem item) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(item, "item");
        int size = contains.size();
        for (int i = 0; i < size; i++) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(contains.getItem(i), item)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(@org.jetbrains.annotations.NotNull android.view.Menu forEach, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.view.MenuItem, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(forEach, "$this$forEach");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        int size = forEach.size();
        for (int i = 0; i < size; i++) {
            android.view.MenuItem item = forEach.getItem(i);
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(item, "getItem(index)");
            action.invoke(item);
        }
    }

    public static final void forEachIndexed(@org.jetbrains.annotations.NotNull android.view.Menu forEachIndexed, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super android.view.MenuItem, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(forEachIndexed, "$this$forEachIndexed");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        int size = forEachIndexed.size();
        for (int i = 0; i < size; i++) {
            java.lang.Integer valueOf = java.lang.Integer.valueOf(i);
            android.view.MenuItem item = forEachIndexed.getItem(i);
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(item, "getItem(index)");
            action.mo5invoke(valueOf, item);
        }
    }

    @org.jetbrains.annotations.NotNull
    public static final android.view.MenuItem get(@org.jetbrains.annotations.NotNull android.view.Menu get, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(get, "$this$get");
        android.view.MenuItem item = get.getItem(i);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(item, "getItem(index)");
        return item;
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.sequences.Sequence<android.view.MenuItem> getChildren(@org.jetbrains.annotations.NotNull android.view.Menu children) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(children, "$this$children");
        return new androidx.core.view.MenuKt$children$1(children);
    }

    public static final int getSize(@org.jetbrains.annotations.NotNull android.view.Menu size) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(size, "$this$size");
        return size.size();
    }

    public static final boolean isEmpty(@org.jetbrains.annotations.NotNull android.view.Menu isEmpty) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(isEmpty, "$this$isEmpty");
        return isEmpty.size() == 0;
    }

    public static final boolean isNotEmpty(@org.jetbrains.annotations.NotNull android.view.Menu isNotEmpty) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.size() != 0;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.Iterator<android.view.MenuItem> iterator(@org.jetbrains.annotations.NotNull android.view.Menu iterator) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(iterator, "$this$iterator");
        return new androidx.core.view.MenuKt$iterator$1(iterator);
    }

    public static final void minusAssign(@org.jetbrains.annotations.NotNull android.view.Menu minusAssign, @org.jetbrains.annotations.NotNull android.view.MenuItem item) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(minusAssign, "$this$minusAssign");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(item, "item");
        minusAssign.removeItem(item.getItemId());
    }
}
