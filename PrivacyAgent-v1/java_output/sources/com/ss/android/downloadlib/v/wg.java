package com.ss.android.downloadlib.v;

/* loaded from: classes19.dex */
public class wg extends android.database.sqlite.SQLiteOpenHelper {
    static final java.lang.String[] vw = {"_id", com.bytedance.sdk.openadsdk.mediation.MediationConstant.EXTRA_ADID, com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.reqId, "time"};

    public wg(@androidx.annotation.Nullable android.content.Context context) {
        super(context, "click_event", (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS click_event(_id INTEGER PRIMARY KEY AUTOINCREMENT,ad_id INTEGER,req_id TEXT,time INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS click_event");
        onCreate(sQLiteDatabase);
    }
}
