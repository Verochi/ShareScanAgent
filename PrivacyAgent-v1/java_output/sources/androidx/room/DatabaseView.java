package androidx.room;

@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface DatabaseView {
    java.lang.String value() default "";

    java.lang.String viewName() default "";
}
