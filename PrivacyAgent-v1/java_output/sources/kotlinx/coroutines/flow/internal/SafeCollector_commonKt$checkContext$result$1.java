package kotlinx.coroutines.flow.internal;

@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n"}, d2 = {"", me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT, "Lkotlin/coroutines/CoroutineContext$Element;", "element", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class SafeCollector_commonKt$checkContext$result$1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function2<java.lang.Integer, kotlin.coroutines.CoroutineContext.Element, java.lang.Integer> {
    final /* synthetic */ kotlinx.coroutines.flow.internal.SafeCollector<?> $this_checkContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeCollector_commonKt$checkContext$result$1(kotlinx.coroutines.flow.internal.SafeCollector<?> safeCollector) {
        super(2);
        this.$this_checkContext = safeCollector;
    }

    public final int invoke(int i, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Element element) {
        kotlin.coroutines.CoroutineContext.Key<?> key = element.getKey();
        kotlin.coroutines.CoroutineContext.Element element2 = this.$this_checkContext.collectContext.get(key);
        if (key != kotlinx.coroutines.Job.INSTANCE) {
            if (element != element2) {
                return Integer.MIN_VALUE;
            }
            return i + 1;
        }
        kotlinx.coroutines.Job job = (kotlinx.coroutines.Job) element2;
        kotlinx.coroutines.Job transitiveCoroutineParent = kotlinx.coroutines.flow.internal.SafeCollector_commonKt.transitiveCoroutineParent((kotlinx.coroutines.Job) element, job);
        if (transitiveCoroutineParent == job) {
            return job == null ? i : i + 1;
        }
        throw new java.lang.IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + transitiveCoroutineParent + ", expected child of " + job + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ java.lang.Integer mo5invoke(java.lang.Integer num, kotlin.coroutines.CoroutineContext.Element element) {
        return java.lang.Integer.valueOf(invoke(num.intValue(), element));
    }
}
