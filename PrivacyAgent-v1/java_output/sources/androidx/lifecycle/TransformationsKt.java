package androidx.lifecycle;

@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0086\b\u001a>\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0014\b\u0004\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u0006H\u0086\bø\u0001\u0000\u001aD\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u001a\b\u0004\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00010\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\b"}, d2 = {"distinctUntilChanged", "Landroidx/lifecycle/LiveData;", "X", "map", "Y", "transform", "Lkotlin/Function1;", "switchMap", "lifecycle-livedata-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class TransformationsKt {
    @org.jetbrains.annotations.NotNull
    public static final <X> androidx.lifecycle.LiveData<X> distinctUntilChanged(@org.jetbrains.annotations.NotNull androidx.lifecycle.LiveData<X> liveData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(liveData, "<this>");
        androidx.lifecycle.LiveData<X> distinctUntilChanged = androidx.lifecycle.Transformations.distinctUntilChanged(liveData);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "distinctUntilChanged(this)");
        return distinctUntilChanged;
    }

    @org.jetbrains.annotations.NotNull
    public static final <X, Y> androidx.lifecycle.LiveData<Y> map(@org.jetbrains.annotations.NotNull androidx.lifecycle.LiveData<X> liveData, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super X, ? extends Y> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(liveData, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        androidx.lifecycle.LiveData<Y> map = androidx.lifecycle.Transformations.map(liveData, new androidx.lifecycle.TransformationsKt$map$1(transform));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(map, "crossinline transform: (…p(this) { transform(it) }");
        return map;
    }

    @org.jetbrains.annotations.NotNull
    public static final <X, Y> androidx.lifecycle.LiveData<Y> switchMap(@org.jetbrains.annotations.NotNull androidx.lifecycle.LiveData<X> liveData, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super X, ? extends androidx.lifecycle.LiveData<Y>> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(liveData, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        androidx.lifecycle.LiveData<Y> switchMap = androidx.lifecycle.Transformations.switchMap(liveData, new androidx.lifecycle.TransformationsKt$switchMap$1(transform));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(switchMap, "crossinline transform: (…p(this) { transform(it) }");
        return switchMap;
    }
}
