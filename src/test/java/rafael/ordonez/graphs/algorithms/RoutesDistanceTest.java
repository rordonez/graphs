package rafael.ordonez.graphs.algorithms;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static rafael.ordonez.graphs.datastructure.mock.GraphTestUtils.createGraph;

public class RoutesDistanceTest {

    @Test
    public void calculateDistance_for_a_null_route_should_return_zero() throws Exception {
        //Given
        int [] route = null;

        //When
        RoutesDistance routesDistance = new RoutesDistance(createGraph(), route);

        //Then
        assertFalse(routesDistance.existRoute());
        assertThat(routesDistance.getDistance(), is(0));
    }

    @Test
    public void calculateDistance_for_an_array_with_less_than_two_elements_should_return_zero() throws Exception {
        //Given
        int [] route = {1};

        //When
        RoutesDistance routesDistance = new RoutesDistance(createGraph(), route);

        //Then
        assertFalse(routesDistance.existRoute());
        assertThat(routesDistance.getDistance(), is(0));
    }

    @Test
    public void calculateDistance_for_a_non_existent_route_should_return_zero() throws Exception {
        //Given
        int [] route = {0,4,3};

        //When
        RoutesDistance routesDistance = new RoutesDistance(createGraph(), route);

        //Then
        assertFalse(routesDistance.existRoute());
        assertThat(routesDistance.getDistance(), is(0));
    }

    @Test
    public void calculateDistance_for_a_simple_route_should_return_its_weight() throws Exception {
        //Given
        int [] route = {0,1};

        //When
        RoutesDistance routesDistance = new RoutesDistance(createGraph(), route);

        //Then
        assertTrue(routesDistance.existRoute());
        assertThat(routesDistance.getDistance(), is(5));
    }

    @Test
    public void calculateDistance_for_a_complex_route_should_return_the_sum_of_all_weights_inside_the_route() throws Exception {
        //Given
        int [] route = {0,4,1,2,3};

        //When
        RoutesDistance routesDistance = new RoutesDistance(createGraph(), route);

        //Then
        assertTrue(routesDistance.existRoute());
        assertThat(routesDistance.getDistance(), is(22));
    }
}
