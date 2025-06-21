package io.reactivex.annotations;

@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.TYPE})
@java.lang.annotation.Documented
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/* loaded from: classes9.dex */
public @interface BackpressureSupport {
    io.reactivex.annotations.BackpressureKind value();
}
