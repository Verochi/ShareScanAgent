package com.huawei.secure.android.common.ssl.util;

/* loaded from: classes22.dex */
public class e extends android.os.AsyncTask<android.content.Context, java.lang.Integer, java.lang.Boolean> {
    public static final java.lang.String a = "e";

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public java.lang.Boolean doInBackground(android.content.Context... contextArr) {
        java.io.InputStream inputStream;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        try {
            inputStream = com.huawei.secure.android.common.ssl.util.BksUtil.getBksFromTss(contextArr[0]);
        } catch (java.lang.Exception e) {
            com.huawei.secure.android.common.ssl.util.g.b(a, "doInBackground: exception : " + e.getMessage());
            inputStream = null;
        }
        com.huawei.secure.android.common.ssl.util.g.a(a, "doInBackground: get bks from hms tss cost : " + (java.lang.System.currentTimeMillis() - currentTimeMillis) + " ms");
        if (inputStream == null) {
            return java.lang.Boolean.FALSE;
        }
        com.huawei.secure.android.common.ssl.util.f.a(inputStream);
        return java.lang.Boolean.TRUE;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(java.lang.Boolean bool) {
        if (bool.booleanValue()) {
            com.huawei.secure.android.common.ssl.util.g.c(a, "onPostExecute: upate done");
        } else {
            com.huawei.secure.android.common.ssl.util.g.b(a, "onPostExecute: upate failed");
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(java.lang.Integer... numArr) {
        com.huawei.secure.android.common.ssl.util.g.c(a, "onProgressUpdate");
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        com.huawei.secure.android.common.ssl.util.g.a(a, "onPreExecute");
    }
}
