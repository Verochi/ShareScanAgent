package org.intellij.lang.annotations;

@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.LOCAL_VARIABLE, java.lang.annotation.ElementType.ANNOTATION_TYPE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
@org.intellij.lang.annotations.Language("RegExp")
/* loaded from: classes26.dex */
public @interface RegExp {
    java.lang.String prefix() default "";

    java.lang.String suffix() default "";
}
