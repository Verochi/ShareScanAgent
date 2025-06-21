package com.otaliastudios.opengl.buffer;

@androidx.annotation.RequiresApi(api = 21, value = 21)
@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/otaliastudios/opengl/buffer/GlShaderStorageBuffer;", "Lcom/otaliastudios/opengl/buffer/GlBuffer;", "", "index", "", "bind", "Lkotlin/Function0;", "block", "use", "c", "I", "getSize", "()I", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "d", "getUsage", "usage", "<init>", "(II)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public final class GlShaderStorageBuffer extends com.otaliastudios.opengl.buffer.GlBuffer {

    /* renamed from: c, reason: from kotlin metadata */
    public final int size;

    /* renamed from: d, reason: from kotlin metadata */
    public final int usage;

    @kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
    /* renamed from: com.otaliastudios.opengl.buffer.GlShaderStorageBuffer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<kotlin.Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ kotlin.Unit invoke() {
            invoke2();
            return kotlin.Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            android.opengl.GLES20.glBufferData(kotlin.UInt.m191constructorimpl(com.otaliastudios.opengl.buffer.GlShaderStorageBuffer.this.getCom.umeng.ccg.a.A java.lang.String()), com.otaliastudios.opengl.buffer.GlShaderStorageBuffer.this.getSize(), null, kotlin.UInt.m191constructorimpl(com.otaliastudios.opengl.buffer.GlShaderStorageBuffer.this.getUsage()));
            com.otaliastudios.opengl.core.Egloo.checkGlError("glBufferData");
        }
    }

    public GlShaderStorageBuffer(int i, int i2) {
        super(com.otaliastudios.opengl.internal.GlKt.getGL_SHADER_STORAGE_BUFFER(), null, 2, null);
        this.size = i;
        this.usage = i2;
        com.otaliastudios.opengl.core.GlBindableKt.use(this, new com.otaliastudios.opengl.buffer.GlShaderStorageBuffer.AnonymousClass1());
    }

    public final void bind(int index) {
        android.opengl.GLES30.glBindBufferBase(kotlin.UInt.m191constructorimpl(getCom.umeng.ccg.a.A java.lang.String()), kotlin.UInt.m191constructorimpl(index), kotlin.UInt.m191constructorimpl(getId()));
        com.otaliastudios.opengl.core.Egloo.checkGlError("glBindBufferBase");
    }

    public final int getSize() {
        return this.size;
    }

    public final int getUsage() {
        return this.usage;
    }

    public final void use(int index, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(block, "block");
        bind(index);
        block.invoke();
        unbind();
    }
}
