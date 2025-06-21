package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class be extends com.xiaomi.push.bj.b<java.lang.Long> {
    private long a;
    private java.lang.String f;

    public be(java.lang.String str, java.util.List<java.lang.String> list, java.lang.String str2) {
        super(str, list);
        this.a = 0L;
        this.f = str2;
    }

    @Override // com.xiaomi.push.bj.a
    public final java.lang.Object a() {
        return java.lang.Long.valueOf(this.a);
    }

    @Override // com.xiaomi.push.bj.b
    public final /* synthetic */ java.lang.Long a(android.database.Cursor cursor) {
        return java.lang.Long.valueOf(cursor.getLong(0));
    }

    @Override // com.xiaomi.push.bj.b
    public final void a(android.content.Context context, java.util.List<java.lang.Long> list) {
        if (context == null || list == null || list.size() <= 0) {
            return;
        }
        this.a = list.get(0).longValue();
    }
}
