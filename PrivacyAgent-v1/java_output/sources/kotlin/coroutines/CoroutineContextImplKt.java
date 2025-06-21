package kotlin.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0007¨\u0006\b"}, d2 = {"getPolymorphicElement", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Element;Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusPolymorphicKey", "Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class CoroutineContextImplKt {
    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.ExperimentalStdlibApi
    @org.jetbrains.annotations.Nullable
    public static final <E extends kotlin.coroutines.CoroutineContext.Element> E getPolymorphicElement(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Element element, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Key<E> key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(element, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        if (!(key instanceof kotlin.coroutines.AbstractCoroutineContextKey)) {
            if (element.getKey() == key) {
                return element;
            }
            return null;
        }
        kotlin.coroutines.AbstractCoroutineContextKey abstractCoroutineContextKey = (kotlin.coroutines.AbstractCoroutineContextKey) key;
        if (!abstractCoroutineContextKey.isSubKey$kotlin_stdlib(element.getKey())) {
            return null;
        }
        E e = (E) abstractCoroutineContextKey.tryCast$kotlin_stdlib(element);
        if (e instanceof kotlin.coroutines.CoroutineContext.Element) {
            return e;
        }
        return null;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.ExperimentalStdlibApi
    @org.jetbrains.annotations.NotNull
    public static final kotlin.coroutines.CoroutineContext minusPolymorphicKey(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Element element, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Key<?> key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(element, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        if (!(key instanceof kotlin.coroutines.AbstractCoroutineContextKey)) {
            return element.getKey() == key ? kotlin.coroutines.EmptyCoroutineContext.INSTANCE : element;
        }
        kotlin.coroutines.AbstractCoroutineContextKey abstractCoroutineContextKey = (kotlin.coroutines.AbstractCoroutineContextKey) key;
        return (!abstractCoroutineContextKey.isSubKey$kotlin_stdlib(element.getKey()) || abstractCoroutineContextKey.tryCast$kotlin_stdlib(element) == null) ? element : kotlin.coroutines.EmptyCoroutineContext.INSTANCE;
    }
}
