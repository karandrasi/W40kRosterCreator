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

    private List<W40kUnit> units;

    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }

    public W40kCodex(InputStream stream) throws XmlPullParserException, IOException{
        units = new ArrayList<W40kUnit>();
        XmlPullParser parser = Xml.newPullParser();
        parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
        parser.setInput(stream, null);
        parser.nextTag();
        parser.require(XmlPullParser.START_TAG, "", "units");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) continue;
            String name = parser.getName();
            if(name == null) continue;
            if (name.equals("unit")) {
                W40kUnit unit = ParseUnit(parser);
                units.add(unit);
            } else {
                skip(parser);
            }
        }
        parser.require(XmlPullParser.END_TAG, "", "units");
    }

    W40kUnit ParseUnit(XmlPullParser parser) throws XmlPullParserException, IOException{
        W40kUnit unit = new W40kUnit();
        parser.require(XmlPullParser.START_TAG, "", "unit");
        unit.setSlot(parser.getAttributeValue(null, "slot"));
        unit.setName(parser.getAttributeValue(null, "name"));
        unit.setBasicCost(Integer.parseInt(parser.getAttributeValue(null, "cost")));
        unit.setBasicValue(Integer.parseInt(parser.getAttributeValue(null, "value")));
        unit.setUnique(Boolean.parseBoolean(parser.getAttributeValue(null, "unique")));
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) continue;
            String name = parser.getName();
            if(name.equals("model")) {
                W40kModel model = ParseModel(parser);
                unit.addModel(model);
            } else if(name.equals("options")) {
                W40kOptionSlot optionSlot = ParseOptions(parser);
                unit.addOptionSlot(optionSlot);
            }  else {
                skip(parser);
            }
        }
        parser.require(XmlPullParser.END_TAG, "", "unit");
        return unit;
    }

    W40kModel ParseModel(XmlPullParser parser) throws XmlPullParserException, IOException{
        parser.require(XmlPullParser.START_TAG, "", "model");
        W40kModel model = new W40kModel();
        model.setType(parser.getAttributeValue(null, "type"));
        model.setName(parser.getAttributeValue(null, "name"));
        String ws = parser.getAttributeValue(null, "WS");
        if(ws != null) model.setWeaponSkill(Integer.parseInt(ws));
        model.setBallisticSkill(Integer.parseInt(parser.getAttributeValue(null, "BS")));
        if(model.getType().getBasicType() != W40kModelType.BasicType.VEHICLE) {
            model.setStrength(Integer.parseInt(parser.getAttributeValue(null, "S")));
            model.setToughness(Integer.parseInt(parser.getAttributeValue(null, "T")));
            model.setWounds(Integer.parseInt(parser.getAttributeValue(null, "W")));
            model.setInitiative(Integer.parseInt(parser.getAttributeValue(null, "I")));
            model.setAttacks(Integer.parseInt(parser.getAttributeValue(null, "A")));
            model.setLeadership(Integer.parseInt(parser.getAttributeValue(null, "Ld")));
            model.setSave(Integer.parseInt(parser.getAttributeValue(null, "Sv")));
        } else {
            model.setFrontArmour(Integer.parseInt(parser.getAttributeValue(null, "FA")));
            model.setSideArmour(Integer.parseInt(parser.getAttributeValue(null, "SA")));
            model.setRearArmour(Integer.parseInt(parser.getAttributeValue(null, "RA")));
            model.setRearArmour(Integer.parseInt(parser.getAttributeValue(null, "HP")));
        }
        model.setDefaultCount(Integer.parseInt(parser.getAttributeValue(null, "count")));
        model.setMaxCount(Integer.parseInt(parser.getAttributeValue(null, "max")));
        parser.next();
        parser.require(XmlPullParser.END_TAG, "", "model");
        return model;
    }

    W40kOptionSlot ParseOptions(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, "", "options");
        W40kOptionSlot slot = new W40kOptionSlot();
        slot.setMax(Integer.parseInt(parser.getAttributeValue(null, "max")));
        String requredModels = parser.getAttributeValue(null, "requiresModels");
        slot.setModelsRequired((requredModels != null)?Integer.parseInt(requredModels):0);
        String onePerModel = parser.getAttributeValue(null, "onePerModel");
        slot.setOnePerModel((onePerModel != null)?Boolean.parseBoolean(onePerModel):false);
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) continue;
            String name = parser.getName();
            if (name.equals("option")) {
                parser.require(XmlPullParser.START_TAG, "", "option");
                W40kOption option = new W40kOption();
                option.setName(parser.getAttributeValue(null, "name"));
                option.setCost(Integer.parseInt(parser.getAttributeValue(null, "cost")));
                option.setValue(Integer.parseInt(parser.getAttributeValue(null, "value")));
                slot.addOption(option);
                parser.next();
                parser.require(XmlPullParser.END_TAG, "", "option");
            }  else {
                skip(parser);
            }
        }
        parser.require(XmlPullParser.END_TAG, "", "options");
        return slot;
    }

    public List<W40kUnit> getUnits() {
        return units;
    }
}
