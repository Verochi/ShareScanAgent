package androidx.core.os;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0086\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"trace", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "sectionName", "", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class TraceKt {
    public static final <T> T trace(@org.jetbrains.annotations.NotNull java.lang.String sectionName, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> block) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(sectionName, "sectionName");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        androidx.core.os.TraceCompat.beginSection(sectionName);
        try {
            return block.invoke();
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            androidx.core.os.TraceCompat.endSection();
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }
}
