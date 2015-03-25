package com.example.wh40k;
import org.xmlpull.v1.*;
import android.util.Xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Urgak_000 on 21.03.2015.
 */
public class W40kCodex {

    private List<W40kUnit> units = new ArrayList<W40kUnit>();

    public List<W40kUnit> getUnits() {
        return units;
    }

    public void addUnit(W40kUnit unit) {
        units.add(unit);
    }

    public W40kUnit getUnitByName(String name) {
        for(W40kUnit unit : units) {
            if(unit.getName().equals(name)) {
                return unit;
            }
        }
        return new W40kUnit();
    }
}
