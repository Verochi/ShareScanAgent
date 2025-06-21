package com.bumptech.glide.annotation;

@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface GlideOption {
    public static final int OVERRIDE_EXTEND = 1;
    public static final int OVERRIDE_NONE = 0;
    public static final int OVERRIDE_REPLACE = 2;

    boolean memoizeStaticMethod() default false;

    int override() default 0;

    boolean skipStaticMethod() default false;

    java.lang.String staticMethodName() default "";
}
