package org.apache.tools.ant.input;

/* loaded from: classes25.dex */
public class MultipleChoiceInputRequest extends org.apache.tools.ant.input.InputRequest {
    public final java.util.LinkedHashSet<java.lang.String> d;

    public MultipleChoiceInputRequest(java.lang.String str, java.util.Vector<java.lang.String> vector) {
        super(str);
        if (vector == null) {
            throw new java.lang.IllegalArgumentException("choices must not be null");
        }
        this.d = new java.util.LinkedHashSet<>(vector);
    }

    public java.util.Vector<java.lang.String> getChoices() {
        return new java.util.Vector<>(this.d);
    }

    @Override // org.apache.tools.ant.input.InputRequest
    public boolean isInputValid() {
        return this.d.contains(getInput()) || ("".equals(getInput()) && getDefaultValue() != null);
    }
}
