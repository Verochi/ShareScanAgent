package androidx.core.graphics;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003\u001a\u001a\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u001a\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0001H\u0086\b¨\u0006\u0010"}, d2 = {"rotationMatrix", "Landroid/graphics/Matrix;", "degrees", "", "px", "py", "scaleMatrix", "sx", "sy", "translationMatrix", "tx", com.alipay.sdk.m.s.a.f86s, "times", com.anythink.expressad.d.a.b.dH, "values", "", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class MatrixKt {
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Matrix rotationMatrix(float f, float f2, float f3) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setRotate(f, f2, f3);
        return matrix;
    }

    public static /* synthetic */ android.graphics.Matrix rotationMatrix$default(float f, float f2, float f3, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        return rotationMatrix(f, f2, f3);
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Matrix scaleMatrix(float f, float f2) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setScale(f, f2);
        return matrix;
    }

    public static /* synthetic */ android.graphics.Matrix scaleMatrix$default(float f, float f2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        return scaleMatrix(f, f2);
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Matrix times(@org.jetbrains.annotations.NotNull android.graphics.Matrix times, @org.jetbrains.annotations.NotNull android.graphics.Matrix m) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(times, "$this$times");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(m, "m");
        android.graphics.Matrix matrix = new android.graphics.Matrix(times);
        matrix.preConcat(m);
        return matrix;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Matrix translationMatrix(float f, float f2) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setTranslate(f, f2);
        return matrix;
    }

    public static /* synthetic */ android.graphics.Matrix translationMatrix$default(float f, float f2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        return translationMatrix(f, f2);
    }

    @org.jetbrains.annotations.NotNull
    public static final float[] values(@org.jetbrains.annotations.NotNull android.graphics.Matrix values) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(values, "$this$values");
        float[] fArr = new float[9];
        values.getValues(fArr);
        return fArr;
    }
}
