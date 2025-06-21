package com.tanx.exposer.achieve;

/* loaded from: classes19.dex */
public class tanxc_if {
    public long a;
    public java.lang.String b;
    public java.lang.String c;
    public java.lang.String d;
    public com.tanx.exposer.achieve.AdMonitorType e;
    public java.lang.String f;
    public com.tanx.exposer.tanxc_if g;
    public final int h;
    public java.util.concurrent.atomic.AtomicInteger i;
    public long j;
    public java.lang.String k;
    public com.tanx.exposer.achieve.retry.AdMonitorRetryType l;

    public tanxc_if(android.database.Cursor cursor) {
        this.a = -1L;
        this.i = new java.util.concurrent.atomic.AtomicInteger(0);
        this.l = com.tanx.exposer.achieve.retry.AdMonitorRetryType.MEMORY;
        this.a = cursor.getLong(cursor.getColumnIndex("id"));
        this.e = com.tanx.exposer.achieve.AdMonitorType.valueOf(cursor.getString(cursor.getColumnIndex("monitor_type")));
        this.b = cursor.getString(cursor.getColumnIndex("monitor_url"));
        this.c = cursor.getString(cursor.getColumnIndex("monitor_original_url"));
        this.d = cursor.getString(cursor.getColumnIndex("monitor_url_host"));
        this.f = cursor.getString(cursor.getColumnIndex("monitor_url_hash"));
        this.i = new java.util.concurrent.atomic.AtomicInteger(cursor.getInt(cursor.getColumnIndex("retry_times")));
        this.h = cursor.getInt(cursor.getColumnIndex("max_retry_times"));
        this.k = cursor.getString(cursor.getColumnIndex("date"));
        this.j = cursor.getLong(cursor.getColumnIndex("expire_time"));
        java.lang.String string = cursor.getString(cursor.getColumnIndex("monitor_extra_params"));
        if (android.text.TextUtils.isEmpty(string)) {
            return;
        }
        try {
            this.g = new com.tanx.exposer.tanxc_if(string);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public tanxc_if(java.lang.String str, java.lang.String str2, com.tanx.exposer.achieve.AdMonitorType adMonitorType, java.lang.String str3, java.lang.String str4, int i) {
        this.a = -1L;
        this.i = new java.util.concurrent.atomic.AtomicInteger(0);
        this.l = com.tanx.exposer.achieve.retry.AdMonitorRetryType.MEMORY;
        this.b = str;
        this.c = str2;
        this.e = adMonitorType;
        this.d = str3;
        this.f = str4;
        this.h = i;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        this.k = com.tanx.exposer.tanxc_if.tanxc_for.tanxc_do(currentTimeMillis, "yyyy-MM-dd");
        this.j = currentTimeMillis + 86400000;
    }

    public long tanxc_byte() {
        return this.j;
    }

    public java.lang.String tanxc_case() {
        return this.k;
    }

    public int tanxc_char() {
        return this.h;
    }

    public long tanxc_do() {
        return this.a;
    }

    public void tanxc_do(long j) {
        this.a = j;
    }

    public void tanxc_do(com.tanx.exposer.achieve.retry.AdMonitorRetryType adMonitorRetryType) {
        this.l = adMonitorRetryType;
    }

    public void tanxc_do(com.tanx.exposer.tanxc_if tanxc_ifVar) {
        this.g = tanxc_ifVar;
    }

    public java.util.concurrent.atomic.AtomicInteger tanxc_else() {
        return this.i;
    }

    public java.lang.String tanxc_for() {
        return this.c;
    }

    public com.tanx.exposer.tanxc_if tanxc_goto() {
        return this.g;
    }

    public java.lang.String tanxc_if() {
        return this.b;
    }

    public com.tanx.exposer.achieve.AdMonitorType tanxc_int() {
        return this.e;
    }

    public com.tanx.exposer.achieve.retry.AdMonitorRetryType tanxc_long() {
        return this.l;
    }

    public java.lang.String tanxc_new() {
        return this.f;
    }

    public java.lang.String tanxc_try() {
        return this.d;
    }
}
