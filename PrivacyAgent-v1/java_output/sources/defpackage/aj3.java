package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class aj3 implements java.lang.Runnable {
    public final /* synthetic */ android.app.job.JobParameters n;
    public final /* synthetic */ android.os.Handler t;

    public /* synthetic */ aj3(android.app.job.JobParameters jobParameters, android.os.Handler handler) {
        this.n = jobParameters;
        this.t = handler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.weatherprovider.work.WeatherUpdateWorker.Companion.a(this.n, this.t);
    }
}
