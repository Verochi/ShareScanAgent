package cn.fly.verify;

/* loaded from: classes.dex */
public class FlyVerify {
    public static final int SDK_VERSION_CODE = 130604;
    private static final java.lang.String SDK_VERSION_NAME = "13.6.4";
    public static final cn.fly.verify.p instance = cn.fly.verify.p.a();
    public static java.lang.String sdkTag = "FLYVERIFY";

    public static java.lang.String getVersion() {
        return "13.6.4";
    }

    public static void init(android.content.Context context, java.lang.String str, java.lang.String str2) {
        cn.fly.verify.ax.a(context, str, str2);
    }

    public static void preVerify(cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult> operationCallback) {
        instance.a(operationCallback);
    }

    public static void preVerify(cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult> operationCallback, boolean z) {
        instance.a(operationCallback, z);
    }

    public static void setPreVerifyTimeout(long j) {
        cn.fly.verify.ak.b = java.lang.Long.valueOf(j);
    }

    public static void submitPolicyGrantResult(cn.fly.verify.CustomController customController, boolean z) {
        cn.fly.verify.ax.a(customController, z);
    }

    public static void submitPolicyGrantResult(boolean z) {
        cn.fly.verify.ax.a(z);
    }

    public static void updateCustomController(cn.fly.verify.CustomController customController) {
        cn.fly.verify.ax.a(customController);
    }

    public static void verify(cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.VerifyResult> operationCallback) {
        instance.b(operationCallback);
    }
}
