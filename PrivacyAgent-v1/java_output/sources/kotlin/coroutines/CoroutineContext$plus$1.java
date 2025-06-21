package kotlin.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class CoroutineContext$plus$1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function2<kotlin.coroutines.CoroutineContext, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext> {
    public static final kotlin.coroutines.CoroutineContext$plus$1 INSTANCE = new kotlin.coroutines.CoroutineContext$plus$1();

    public CoroutineContext$plus$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.NotNull
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final kotlin.coroutines.CoroutineContext mo5invoke(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext acc, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Element element) {
        kotlin.coroutines.CombinedContext combinedContext;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(acc, "acc");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(element, "element");
        kotlin.coroutines.CoroutineContext minusKey = acc.minusKey(element.getKey());
        kotlin.coroutines.EmptyCoroutineContext emptyCoroutineContext = kotlin.coroutines.EmptyCoroutineContext.INSTANCE;
        if (minusKey == emptyCoroutineContext) {
            return element;
        }
        kotlin.coroutines.ContinuationInterceptor.Companion companion = kotlin.coroutines.ContinuationInterceptor.INSTANCE;
        kotlin.coroutines.ContinuationInterceptor continuationInterceptor = (kotlin.coroutines.ContinuationInterceptor) minusKey.get(companion);
        if (continuationInterceptor == null) {
            combinedContext = new kotlin.coroutines.CombinedContext(minusKey, element);
        } else {
            kotlin.coroutines.CoroutineContext minusKey2 = minusKey.minusKey(companion);
            if (minusKey2 == emptyCoroutineContext) {
                return new kotlin.coroutines.CombinedContext(element, continuationInterceptor);
            }
            combinedContext = new kotlin.coroutines.CombinedContext(new kotlin.coroutines.CombinedContext(minusKey2, element), continuationInterceptor);
        }
        return combinedContext;
    }
}
