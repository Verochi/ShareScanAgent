package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class ba implements com.amap.api.services.interfaces.IInputtipsSearch {
    public android.content.Context a;
    public com.amap.api.services.help.Inputtips.InputtipsListener b;
    public android.os.Handler c;
    public com.amap.api.services.help.InputtipsQuery d;

    /* renamed from: com.amap.api.col.s.ba$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            obtainMessage.obj = com.amap.api.col.s.ba.this.b;
            obtainMessage.arg1 = 5;
            try {
                try {
                    com.amap.api.col.s.ba baVar = com.amap.api.col.s.ba.this;
                    java.util.ArrayList<? extends android.os.Parcelable> c = baVar.c(baVar.d);
                    android.os.Bundle bundle = new android.os.Bundle();
                    bundle.putParcelableArrayList("result", c);
                    obtainMessage.setData(bundle);
                    obtainMessage.what = 1000;
                } catch (com.amap.api.services.core.AMapException e) {
                    obtainMessage.what = e.getErrorCode();
                }
            } finally {
                com.amap.api.col.s.ba.this.c.sendMessage(obtainMessage);
            }
        }
    }

    public ba(android.content.Context context, com.amap.api.services.help.Inputtips.InputtipsListener inputtipsListener) throws com.amap.api.services.core.AMapException {
        com.amap.api.col.s.bs a = com.amap.api.col.s.br.a(context, com.amap.api.col.s.h.a(false));
        if (a.a != com.amap.api.col.s.br.c.SuccessCode) {
            java.lang.String str = a.b;
            throw new com.amap.api.services.core.AMapException(str, 1, str, a.a.a());
        }
        this.a = context.getApplicationContext();
        this.b = inputtipsListener;
        this.c = com.amap.api.col.s.s.a();
    }

    public ba(android.content.Context context, com.amap.api.services.help.InputtipsQuery inputtipsQuery) {
        this.a = context.getApplicationContext();
        this.d = inputtipsQuery;
        this.c = com.amap.api.col.s.s.a();
    }

    public final java.util.ArrayList<com.amap.api.services.help.Tip> c(com.amap.api.services.help.InputtipsQuery inputtipsQuery) throws com.amap.api.services.core.AMapException {
        try {
            com.amap.api.col.s.q.a(this.a);
            if (inputtipsQuery == null) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            if (inputtipsQuery.getKeyword() == null || inputtipsQuery.getKeyword().equals("")) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            return new com.amap.api.col.s.o(this.a, inputtipsQuery).b();
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "Inputtips", "requestInputtips");
            if (th instanceof com.amap.api.services.core.AMapException) {
                throw th;
            }
            return null;
        }
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final com.amap.api.services.help.InputtipsQuery getQuery() {
        return this.d;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final java.util.ArrayList<com.amap.api.services.help.Tip> requestInputtips() throws com.amap.api.services.core.AMapException {
        return c(this.d);
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtips(java.lang.String str, java.lang.String str2) throws com.amap.api.services.core.AMapException {
        requestInputtips(str, str2, null);
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtips(java.lang.String str, java.lang.String str2, java.lang.String str3) throws com.amap.api.services.core.AMapException {
        if (str == null || str.equals("")) {
            throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
        }
        com.amap.api.services.help.InputtipsQuery inputtipsQuery = new com.amap.api.services.help.InputtipsQuery(str, str2);
        this.d = inputtipsQuery;
        inputtipsQuery.setType(str3);
        requestInputtipsAsyn();
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtipsAsyn() {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.ba.AnonymousClass1());
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "Inputtips", "requestInputtipsAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void setInputtipsListener(com.amap.api.services.help.Inputtips.InputtipsListener inputtipsListener) {
        this.b = inputtipsListener;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void setQuery(com.amap.api.services.help.InputtipsQuery inputtipsQuery) {
        this.d = inputtipsQuery;
    }
}
