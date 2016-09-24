package ru.antalas.codewars;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class GapInPrimesTest {

    private GapInPrimes gapInPrimes;

    @Before
    public void setUp() throws Exception {
        gapInPrimes = new GapInPrimes();
    }

    @Test
    public void shouldReturnGaps() throws Exception {
        assertEquals("[101, 103]", Arrays.toString(GapInPrimes.gap(2,100,110)));
        assertEquals("[103, 107]", Arrays.toString(GapInPrimes.gap(4,100,110)));
        assertEquals(null, GapInPrimes.gap(6,100,110));
        assertEquals("[359, 367]", Arrays.toString(GapInPrimes.gap(8,300,400)));
        assertEquals("[337, 347]", Arrays.toString(GapInPrimes.gap(10,300,400)));
    }

    @Test
    public void shouldEmptyWhenLimitsMatch() throws Exception {
        assertThat(GapInPrimes.gap(2, 5, 5), is(nullValue()));
    }

    @Test
    public void performanceCheck() throws Exception {
        //~ 19 seconds
        GapInPrimes.gap(100,100000,100000000);

    }
}