package androidx.room.migration;

/* loaded from: classes.dex */
public abstract class Migration {
    public final int endVersion;
    public final int startVersion;

    public Migration(int i, int i2) {
        this.startVersion = i;
        this.endVersion = i2;
    }

    public abstract void migrate(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase);
}
