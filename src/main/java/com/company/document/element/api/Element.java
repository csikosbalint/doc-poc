package com.company.document.element.api;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public abstract class Element {
    private String type;
    protected String value;
    private String options;

    @XmlAttribute
    public String getType() {
        return type();
    }

    @XmlValue
    protected String getValue() {
        return this.value + " | " + this.options;
    }

    protected String type() {
        return this.getClass().getCanonicalName();
    }

}
