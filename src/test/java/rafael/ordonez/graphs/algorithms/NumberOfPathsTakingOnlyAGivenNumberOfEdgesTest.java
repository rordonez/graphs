package rafael.ordonez.graphs.algorithms;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static rafael.ordonez.graphs.datastructure.mock.GraphTestUtils.createGraph;

public class NumberOfPathsTakingOnlyAGivenNumberOfEdgesTest {

    @Test
    public void testNumberOfPathsTakingZeroEdges() throws Exception {
        //When
        NumberOfPathsTakingOnlyAGivenNumberOfEdges numberOfPathsTakingOnlyAGivenNumberOfEdges = new NumberOfPathsTakingOnlyAGivenNumberOfEdges(createGraph(), 0, 1, 0);

        //Then
        assertThat(numberOfPathsTakingOnlyAGivenNumberOfEdges.getNumberOfPaths(), is(0));
    }

    @Test
    public void testNumberOfPathsTakingOneEdge() throws Exception {
        //When
        NumberOfPathsTakingOnlyAGivenNumberOfEdges numberOfPathsTakingOnlyAGivenNumberOfEdges = new NumberOfPathsTakingOnlyAGivenNumberOfEdges(createGraph(), 0, 1, 1);

        //Then
        assertThat(numberOfPathsTakingOnlyAGivenNumberOfEdges.getNumberOfPaths(), is(1));
    }

    @Test
    public void testNumberOfPathsRecursive() throws Exception {
        //When
        NumberOfPathsTakingOnlyAGivenNumberOfEdges numberOfPathsTakingOnlyAGivenNumberOfEdges = new NumberOfPathsTakingOnlyAGivenNumberOfEdges(createGraph(), 0, 4, 4);

        //Then
        assertThat(numberOfPathsTakingOnlyAGivenNumberOfEdges.getNumberOfPaths(), is(7));
    }
}
