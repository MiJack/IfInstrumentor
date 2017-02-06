import org.dom4j.Element;

import java.util.List;


/**
 * @author Mr.Yuan
 * @since 2017/1/23.
 */
public class IfElseUnit extends Unit {
    private Element element;

    public IfElseUnit(Element element) {
        this.element = element;
    }

    public Element getElement() {
        return element;
    }

    public List<Element> thenElements() {
        return element.element("if").element("then").elements();
    }
}
