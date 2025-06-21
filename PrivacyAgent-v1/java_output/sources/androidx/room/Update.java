package androidx.room;

@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface Update {
    java.lang.Class<?> entity() default java.lang.Object.class;

    @androidx.room.OnConflictStrategy
    int onConflict() default 3;
}
