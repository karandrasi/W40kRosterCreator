package com.example.wh40k;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Urgak_000 on 21.03.2015.
 */
public class W40kOptionSlot {
    private List<W40kOption> options = new ArrayList<W40kOption>();
    private Integer max;
    private Boolean onePerModel;
    private Integer modelsRequired;
    private W40kModel model;

    public final List<W40kOption> getOptions() {
        return options;
    }

    public void addOption(W40kOption option) {
        options.add(option);
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Boolean getOnePerModel() {
        return onePerModel;
    }

    public void setOnePerModel(Boolean onePerModel) {
        this.onePerModel = onePerModel;
    }

    public Integer getModelsRequired() {
        return modelsRequired;
    }

    public void setModelsRequired(Integer modelsRequired) {
        this.modelsRequired = modelsRequired;
    }

    public W40kModel getModel() { return model; }

    public void setModel(W40kModel model) { this.model = model; }
}
