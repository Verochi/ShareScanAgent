package kotlin;

@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@kotlin.SinceKotlin(version = "1.3")
@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0087\u0002\u0018\u00002\u00020\u0001B\\\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003R\u0018\u0010\u0006\u001a\u00020\u0005X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0007¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0007¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\r\u001a\u00020\u0003X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\t8\u0007¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011R\u0018\u0010\f\u001a\u00020\tX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0019¨\u0006\u001e"}, d2 = {"Lkotlin/Metadata;", "", "kind", "", "metadataVersion", "", "bytecodeVersion", "data1", "", "", "data2", "extraString", "packageName", "extraInt", "bv$annotations", "()V", "bv", "()[I", com.anythink.expressad.foundation.g.a.N, "()[Ljava/lang/String;", com.anythink.expressad.foundation.g.a.O, "xi$annotations", "xi", "()I", "xs", "()Ljava/lang/String;", "k", com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_MV, "pn$annotations", "pn", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {kotlin.annotation.AnnotationTarget.CLASS})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(kotlin.annotation.AnnotationRetention.RUNTIME)
/* loaded from: classes14.dex */
public @interface Metadata {

    @kotlin.Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Bytecode version had no significant use in Kotlin metadata and it will be removed in a future version.")
        public static /* synthetic */ void bv$annotations() {
        }

        @kotlin.SinceKotlin(version = "1.2")
        public static /* synthetic */ void pn$annotations() {
        }

        @kotlin.SinceKotlin(version = "1.1")
        public static /* synthetic */ void xi$annotations() {
        }
    }

    @kotlin.jvm.JvmName(name = "bv")
    int[] bv() default {1, 0, 3};

    @kotlin.jvm.JvmName(name = com.anythink.expressad.foundation.g.a.N)
    java.lang.String[] d1() default {};

    @kotlin.jvm.JvmName(name = com.anythink.expressad.foundation.g.a.O)
    java.lang.String[] d2() default {};

    @kotlin.jvm.JvmName(name = "k")
    int k() default 1;

    @kotlin.jvm.JvmName(name = com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_MV)
    int[] mv() default {};

    @kotlin.jvm.JvmName(name = "pn")
    java.lang.String pn() default "";

    @kotlin.jvm.JvmName(name = "xi")
    int xi() default 0;

    @kotlin.jvm.JvmName(name = "xs")
    java.lang.String xs() default "";
}
