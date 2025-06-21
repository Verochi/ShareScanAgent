package com.badlogic.gdx.graphics.profiling;

/* loaded from: classes12.dex */
public interface GLErrorListener {
    public static final com.badlogic.gdx.graphics.profiling.GLErrorListener LOGGING_LISTENER = new com.badlogic.gdx.graphics.profiling.GLErrorListener.AnonymousClass1();
    public static final com.badlogic.gdx.graphics.profiling.GLErrorListener THROWING_LISTENER = new com.badlogic.gdx.graphics.profiling.GLErrorListener.AnonymousClass2();

    /* renamed from: com.badlogic.gdx.graphics.profiling.GLErrorListener$1, reason: invalid class name */
    public class AnonymousClass1 implements com.badlogic.gdx.graphics.profiling.GLErrorListener {
        /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
        
            r2 = r2 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
        
            if (r2 >= r1.length) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
        
            r0 = r1[r2].getMethodName();
         */
        @Override // com.badlogic.gdx.graphics.profiling.GLErrorListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onError(int i) {
            java.lang.String str = null;
            try {
                java.lang.StackTraceElement[] stackTrace = java.lang.Thread.currentThread().getStackTrace();
                int i2 = 0;
                while (true) {
                    if (i2 >= stackTrace.length) {
                        break;
                    } else if ("check".equals(stackTrace[i2].getMethodName())) {
                        break;
                    } else {
                        i2++;
                    }
                }
            } catch (java.lang.Exception unused) {
            }
            if (str == null) {
                com.badlogic.gdx.Gdx.app.error("GLProfiler", "Error " + com.badlogic.gdx.graphics.profiling.GLProfiler.resolveErrorNumber(i) + " at: ", new java.lang.Exception());
                return;
            }
            com.badlogic.gdx.Gdx.app.error("GLProfiler", "Error " + com.badlogic.gdx.graphics.profiling.GLProfiler.resolveErrorNumber(i) + " from " + str);
        }
    }

    /* renamed from: com.badlogic.gdx.graphics.profiling.GLErrorListener$2, reason: invalid class name */
    public class AnonymousClass2 implements com.badlogic.gdx.graphics.profiling.GLErrorListener {
        @Override // com.badlogic.gdx.graphics.profiling.GLErrorListener
        public void onError(int i) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("GLProfiler: Got GL error " + com.badlogic.gdx.graphics.profiling.GLProfiler.resolveErrorNumber(i));
        }
    }

    void onError(int i);
}
