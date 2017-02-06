import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Yuan
 * @since 2017/1/23.
 */
public class Block {
    private List<Unit> units;

    public Block() {
        units = new ArrayList<Unit>();
    }

    public List<Unit> getUnits() {
        return units;
    }
}
