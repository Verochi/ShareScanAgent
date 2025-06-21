package com.xiaomi.push.a;

/* loaded from: classes19.dex */
public final class a extends android.database.sqlite.SQLiteOpenHelper {
    private static int b = 1;
    public static final java.lang.Object a = new java.lang.Object();
    private static final java.lang.String[] c = {"package_name", "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", "network_type", " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", "imsi", "TEXT"};

    public a(android.content.Context context) {
        super(context, "traffic.db", (android.database.sqlite.SQLiteDatabase.CursorFactory) null, b);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        synchronized (a) {
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
                int i = 0;
                while (true) {
                    java.lang.String[] strArr = c;
                    if (i >= strArr.length - 1) {
                        break;
                    }
                    if (i != 0) {
                        sb.append(",");
                    }
                    sb.append(strArr[i]);
                    sb.append(" ");
                    sb.append(strArr[i + 1]);
                    i += 2;
                }
                sb.append(");");
                sQLiteDatabase.execSQL(sb.toString());
            } catch (android.database.SQLException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
