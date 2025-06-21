package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001B\\\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\"\u0010#J\u001a\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004J`\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR1\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0011\u0010!\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u001c\u0010 ¨\u0006$"}, d2 = {"Lkotlinx/coroutines/CompletedContinuation;", "", "Lkotlinx/coroutines/CancellableContinuationImpl;", "cont", "", "cause", "", "d", "result", "Lkotlinx/coroutines/CancelHandler;", "cancelHandler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onCancellation", "idempotentResume", "cancelCause", "a", "", "toString", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "other", "", "equals", "Ljava/lang/Object;", "b", "Lkotlinx/coroutines/CancelHandler;", "c", "Lkotlin/jvm/functions/Function1;", "e", "Ljava/lang/Throwable;", "()Z", "cancelled", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/CancelHandler;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes15.dex */
final /* data */ class CompletedContinuation {

    /* renamed from: a, reason: from kotlin metadata and from toString */
    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object result;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.Nullable
    public final kotlinx.coroutines.CancelHandler cancelHandler;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.Nullable
    public final kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> onCancellation;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object idempotentResume;

    /* renamed from: e, reason: from kotlin metadata and from toString */
    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.Nullable
    public final java.lang.Throwable cancelCause;

    /* JADX WARN: Multi-variable type inference failed */
    public CompletedContinuation(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.Nullable kotlinx.coroutines.CancelHandler cancelHandler, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> function1, @org.jetbrains.annotations.Nullable java.lang.Object obj2, @org.jetbrains.annotations.Nullable java.lang.Throwable th) {
        this.result = obj;
        this.cancelHandler = cancelHandler;
        this.onCancellation = function1;
        this.idempotentResume = obj2;
        this.cancelCause = th;
    }

    public /* synthetic */ CompletedContinuation(java.lang.Object obj, kotlinx.coroutines.CancelHandler cancelHandler, kotlin.jvm.functions.Function1 function1, java.lang.Object obj2, java.lang.Throwable th, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? null : cancelHandler, (i & 4) != 0 ? null : function1, (i & 8) != 0 ? null : obj2, (i & 16) != 0 ? null : th);
    }

    public static /* synthetic */ kotlinx.coroutines.CompletedContinuation b(kotlinx.coroutines.CompletedContinuation completedContinuation, java.lang.Object obj, kotlinx.coroutines.CancelHandler cancelHandler, kotlin.jvm.functions.Function1 function1, java.lang.Object obj2, java.lang.Throwable th, int i, java.lang.Object obj3) {
        if ((i & 1) != 0) {
            obj = completedContinuation.result;
        }
        if ((i & 2) != 0) {
            cancelHandler = completedContinuation.cancelHandler;
        }
        kotlinx.coroutines.CancelHandler cancelHandler2 = cancelHandler;
        if ((i & 4) != 0) {
            function1 = completedContinuation.onCancellation;
        }
        kotlin.jvm.functions.Function1 function12 = function1;
        if ((i & 8) != 0) {
            obj2 = completedContinuation.idempotentResume;
        }
        java.lang.Object obj4 = obj2;
        if ((i & 16) != 0) {
            th = completedContinuation.cancelCause;
        }
        return completedContinuation.a(obj, cancelHandler2, function12, obj4, th);
    }

    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.CompletedContinuation a(@org.jetbrains.annotations.Nullable java.lang.Object result, @org.jetbrains.annotations.Nullable kotlinx.coroutines.CancelHandler cancelHandler, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> onCancellation, @org.jetbrains.annotations.Nullable java.lang.Object idempotentResume, @org.jetbrains.annotations.Nullable java.lang.Throwable cancelCause) {
        return new kotlinx.coroutines.CompletedContinuation(result, cancelHandler, onCancellation, idempotentResume, cancelCause);
    }

    public final boolean c() {
        return this.cancelCause != null;
    }

    public final void d(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CancellableContinuationImpl<?> cont, @org.jetbrains.annotations.NotNull java.lang.Throwable cause) {
        kotlinx.coroutines.CancelHandler cancelHandler = this.cancelHandler;
        if (cancelHandler != null) {
            cont.callCancelHandler(cancelHandler, cause);
        }
        kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> function1 = this.onCancellation;
        if (function1 == null) {
            return;
        }
        cont.callOnCancellation(function1, cause);
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof kotlinx.coroutines.CompletedContinuation)) {
            return false;
        }
        kotlinx.coroutines.CompletedContinuation completedContinuation = (kotlinx.coroutines.CompletedContinuation) other;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.result, completedContinuation.result) && kotlin.jvm.internal.Intrinsics.areEqual(this.cancelHandler, completedContinuation.cancelHandler) && kotlin.jvm.internal.Intrinsics.areEqual(this.onCancellation, completedContinuation.onCancellation) && kotlin.jvm.internal.Intrinsics.areEqual(this.idempotentResume, completedContinuation.idempotentResume) && kotlin.jvm.internal.Intrinsics.areEqual(this.cancelCause, completedContinuation.cancelCause);
    }

    public int hashCode() {
        java.lang.Object obj = this.result;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        kotlinx.coroutines.CancelHandler cancelHandler = this.cancelHandler;
        int hashCode2 = (hashCode + (cancelHandler == null ? 0 : cancelHandler.hashCode())) * 31;
        kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> function1 = this.onCancellation;
        int hashCode3 = (hashCode2 + (function1 == null ? 0 : function1.hashCode())) * 31;
        java.lang.Object obj2 = this.idempotentResume;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        java.lang.Throwable th = this.cancelCause;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return "CompletedContinuation(result=" + this.result + ", cancelHandler=" + this.cancelHandler + ", onCancellation=" + this.onCancellation + ", idempotentResume=" + this.idempotentResume + ", cancelCause=" + this.cancelCause + ')';
    }
}
