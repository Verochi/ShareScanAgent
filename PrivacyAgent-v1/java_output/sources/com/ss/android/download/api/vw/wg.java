package com.ss.android.download.api.vw;

/* loaded from: classes19.dex */
public class wg implements com.ss.android.download.api.config.x {
    private com.ss.android.download.api.config.q vw;

    @Override // com.ss.android.download.api.config.x
    public void vw(@androidx.annotation.NonNull android.app.Activity activity, int i, @androidx.annotation.NonNull java.lang.String[] strArr, @androidx.annotation.NonNull int[] iArr) {
        com.ss.android.download.api.config.q qVar;
        if (iArr.length <= 0 || (qVar = this.vw) == null) {
            return;
        }
        int i2 = iArr[0];
        if (i2 == -1) {
            qVar.vw(strArr[0]);
        } else if (i2 == 0) {
            qVar.vw();
        }
    }

    @Override // com.ss.android.download.api.config.x
    public void vw(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull java.lang.String[] strArr, com.ss.android.download.api.config.q qVar) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            this.vw = qVar;
            activity.requestPermissions(strArr, 1);
        } else if (qVar != null) {
            qVar.vw();
        }
    }

    @Override // com.ss.android.download.api.config.x
    public boolean vw(@androidx.annotation.Nullable android.content.Context context, @androidx.annotation.NonNull java.lang.String str) {
        return context != null && androidx.core.content.ContextCompat.checkSelfPermission(context, str) == 0;
    }
}
