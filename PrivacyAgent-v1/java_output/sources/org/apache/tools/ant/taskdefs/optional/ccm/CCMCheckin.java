package org.apache.tools.ant.taskdefs.optional.ccm;

/* loaded from: classes25.dex */
public class CCMCheckin extends org.apache.tools.ant.taskdefs.optional.ccm.CCMCheck {
    public CCMCheckin() {
        setCcmAction("ci");
        setComment("Checkin " + new java.util.Date());
    }
}
