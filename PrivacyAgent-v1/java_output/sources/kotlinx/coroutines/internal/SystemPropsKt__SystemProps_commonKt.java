package kotlinx.coroutines.internal;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a,\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0000\u001a,\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\t2\b\b\u0002\u0010\u0007\u001a\u00020\tH\u0000¨\u0006\u000b"}, d2 = {"", "propertyName", "", "defaultValue", "c", "", "minValue", "maxValue", "a", "", "b", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xs = "kotlinx/coroutines/internal/SystemPropsKt")
/* loaded from: classes16.dex */
public final /* synthetic */ class SystemPropsKt__SystemProps_commonKt {
    public static final int a(@org.jetbrains.annotations.NotNull java.lang.String str, int i, int i2, int i3) {
        return (int) kotlinx.coroutines.internal.SystemPropsKt.systemProp(str, i, i2, i3);
    }

    public static final long b(@org.jetbrains.annotations.NotNull java.lang.String str, long j, long j2, long j3) {
        java.lang.Long longOrNull;
        java.lang.String systemProp = kotlinx.coroutines.internal.SystemPropsKt.systemProp(str);
        if (systemProp == null) {
            return j;
        }
        longOrNull = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(systemProp);
        if (longOrNull == null) {
            throw new java.lang.IllegalStateException(("System property '" + str + "' has unrecognized value '" + systemProp + '\'').toString());
        }
        long longValue = longOrNull.longValue();
        boolean z = false;
        if (j2 <= longValue && longValue <= j3) {
            z = true;
        }
        if (z) {
            return longValue;
        }
        throw new java.lang.IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + longValue + '\'').toString());
    }

    public static final boolean c(@org.jetbrains.annotations.NotNull java.lang.String str, boolean z) {
        java.lang.String systemProp = kotlinx.coroutines.internal.SystemPropsKt.systemProp(str);
        return systemProp == null ? z : java.lang.Boolean.parseBoolean(systemProp);
    }

    public static /* synthetic */ int d(java.lang.String str, int i, int i2, int i3, int i4, java.lang.Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return kotlinx.coroutines.internal.SystemPropsKt.systemProp(str, i, i2, i3);
    }

    public static /* synthetic */ long e(java.lang.String str, long j, long j2, long j3, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return kotlinx.coroutines.internal.SystemPropsKt.systemProp(str, j, j4, j3);
    }
}
