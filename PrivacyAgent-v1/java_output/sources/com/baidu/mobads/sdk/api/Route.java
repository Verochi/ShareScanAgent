package com.baidu.mobads.sdk.api;

@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface Route {
    java.lang.String name() default "";

    java.lang.String path();
}
