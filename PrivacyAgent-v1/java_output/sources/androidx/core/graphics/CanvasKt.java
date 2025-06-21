package androidx.core.graphics;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\n2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a0\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aD\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a&\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aN\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a:\u0010\u001c\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a:\u0010\u001d\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b¨\u0006\u001e"}, d2 = {"withClip", "", "Landroid/graphics/Canvas;", "clipPath", "Landroid/graphics/Path;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "clipRect", "Landroid/graphics/Rect;", "Landroid/graphics/RectF;", com.sensorsdata.sf.ui.view.UIProperty.left, "", com.sensorsdata.sf.ui.view.UIProperty.top, com.sensorsdata.sf.ui.view.UIProperty.right, com.sensorsdata.sf.ui.view.UIProperty.bottom, "", "withMatrix", "matrix", "Landroid/graphics/Matrix;", "withRotation", "degrees", "pivotX", "pivotY", "withSave", "withScale", "x", "y", "withSkew", "withTranslation", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class CanvasKt {
    public static final void withClip(@org.jetbrains.annotations.NotNull android.graphics.Canvas withClip, float f, float f2, float f3, float f4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.graphics.Canvas, kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(withClip, "$this$withClip");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        int save = withClip.save();
        withClip.clipRect(f, f2, f3, f4);
        try {
            block.invoke(withClip);
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            withClip.restoreToCount(save);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }

    public static final void withClip(@org.jetbrains.annotations.NotNull android.graphics.Canvas withClip, int i, int i2, int i3, int i4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.graphics.Canvas, kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(withClip, "$this$withClip");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        int save = withClip.save();
        withClip.clipRect(i, i2, i3, i4);
        try {
            block.invoke(withClip);
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            withClip.restoreToCount(save);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }

    public static final void withClip(@org.jetbrains.annotations.NotNull android.graphics.Canvas withClip, @org.jetbrains.annotations.NotNull android.graphics.Path clipPath, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.graphics.Canvas, kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(withClip, "$this$withClip");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(clipPath, "clipPath");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        int save = withClip.save();
        withClip.clipPath(clipPath);
        try {
            block.invoke(withClip);
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            withClip.restoreToCount(save);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }

    public static final void withClip(@org.jetbrains.annotations.NotNull android.graphics.Canvas withClip, @org.jetbrains.annotations.NotNull android.graphics.Rect clipRect, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.graphics.Canvas, kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(withClip, "$this$withClip");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(clipRect, "clipRect");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        int save = withClip.save();
        withClip.clipRect(clipRect);
        try {
            block.invoke(withClip);
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            withClip.restoreToCount(save);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }

    public static final void withClip(@org.jetbrains.annotations.NotNull android.graphics.Canvas withClip, @org.jetbrains.annotations.NotNull android.graphics.RectF clipRect, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.graphics.Canvas, kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(withClip, "$this$withClip");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(clipRect, "clipRect");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        int save = withClip.save();
        withClip.clipRect(clipRect);
        try {
            block.invoke(withClip);
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            withClip.restoreToCount(save);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }

    public static final void withMatrix(@org.jetbrains.annotations.NotNull android.graphics.Canvas withMatrix, @org.jetbrains.annotations.NotNull android.graphics.Matrix matrix, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.graphics.Canvas, kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(withMatrix, "$this$withMatrix");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(matrix, "matrix");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        int save = withMatrix.save();
        withMatrix.concat(matrix);
        try {
            block.invoke(withMatrix);
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            withMatrix.restoreToCount(save);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ void withMatrix$default(android.graphics.Canvas withMatrix, android.graphics.Matrix matrix, kotlin.jvm.functions.Function1 block, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            matrix = new android.graphics.Matrix();
        }
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(withMatrix, "$this$withMatrix");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(matrix, "matrix");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        int save = withMatrix.save();
        withMatrix.concat(matrix);
        try {
            block.invoke(withMatrix);
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            withMatrix.restoreToCount(save);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }

    public static final void withRotation(@org.jetbrains.annotations.NotNull android.graphics.Canvas withRotation, float f, float f2, float f3, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.graphics.Canvas, kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(withRotation, "$this$withRotation");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        int save = withRotation.save();
        withRotation.rotate(f, f2, f3);
        try {
            block.invoke(withRotation);
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            withRotation.restoreToCount(save);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ void withRotation$default(android.graphics.Canvas withRotation, float f, float f2, float f3, kotlin.jvm.functions.Function1 block, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(withRotation, "$this$withRotation");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        int save = withRotation.save();
        withRotation.rotate(f, f2, f3);
        try {
            block.invoke(withRotation);
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            withRotation.restoreToCount(save);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }

    public static final void withSave(@org.jetbrains.annotations.NotNull android.graphics.Canvas withSave, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.graphics.Canvas, kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(withSave, "$this$withSave");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        int save = withSave.save();
        try {
            block.invoke(withSave);
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            withSave.restoreToCount(save);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }

    public static final void withScale(@org.jetbrains.annotations.NotNull android.graphics.Canvas withScale, float f, float f2, float f3, float f4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.graphics.Canvas, kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(withScale, "$this$withScale");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        int save = withScale.save();
        withScale.scale(f, f2, f3, f4);
        try {
            block.invoke(withScale);
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            withScale.restoreToCount(save);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ void withScale$default(android.graphics.Canvas withScale, float f, float f2, float f3, float f4, kotlin.jvm.functions.Function1 block, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i & 8) != 0) {
            f4 = 0.0f;
        }
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(withScale, "$this$withScale");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        int save = withScale.save();
        withScale.scale(f, f2, f3, f4);
        try {
            block.invoke(withScale);
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            withScale.restoreToCount(save);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }

    public static final void withSkew(@org.jetbrains.annotations.NotNull android.graphics.Canvas withSkew, float f, float f2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.graphics.Canvas, kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(withSkew, "$this$withSkew");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        int save = withSkew.save();
        withSkew.skew(f, f2);
        try {
            block.invoke(withSkew);
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            withSkew.restoreToCount(save);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ void withSkew$default(android.graphics.Canvas withSkew, float f, float f2, kotlin.jvm.functions.Function1 block, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(withSkew, "$this$withSkew");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        int save = withSkew.save();
        withSkew.skew(f, f2);
        try {
            block.invoke(withSkew);
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            withSkew.restoreToCount(save);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }

    public static final void withTranslation(@org.jetbrains.annotations.NotNull android.graphics.Canvas withTranslation, float f, float f2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.graphics.Canvas, kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(withTranslation, "$this$withTranslation");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        int save = withTranslation.save();
        withTranslation.translate(f, f2);
        try {
            block.invoke(withTranslation);
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            withTranslation.restoreToCount(save);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ void withTranslation$default(android.graphics.Canvas withTranslation, float f, float f2, kotlin.jvm.functions.Function1 block, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(withTranslation, "$this$withTranslation");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        int save = withTranslation.save();
        withTranslation.translate(f, f2);
        try {
            block.invoke(withTranslation);
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            withTranslation.restoreToCount(save);
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }
}
