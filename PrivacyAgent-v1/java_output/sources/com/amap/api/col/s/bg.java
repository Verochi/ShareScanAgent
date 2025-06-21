package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class bg implements com.amap.api.services.interfaces.IWeatherSearch {
    public android.content.Context a;
    public com.amap.api.services.weather.WeatherSearchQuery b;
    public com.amap.api.services.weather.WeatherSearch.OnWeatherSearchListener c;
    public com.amap.api.services.weather.LocalWeatherLiveResult d;
    public com.amap.api.services.weather.LocalWeatherForecastResult e;
    public android.os.Handler f;

    /* renamed from: com.amap.api.col.s.bg$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            obtainMessage.arg1 = 13;
            android.os.Bundle bundle = new android.os.Bundle();
            if (com.amap.api.col.s.bg.this.b == null) {
                try {
                    throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
                } catch (com.amap.api.services.core.AMapException e) {
                    com.amap.api.col.s.i.a(e, "WeatherSearch", "searchWeatherAsyn");
                    return;
                }
            }
            if (com.amap.api.col.s.bg.this.b.getType() == 1) {
                try {
                    try {
                        com.amap.api.col.s.bg bgVar = com.amap.api.col.s.bg.this;
                        bgVar.d = bgVar.b();
                        bundle.putInt("errorCode", 1000);
                        return;
                    } finally {
                        com.amap.api.col.s.s.l lVar = new com.amap.api.col.s.s.l();
                        obtainMessage.what = 1301;
                        lVar.b = com.amap.api.col.s.bg.this.c;
                        lVar.a = com.amap.api.col.s.bg.this.d;
                        obtainMessage.obj = lVar;
                        obtainMessage.setData(bundle);
                        com.amap.api.col.s.bg.this.f.sendMessage(obtainMessage);
                    }
                } catch (com.amap.api.services.core.AMapException e2) {
                    bundle.putInt("errorCode", e2.getErrorCode());
                    com.amap.api.col.s.i.a(e2, "WeatherSearch", "searchWeatherAsyn");
                    return;
                } catch (java.lang.Throwable th) {
                    com.amap.api.col.s.i.a(th, "WeatherSearch", "searchWeatherAnsyThrowable");
                    return;
                }
            }
            if (com.amap.api.col.s.bg.this.b.getType() == 2) {
                try {
                    try {
                        com.amap.api.col.s.bg bgVar2 = com.amap.api.col.s.bg.this;
                        bgVar2.e = bgVar2.e();
                        bundle.putInt("errorCode", 1000);
                    } finally {
                        com.amap.api.col.s.s.k kVar = new com.amap.api.col.s.s.k();
                        obtainMessage.what = 1302;
                        kVar.b = com.amap.api.col.s.bg.this.c;
                        kVar.a = com.amap.api.col.s.bg.this.e;
                        obtainMessage.obj = kVar;
                        obtainMessage.setData(bundle);
                        com.amap.api.col.s.bg.this.f.sendMessage(obtainMessage);
                    }
                } catch (com.amap.api.services.core.AMapException e3) {
                    bundle.putInt("errorCode", e3.getErrorCode());
                    com.amap.api.col.s.i.a(e3, "WeatherSearch", "searchWeatherAsyn");
                } catch (java.lang.Throwable th2) {
                    com.amap.api.col.s.i.a(th2, "WeatherSearch", "searchWeatherAnsyThrowable");
                }
            }
        }
    }

    public bg(android.content.Context context) throws com.amap.api.services.core.AMapException {
        this.f = null;
        com.amap.api.col.s.bs a = com.amap.api.col.s.br.a(context, com.amap.api.col.s.h.a(false));
        if (a.a != com.amap.api.col.s.br.c.SuccessCode) {
            java.lang.String str = a.b;
            throw new com.amap.api.services.core.AMapException(str, 1, str, a.a.a());
        }
        this.a = context.getApplicationContext();
        this.f = com.amap.api.col.s.s.a();
    }

    public final com.amap.api.services.weather.LocalWeatherLiveResult b() throws com.amap.api.services.core.AMapException {
        com.amap.api.col.s.q.a(this.a);
        com.amap.api.services.weather.WeatherSearchQuery weatherSearchQuery = this.b;
        if (weatherSearchQuery == null) {
            throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
        }
        com.amap.api.col.s.ar arVar = new com.amap.api.col.s.ar(this.a, weatherSearchQuery);
        return com.amap.api.services.weather.LocalWeatherLiveResult.createPagedResult(arVar.c_(), arVar.b());
    }

    public final com.amap.api.services.weather.LocalWeatherForecastResult e() throws com.amap.api.services.core.AMapException {
        com.amap.api.col.s.q.a(this.a);
        com.amap.api.services.weather.WeatherSearchQuery weatherSearchQuery = this.b;
        if (weatherSearchQuery == null) {
            throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
        }
        com.amap.api.col.s.aq aqVar = new com.amap.api.col.s.aq(this.a, weatherSearchQuery);
        return com.amap.api.services.weather.LocalWeatherForecastResult.createPagedResult(aqVar.c_(), aqVar.b());
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final com.amap.api.services.weather.WeatherSearchQuery getQuery() {
        return this.b;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void searchWeatherAsyn() {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.bg.AnonymousClass1());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void setOnWeatherSearchListener(com.amap.api.services.weather.WeatherSearch.OnWeatherSearchListener onWeatherSearchListener) {
        this.c = onWeatherSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void setQuery(com.amap.api.services.weather.WeatherSearchQuery weatherSearchQuery) {
        this.b = weatherSearchQuery;
    }
}
