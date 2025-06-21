package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n"}, d2 = {"", "countOrElement", "Lkotlin/coroutines/CoroutineContext$Element;", "element", "<no name provided>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class ThreadContextKt$countAll$1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function2<java.lang.Object, kotlin.coroutines.CoroutineContext.Element, java.lang.Object> {
    public static final kotlinx.coroutines.internal.ThreadContextKt$countAll$1 INSTANCE = new kotlinx.coroutines.internal.ThreadContextKt$countAll$1();

    public ThreadContextKt$countAll$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Element element) {
        if (!(element instanceof kotlinx.coroutines.ThreadContextElement)) {
            return obj;
        }
        java.lang.Integer num = obj instanceof java.lang.Integer ? (java.lang.Integer) obj : null;
        int intValue = num == null ? 1 : num.intValue();
        return intValue == 0 ? element : java.lang.Integer.valueOf(intValue + 1);
    }
}
