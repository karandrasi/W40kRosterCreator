package com.example.wh40k;

/**
 * Created by Urgak_000 on 23.03.2015.
 */
public class W40kCombo {
    private W40kUnit unit;
    private Float multiplier;

    public W40kUnit getUnit() {
        return unit;
    }

    public void setUnit(W40kUnit unit) {
        this.unit = unit;
    }

    public Float getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Float multiplier) {
        this.multiplier = multiplier;
    }

    public Integer GetCost() {
        return unit.getBasicCost();
    }
}

