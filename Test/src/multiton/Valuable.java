package src.multiton;

import java.util.HashMap;
import java.util.Map;

public class Valuable
{
    private static Map<Ore, Valuable> map = new HashMap<>();
    private Ore type;
    private Valuable(Ore type)
    {
        this.type = type;
    }

    public static Valuable getOre(Ore type)
    {
        Valuable instance = map.get(type);
        if (instance == null)
        {
            synchronized (map)
            {
                if (instance == null)
                {
                    instance = new Valuable(type);
                    map.put(type, instance);
                }
            }
        }
        return instance;
    }

    public Ore getType()
    {
        return type;
    }
}
