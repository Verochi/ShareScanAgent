package com.tencent.mm.opensdk.openapi;

/* loaded from: classes19.dex */
class WXApiImplComm {
    private static final java.lang.String TAG = "MicroMsg.SDK.WXMsgImplComm";
    private static final java.lang.String WX_APP_SIGNATURE = "308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499";

    private WXApiImplComm() {
        throw new java.lang.RuntimeException(com.tencent.mm.opensdk.openapi.WXApiImplComm.class.getSimpleName() + " should not be instantiated");
    }

    public static boolean isIntentFromWx(android.content.Intent intent, java.lang.String str) {
        java.lang.String stringExtra;
        return (intent == null || (stringExtra = intent.getStringExtra(com.tencent.mm.opensdk.constants.ConstantsAPI.Token.WX_TOKEN_KEY)) == null || !stringExtra.equals(str)) ? false : true;
    }

    public static boolean validateAppSignature(android.content.Context context, android.content.pm.Signature[] signatureArr, boolean z) {
        java.lang.String str;
        if (z) {
            for (android.content.pm.Signature signature : signatureArr) {
                if (signature != null) {
                    java.lang.String lowerCase = signature.toCharsString().toLowerCase();
                    com.tencent.mm.opensdk.utils.Log.d(TAG, "check signature:" + lowerCase);
                    if (lowerCase.equals(WX_APP_SIGNATURE)) {
                        str = "pass";
                    }
                }
            }
            return false;
        }
        str = "ignore wechat app signature validation";
        com.tencent.mm.opensdk.utils.Log.d(TAG, str);
        return true;
    }

    public static boolean validateAppSignatureForPackage(android.content.Context context, java.lang.String str, boolean z) {
        if (z) {
            try {
                return validateAppSignature(context, context.getPackageManager().getPackageInfo(str, 64).signatures, z);
            } catch (android.content.pm.PackageManager.NameNotFoundException | java.lang.Exception unused) {
                return false;
            }
        }
        com.tencent.mm.opensdk.utils.Log.d(TAG, "ignore wechat app signature validation");
        return true;
    }
}
