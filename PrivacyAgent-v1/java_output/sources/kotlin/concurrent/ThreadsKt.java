package kotlin.concurrent;

@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aJ\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000e"}, d2 = {"", com.anythink.expressad.foundation.d.c.bT, "isDaemon", "Ljava/lang/ClassLoader;", "contextClassLoader", "", "name", "", "priority", "Lkotlin/Function0;", "", "block", "Ljava/lang/Thread;", "thread", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
@kotlin.jvm.JvmName(name = "ThreadsKt")
/* loaded from: classes14.dex */
public final class ThreadsKt {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.Thread thread(boolean z, boolean z2, @org.jetbrains.annotations.Nullable java.lang.ClassLoader classLoader, @org.jetbrains.annotations.Nullable java.lang.String str, int i, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(block, "block");
        kotlin.concurrent.ThreadsKt$thread$thread$1 threadsKt$thread$thread$1 = new kotlin.concurrent.ThreadsKt$thread$thread$1(block);
        if (z2) {
            threadsKt$thread$thread$1.setDaemon(true);
        }
        if (i > 0) {
            threadsKt$thread$thread$1.setPriority(i);
        }
        if (str != null) {
            threadsKt$thread$thread$1.setName(str);
        }
        if (classLoader != null) {
            threadsKt$thread$thread$1.setContextClassLoader(classLoader);
        }
        if (z) {
            threadsKt$thread$thread$1.start();
        }
        return threadsKt$thread$thread$1;
    }
}
