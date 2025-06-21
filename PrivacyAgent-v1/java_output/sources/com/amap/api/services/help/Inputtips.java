package com.amap.api.services.help;

/* loaded from: classes12.dex */
public final class Inputtips {
    private com.amap.api.services.interfaces.IInputtipsSearch a;

    public interface InputtipsListener {
        void onGetInputtips(java.util.List<com.amap.api.services.help.Tip> list, int i);
    }

    public Inputtips(android.content.Context context, com.amap.api.services.help.Inputtips.InputtipsListener inputtipsListener) throws com.amap.api.services.core.AMapException {
        this.a = null;
        try {
            this.a = new com.amap.api.col.s.ba(context, inputtipsListener);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            if (e instanceof com.amap.api.services.core.AMapException) {
                throw ((com.amap.api.services.core.AMapException) e);
            }
        }
    }

    public Inputtips(android.content.Context context, com.amap.api.services.help.InputtipsQuery inputtipsQuery) {
        this.a = null;
        try {
            this.a = new com.amap.api.col.s.ba(context, inputtipsQuery);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public final com.amap.api.services.help.InputtipsQuery getQuery() {
        com.amap.api.services.interfaces.IInputtipsSearch iInputtipsSearch = this.a;
        if (iInputtipsSearch != null) {
            return iInputtipsSearch.getQuery();
        }
        return null;
    }

    public final java.util.List<com.amap.api.services.help.Tip> requestInputtips() throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IInputtipsSearch iInputtipsSearch = this.a;
        if (iInputtipsSearch != null) {
            return iInputtipsSearch.requestInputtips();
        }
        return null;
    }

    public final void requestInputtips(java.lang.String str, java.lang.String str2) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IInputtipsSearch iInputtipsSearch = this.a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.requestInputtips(str, str2);
        }
    }

    public final void requestInputtips(java.lang.String str, java.lang.String str2, java.lang.String str3) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IInputtipsSearch iInputtipsSearch = this.a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.requestInputtips(str, str2, str3);
        }
    }

    public final void requestInputtipsAsyn() {
        com.amap.api.services.interfaces.IInputtipsSearch iInputtipsSearch = this.a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.requestInputtipsAsyn();
        }
    }

    public final void setInputtipsListener(com.amap.api.services.help.Inputtips.InputtipsListener inputtipsListener) {
        com.amap.api.services.interfaces.IInputtipsSearch iInputtipsSearch = this.a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.setInputtipsListener(inputtipsListener);
        }
    }

    public final void setQuery(com.amap.api.services.help.InputtipsQuery inputtipsQuery) {
        com.amap.api.services.interfaces.IInputtipsSearch iInputtipsSearch = this.a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.setQuery(inputtipsQuery);
        }
    }
}
