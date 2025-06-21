package androidx.core.view;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\u001a0\u0010\r\u001a\u00020\u000e*\u00020\u00032!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\b\u001aE\u0010\u0013\u001a\u00020\u000e*\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0014H\u0086\b\u001a\u0015\u0010\u0016\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\u0002\u001a\r\u0010\u0017\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a*\u00020\u0003H\u0086\u0002\u001a\u0015\u0010\u001b\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\u001c\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\u001a\u0017\u0010\u001d\u001a\u00020\u000e*\u00020\u001e2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0086\b\u001a5\u0010\u001f\u001a\u00020\u000e*\u00020\u001e2\b\b\u0003\u0010 \u001a\u00020\u00072\b\b\u0003\u0010!\u001a\u00020\u00072\b\b\u0003\u0010\"\u001a\u00020\u00072\b\b\u0003\u0010#\u001a\u00020\u0007H\u0086\b\u001a5\u0010$\u001a\u00020\u000e*\u00020\u001e2\b\b\u0003\u0010%\u001a\u00020\u00072\b\b\u0003\u0010!\u001a\u00020\u00072\b\b\u0003\u0010&\u001a\u00020\u00072\b\b\u0003\u0010#\u001a\u00020\u0007H\u0087\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006'"}, d2 = {"children", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "Landroid/view/ViewGroup;", "getChildren", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "", "getSize", "(Landroid/view/ViewGroup;)I", "contains", "", com.anythink.expressad.a.B, "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "index", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "plusAssign", "setMargins", "Landroid/view/ViewGroup$MarginLayoutParams;", "updateMargins", com.sensorsdata.sf.ui.view.UIProperty.left, com.sensorsdata.sf.ui.view.UIProperty.top, com.sensorsdata.sf.ui.view.UIProperty.right, com.sensorsdata.sf.ui.view.UIProperty.bottom, "updateMarginsRelative", com.anythink.expressad.foundation.d.c.bT, "end", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class ViewGroupKt {
    public static final boolean contains(@org.jetbrains.annotations.NotNull android.view.ViewGroup contains, @org.jetbrains.annotations.NotNull android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(view, "view");
        return contains.indexOfChild(view) != -1;
    }

    public static final void forEach(@org.jetbrains.annotations.NotNull android.view.ViewGroup forEach, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.view.View, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(forEach, "$this$forEach");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        int childCount = forEach.getChildCount();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = forEach.getChildAt(i);
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(index)");
            action.invoke(childAt);
        }
    }

    public static final void forEachIndexed(@org.jetbrains.annotations.NotNull android.view.ViewGroup forEachIndexed, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super android.view.View, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(forEachIndexed, "$this$forEachIndexed");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        int childCount = forEachIndexed.getChildCount();
        for (int i = 0; i < childCount; i++) {
            java.lang.Integer valueOf = java.lang.Integer.valueOf(i);
            android.view.View childAt = forEachIndexed.getChildAt(i);
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(index)");
            action.mo5invoke(valueOf, childAt);
        }
    }

    @org.jetbrains.annotations.NotNull
    public static final android.view.View get(@org.jetbrains.annotations.NotNull android.view.ViewGroup get, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(get, "$this$get");
        android.view.View childAt = get.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        throw new java.lang.IndexOutOfBoundsException("Index: " + i + ", Size: " + get.getChildCount());
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.sequences.Sequence<android.view.View> getChildren(@org.jetbrains.annotations.NotNull android.view.ViewGroup children) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(children, "$this$children");
        return new androidx.core.view.ViewGroupKt$children$1(children);
    }

    public static final int getSize(@org.jetbrains.annotations.NotNull android.view.ViewGroup size) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(size, "$this$size");
        return size.getChildCount();
    }

    public static final boolean isEmpty(@org.jetbrains.annotations.NotNull android.view.ViewGroup isEmpty) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(isEmpty, "$this$isEmpty");
        return isEmpty.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(@org.jetbrains.annotations.NotNull android.view.ViewGroup isNotEmpty) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.getChildCount() != 0;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.Iterator<android.view.View> iterator(@org.jetbrains.annotations.NotNull android.view.ViewGroup iterator) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(iterator, "$this$iterator");
        return new androidx.core.view.ViewGroupKt$iterator$1(iterator);
    }

    public static final void minusAssign(@org.jetbrains.annotations.NotNull android.view.ViewGroup minusAssign, @org.jetbrains.annotations.NotNull android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(minusAssign, "$this$minusAssign");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(view, "view");
        minusAssign.removeView(view);
    }

    public static final void plusAssign(@org.jetbrains.annotations.NotNull android.view.ViewGroup plusAssign, @org.jetbrains.annotations.NotNull android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(plusAssign, "$this$plusAssign");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(view, "view");
        plusAssign.addView(view);
    }

    public static final void setMargins(@org.jetbrains.annotations.NotNull android.view.ViewGroup.MarginLayoutParams setMargins, @androidx.annotation.Px int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(setMargins, "$this$setMargins");
        setMargins.setMargins(i, i, i, i);
    }

    public static final void updateMargins(@org.jetbrains.annotations.NotNull android.view.ViewGroup.MarginLayoutParams updateMargins, @androidx.annotation.Px int i, @androidx.annotation.Px int i2, @androidx.annotation.Px int i3, @androidx.annotation.Px int i4) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(updateMargins, "$this$updateMargins");
        updateMargins.setMargins(i, i2, i3, i4);
    }

    public static /* synthetic */ void updateMargins$default(android.view.ViewGroup.MarginLayoutParams updateMargins, int i, int i2, int i3, int i4, int i5, java.lang.Object obj) {
        if ((i5 & 1) != 0) {
            i = updateMargins.leftMargin;
        }
        if ((i5 & 2) != 0) {
            i2 = updateMargins.topMargin;
        }
        if ((i5 & 4) != 0) {
            i3 = updateMargins.rightMargin;
        }
        if ((i5 & 8) != 0) {
            i4 = updateMargins.bottomMargin;
        }
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(updateMargins, "$this$updateMargins");
        updateMargins.setMargins(i, i2, i3, i4);
    }

    @androidx.annotation.RequiresApi(17)
    public static final void updateMarginsRelative(@org.jetbrains.annotations.NotNull android.view.ViewGroup.MarginLayoutParams updateMarginsRelative, @androidx.annotation.Px int i, @androidx.annotation.Px int i2, @androidx.annotation.Px int i3, @androidx.annotation.Px int i4) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(updateMarginsRelative, "$this$updateMarginsRelative");
        updateMarginsRelative.setMarginStart(i);
        updateMarginsRelative.topMargin = i2;
        updateMarginsRelative.setMarginEnd(i3);
        updateMarginsRelative.bottomMargin = i4;
    }

    public static /* synthetic */ void updateMarginsRelative$default(android.view.ViewGroup.MarginLayoutParams updateMarginsRelative, int i, int i2, int i3, int i4, int i5, java.lang.Object obj) {
        if ((i5 & 1) != 0) {
            i = updateMarginsRelative.getMarginStart();
        }
        if ((i5 & 2) != 0) {
            i2 = updateMarginsRelative.topMargin;
        }
        if ((i5 & 4) != 0) {
            i3 = updateMarginsRelative.getMarginEnd();
        }
        if ((i5 & 8) != 0) {
            i4 = updateMarginsRelative.bottomMargin;
        }
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(updateMarginsRelative, "$this$updateMarginsRelative");
        updateMarginsRelative.setMarginStart(i);
        updateMarginsRelative.topMargin = i2;
        updateMarginsRelative.setMarginEnd(i3);
        updateMarginsRelative.bottomMargin = i4;
    }
}
