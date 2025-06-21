package kotlin.io;

@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0001¨\u0006\u0005"}, d2 = {"Ljava/io/Closeable;", "", "cause", "", "closeFinally", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
@kotlin.jvm.JvmName(name = "CloseableKt")
/* loaded from: classes14.dex */
public final class CloseableKt {
    @kotlin.SinceKotlin(version = "1.1")
    @kotlin.PublishedApi
    public static final void closeFinally(@org.jetbrains.annotations.Nullable java.io.Closeable closeable, @org.jetbrains.annotations.Nullable java.lang.Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (java.lang.Throwable th2) {
                kotlin.ExceptionsKt__ExceptionsKt.addSuppressed(th, th2);
            }
        }
    }
}
