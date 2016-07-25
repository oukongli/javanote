package enumTests.enumtest1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kouyang on 11/30/2015.
 */
public enum Operation {
    PLUS("+"),
    MINUS("-");

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    private static final Map<String, Operation> stringToEnumMap = new HashMap<String, Operation>();

    static {
        for (Operation op : Operation.values()) {
            stringToEnumMap.put(op.toString(), op);
        }
    }

    public static Operation fromString(String symbol) {
        return stringToEnumMap.get(symbol);
    }

    @Override
    public String toString() {
        return symbol;
    }
}
