package com.google.gson.annotations;

@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.FIELD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/* loaded from: classes22.dex */
public @interface JsonAdapter {
    boolean nullSafe() default true;

    java.lang.Class<?> value();
}
