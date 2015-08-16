package rafael.ordonez.graphs.algorithms;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static rafael.ordonez.graphs.datastructure.mock.GraphTestUtils.createGraph;

public class NumberOfRoutesUnderDistanceTest {


    @Test
    public void testNumberOfRoutesWhenThereIsNoRoute() throws Exception {
        //When
        NumberOfRoutesUnderDistance routesWithDistance = new NumberOfRoutesUnderDistance(createGraph(), 2, 2, 30);

        //Then
        assertThat(routesWithDistance.getNumberOfRoutes(), is(0));
    }

    @Test
    public void testNumberOfRoutesSmallerThanThirty() throws Exception {
        //When
        NumberOfRoutesUnderDistance routesWithDistance = new NumberOfRoutesUnderDistance(createGraph(), 0, 4, 30);

        //Then
        assertThat(routesWithDistance.getNumberOfRoutes(), is(5));
    }

    @Test
    public void testNumberOfRoutesSmallerThanTen() throws Exception {
        //When
        NumberOfRoutesUnderDistance routesWithDistance = new NumberOfRoutesUnderDistance(createGraph(), 0, 4, 10);

        //Then
        assertThat(routesWithDistance.getNumberOfRoutes(), is(1));
    }
}
