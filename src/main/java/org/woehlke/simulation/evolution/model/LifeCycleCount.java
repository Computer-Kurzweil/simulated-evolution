package org.woehlke.simulation.evolution.model;

import java.io.Serializable;

public class LifeCycleCount implements Serializable {

    private int young;
    private int youngAndFat;
    private int fullAge;
    private int hungry;
    private int old;
    private int dead;
    private int total;

    public void add(LifeCycleStatus status){
        total++;
        switch (status){
            case YOUNG: young++; break;
            case YOUNG_AND_FAT: youngAndFat++; break;
            case FULL_AGE: fullAge++; break;
            case HUNGRY: hungry++; break;
            case OLD: old++; break;
            case DEAD: dead++; break;
        }
    }

    public int getYoung() {
        return young;
    }

    public void setYoung(int young) {
        this.young = young;
    }

    public int getYoungAndFat() {
        return youngAndFat;
    }

    public void setYoungAndFat(int youngAndFat) {
        this.youngAndFat = youngAndFat;
    }

    public int getFullAge() {
        return fullAge;
    }

    public void setFullAge(int fullAge) {
        this.fullAge = fullAge;
    }

    public int getHungry() {
        return hungry;
    }

    public void setHungry(int hungry) {
        this.hungry = hungry;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public int getDead() {
        return dead;
    }

    public void setDead(int dead) {
        this.dead = dead;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "LifeCycleCount{" +
            "young=" + young +
            ", youngAndFat=" + youngAndFat +
            ", fullAge=" + fullAge +
            ", hungry=" + hungry +
            ", old=" + old +
            ", dead=" + dead +
            ", total=" + total +
            '}';
    }
}
