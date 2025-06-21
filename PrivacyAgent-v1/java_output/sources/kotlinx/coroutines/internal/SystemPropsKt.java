package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"kotlinx/coroutines/internal/SystemPropsKt__SystemPropsKt", "kotlinx/coroutines/internal/SystemPropsKt__SystemProps_commonKt"}, k = 4, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class SystemPropsKt {
    public static final int getAVAILABLE_PROCESSORS() {
        return kotlinx.coroutines.internal.SystemPropsKt__SystemPropsKt.a();
    }

    public static final int systemProp(@org.jetbrains.annotations.NotNull java.lang.String str, int i, int i2, int i3) {
        return kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt.a(str, i, i2, i3);
    }

    public static final long systemProp(@org.jetbrains.annotations.NotNull java.lang.String str, long j, long j2, long j3) {
        return kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt.b(str, j, j2, j3);
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.String systemProp(@org.jetbrains.annotations.NotNull java.lang.String str) {
        return kotlinx.coroutines.internal.SystemPropsKt__SystemPropsKt.b(str);
    }

    public static final boolean systemProp(@org.jetbrains.annotations.NotNull java.lang.String str, boolean z) {
        return kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt.c(str, z);
    }
}
