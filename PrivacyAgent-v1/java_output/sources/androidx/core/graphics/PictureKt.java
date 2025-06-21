package androidx.core.graphics;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0086\b¨\u0006\n"}, d2 = {com.aliyun.vod.log.core.AliyunLogCommon.SubModule.RECORD, "Landroid/graphics/Picture;", "width", "", "height", "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class PictureKt {
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Picture record(@org.jetbrains.annotations.NotNull android.graphics.Picture record, int i, int i2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.graphics.Canvas, kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(record, "$this$record");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        android.graphics.Canvas c = record.beginRecording(i, i2);
        try {
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(c, "c");
            block.invoke(c);
            return record;
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            record.endRecording();
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }
}
