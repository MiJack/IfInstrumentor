import org.dom4j.Element;
import org.dom4j.Node;

import java.util.Iterator;

/**
 * @author Mr.Yuan
 * @since 2017/1/23.
 */
public class Utils {
    public static String elementToString(Element element) {
        return elementToString(element, new StringBuilder()).toString();
    }

    private static StringBuilder elementToString(Element elements, StringBuilder stringBuilder) {
        Iterator<Node> iterator = elements.nodeIterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node instanceof Element) {
                stringBuilder = elementToString((Element) node, stringBuilder);
            } else {
                stringBuilder.append(node.getText());
            }
        }
        return stringBuilder;
    }


}
