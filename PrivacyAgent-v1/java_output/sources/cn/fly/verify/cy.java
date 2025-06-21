package cn.fly.verify;

/* loaded from: classes.dex */
public final class cy extends java.lang.RuntimeException {
    public cy(java.lang.String str, java.lang.Throwable th) {
        super(str, th);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(java.io.PrintStream printStream) {
        printStream.println("" + getMessage());
    }

    @Override // java.lang.Throwable
    public void printStackTrace(java.io.PrintWriter printWriter) {
        printWriter.println("" + getMessage());
    }
}
