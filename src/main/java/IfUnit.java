import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Mr.Yuan
 * @since 2017/1/23.
 */
public class IfUnit extends Unit {
    private final Element root;
    private final String id;
    private Element conditionBlock;
    private Element thenBlock;
    private Element elseBlock;
    private List<IfElseUnit> elseifBlock = new ArrayList<>();

    public IfUnit(Element root, String id) {
        this.root = root;
        this.id = id;
    }

    public void handle() {
        //处理element
        for (Iterator it = root.elementIterator(); it.hasNext(); ) {
            Element element = (Element) it.next();
            switch (element.getName()) {
                case "condition":
                    conditionBlock = element;
                    break;
                case "then":
                    thenBlock = element;
                    break;
                case "else":
                    elseBlock = element;
                    break;
                case "elseif":
                    elseifBlock.add(new IfElseUnit(element));
                    break;
            }
        }
        //进行插桩
        handleThen();
        handleElse();
        handleElseIf();
    }

    private void handleElse() {
        if (elseBlock == null) {
            return;
        }
        List<Element> elements = elseBlock.elements();
        Element elseBlock = elements.get(0);
        Element element = DocumentHelper.createElement("expr");
        element.setText("com.mijack.Log.log(\"" + id + "_else_start\");");
        elseBlock.elements().add(0, element);
        Element endElement = DocumentHelper.createElement("expr");
        endElement.setText("com.mijack.Log.log(\"" + id + "_else_end\");");
        int size = elseBlock.elements().size();
        Element last = (Element) elseBlock.elements().get(size - 1);
        if (last.getName().equals("return")) {
            return;
        }
        elseBlock.elements().add(size, endElement);
    }

    private void handleElseIf() {
        if (elseifBlock == null) {
            return;
        }
        int i = 0;
        for (Iterator<IfElseUnit> it = elseifBlock.iterator(); it.hasNext(); i++) {
            IfElseUnit ifElseUnit = it.next();
            //------------------------------------------------------------
            Element ifElseUnitElement = ifElseUnit.thenElements().get(0);
            Element startElement = DocumentHelper.createElement("expr");
            startElement.setText("com.mijack.Log.log(\"" + id + "_else_if_start_" + i + "\");");
            ifElseUnitElement.elements().add(0, startElement);
            //------------------------------------------------------------
            Element endElement = DocumentHelper.createElement("expr");
            endElement.setText("com.mijack.Log.log(\"" + id + "_else_if_end_" + i + "\");");
            int size = ifElseUnitElement.elements().size();
            Element last = (Element) ifElseUnitElement.elements().get(size-1);
            if (last.getName().equals("return")) {
                continue;
            }
            ifElseUnitElement.elements().add(size, endElement);
        }
    }

    private void handleThen() {
        if (thenBlock == null) {
            return;
        }
        List<Element> elements = thenBlock.elements();
        Element thenBlock = elements.get(0);
        Element startElement = DocumentHelper.createElement("expr");
        startElement.setText("com.mijack.Log.log(\"" + id + "_then_start\");");
        thenBlock.elements().add(0, startElement);
        Element endElement = DocumentHelper.createElement("expr");
        endElement.setText("com.mijack.Log.log(\"" + id + "_then_end\");");
        int size = thenBlock.elements().size();
        Element last = (Element) thenBlock.elements().get(size - 1);
        if (last.getName().equals("return")) {
            return;
        }
        thenBlock.elements().add(size, endElement);
    }
}
