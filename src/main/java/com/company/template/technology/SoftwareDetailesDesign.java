package com.company.template.technology;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;

import com.company.document.element.Paragraph;
import com.company.document.item.Section;

@XmlTransient
public abstract class SoftwareDetailesDesign {
    private int sso;
    private String optionalNote;
    private List<String> module;
    private String title;
    private Section introduction;
    private Section introPurpose;
    private Section introScope;
    private SystemArchitectureDesign parent;

    public SoftwareDetailesDesign() {
        this.parent = setParent();
    }

    protected abstract SystemArchitectureDesign setParent();
    @XmlAttribute
    public String getParent() {
        return parent.getClass().getCanonicalName();
    }

    @XmlAttribute
    public String getTitle() {
        return title();
    }

    @XmlElement
    public int getSso() {
        return authorSSO();
    }

    @XmlElement
    protected Section getIntroduction() {
        return introduction();
    }

    @XmlElement
    public String getOptionalNote() {
        return optionalString();
    }

    @XmlElementWrapper(name = "modules")
    @XmlElement
    public List<Section> getSection() {
        return modules();
    }

    protected abstract List<Section> modules();

    protected abstract int authorSSO();

    protected String optionalString() {
        return "No special note on the document";
    }

    protected abstract String title();

    protected Section introduction() {
        Section introduction = new Section("Introduction");
        Section parentIntro = new Section("System Introduction");
        parentIntro.addElement(new Paragraph("This is the introduction section of " + getParent()));
        introduction.addSubSections(new Section[]{parentIntro, introPurpose(), introScope()});
        return introduction;
    }

    protected abstract Section introPurpose();

    protected abstract Section introScope();


}
