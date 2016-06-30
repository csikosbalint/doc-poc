package com.component.document.technology;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.company.document.element.Diagram;
import com.company.document.element.Paragraph;
import com.company.document.item.Section;
import com.company.template.technology.SoftwareDetailesDesign;
import com.company.template.technology.SystemArchitectureDesign;

@XmlRootElement
public class CLIToolSDD extends SoftwareDetailesDesign {

    protected SystemArchitectureDesign setParent() {
        return new SystemArchitectureDesign();
    }

    /**
     * This way you can customize introduction
     * @return customized introduction section
     */
    @XmlElement
    protected Section getIntroduction()  {
        Section introSection = super.getIntroduction();
        Paragraph introDesc = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc porttitor volutpat orci. Suspendisse vel dignissim augue. Ut blandit in lorem vitae semper.");
        introSection.addElement(introDesc);
        introSection.addSubSections(introPurpose(), introScope());

        Diagram introDiagram = null;
        try {
            introDiagram = new Diagram(new URI("http://www.divatlaz.eoldal.hu/img/mid/58/ugro-cica.jpg"), "Jumping cat");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        introSection.addElement(introDiagram);
        return introSection;
    }

    protected String title() {
        return "Security PKI Device Enrollment CLI Tool";
    }

     protected Section introPurpose() {
        Section purpose = new Section("Purpose");
        Paragraph pp = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc porttitor volutpat orci. Suspendisse vel dignissim augue. Ut blandit in lorem vitae semper. Nam sem felis, maximus quis tincidunt viverra, condimentum non elit. Morbi elementum tortor in elit ultricies luctus. Phasellus et consectetur lectus, sed accumsan turpis. Curabitur tempus hendrerit lacinia. Etiam gravida felis nec arcu semper gravida. Phasellus luctus libero nec nunc porttitor blandit nec ac sem. Fusce aliquam est sed neque semper placerat. Ut aliquam tincidunt luctus. Nunc eleifend nulla quis auctor molestie. Proin porttitor posuere mollis. Ut non dictum mauris. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. ");
        purpose.addElement(pp);
        return purpose;
    }

    protected Section introScope() {
        Section purpose = new Section("Scope");
        Paragraph pp = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc porttitor volutpat orci. Suspendisse vel dignissim augue. Ut blandit in lorem vitae semper. Nam sem felis, maximus quis tincidunt viverra, condimentum non elit. Morbi elementum tortor in elit ultricies luctus. Phasellus et consectetur lectus, sed accumsan turpis. Curabitur tempus hendrerit lacinia. Etiam gravida felis nec arcu semper gravida. Phasellus luctus libero nec nunc porttitor blandit nec ac sem. Fusce aliquam est sed neque semper placerat. Ut aliquam tincidunt luctus. Nunc eleifend nulla quis auctor molestie. Proin porttitor posuere mollis. Ut non dictum mauris. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. ");
        purpose.addElement(pp);
        return purpose;
    }

    protected List<Section> modules() {
//        for ( Class c: this.getClass().getClassLoader() ) {
//            System.out.println(c.getCanonicalName());
//        }
        Section sectionA = new Section("CLI Tool Common");
        Paragraph ap = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc porttitor volutpat orci. Suspendisse vel dignissim augue. Ut blandit in lorem vitae semper. Nam sem felis, maximus quis tincidunt viverra, condimentum non elit. Morbi elementum tortor in elit ultricies luctus. Phasellus et consectetur lectus, sed accumsan turpis. Curabitur tempus hendrerit lacinia. Etiam gravida felis nec arcu semper gravida. Phasellus luctus libero nec nunc porttitor blandit nec ac sem. Fusce aliquam est sed neque semper placerat. Ut aliquam tincidunt luctus. Nunc eleifend nulla quis auctor molestie. Proin porttitor posuere mollis. Ut non dictum mauris. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. ");
        sectionA.addElement(ap);

        Section sectionB = new Section("SCEP Enrollment");
        Paragraph bp = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc porttitor volutpat orci. Suspendisse vel dignissim augue. Ut blandit in lorem vitae semper. Nam sem felis, maximus quis tincidunt viverra, condimentum non elit. Morbi elementum tortor in elit ultricies luctus. Phasellus et consectetur lectus, sed accumsan turpis. Curabitur tempus hendrerit lacinia. Etiam gravida felis nec arcu semper gravida. Phasellus luctus libero nec nunc porttitor blandit nec ac sem. Fusce aliquam est sed neque semper placerat. Ut aliquam tincidunt luctus. Nunc eleifend nulla quis auctor molestie. Proin porttitor posuere mollis. Ut non dictum mauris. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. ");
        sectionB.addElement(bp);

        Section moduleSOUPjscep = new Section("SOUP: com.google.code.jscpe:jscep");
        Paragraph jscpeParagraph = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc porttitor volutpat orci. Suspendisse vel dignissim augue. Ut blandit in lorem vitae semper. Nam sem felis, maximus quis tincidunt viverra, condimentum non elit. Morbi elementum tortor in elit ultricies luctus. Phasellus et consectetur lectus, sed accumsan turpis. Curabitur tempus hendrerit lacinia. Etiam gravida felis nec arcu semper gravida. Phasellus luctus libero nec nunc porttitor blandit nec ac sem. Fusce aliquam est sed neque semper placerat. Ut aliquam tincidunt luctus. Nunc eleifend nulla quis auctor molestie. Proin porttitor posuere mollis. Ut non dictum mauris. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. ");
        moduleSOUPjscep.addElement(jscpeParagraph);

        Section modeleSOUPother = new Section("SOUP: com.google.whatever...");
        sectionB.addSubSections(new Section[] {moduleSOUPjscep, modeleSOUPother});
        return Arrays.asList(new Section[] {sectionA, sectionB});
    }

    protected int authorSSO() {
        return 123456789;
    }

    @XmlElement
    public String getExtraNote() {
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
    }
}
