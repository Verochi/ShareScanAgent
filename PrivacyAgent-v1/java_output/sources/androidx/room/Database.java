package androidx.room;

@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface Database {
    androidx.room.AutoMigration[] autoMigrations() default {};

    java.lang.Class<?>[] entities();

    boolean exportSchema() default true;

    int version();

    java.lang.Class<?>[] views() default {};
}
