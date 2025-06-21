package androidx.room;

/* loaded from: classes.dex */
public class Room {
    private static final java.lang.String CURSOR_CONV_SUFFIX = "_CursorConverter";
    static final java.lang.String LOG_TAG = "ROOM";
    public static final java.lang.String MASTER_TABLE_NAME = "room_master_table";

    @java.lang.Deprecated
    public Room() {
    }

    @androidx.annotation.NonNull
    public static <T extends androidx.room.RoomDatabase> androidx.room.RoomDatabase.Builder<T> databaseBuilder(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.Class<T> cls, @androidx.annotation.NonNull java.lang.String str) {
        if (str == null || str.trim().length() == 0) {
            throw new java.lang.IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        return new androidx.room.RoomDatabase.Builder<>(context, cls, str);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static <T, C> T getGeneratedImplementation(@androidx.annotation.NonNull java.lang.Class<C> cls, @androidx.annotation.NonNull java.lang.String str) {
        java.lang.String str2;
        java.lang.String name = cls.getPackage().getName();
        java.lang.String canonicalName = cls.getCanonicalName();
        if (!name.isEmpty()) {
            canonicalName = canonicalName.substring(name.length() + 1);
        }
        java.lang.String str3 = canonicalName.replace('.', '_') + str;
        try {
            if (name.isEmpty()) {
                str2 = str3;
            } else {
                str2 = name + "." + str3;
            }
            return (T) java.lang.Class.forName(str2, true, cls.getClassLoader()).newInstance();
        } catch (java.lang.ClassNotFoundException unused) {
            throw new java.lang.RuntimeException("cannot find implementation for " + cls.getCanonicalName() + ". " + str3 + " does not exist");
        } catch (java.lang.IllegalAccessException unused2) {
            throw new java.lang.RuntimeException("Cannot access the constructor" + cls.getCanonicalName());
        } catch (java.lang.InstantiationException unused3) {
            throw new java.lang.RuntimeException("Failed to create an instance of " + cls.getCanonicalName());
        }
    }

    @androidx.annotation.NonNull
    public static <T extends androidx.room.RoomDatabase> androidx.room.RoomDatabase.Builder<T> inMemoryDatabaseBuilder(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.Class<T> cls) {
        return new androidx.room.RoomDatabase.Builder<>(context, cls, null);
    }
}
