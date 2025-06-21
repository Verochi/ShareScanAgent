package com.umeng.commonsdk.statistics.noise;

/* loaded from: classes19.dex */
public class ABTest implements com.umeng.commonsdk.statistics.internal.d {
    private static com.umeng.commonsdk.statistics.noise.ABTest instance;
    private android.content.Context context;
    private boolean isInTest = false;
    private int mPolicy = -1;
    private int mInterval = -1;
    private int mGroup = -1;
    private float mProb13 = 0.0f;
    private float mProb07 = 0.0f;
    private java.lang.String mPoli = null;

    private ABTest(android.content.Context context, java.lang.String str, int i) {
        this.context = context;
        onExperimentChanged(str, i);
    }

    public static synchronized com.umeng.commonsdk.statistics.noise.ABTest getService(android.content.Context context) {
        com.umeng.commonsdk.statistics.noise.ABTest aBTest;
        synchronized (com.umeng.commonsdk.statistics.noise.ABTest.class) {
            if (instance == null) {
                instance = new com.umeng.commonsdk.statistics.noise.ABTest(context, com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(context, "client_test", null), java.lang.Integer.valueOf(com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(context, "test_report_interval", "0")).intValue());
            }
            aBTest = instance;
        }
        return aBTest;
    }

    private void parseFIXED(java.lang.String str) {
        int[] iArr;
        if (str == null) {
            return;
        }
        java.lang.String[] split = str.split("\\|");
        if (this.mProb13 > (split[2].equals("SIG13") ? java.lang.Float.valueOf(split[3]).floatValue() : 0.0f)) {
            this.isInTest = false;
            return;
        }
        int intValue = split[0].equals("FIXED") ? java.lang.Integer.valueOf(split[1]).intValue() : -1;
        if (split[4].equals("RPT")) {
            this.mPoli = "RPT";
            java.lang.String[] split2 = split[5].split(",");
            iArr = new int[split2.length];
            for (int i = 0; i < split2.length; i++) {
                iArr[i] = java.lang.Integer.valueOf(split2[i]).intValue();
            }
        } else {
            if (split[4].equals("DOM")) {
                this.mPoli = "DOM";
                this.isInTest = true;
                try {
                    java.lang.String[] split3 = split[5].split(",");
                    iArr = new int[split3.length];
                    for (int i2 = 0; i2 < split3.length; i2++) {
                        try {
                            iArr[i2] = java.lang.Integer.valueOf(split3[i2]).intValue();
                        } catch (java.lang.Exception unused) {
                        }
                    }
                } catch (java.lang.Exception unused2) {
                }
            }
            iArr = null;
        }
        if (intValue == -1) {
            this.isInTest = false;
            return;
        }
        this.isInTest = true;
        this.mGroup = intValue;
        if (iArr != null) {
            this.mPolicy = iArr[intValue - 1];
        }
    }

    private void parseSig7(java.lang.String str) {
        float[] fArr;
        if (str == null) {
            return;
        }
        java.lang.String[] split = str.split("\\|");
        float f = 0.0f;
        if (this.mProb13 > (split[2].equals("SIG13") ? java.lang.Float.valueOf(split[3]).floatValue() : 0.0f)) {
            this.isInTest = false;
            return;
        }
        int[] iArr = null;
        if (split[0].equals("SIG7")) {
            java.lang.String[] split2 = split[1].split(",");
            fArr = new float[split2.length];
            for (int i = 0; i < split2.length; i++) {
                fArr[i] = java.lang.Float.valueOf(split2[i]).floatValue();
            }
        } else {
            fArr = null;
        }
        if (split[4].equals("RPT")) {
            this.mPoli = "RPT";
            java.lang.String[] split3 = split[5].split(",");
            iArr = new int[split3.length];
            for (int i2 = 0; i2 < split3.length; i2++) {
                iArr[i2] = java.lang.Integer.valueOf(split3[i2]).intValue();
            }
        } else if (split[4].equals("DOM")) {
            this.isInTest = true;
            this.mPoli = "DOM";
            try {
                java.lang.String[] split4 = split[5].split(",");
                iArr = new int[split4.length];
                for (int i3 = 0; i3 < split4.length; i3++) {
                    iArr[i3] = java.lang.Integer.valueOf(split4[i3]).intValue();
                }
            } catch (java.lang.Exception unused) {
            }
        }
        int i4 = 0;
        while (true) {
            if (i4 >= fArr.length) {
                i4 = -1;
                break;
            }
            f += fArr[i4];
            if (this.mProb07 < f) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 == -1) {
            this.isInTest = false;
            return;
        }
        this.isInTest = true;
        this.mGroup = i4 + 1;
        if (iArr != null) {
            this.mPolicy = iArr[i4];
        }
    }

    private float prob(java.lang.String str, int i) {
        int i2 = i * 2;
        if (str == null) {
            return 0.0f;
        }
        return java.lang.Integer.valueOf(str.substring(i2, i2 + 5), 16).intValue() / 1048576.0f;
    }

    public static boolean validate(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        java.lang.String[] split = str.split("\\|");
        if (split.length != 6) {
            return false;
        }
        if (split[0].startsWith("SIG7") && split[1].split(",").length == split[5].split(",").length) {
            return true;
        }
        if (split[0].startsWith("FIXED")) {
            int length = split[5].split(",").length;
            int parseInt = java.lang.Integer.parseInt(split[1]);
            if (length >= parseInt && parseInt >= 1) {
                return true;
            }
        }
        return false;
    }

    public int getGroup() {
        return this.mGroup;
    }

    public java.lang.String getGroupInfo() {
        return !this.isInTest ? "error" : java.lang.String.valueOf(this.mGroup);
    }

    public int getTestInterval() {
        return this.mInterval;
    }

    public java.lang.String getTestName() {
        return this.mPoli;
    }

    public int getTestPolicy() {
        return this.mPolicy;
    }

    public boolean isInTest() {
        return this.isInTest;
    }

    public void onExperimentChanged(java.lang.String str, int i) {
        this.mInterval = i;
        java.lang.String signature = com.umeng.commonsdk.statistics.idtracking.Envelope.getSignature(this.context);
        if (android.text.TextUtils.isEmpty(signature) || android.text.TextUtils.isEmpty(str)) {
            this.isInTest = false;
            return;
        }
        try {
            this.mProb13 = prob(signature, 12);
            this.mProb07 = prob(signature, 6);
            if (str.startsWith("SIG7")) {
                parseSig7(str);
            } else if (str.startsWith("FIXED")) {
                parseFIXED(str);
            }
        } catch (java.lang.Exception e) {
            this.isInTest = false;
            com.umeng.commonsdk.statistics.common.MLog.e("v:" + str, e);
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.d
    public void onImprintChanged(com.umeng.commonsdk.statistics.idtracking.ImprintHandler.a aVar) {
        onExperimentChanged(aVar.a("client_test", null), java.lang.Integer.valueOf(aVar.a("test_report_interval", "0")).intValue());
    }

    public java.lang.String toString() {
        return " p13:" + this.mProb13 + " p07:" + this.mProb07 + " policy:" + this.mPolicy + " interval:" + this.mInterval;
    }
}
