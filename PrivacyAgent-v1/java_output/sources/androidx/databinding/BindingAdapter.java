package androidx.databinding;

@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD})
/* loaded from: classes.dex */
public @interface BindingAdapter {
    boolean requireAll() default true;

    java.lang.String[] value();
}
