package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u0000`\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u001a!\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a.\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u00002\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0080\b¢\u0006\u0004\b\u0003\u0010\u0007\u001a-\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u00002\n\u0010\u0006\u001a\u00060\bj\u0002`\tH\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a;\u0010\u0012\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u00002\u0010\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a3\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u00150\u0014\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u0000H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a3\u0010\u001a\u001a\u00020\u00192\u0010\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u00152\u0010\u0010\r\u001a\f\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u0000H\u0080Hø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\"\u0010\u001f\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\u001f\u0010\u0004\u001a!\u0010 \u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000¢\u0006\u0004\b \u0010\u0004\u001a\u001e\u0010!\u001a\f\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u000e2\n\u0010\u0006\u001a\u00060\bj\u0002`\tH\u0002\u001a\u0014\u0010$\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010#\u001a\u00020\"H\u0007\u001a\u0010\u0010&\u001a\u00020%*\u00060\u000fj\u0002`\u0010H\u0000\u001a%\u0010)\u001a\u00020(*\f\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u00152\u0006\u0010'\u001a\u00020\"H\u0002¢\u0006\u0004\b)\u0010*\u001a\u001c\u0010+\u001a\u00020%*\u00060\u000fj\u0002`\u00102\n\u0010)\u001a\u00060\u000fj\u0002`\u0010H\u0002\u001a\u0014\u0010,\u001a\u00020\u0019*\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0000\"\u001c\u0010/\u001a\n -*\u0004\u0018\u00010\"0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010.\"\u001c\u00100\u001a\n -*\u0004\u0018\u00010\"0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010.*\f\b\u0000\u00101\"\u00020\b2\u00020\b*\f\b\u0000\u00102\"\u00020\u000f2\u00020\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u00063"}, d2 = {"", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "exception", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/coroutines/Continuation;", "continuation", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "g", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "cause", "result", "Ljava/util/ArrayDeque;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "resultStackTrace", "b", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "Lkotlin/Pair;", "", "a", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "recoveredStacktrace", "", "f", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "", "recoverAndThrow", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unwrap", "unwrapImpl", "c", "", "message", "artificialFrame", "", "isArtificial", "methodName", "", "e", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "d", "initCause", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "baseContinuationImplClassName", "stackTraceRecoveryClassName", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class StackTraceRecoveryKt {
    public static final java.lang.String a;
    public static final java.lang.String b;

    static {
        java.lang.Object m156constructorimpl;
        java.lang.Object m156constructorimpl2;
        try {
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            m156constructorimpl = kotlin.Result.m156constructorimpl(kotlin.coroutines.jvm.internal.BaseContinuationImpl.class.getCanonicalName());
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            m156constructorimpl = kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th));
        }
        if (kotlin.Result.m159exceptionOrNullimpl(m156constructorimpl) != null) {
            m156constructorimpl = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        a = (java.lang.String) m156constructorimpl;
        try {
            m156constructorimpl2 = kotlin.Result.m156constructorimpl(kotlinx.coroutines.internal.StackTraceRecoveryKt.class.getCanonicalName());
        } catch (java.lang.Throwable th2) {
            kotlin.Result.Companion companion3 = kotlin.Result.INSTANCE;
            m156constructorimpl2 = kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th2));
        }
        if (kotlin.Result.m159exceptionOrNullimpl(m156constructorimpl2) != null) {
            m156constructorimpl2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        b = (java.lang.String) m156constructorimpl2;
    }

    public static /* synthetic */ void CoroutineStackFrame$annotations() {
    }

    public static /* synthetic */ void StackTraceElement$annotations() {
    }

    public static final <E extends java.lang.Throwable> kotlin.Pair<E, java.lang.StackTraceElement[]> a(E e) {
        boolean z;
        java.lang.Throwable cause = e.getCause();
        if (cause == null || !kotlin.jvm.internal.Intrinsics.areEqual(cause.getClass(), e.getClass())) {
            return kotlin.TuplesKt.to(e, new java.lang.StackTraceElement[0]);
        }
        java.lang.StackTraceElement[] stackTrace = e.getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            if (isArtificial(stackTrace[i])) {
                z = true;
                break;
            }
            i++;
        }
        return z ? kotlin.TuplesKt.to(cause, stackTrace) : kotlin.TuplesKt.to(e, new java.lang.StackTraceElement[0]);
    }

    @kotlinx.coroutines.InternalCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public static final java.lang.StackTraceElement artificialFrame(@org.jetbrains.annotations.NotNull java.lang.String str) {
        return new java.lang.StackTraceElement(kotlin.jvm.internal.Intrinsics.stringPlus("\b\b\b(", str), "\b", "\b", -1);
    }

    public static final <E extends java.lang.Throwable> E b(E e, E e2, java.util.ArrayDeque<java.lang.StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(artificialFrame("Coroutine boundary"));
        java.lang.StackTraceElement[] stackTrace = e.getStackTrace();
        int e3 = e(stackTrace, a);
        int i = 0;
        if (e3 == -1) {
            java.lang.Object[] array = arrayDeque.toArray(new java.lang.StackTraceElement[0]);
            if (array == null) {
                throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            e2.setStackTrace((java.lang.StackTraceElement[]) array);
            return e2;
        }
        java.lang.StackTraceElement[] stackTraceElementArr = new java.lang.StackTraceElement[arrayDeque.size() + e3];
        if (e3 > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                stackTraceElementArr[i2] = stackTrace[i2];
                if (i3 >= e3) {
                    break;
                }
                i2 = i3;
            }
        }
        java.util.Iterator<java.lang.StackTraceElement> it = arrayDeque.iterator();
        while (it.hasNext()) {
            int i4 = i + 1;
            stackTraceElementArr[i + e3] = it.next();
            i = i4;
        }
        e2.setStackTrace(stackTraceElementArr);
        return e2;
    }

    public static final java.util.ArrayDeque<java.lang.StackTraceElement> c(kotlin.coroutines.jvm.internal.CoroutineStackFrame coroutineStackFrame) {
        java.util.ArrayDeque<java.lang.StackTraceElement> arrayDeque = new java.util.ArrayDeque<>();
        java.lang.StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return arrayDeque;
            }
            java.lang.StackTraceElement stackTraceElement2 = coroutineStackFrame.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
    }

    public static final boolean d(java.lang.StackTraceElement stackTraceElement, java.lang.StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && kotlin.jvm.internal.Intrinsics.areEqual(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && kotlin.jvm.internal.Intrinsics.areEqual(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && kotlin.jvm.internal.Intrinsics.areEqual(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    public static final int e(java.lang.StackTraceElement[] stackTraceElementArr, java.lang.String str) {
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(str, stackTraceElementArr[i].getClassName())) {
                return i;
            }
        }
        return -1;
    }

    public static final void f(java.lang.StackTraceElement[] stackTraceElementArr, java.util.ArrayDeque<java.lang.StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (isArtificial(stackTraceElementArr[i])) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (i2 > length2) {
            return;
        }
        while (true) {
            int i3 = length2 - 1;
            if (d(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i2) {
                return;
            } else {
                length2 = i3;
            }
        }
    }

    public static final <E extends java.lang.Throwable> E g(E e, kotlin.coroutines.jvm.internal.CoroutineStackFrame coroutineStackFrame) {
        kotlin.Pair a2 = a(e);
        java.lang.Throwable th = (java.lang.Throwable) a2.component1();
        java.lang.StackTraceElement[] stackTraceElementArr = (java.lang.StackTraceElement[]) a2.component2();
        java.lang.Throwable tryCopyException = kotlinx.coroutines.internal.ExceptionsConstuctorKt.tryCopyException(th);
        if (tryCopyException == null || !kotlin.jvm.internal.Intrinsics.areEqual(tryCopyException.getMessage(), th.getMessage())) {
            return e;
        }
        java.util.ArrayDeque<java.lang.StackTraceElement> c = c(coroutineStackFrame);
        if (c.isEmpty()) {
            return e;
        }
        if (th != e) {
            f(stackTraceElementArr, c);
        }
        return (E) b(th, tryCopyException, c);
    }

    public static final void initCause(@org.jetbrains.annotations.NotNull java.lang.Throwable th, @org.jetbrains.annotations.NotNull java.lang.Throwable th2) {
        th.initCause(th2);
    }

    public static final boolean isArtificial(@org.jetbrains.annotations.NotNull java.lang.StackTraceElement stackTraceElement) {
        return kotlin.text.StringsKt__StringsJVMKt.startsWith$default(stackTraceElement.getClassName(), "\b\b\b", false, 2, null);
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object recoverAndThrow(@org.jetbrains.annotations.NotNull java.lang.Throwable th, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        throw th;
    }

    @org.jetbrains.annotations.NotNull
    public static final <E extends java.lang.Throwable> E recoverStackTrace(@org.jetbrains.annotations.NotNull E e) {
        return e;
    }

    @org.jetbrains.annotations.NotNull
    public static final <E extends java.lang.Throwable> E recoverStackTrace(@org.jetbrains.annotations.NotNull E e, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        return e;
    }

    @org.jetbrains.annotations.NotNull
    public static final <E extends java.lang.Throwable> E unwrap(@org.jetbrains.annotations.NotNull E e) {
        return e;
    }

    @org.jetbrains.annotations.NotNull
    public static final <E extends java.lang.Throwable> E unwrapImpl(@org.jetbrains.annotations.NotNull E e) {
        E e2 = (E) e.getCause();
        if (e2 != null && kotlin.jvm.internal.Intrinsics.areEqual(e2.getClass(), e.getClass())) {
            java.lang.StackTraceElement[] stackTrace = e.getStackTrace();
            int length = stackTrace.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (isArtificial(stackTrace[i])) {
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                return e2;
            }
        }
        return e;
    }
}
