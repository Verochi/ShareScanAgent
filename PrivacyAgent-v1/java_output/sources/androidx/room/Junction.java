package androidx.room;

@java.lang.annotation.Target({})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface Junction {
    java.lang.String entityColumn() default "";

    java.lang.String parentColumn() default "";

    java.lang.Class<?> value();
}
