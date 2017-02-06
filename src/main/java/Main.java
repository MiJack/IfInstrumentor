import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Mr.Yuan
 * @since 2017/1/19.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        SAXReader reader = new SAXReader();
        File file = new File("F:\\IdeaProject\\Plan\\src\\main\\resources\\Demo.java.xml");
        Document document = reader.read(file);
        Element root = document.getRootElement();
        List<Function> functions = new ArrayList();
        findAllFunctions(root, functions);
        System.out.println("size:" + functions.size());
        for (Function func : functions) {
            Counter count = new Counter();
            findIf(func, func.getRoot(), func.getBlock(), count);
            System.out.println(func.toString() + ":" + func.ifBlockSize());
        }
        functions.stream().forEach((f) -> f.collectIfBLock());
        for (Function f : functions) {
            for (IfUnit ifUnit : f.getIfUnitSet()) {
                ifUnit.handle();
            }
        }
        File f = new File("file.java");
        FileWriter fileWriter = new FileWriter(f, false);
        printFile(root, fileWriter);
        fileWriter.flush();
        fileWriter.close();
        System.out.println(f.getAbsolutePath());
    }

    private static void findIf(Function function, Element root, Block blockList, Counter counter) {
        Iterator<Element> iterator = root.elementIterator();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            if ("if".equals(element.getName()) && !element.getParent().getName().equals("elseif")) {
                counter.increment();
                IfUnit unit = new IfUnit(element, counter.getIdString());
                blockList.getUnits().add(unit);
                findIf(function, element, unit.getInner(), counter.clone().append());
            } else {
                findIf(function, element, blockList, counter);
            }
        }
    }

    private static void printFile(Element root, FileWriter fileWriter) {
        Iterator<Node> elements = root.nodeIterator();
        while (elements.hasNext()) {
            Node next = elements.next();
            if (next instanceof Element) {
                printFile((Element) next, fileWriter);
            } else {
                if (!(next instanceof Namespace)) {
                    try {
                        fileWriter.write(next.getText());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static List<Element> findIf(Element func) {
        return findIf(func, new ArrayList<Element>());
    }

    private static List<Element> findIf(Element func, List<Element> list) {
        Iterator<Element> iterator = func.elementIterator();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            if ("if".equals(element.getName())) {
                list.add(element);
            }
            findIf(element, list);
        }
        return list;
    }

    private static void findAllFunctions(Element root, List<Function> functions) {
        Iterator<Element> iterator = root.elementIterator();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            if ("function".equals(element.getName())) {
                functions.add(new Function(element));
                continue;
            }
            findAllFunctions(element, functions);
        }
    }
}
