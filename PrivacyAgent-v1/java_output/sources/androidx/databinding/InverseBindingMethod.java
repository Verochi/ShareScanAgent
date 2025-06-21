package androidx.databinding;

@java.lang.annotation.Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
/* loaded from: classes.dex */
public @interface InverseBindingMethod {
    java.lang.String attribute();

    java.lang.String event() default "";

    java.lang.String method() default "";

    java.lang.Class type();
}
