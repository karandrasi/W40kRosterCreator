package com.example.wh40k;

/**
 * Created by Urgak_000 on 21.03.2015.
 */
public class W40kModel {
    private String name;
    private Integer weaponSkill;
    private Integer ballisticSkill;
    private Integer strength;
    private Integer toughness;
    private Integer wounds;
    private Integer initiative;
    private Integer attacks;
    private Integer leadership;
    private Integer save;
    private Integer invulSave;
    private W40kModelType type;
    private Integer defaultCount;
    private Integer maxCount;
    private Integer frontArmour;
    private Integer sideArmour;
    private Integer rearArmour;
    private Integer hullPoints;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeaponSkill() {
        return weaponSkill;
    }

    public void setWeaponSkill(Integer weaponSkill) {
        this.weaponSkill = weaponSkill;
    }

    public Integer getBallisticSkill() {
        return ballisticSkill;
    }

    public void setBallisticSkill(Integer ballisticSkill) {
        this.ballisticSkill = ballisticSkill;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getToughness() {
        return toughness;
    }

    public void setToughness(Integer toughness) {
        this.toughness = toughness;
    }

    public Integer getWounds() {
        return wounds;
    }

    public void setWounds(Integer wounds) {
        this.wounds = wounds;
    }

    public Integer getInitiative() {
        return initiative;
    }

    public void setInitiative(Integer initiative) {
        this.initiative = initiative;
    }

    public Integer getAttacks() {
        return attacks;
    }

    public void setAttacks(Integer attacks) {
        this.attacks = attacks;
    }

    public Integer getLeadership() {
        return leadership;
    }

    public void setLeadership(Integer leadership) {
        this.leadership = leadership;
    }

    public Integer getSave() {
        return save;
    }

    public void setSave(Integer save) {
        this.save = save;
    }

    public Integer getInvulSave() {
        return invulSave;
    }

    public void setInvulSave(Integer invulSave) {
        this.invulSave = invulSave;
    }

    public W40kModelType getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = new W40kModelType(type);
    }

    public Integer getDefaultCount() {
        return defaultCount;
    }

    public void setDefaultCount(Integer defaultCount) {
        this.defaultCount = defaultCount;
    }

    public Integer getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }

    public Integer getFrontArmour() {
        return frontArmour;
    }

    public void setFrontArmour(Integer frontArmour) {
        this.frontArmour = frontArmour;
    }

    public Integer getSideArmour() {
        return sideArmour;
    }

    public void setSideArmour(Integer sideArmour) {
        this.sideArmour = sideArmour;
    }

    public Integer getRearArmour() {
        return rearArmour;
    }

    public void setRearArmour(Integer rearArmour) {
        this.rearArmour = rearArmour;
    }

    public Integer getHullPoints() {
        return hullPoints;
    }

    public void setHullPoints(Integer hullPoints) {
        this.hullPoints = hullPoints;
    }
}
