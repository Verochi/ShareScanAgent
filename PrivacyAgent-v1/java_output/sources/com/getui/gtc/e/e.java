package com.getui.gtc.e;

/* loaded from: classes22.dex */
public class e extends com.getui.gtc.base.db.AbstractTable {
    @Override // com.getui.gtc.base.db.AbstractTable
    public java.lang.String createSql() {
        return "create table if not exists t(_id integer primary key autoincrement, s bigint, r bigint)";
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public java.lang.String getTableName() {
        return "t";
    }
}
