package com.bykv.vw.vw.vw.vw;

/* loaded from: classes.dex */
public class vw {
    public boolean a = false;
    public int b = -1;
    public java.lang.String c = null;
    public com.bykv.vk.openvk.api.proto.ValueSet d = null;

    /* renamed from: com.bykv.vw.vw.vw.vw.vw$vw, reason: collision with other inner class name */
    public static final class C0261vw implements com.bykv.vk.openvk.api.proto.Result {
        public final boolean a;
        public final int b;
        public final java.lang.String c;
        public final com.bykv.vk.openvk.api.proto.ValueSet d;

        public C0261vw(boolean z, int i, java.lang.String str, com.bykv.vk.openvk.api.proto.ValueSet valueSet) {
            this.a = z;
            this.b = i;
            this.c = str;
            this.d = valueSet;
        }

        public /* synthetic */ C0261vw(boolean z, int i, java.lang.String str, com.bykv.vk.openvk.api.proto.ValueSet valueSet, com.bykv.vw.vw.vw.vw.vw.AnonymousClass1 anonymousClass1) {
            this(z, i, str, valueSet);
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.b;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.a;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public java.lang.String message() {
            return this.c;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public com.bykv.vk.openvk.api.proto.ValueSet values() {
            return this.d;
        }
    }

    public static final com.bykv.vw.vw.vw.vw.vw vw() {
        return new com.bykv.vw.vw.vw.vw.vw();
    }

    public com.bykv.vw.vw.vw.vw.vw vw(int i) {
        this.b = i;
        return this;
    }

    public com.bykv.vw.vw.vw.vw.vw vw(com.bykv.vk.openvk.api.proto.ValueSet valueSet) {
        this.d = valueSet;
        return this;
    }

    public com.bykv.vw.vw.vw.vw.vw vw(java.lang.String str) {
        this.c = str;
        return this;
    }

    public com.bykv.vw.vw.vw.vw.vw vw(boolean z) {
        this.a = z;
        return this;
    }

    public com.bykv.vk.openvk.api.proto.Result wg() {
        boolean z = this.a;
        int i = this.b;
        java.lang.String str = this.c;
        com.bykv.vk.openvk.api.proto.ValueSet valueSet = this.d;
        if (valueSet == null) {
            valueSet = com.bykv.vw.vw.vw.vw.wg.vw().wg();
        }
        return new com.bykv.vw.vw.vw.vw.vw.C0261vw(z, i, str, valueSet, null);
    }
}
