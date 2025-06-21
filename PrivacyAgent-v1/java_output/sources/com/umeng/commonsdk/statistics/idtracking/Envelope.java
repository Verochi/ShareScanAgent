package com.umeng.commonsdk.statistics.idtracking;

/* loaded from: classes19.dex */
public class Envelope {
    private static final java.lang.String dummyID1 = "1234567890987654321";
    private static final java.lang.String dummyID2 = "02:00:00:00:00:00";
    private byte[] identity;
    private java.lang.String mAddress;
    private byte[] mEntity;
    private int mLength;
    private int mTimestamp;
    private final byte[] SEED = {0, 0, 0, 0, 0, 0, 0, 0};
    private final int CODEX_ENCRYPT = 1;
    private final int CODEX_NORMAL = 0;
    private java.lang.String mVersion = "1.0";
    private byte[] mSignature = null;
    private byte[] mGuid = null;
    private byte[] mChecksum = null;
    private int mSerialNo = 0;
    private boolean encrypt = false;

    private Envelope(byte[] bArr, java.lang.String str, byte[] bArr2) throws java.lang.Exception {
        this.mAddress = null;
        this.mTimestamp = 0;
        this.mLength = 0;
        this.mEntity = null;
        this.identity = null;
        if (bArr == null || bArr.length == 0) {
            throw new java.lang.Exception("entity is null or empty");
        }
        this.mAddress = str;
        this.mLength = bArr.length;
        this.mEntity = com.umeng.commonsdk.statistics.common.b.a(bArr);
        this.mTimestamp = (int) (java.lang.System.currentTimeMillis() / 1000);
        this.identity = bArr2;
    }

    private byte[] genCheckSum() {
        return com.umeng.commonsdk.statistics.common.DataHelper.hash((com.umeng.commonsdk.statistics.common.DataHelper.toHexString(this.mSignature) + this.mSerialNo + this.mTimestamp + this.mLength + com.umeng.commonsdk.statistics.common.DataHelper.toHexString(this.mGuid)).getBytes());
    }

    public static com.umeng.commonsdk.statistics.idtracking.Envelope genEncryptEnvelope(android.content.Context context, java.lang.String str, byte[] bArr) {
        try {
            android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context);
            java.lang.String string = sharedPreferences.getString("signature", null);
            int i = sharedPreferences.getInt("serial", 1);
            com.umeng.commonsdk.statistics.idtracking.Envelope envelope = new com.umeng.commonsdk.statistics.idtracking.Envelope(bArr, str, "123456789098765432102:00:00:00:00:00".getBytes());
            envelope.setEncrypt(true);
            envelope.setSignature(string);
            envelope.setSerialNumber(i);
            envelope.seal();
            sharedPreferences.edit().putInt("serial", i + 1).putString("signature", envelope.getSignature()).commit();
            envelope.export(context);
            return envelope;
        } catch (java.lang.Exception e) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
            return null;
        }
    }

    public static com.umeng.commonsdk.statistics.idtracking.Envelope genEnvelope(android.content.Context context, java.lang.String str, byte[] bArr) {
        try {
            android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context);
            java.lang.String string = sharedPreferences.getString("signature", null);
            int i = sharedPreferences.getInt("serial", 1);
            com.umeng.commonsdk.statistics.idtracking.Envelope envelope = new com.umeng.commonsdk.statistics.idtracking.Envelope(bArr, str, "123456789098765432102:00:00:00:00:00".getBytes());
            envelope.setSignature(string);
            envelope.setSerialNumber(i);
            envelope.seal();
            sharedPreferences.edit().putInt("serial", i + 1).putString("signature", envelope.getSignature()).commit();
            envelope.export(context);
            return envelope;
        } catch (java.lang.Exception e) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
            return null;
        }
    }

    private byte[] genGuid(byte[] bArr, int i) {
        byte[] hash = com.umeng.commonsdk.statistics.common.DataHelper.hash(this.identity);
        byte[] hash2 = com.umeng.commonsdk.statistics.common.DataHelper.hash(this.mEntity);
        int length = hash.length;
        int i2 = length * 2;
        byte[] bArr2 = new byte[i2];
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * 2;
            bArr2[i4] = hash2[i3];
            bArr2[i4 + 1] = hash[i3];
        }
        for (int i5 = 0; i5 < 2; i5++) {
            bArr2[i5] = bArr[i5];
            bArr2[(i2 - i5) - 1] = bArr[(bArr.length - i5) - 1];
        }
        byte[] bArr3 = {(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) (i >>> 24)};
        for (int i6 = 0; i6 < i2; i6++) {
            bArr2[i6] = (byte) (bArr2[i6] ^ bArr3[i6 % 4]);
        }
        return bArr2;
    }

    private byte[] genSignature() {
        return genGuid(this.SEED, (int) (java.lang.System.currentTimeMillis() / 1000));
    }

    public static java.lang.String getSignature(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(context);
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("signature", null);
    }

    public void export(android.content.Context context) {
        java.lang.String str = this.mAddress;
        java.lang.String imprintProperty = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(context, com.umeng.analytics.pro.bo.g, null);
        java.lang.String hexString = com.umeng.commonsdk.statistics.common.DataHelper.toHexString(this.mSignature);
        byte[] bArr = new byte[16];
        java.lang.System.arraycopy(this.mSignature, 2, bArr, 0, 16);
        java.lang.String hexString2 = com.umeng.commonsdk.statistics.common.DataHelper.toHexString(com.umeng.commonsdk.statistics.common.DataHelper.hash(bArr));
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("appkey", str);
            if (imprintProperty != null) {
                jSONObject.put(com.umeng.analytics.pro.bo.g, imprintProperty);
            }
            jSONObject.put("signature", hexString);
            jSONObject.put("checksum", hexString2);
            java.io.File file = new java.io.File(context.getFilesDir(), com.umeng.analytics.pro.ay.b().b(com.umeng.analytics.pro.ay.b));
            if (!file.exists()) {
                file.mkdir();
            }
            com.umeng.commonsdk.statistics.common.HelperUtils.writeFile(new java.io.File(file, "exchangeIdentity.json"), jSONObject.toString());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("appkey", str);
            jSONObject2.put("channel", com.umeng.commonsdk.utils.UMUtils.getChannel(context));
            if (imprintProperty != null) {
                jSONObject2.put(com.umeng.analytics.pro.bo.g, com.umeng.commonsdk.statistics.common.HelperUtils.getUmengMD5(imprintProperty));
            }
            com.umeng.commonsdk.statistics.common.HelperUtils.writeFile(new java.io.File(context.getFilesDir(), com.umeng.analytics.pro.ay.b().b(com.umeng.analytics.pro.ay.h)), jSONObject2.toString());
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
    }

    public java.lang.String getSignature() {
        return com.umeng.commonsdk.statistics.common.DataHelper.toHexString(this.mSignature);
    }

    public void seal() {
        if (this.mSignature == null) {
            this.mSignature = genSignature();
        }
        if (this.encrypt) {
            byte[] bArr = new byte[16];
            try {
                java.lang.System.arraycopy(this.mSignature, 1, bArr, 0, 16);
                this.mEntity = com.umeng.commonsdk.statistics.common.DataHelper.encrypt(this.mEntity, bArr);
            } catch (java.lang.Exception unused) {
            }
        }
        this.mGuid = genGuid(this.mSignature, this.mTimestamp);
        this.mChecksum = genCheckSum();
    }

    public void setEncrypt(boolean z) {
        this.encrypt = z;
    }

    public void setSerialNumber(int i) {
        this.mSerialNo = i;
    }

    public void setSignature(java.lang.String str) {
        this.mSignature = com.umeng.commonsdk.statistics.common.DataHelper.reverseHexString(str);
    }

    public byte[] toBinary() {
        com.umeng.analytics.pro.bp bpVar = new com.umeng.analytics.pro.bp();
        bpVar.a(this.mVersion);
        bpVar.b(this.mAddress);
        bpVar.c(com.umeng.commonsdk.statistics.common.DataHelper.toHexString(this.mSignature));
        bpVar.a(this.mSerialNo);
        bpVar.b(this.mTimestamp);
        bpVar.c(this.mLength);
        bpVar.a(this.mEntity);
        bpVar.d(this.encrypt ? 1 : 0);
        bpVar.d(com.umeng.commonsdk.statistics.common.DataHelper.toHexString(this.mGuid));
        bpVar.e(com.umeng.commonsdk.statistics.common.DataHelper.toHexString(this.mChecksum));
        try {
            return new com.umeng.analytics.pro.cl().a(bpVar);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public java.lang.String toString() {
        return java.lang.String.format("version : %s\n", this.mVersion) + java.lang.String.format("address : %s\n", this.mAddress) + java.lang.String.format("signature : %s\n", com.umeng.commonsdk.statistics.common.DataHelper.toHexString(this.mSignature)) + java.lang.String.format("serial : %s\n", java.lang.Integer.valueOf(this.mSerialNo)) + java.lang.String.format("timestamp : %d\n", java.lang.Integer.valueOf(this.mTimestamp)) + java.lang.String.format("length : %d\n", java.lang.Integer.valueOf(this.mLength)) + java.lang.String.format("guid : %s\n", com.umeng.commonsdk.statistics.common.DataHelper.toHexString(this.mGuid)) + java.lang.String.format("checksum : %s ", com.umeng.commonsdk.statistics.common.DataHelper.toHexString(this.mChecksum)) + java.lang.String.format("codex : %d", java.lang.Integer.valueOf(this.encrypt ? 1 : 0));
    }
}
