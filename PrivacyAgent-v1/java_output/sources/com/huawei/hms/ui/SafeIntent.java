package com.huawei.hms.ui;

/* loaded from: classes22.dex */
public class SafeIntent extends android.content.Intent {
    public SafeIntent(android.content.Intent intent) {
        super(intent == null ? new android.content.Intent() : intent);
    }

    @Override // android.content.Intent
    public java.lang.String getAction() {
        try {
            return super.getAction();
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    @Override // android.content.Intent
    public boolean[] getBooleanArrayExtra(java.lang.String str) {
        try {
            return super.getBooleanArrayExtra(str);
        } catch (java.lang.Exception unused) {
            return new boolean[0];
        }
    }

    @Override // android.content.Intent
    public boolean getBooleanExtra(java.lang.String str, boolean z) {
        try {
            return super.getBooleanExtra(str, z);
        } catch (java.lang.Exception unused) {
            return z;
        }
    }

    @Override // android.content.Intent
    public android.os.Bundle getBundleExtra(java.lang.String str) {
        try {
            return super.getBundleExtra(str);
        } catch (java.lang.Exception unused) {
            return new android.os.Bundle();
        }
    }

    @Override // android.content.Intent
    public byte[] getByteArrayExtra(java.lang.String str) {
        try {
            return super.getByteArrayExtra(str);
        } catch (java.lang.Exception unused) {
            return new byte[0];
        }
    }

    @Override // android.content.Intent
    public byte getByteExtra(java.lang.String str, byte b) {
        try {
            return super.getByteExtra(str, b);
        } catch (java.lang.Exception unused) {
            return b;
        }
    }

    @Override // android.content.Intent
    public char[] getCharArrayExtra(java.lang.String str) {
        try {
            return super.getCharArrayExtra(str);
        } catch (java.lang.Exception unused) {
            return new char[0];
        }
    }

    @Override // android.content.Intent
    public char getCharExtra(java.lang.String str, char c) {
        try {
            return super.getCharExtra(str, c);
        } catch (java.lang.Exception unused) {
            return c;
        }
    }

    @Override // android.content.Intent
    public java.lang.CharSequence[] getCharSequenceArrayExtra(java.lang.String str) {
        try {
            return super.getCharSequenceArrayExtra(str);
        } catch (java.lang.Exception unused) {
            return new java.lang.CharSequence[0];
        }
    }

    @Override // android.content.Intent
    public java.util.ArrayList<java.lang.CharSequence> getCharSequenceArrayListExtra(java.lang.String str) {
        try {
            return super.getCharSequenceArrayListExtra(str);
        } catch (java.lang.Exception unused) {
            return new java.util.ArrayList<>();
        }
    }

    @Override // android.content.Intent
    public java.lang.CharSequence getCharSequenceExtra(java.lang.String str) {
        try {
            return super.getCharSequenceExtra(str);
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    @Override // android.content.Intent
    public double[] getDoubleArrayExtra(java.lang.String str) {
        try {
            return super.getDoubleArrayExtra(str);
        } catch (java.lang.Exception unused) {
            return new double[0];
        }
    }

    @Override // android.content.Intent
    public double getDoubleExtra(java.lang.String str, double d) {
        try {
            return super.getDoubleExtra(str, d);
        } catch (java.lang.Exception unused) {
            return d;
        }
    }

    @Override // android.content.Intent
    public android.os.Bundle getExtras() {
        try {
            return super.getExtras();
        } catch (java.lang.Exception unused) {
            return new android.os.Bundle();
        }
    }

    @Override // android.content.Intent
    public float[] getFloatArrayExtra(java.lang.String str) {
        try {
            return super.getFloatArrayExtra(str);
        } catch (java.lang.Exception unused) {
            return new float[0];
        }
    }

    @Override // android.content.Intent
    public float getFloatExtra(java.lang.String str, float f) {
        try {
            return super.getFloatExtra(str, f);
        } catch (java.lang.Exception unused) {
            return f;
        }
    }

    @Override // android.content.Intent
    public int[] getIntArrayExtra(java.lang.String str) {
        try {
            return super.getIntArrayExtra(str);
        } catch (java.lang.Exception unused) {
            return new int[0];
        }
    }

    @Override // android.content.Intent
    public int getIntExtra(java.lang.String str, int i) {
        try {
            return super.getIntExtra(str, i);
        } catch (java.lang.Exception unused) {
            return i;
        }
    }

    @Override // android.content.Intent
    public java.util.ArrayList<java.lang.Integer> getIntegerArrayListExtra(java.lang.String str) {
        try {
            return super.getIntegerArrayListExtra(str);
        } catch (java.lang.Exception unused) {
            return new java.util.ArrayList<>();
        }
    }

    @Override // android.content.Intent
    public long[] getLongArrayExtra(java.lang.String str) {
        try {
            return super.getLongArrayExtra(str);
        } catch (java.lang.Exception unused) {
            return new long[0];
        }
    }

    @Override // android.content.Intent
    public long getLongExtra(java.lang.String str, long j) {
        try {
            return super.getLongExtra(str, j);
        } catch (java.lang.Exception unused) {
            return j;
        }
    }

    @Override // android.content.Intent
    public android.os.Parcelable[] getParcelableArrayExtra(java.lang.String str) {
        try {
            return super.getParcelableArrayExtra(str);
        } catch (java.lang.Exception unused) {
            return new android.os.Parcelable[0];
        }
    }

    @Override // android.content.Intent
    public <T extends android.os.Parcelable> java.util.ArrayList<T> getParcelableArrayListExtra(java.lang.String str) {
        try {
            return super.getParcelableArrayListExtra(str);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    @Override // android.content.Intent
    public <T extends android.os.Parcelable> T getParcelableExtra(java.lang.String str) {
        try {
            return (T) super.getParcelableExtra(str);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    @Override // android.content.Intent
    public java.io.Serializable getSerializableExtra(java.lang.String str) {
        try {
            return super.getSerializableExtra(str);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    @Override // android.content.Intent
    public short[] getShortArrayExtra(java.lang.String str) {
        try {
            return super.getShortArrayExtra(str);
        } catch (java.lang.Exception unused) {
            return new short[0];
        }
    }

    @Override // android.content.Intent
    public short getShortExtra(java.lang.String str, short s2) {
        try {
            return super.getShortExtra(str, s2);
        } catch (java.lang.Exception unused) {
            return s2;
        }
    }

    @Override // android.content.Intent
    public java.lang.String[] getStringArrayExtra(java.lang.String str) {
        try {
            return super.getStringArrayExtra(str);
        } catch (java.lang.Exception unused) {
            return new java.lang.String[0];
        }
    }

    @Override // android.content.Intent
    public java.util.ArrayList<java.lang.String> getStringArrayListExtra(java.lang.String str) {
        try {
            return super.getStringArrayListExtra(str);
        } catch (java.lang.Exception unused) {
            return new java.util.ArrayList<>();
        }
    }

    @Override // android.content.Intent
    public java.lang.String getStringExtra(java.lang.String str) {
        try {
            return super.getStringExtra(str);
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    @Override // android.content.Intent
    public boolean hasExtra(java.lang.String str) {
        try {
            return super.hasExtra(str);
        } catch (java.lang.Exception unused) {
            return false;
        }
    }
}
