package org.woehlke.simulation.evolution.config;

public interface WorldMapFoodConf {

    /**
     * How much food per Time Step (a day) shall be placed in this World.
     */
    int FOOD_PER_DAY = 10;

    /**
     * A Garden of Eden is an Area where much more Food grows within the same time.
     * As a Result of Evolution you will find sucessful Bacteria Cells with a different DNA and Motion as outside the Garden of Eden.
     */
    boolean EABLE_GARDEN_OF_EDEN = true;

    /**
     * Start with 20 Cells.
     */
    int INITIAL_POPULATION = 20;
}
