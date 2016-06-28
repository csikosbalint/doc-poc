package com.company.document.element;

import java.net.URI;

import com.company.document.element.api.Element;

public class Diagram extends Element {
    private String caption;

    public Diagram(URI image) {
        this.value = image.toASCIIString();
    }

    public Diagram(URI image, String caption) {
        this.value = image.toASCIIString();
        this.caption = caption;
    }

}
