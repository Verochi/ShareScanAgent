package org.jetbrains.annotations;

@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD})
@java.lang.annotation.Documented
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
/* loaded from: classes26.dex */
public @interface Contract {
    boolean pure() default false;

    java.lang.String value() default "";
}
