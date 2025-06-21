package androidx.databinding;

@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.ANNOTATION_TYPE})
/* loaded from: classes.dex */
public @interface InverseBindingAdapter {
    java.lang.String attribute();

    java.lang.String event() default "";
}
