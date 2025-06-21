package com.bumptech.glide.annotation.compiler;

@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
/* loaded from: classes.dex */
@interface Index {
    java.lang.String[] extensions() default {};

    java.lang.String[] modules() default {};
}
