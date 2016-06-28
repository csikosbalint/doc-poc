package com.company.document.item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.company.document.element.api.Element;

public class Section {
    List<Section> section;
    List<Element> element;
    private String title;

    public Section(String title) {
        this.element = new ArrayList<Element>();
        this.section = new ArrayList<Section>();
        this.title = title;
    }

    @XmlAttribute
    public String getTitle() {
        return title;
    }

    @XmlElement
    public List<Element> getElement() {
        return element;
    }

    @XmlElement
    public List<Section> getSection() {
        return section;
    }

    public void addSubSections(Section... sections) {
        this.section.addAll(Arrays.asList(sections));
    }

    public void addElement(Element... elements) {
        this.element.addAll(Arrays.asList(elements));
    }
}
