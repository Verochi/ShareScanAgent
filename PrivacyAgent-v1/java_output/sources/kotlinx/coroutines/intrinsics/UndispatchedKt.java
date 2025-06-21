package kotlinx.coroutines.intrinsics;

@kotlin.Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a@\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001aT\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u000b\u001a@\u0010\f\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0007\u001aT\u0010\f\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000b\u001a[\u0010\u0010\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\n\u001a\u00028\u00012'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t¢\u0006\u0002\b\u000eH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a[\u0010\u0012\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\n\u001a\u00028\u00012'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t¢\u0006\u0002\b\u000eH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "completion", "", "startCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", com.tencent.open.SocialConstants.PARAM_RECEIVER, "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startCoroutineUndispatched", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/ExtensionFunctionType;", "block", "startUndispatchedOrReturn", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class UndispatchedKt {
    public static final <T> void startCoroutineUndispatched(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function1, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        java.lang.Object coroutine_suspended;
        kotlin.coroutines.Continuation probeCoroutineCreated = kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            kotlin.coroutines.CoroutineContext context = continuation.getContext();
            java.lang.Object updateThreadContext = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(context, null);
            try {
                if (function1 == null) {
                    throw new java.lang.NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                }
                java.lang.Object invoke = ((kotlin.jvm.functions.Function1) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(probeCoroutineCreated);
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (invoke != coroutine_suspended) {
                    probeCoroutineCreated.resumeWith(kotlin.Result.m156constructorimpl(invoke));
                }
            } finally {
                kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            probeCoroutineCreated.resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th)));
        }
    }

    public static final <R, T> void startCoroutineUndispatched(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function2, R r, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        java.lang.Object coroutine_suspended;
        kotlin.coroutines.Continuation probeCoroutineCreated = kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            kotlin.coroutines.CoroutineContext context = continuation.getContext();
            java.lang.Object updateThreadContext = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(context, null);
            try {
                if (function2 == null) {
                    throw new java.lang.NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                }
                java.lang.Object mo5invoke = ((kotlin.jvm.functions.Function2) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).mo5invoke(r, probeCoroutineCreated);
                coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (mo5invoke != coroutine_suspended) {
                    probeCoroutineCreated.resumeWith(kotlin.Result.m156constructorimpl(mo5invoke));
                }
            } finally {
                kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            probeCoroutineCreated.resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th)));
        }
    }

    public static final <T> void startCoroutineUnintercepted(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function1, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        java.lang.Object coroutine_suspended;
        kotlin.coroutines.Continuation probeCoroutineCreated = kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            if (function1 == null) {
                throw new java.lang.NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            }
            java.lang.Object invoke = ((kotlin.jvm.functions.Function1) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(probeCoroutineCreated);
            coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (invoke != coroutine_suspended) {
                probeCoroutineCreated.resumeWith(kotlin.Result.m156constructorimpl(invoke));
            }
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            probeCoroutineCreated.resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th)));
        }
    }

    public static final <R, T> void startCoroutineUnintercepted(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function2, R r, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation) {
        java.lang.Object coroutine_suspended;
        kotlin.coroutines.Continuation probeCoroutineCreated = kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            if (function2 == null) {
                throw new java.lang.NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            }
            java.lang.Object mo5invoke = ((kotlin.jvm.functions.Function2) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).mo5invoke(r, probeCoroutineCreated);
            coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (mo5invoke != coroutine_suspended) {
                probeCoroutineCreated.resumeWith(kotlin.Result.m156constructorimpl(mo5invoke));
            }
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            probeCoroutineCreated.resumeWith(kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th)));
        }
    }

    @org.jetbrains.annotations.Nullable
    public static final <T, R> java.lang.Object startUndispatchedOrReturn(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.ScopeCoroutine<? super T> scopeCoroutine, R r, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function2) {
        java.lang.Object completedExceptionally;
        java.lang.Object coroutine_suspended;
        java.lang.Object coroutine_suspended2;
        java.lang.Object coroutine_suspended3;
        try {
        } catch (java.lang.Throwable th) {
            completedExceptionally = new kotlinx.coroutines.CompletedExceptionally(th, false, 2, null);
        }
        if (function2 == null) {
            throw new java.lang.NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
        completedExceptionally = ((kotlin.jvm.functions.Function2) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).mo5invoke(r, scopeCoroutine);
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (completedExceptionally == coroutine_suspended) {
            coroutine_suspended3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return coroutine_suspended3;
        }
        java.lang.Object makeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally);
        if (makeCompletingOnce$kotlinx_coroutines_core == kotlinx.coroutines.JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            coroutine_suspended2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return coroutine_suspended2;
        }
        if (makeCompletingOnce$kotlinx_coroutines_core instanceof kotlinx.coroutines.CompletedExceptionally) {
            throw ((kotlinx.coroutines.CompletedExceptionally) makeCompletingOnce$kotlinx_coroutines_core).cause;
        }
        return kotlinx.coroutines.JobSupportKt.unboxState(makeCompletingOnce$kotlinx_coroutines_core);
    }

    @org.jetbrains.annotations.Nullable
    public static final <T, R> java.lang.Object startUndispatchedOrReturnIgnoreTimeout(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.ScopeCoroutine<? super T> scopeCoroutine, R r, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> function2) {
        java.lang.Object completedExceptionally;
        java.lang.Object coroutine_suspended;
        java.lang.Object coroutine_suspended2;
        java.lang.Object coroutine_suspended3;
        try {
        } catch (java.lang.Throwable th) {
            completedExceptionally = new kotlinx.coroutines.CompletedExceptionally(th, false, 2, null);
        }
        if (function2 == null) {
            throw new java.lang.NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
        completedExceptionally = ((kotlin.jvm.functions.Function2) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).mo5invoke(r, scopeCoroutine);
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (completedExceptionally == coroutine_suspended) {
            coroutine_suspended3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return coroutine_suspended3;
        }
        java.lang.Object makeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally);
        if (makeCompletingOnce$kotlinx_coroutines_core == kotlinx.coroutines.JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            coroutine_suspended2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return coroutine_suspended2;
        }
        if (makeCompletingOnce$kotlinx_coroutines_core instanceof kotlinx.coroutines.CompletedExceptionally) {
            java.lang.Throwable th2 = ((kotlinx.coroutines.CompletedExceptionally) makeCompletingOnce$kotlinx_coroutines_core).cause;
            if (((th2 instanceof kotlinx.coroutines.TimeoutCancellationException) && ((kotlinx.coroutines.TimeoutCancellationException) th2).coroutine == scopeCoroutine) ? false : true) {
                throw th2;
            }
            if (completedExceptionally instanceof kotlinx.coroutines.CompletedExceptionally) {
                throw ((kotlinx.coroutines.CompletedExceptionally) completedExceptionally).cause;
            }
        } else {
            completedExceptionally = kotlinx.coroutines.JobSupportKt.unboxState(makeCompletingOnce$kotlinx_coroutines_core);
        }
        return completedExceptionally;
    }
}
