package edu.gcit.to_d0_9;

import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(JUnit4.class)
@SmallTest


public class ExampleUnitTest {
    private calculator mcalculator;

    @Before
    public void setUp()
    {
        mcalculator = new calculator();
    }

    @Test
    public void addTwoNumber()
    {
        double result = mcalculator.add(1d, 2d);
        assertThat(result, is(equalTo(3d)));
    }
    @Test
    public void addTwoNUmberNegative()
    {
        double result = mcalculator.add(-1d, 2d);
        assertThat(result, is(equalTo(1d)));
    }

    @Test
    public void addTwoNUmberFloat()
    {
        double result = mcalculator.add(1.11f, 1.11d);
        assertThat(result, is(closeTo(2.22d, 0.01)));
    }
    @Test
    public void subTwoNUmber()
    {
        double result = mcalculator.sub(3d, 2d);
        assertThat(result, is(equalTo(1d)));
    }

    @Test
    public void subTwoNUmberNegative()
    {
        double result = mcalculator.sub(-3f, 2d);
        assertThat(result, is(equalTo(-5d)));
    }

    @Test
    public void addTwoNUmberNegativeFloat()
    {
        double result = mcalculator.sub(-1.11f, 2.22d);
        assertThat(result, is(closeTo(-3.33d, 0.01)));
    }
    @Test
    public void subTwoNUmberdiffNegative()
    {
        double result = mcalculator.sub(-3f, -2d);
        assertThat(result, is(equalTo(-1d)));
    }

    @Test
    public void mulTwoNUmber()
    {
        double result = mcalculator.mul(3d, 2d);
        assertThat(result, is(equalTo(6d)));
    }

    @Test
    public void mulwoNUmberZero()
    {
        double result = mcalculator.mul(3f, 0d);
        assertThat(result, is(equalTo(0d)));
    }

    @Test
    public void mulTwoNUmberFloat()
    {
        double result = mcalculator.mul(1.11f, 2.22d);
        assertThat(result, is(closeTo(2.4642, 0.01)));
    }
    

    @Test
    public void divTwoNUmber()
    {
        double result = mcalculator.div(5d, 10d);
        assertThat(result, is(equalTo(0.5d)));
    }

    @Test
    public void divTwoNUmberZero()
    {
        double result = mcalculator.div(3f, 0d);
        assertThat(result, is(equalTo(Double.POSITIVE_INFINITY)));
    }
    @Test
    public void divTwoNUmberZeros()
    {
        double result = mcalculator.div(0f, 10d);
        assertThat(result, is(equalTo(0d)));
    }
    @Test
    public void divTwoNUmberNegativeZero()
    {
        double result = mcalculator.div(-3f, 0d);
        assertThat(result, is(equalTo(Double.NEGATIVE_INFINITY)));
    }
}