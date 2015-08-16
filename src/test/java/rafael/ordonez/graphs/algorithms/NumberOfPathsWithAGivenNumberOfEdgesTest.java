package rafael.ordonez.graphs.algorithms;

import org.junit.Test;
import rafael.ordonez.graphs.datastructure.mock.GraphTestUtils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NumberOfPathsWithAGivenNumberOfEdgesTest {

    @Test
    public void testNumberOfPathsForZeroEdgesAndDifferentSourceAndTargetVertices() throws Exception {
        //When
        NumberOfPathsWithAGivenNumberOfEdges numberOfPathsWithAGivenNumberOfEdges = new NumberOfPathsWithAGivenNumberOfEdges(GraphTestUtils.createGraph(), 0, 1, 0);

        //Then
        assertThat(numberOfPathsWithAGivenNumberOfEdges.getNumberOfPaths(), is(0));
    }

    @Test
    public void testNumberOfPathsForZeroEdgesAndEqualSourceAndTargetVertices() throws Exception {
        //When
        NumberOfPathsWithAGivenNumberOfEdges numberOfPathsWithAGivenNumberOfEdges = new NumberOfPathsWithAGivenNumberOfEdges(GraphTestUtils.createGraph(), 0, 0, 0);

        //Then
        assertThat(numberOfPathsWithAGivenNumberOfEdges.getNumberOfPaths(), is(1));
    }

    @Test
    public void testNumberOfPathsRecursive() throws Exception {
        //When
        NumberOfPathsWithAGivenNumberOfEdges numberOfPathsWithAGivenNumberOfEdges = new NumberOfPathsWithAGivenNumberOfEdges(GraphTestUtils.createGraph(), 0, 4, 4);

        //Then
        assertThat(numberOfPathsWithAGivenNumberOfEdges.getNumberOfPaths(), is(2));
    }
}
