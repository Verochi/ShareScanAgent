package kotlinx.coroutines.android;

@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public final class HandlerContext$scheduleResumeAfterDelay$1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> {
    final /* synthetic */ java.lang.Runnable $block;
    final /* synthetic */ kotlinx.coroutines.android.HandlerContext this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerContext$scheduleResumeAfterDelay$1(kotlinx.coroutines.android.HandlerContext handlerContext, java.lang.Runnable runnable) {
        super(1);
        this.this$0 = handlerContext;
        this.$block = runnable;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.Unit invoke(java.lang.Throwable th) {
        invoke2(th);
        return kotlin.Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Throwable th) {
        android.os.Handler handler;
        handler = this.this$0.handler;
        handler.removeCallbacks(this.$block);
    }
}
