package org.woehlke.computer.kurzweil.simulated.evolution.model.geometry;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class LatticeDimensionTest {

    @Test
    public void MakePositive() {
        LatticeDimension dimension = new LatticeDimension(-10, -10);
        dimension.makePositive();
        assertEquals(dimension.getWidth(), 10);
        assertEquals(dimension.getHeight(), 10);
    }

    @Test
    public void PlusAndAbsolute(){
        //given
        LatticeDimension negativeLhs = new LatticeDimension(-10, -10);
        LatticeDimension negativeRhs = new LatticeDimension(-20, -5);
        LatticeDimension positiveLhs = new LatticeDimension(10, 10);
        LatticeDimension positiveRhs= new LatticeDimension(20 ,5);

        //when
        negativeLhs.plusAndAbsolute(negativeRhs);
        positiveLhs.plusAndAbsolute(positiveRhs);

        //then
        assertEquals(negativeLhs.getWidth(), 30);
        assertEquals(negativeLhs.getHeight() , 15);
        assertEquals(positiveLhs.getWidth(),30);
        assertEquals(positiveLhs.getHeight() ,15);
    }

    @Test
    public void copy() {
        //given
        LatticeDimension target = new LatticeDimension();
        LatticeDimension origin = new LatticeDimension(10 , 20);
        LatticeDimension nullOrigin = null;

        //when
        target = origin.copy();
        //then
        assertEquals(target.getWidth(), 10);
        assertEquals(target.getHeight() , 20);
        assertThrows(NullPointerException.class, ()->{
            LatticeDimension target2 = nullOrigin.copy();
        });
    }

    @Test
    public void toLatticePoint(){
        //given
        LatticeDimension target = new LatticeDimension();
        LatticeDimension origin = new LatticeDimension(10 , 20);
        LatticeDimension nullOrigin = null;

        //when
        target = origin.copy();
        //then
        assertEquals(target.getWidth(), 10);
        assertEquals(target.getHeight() , 20);
        assertThrows(NullPointerException.class, ()->{
            LatticeDimension target2 = nullOrigin.copy();
        });
    }

    @Test
    public void ofByLatticePoint(){
        //given
        LatticeDimension dimension;
        LatticePoint pointForParam = new LatticePoint(12,10);
        LatticeDimension dimension2;
        LatticePoint pointForParam2 = new LatticePoint(-10, -20);
        //when
        dimension = LatticeDimension.of(pointForParam);
        dimension2 = LatticeDimension.of(pointForParam2);
        //then
        assertEquals(dimension.getWidth(), 12);
        assertEquals(dimension.getHeight(), 10);

        assertEquals(dimension2.getWidth(), -10);
        assertEquals(dimension2.getHeight(), -20);
    }

    @Test
    public void ofByWidthAndHeight() throws Exception{
        //given
        int width = 265;
        int height = 666;
        LatticeDimension dimension = new LatticeDimension();
        //when
        dimension = LatticeDimension.of(width, height);
        //then
        assertEquals(dimension.getWidth(), 265);
        assertEquals(dimension.getHeight(), 666);
    }

    @Test
    public void ofByDimension() {
        //given
        LatticeDimension dimension = new LatticeDimension();
        LatticeDimension param = new LatticeDimension(10, 20);
        //when
        dimension = LatticeDimension.of(param);
        //then
        assertEquals(dimension.getWidth(), 10);
        assertEquals(dimension.getHeight(), 20);
    }
}
