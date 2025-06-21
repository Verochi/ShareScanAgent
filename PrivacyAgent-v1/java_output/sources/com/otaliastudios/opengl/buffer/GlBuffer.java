package com.otaliastudios.opengl.buffer;

@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000e\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/otaliastudios/opengl/buffer/GlBuffer;", "Lcom/otaliastudios/opengl/core/GlBindable;", "", "bind", "unbind", "release", "", "a", "I", "getId", "()I", "id", "b", "getTarget", com.umeng.ccg.a.A, "<init>", "(ILjava/lang/Integer;)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public class GlBuffer implements com.otaliastudios.opengl.core.GlBindable {

    /* renamed from: a, reason: from kotlin metadata */
    public final int id;

    /* renamed from: b, reason: from kotlin metadata */
    public final int target;

    public GlBuffer(int i, @org.jetbrains.annotations.Nullable java.lang.Integer num) {
        int m204getpVg5ArA;
        this.target = i;
        if (num != null) {
            m204getpVg5ArA = num.intValue();
        } else {
            int[] m198constructorimpl = kotlin.UIntArray.m198constructorimpl(1);
            int m205getSizeimpl = kotlin.UIntArray.m205getSizeimpl(m198constructorimpl);
            int[] iArr = new int[m205getSizeimpl];
            for (int i2 = 0; i2 < m205getSizeimpl; i2++) {
                iArr[i2] = kotlin.UIntArray.m204getpVg5ArA(m198constructorimpl, i2);
            }
            android.opengl.GLES20.glGenBuffers(1, iArr, 0);
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
            for (int i3 = 0; i3 < 1; i3++) {
                kotlin.UIntArray.m209setVXSXFK8(m198constructorimpl, i3, kotlin.UInt.m191constructorimpl(iArr[i3]));
            }
            com.otaliastudios.opengl.core.Egloo.checkGlError("glGenBuffers");
            m204getpVg5ArA = kotlin.UIntArray.m204getpVg5ArA(m198constructorimpl, 0);
        }
        this.id = m204getpVg5ArA;
    }

    public /* synthetic */ GlBuffer(int i, java.lang.Integer num, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : num);
    }

    @Override // com.otaliastudios.opengl.core.GlBindable
    public void bind() {
        android.opengl.GLES20.glBindBuffer(kotlin.UInt.m191constructorimpl(this.target), kotlin.UInt.m191constructorimpl(this.id));
    }

    public final int getId() {
        return this.id;
    }

    public final int getTarget() {
        return this.target;
    }

    public final void release() {
        int[] iArr = {kotlin.UInt.m191constructorimpl(this.id)};
        int m205getSizeimpl = kotlin.UIntArray.m205getSizeimpl(iArr);
        int[] iArr2 = new int[m205getSizeimpl];
        for (int i = 0; i < m205getSizeimpl; i++) {
            iArr2[i] = kotlin.UIntArray.m204getpVg5ArA(iArr, i);
        }
        android.opengl.GLES20.glDeleteBuffers(1, iArr2, 0);
        kotlin.Unit unit = kotlin.Unit.INSTANCE;
        for (int i2 = 0; i2 < 1; i2++) {
            kotlin.UIntArray.m209setVXSXFK8(iArr, i2, kotlin.UInt.m191constructorimpl(iArr2[i2]));
        }
    }

    @Override // com.otaliastudios.opengl.core.GlBindable
    public void unbind() {
        android.opengl.GLES20.glBindBuffer(kotlin.UInt.m191constructorimpl(this.target), 0);
    }
}
