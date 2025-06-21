package androidx.room;

@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface OnConflictStrategy {
    public static final int ABORT = 3;

    @java.lang.Deprecated
    public static final int FAIL = 4;
    public static final int IGNORE = 5;
    public static final int REPLACE = 1;

    @java.lang.Deprecated
    public static final int ROLLBACK = 2;
}
