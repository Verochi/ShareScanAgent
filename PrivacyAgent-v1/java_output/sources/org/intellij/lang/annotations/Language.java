package org.intellij.lang.annotations;

@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.LOCAL_VARIABLE, java.lang.annotation.ElementType.ANNOTATION_TYPE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
/* loaded from: classes26.dex */
public @interface Language {
    @org.jetbrains.annotations.NonNls
    java.lang.String prefix() default "";

    @org.jetbrains.annotations.NonNls
    java.lang.String suffix() default "";

    @org.jetbrains.annotations.NonNls
    java.lang.String value();
}
