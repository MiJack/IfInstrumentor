import org.dom4j.Element;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Mr.Yuan
 * @since 2017/1/23.
 */
public class Function {
    private String name;
    private String type;
    private String parameter_list;
    private Element root;
    private Block blockList;
    private Set<IfUnit> ifUnitSet;

    public Function(Element element) {
        if (!element.getName().equals("function")) {
            throw new IllegalArgumentException();
        }
        root = element;
        name = root.element("name").getText();
        parameter_list = root.element("parameter_list").getText();
        type = Utils.elementToString(root.element("type"));
        blockList = new Block();
    }

    public Element getRoot() {
        return root;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getParameter_list() {
        return parameter_list;
    }

    @Override
    public String toString() {
        return "Function{" + type + " " + name + " " + parameter_list + '}';
    }

    public List<Unit> getBlockList() {
        return blockList.getUnits();
    }

    public int ifBlockSize() {
        return ifBlockSize(blockList);
    }

    private int ifBlockSize(Block blockList) {
        List<Unit> units = blockList.getUnits();
        int size = 0;
        for (Unit u : units) {
            if (u instanceof IfUnit) {
                size++;
            }
            size += ifBlockSize(u.getInner());
        }
        return size;
    }


    public Block getBlock() {
        return blockList;
    }

    public Set<IfUnit> getIfUnitSet() {
        return ifUnitSet;
    }

    public void collectIfBLock() {
        Set<IfUnit> ifUnitSet = new HashSet<>();
        collectIfBLock(blockList, ifUnitSet);
        this.ifUnitSet=ifUnitSet;
    }

    private void collectIfBLock(Block blockList, Set<IfUnit> set) {
        List<Unit> units = blockList.getUnits();
        for (Unit u : units) {
            if (u instanceof IfUnit) {
                set.add((IfUnit) u);
            }
            collectIfBLock(u.getInner(), set);
        }
    }
}
