package org.greenrobot.eventbus;

@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD})
@java.lang.annotation.Documented
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/* loaded from: classes26.dex */
public @interface Subscribe {
    int priority() default 0;

    boolean sticky() default false;

    org.greenrobot.eventbus.ThreadMode threadMode() default org.greenrobot.eventbus.ThreadMode.POSTING;
}
