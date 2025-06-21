package com.bytedance.sdk.openadsdk;

@java.lang.annotation.Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
/* loaded from: classes22.dex */
public @interface StringDef {
    boolean flag() default false;

    java.lang.String[] value() default {};
}
