package androidx.room;

@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface Relation {
    androidx.room.Junction associateBy() default @androidx.room.Junction(java.lang.Object.class);

    java.lang.Class<?> entity() default java.lang.Object.class;

    java.lang.String entityColumn();

    java.lang.String parentColumn();

    java.lang.String[] projection() default {};
}
