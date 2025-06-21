package com.otaliastudios.opengl.program;

@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B!\b\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\u000b\u001a\u00020\b8\u0000X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0019"}, d2 = {"Lcom/otaliastudios/opengl/program/GlProgramLocation;", "", "", "a", "I", "getValue", "()I", "value", "Lkotlin/UInt;", "b", "getUvalue-pVg5ArA$egloo_metadata_release", "uvalue", "", "c", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "program", "Lcom/otaliastudios/opengl/program/GlProgramLocation$Type;", "type", "<init>", "(ILcom/otaliastudios/opengl/program/GlProgramLocation$Type;Ljava/lang/String;)V", "Companion", "Type", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public final class GlProgramLocation {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final com.otaliastudios.opengl.program.GlProgramLocation.Companion INSTANCE = new com.otaliastudios.opengl.program.GlProgramLocation.Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    public final int value;

    /* renamed from: b, reason: from kotlin metadata */
    public final int uvalue;

    /* renamed from: c, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String name;

    @kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, d2 = {"Lcom/otaliastudios/opengl/program/GlProgramLocation$Companion;", "", "()V", "getAttrib", "Lcom/otaliastudios/opengl/program/GlProgramLocation;", "program", "", "name", "", "getUniform", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @org.jetbrains.annotations.NotNull
        public final com.otaliastudios.opengl.program.GlProgramLocation getAttrib(int program, @org.jetbrains.annotations.NotNull java.lang.String name) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            return new com.otaliastudios.opengl.program.GlProgramLocation(program, com.otaliastudios.opengl.program.GlProgramLocation.Type.ATTRIB, name, null);
        }

        @org.jetbrains.annotations.NotNull
        public final com.otaliastudios.opengl.program.GlProgramLocation getUniform(int program, @org.jetbrains.annotations.NotNull java.lang.String name) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            return new com.otaliastudios.opengl.program.GlProgramLocation(program, com.otaliastudios.opengl.program.GlProgramLocation.Type.UNIFORM, name, null);
        }
    }

    @kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/otaliastudios/opengl/program/GlProgramLocation$Type;", "", "(Ljava/lang/String;I)V", "ATTRIB", "UNIFORM", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
    public enum Type {
        ATTRIB,
        UNIFORM
    }

    @kotlin.Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[com.otaliastudios.opengl.program.GlProgramLocation.Type.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[com.otaliastudios.opengl.program.GlProgramLocation.Type.ATTRIB.ordinal()] = 1;
            iArr[com.otaliastudios.opengl.program.GlProgramLocation.Type.UNIFORM.ordinal()] = 2;
        }
    }

    public GlProgramLocation(int i, com.otaliastudios.opengl.program.GlProgramLocation.Type type, java.lang.String str) {
        int glGetAttribLocation;
        this.name = str;
        int i2 = com.otaliastudios.opengl.program.GlProgramLocation.WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i2 == 1) {
            glGetAttribLocation = android.opengl.GLES20.glGetAttribLocation(kotlin.UInt.m191constructorimpl(i), str);
        } else {
            if (i2 != 2) {
                throw new kotlin.NoWhenBranchMatchedException();
            }
            glGetAttribLocation = android.opengl.GLES20.glGetUniformLocation(kotlin.UInt.m191constructorimpl(i), str);
        }
        this.value = glGetAttribLocation;
        com.otaliastudios.opengl.core.Egloo.checkGlProgramLocation(glGetAttribLocation, str);
        this.uvalue = kotlin.UInt.m191constructorimpl(glGetAttribLocation);
    }

    public /* synthetic */ GlProgramLocation(int i, com.otaliastudios.opengl.program.GlProgramLocation.Type type, java.lang.String str, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(i, type, str);
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return this.name;
    }

    /* renamed from: getUvalue-pVg5ArA$egloo_metadata_release, reason: not valid java name and from getter */
    public final int getUvalue() {
        return this.uvalue;
    }

    public final int getValue() {
        return this.value;
    }
}
