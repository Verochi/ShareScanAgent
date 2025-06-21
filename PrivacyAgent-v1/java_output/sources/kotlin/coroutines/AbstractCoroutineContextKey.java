package kotlin.coroutines;

@kotlin.SinceKotlin(version = "1.3")
@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00028\u00002\b\u0012\u0004\u0012\u00028\u00010\u0004B:\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012#\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u000e¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\r\u001a\u00020\n2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\b\u000b\u0010\fR1\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlin/coroutines/CoroutineContext$Element;", "B", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/CoroutineContext$Key;", "element", "tryCast$kotlin_stdlib", "(Lkotlin/coroutines/CoroutineContext$Element;)Lkotlin/coroutines/CoroutineContext$Element;", "tryCast", "key", "", "isSubKey$kotlin_stdlib", "(Lkotlin/coroutines/CoroutineContext$Key;)Z", "isSubKey", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lkotlin/jvm/functions/Function1;", "safeCast", "t", "Lkotlin/coroutines/CoroutineContext$Key;", "topmostKey", "baseKey", "<init>", "(Lkotlin/coroutines/CoroutineContext$Key;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@kotlin.ExperimentalStdlibApi
/* loaded from: classes14.dex */
public abstract class AbstractCoroutineContextKey<B extends kotlin.coroutines.CoroutineContext.Element, E extends B> implements kotlin.coroutines.CoroutineContext.Key<E> {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function1<kotlin.coroutines.CoroutineContext.Element, E> safeCast;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.CoroutineContext.Key<?> topmostKey;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.CoroutineContext$Key<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, kotlin.jvm.functions.Function1<? super kotlin.coroutines.CoroutineContext$Element, ? extends E extends B>, kotlin.jvm.functions.Function1<kotlin.coroutines.CoroutineContext$Element, E extends B>] */
    public AbstractCoroutineContextKey(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Key<B> baseKey, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.CoroutineContext.Element, ? extends E> safeCast) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(baseKey, "baseKey");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(safeCast, "safeCast");
        this.safeCast = safeCast;
        this.topmostKey = baseKey instanceof kotlin.coroutines.AbstractCoroutineContextKey ? (kotlin.coroutines.CoroutineContext.Key<B>) ((kotlin.coroutines.AbstractCoroutineContextKey) baseKey).topmostKey : baseKey;
    }

    public final boolean isSubKey$kotlin_stdlib(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Key<?> key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        return key == this || this.topmostKey == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/CoroutineContext$Element;)TE; */
    @org.jetbrains.annotations.Nullable
    public final kotlin.coroutines.CoroutineContext.Element tryCast$kotlin_stdlib(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Element element) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(element, "element");
        return (kotlin.coroutines.CoroutineContext.Element) this.safeCast.invoke(element);
    }
}
