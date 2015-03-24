package com.example.wh40k;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Urgak_000 on 21.03.2015.
 */
public class W40kModelType {

    private BasicType type;
    private List<TypeModifiers> modifiers;

    public BasicType getBasicType() {
        return type;
    }

    public List<TypeModifiers> getModifiers() {
        return modifiers;
    }

    W40kModelType(final String str) {
        String lowerStr = str.toLowerCase();
        type = BasicType.INFANTRY;
        if(lowerStr.contains("vehicle")) {
            type=BasicType.VEHICLE;
        }
        modifiers = new ArrayList<TypeModifiers>();
    }

    public enum BasicType {
        INFANTRY,
        JUMP_INFANTRY,
        JETPACK_INFANTRY,
        BIKE,
        JETBIKE,
        BEAST,
        CALVARY,
        ARTILLERY,
        MONSTROUS_CREATURE,
        FLYING_MONSTROUS_CREATURE,
        VEHICLE,
        SUPER_HEAVY_VEHICLE,
    }

    public enum TypeModifiers {
        //non-vehicle modifiers
        CHARACTER,
        //vehicle modifiers
        FAST,
        SKIMMER,
        TANK,
        OPEN_TOPPED,
        TRANSPORT,
        WALKER,
        FLYER,
        HOVER,
    }
}
