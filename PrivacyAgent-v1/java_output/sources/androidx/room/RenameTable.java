package androidx.room;

@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@java.lang.annotation.Repeatable(androidx.room.RenameTable.Entries.class)
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface RenameTable {

    @java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
    public @interface Entries {
        androidx.room.RenameTable[] value();
    }

    java.lang.String fromTableName();

    java.lang.String toTableName();
}
