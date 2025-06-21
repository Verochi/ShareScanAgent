package androidx.room;

@java.lang.annotation.Target({})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface ForeignKey {
    public static final int CASCADE = 5;
    public static final int NO_ACTION = 1;
    public static final int RESTRICT = 2;
    public static final int SET_DEFAULT = 4;
    public static final int SET_NULL = 3;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
    public @interface Action {
    }

    java.lang.String[] childColumns();

    boolean deferred() default false;

    java.lang.Class<?> entity();

    @androidx.room.ForeignKey.Action
    int onDelete() default 1;

    @androidx.room.ForeignKey.Action
    int onUpdate() default 1;

    java.lang.String[] parentColumns();
}
