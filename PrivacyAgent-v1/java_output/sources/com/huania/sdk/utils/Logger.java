package com.huania.sdk.utils;

@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/huania/sdk/utils/Logger;", "", "", "text", "", "e", "i", "d", "v", "", "a", "Z", "getDebug", "()Z", "setDebug", "(Z)V", "debug", "<init>", "()V", "sdk_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class Logger {
    public static final com.huania.sdk.utils.Logger INSTANCE = new com.huania.sdk.utils.Logger();

    /* renamed from: a, reason: from kotlin metadata */
    public static boolean debug;

    public final void d(@org.jetbrains.annotations.NotNull java.lang.String text) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(text, "text");
        if (debug) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("----------");
            sb.append(text);
        }
    }

    public final void e(@org.jetbrains.annotations.NotNull java.lang.String text) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(text, "text");
        if (debug) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("----------");
            sb.append(text);
        }
    }

    public final boolean getDebug() {
        return debug;
    }

    public final void i(@org.jetbrains.annotations.NotNull java.lang.String text) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(text, "text");
        if (debug) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("----------");
            sb.append(text);
        }
    }

    public final void setDebug(boolean z) {
        debug = z;
    }

    public final void v(@org.jetbrains.annotations.NotNull java.lang.String text) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(text, "text");
        if (debug) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("----------");
            sb.append(text);
        }
    }
}
