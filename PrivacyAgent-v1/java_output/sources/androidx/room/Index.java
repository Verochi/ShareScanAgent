package androidx.room;

@java.lang.annotation.Target({})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface Index {
    java.lang.String name() default "";

    boolean unique() default false;

    java.lang.String[] value();
}
