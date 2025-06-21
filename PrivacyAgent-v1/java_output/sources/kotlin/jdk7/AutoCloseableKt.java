package kotlin.jdk7;

@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0001¨\u0006\u0005"}, d2 = {"Ljava/lang/AutoCloseable;", "", "cause", "", "closeFinally", "kotlin-stdlib-jdk7"}, k = 2, mv = {1, 7, 1}, pn = "kotlin")
@kotlin.jvm.JvmName(name = "AutoCloseableKt")
/* loaded from: classes14.dex */
public final class AutoCloseableKt {
    @kotlin.SinceKotlin(version = "1.2")
    @kotlin.PublishedApi
    public static final void closeFinally(@org.jetbrains.annotations.Nullable java.lang.AutoCloseable autoCloseable, @org.jetbrains.annotations.Nullable java.lang.Throwable th) {
        if (autoCloseable != null) {
            if (th == null) {
                autoCloseable.close();
                return;
            }
            try {
                autoCloseable.close();
            } catch (java.lang.Throwable th2) {
                kotlin.ExceptionsKt__ExceptionsKt.addSuppressed(th, th2);
            }
        }
    }
}
