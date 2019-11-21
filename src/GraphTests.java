import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Map;

public class GraphTests {

    public static void main(String[] args) {
        // Create graph
        GraphTests TestGraph= new GraphTests();
        Graph g = TestGraph.MakeSmallGraph();
        Vertex source = g.getvertex("10");
        Vertex zink = g.getvertex("6");
        Pair<Integer, Map<Vertex, Vertex>> results=g.ShortestDistance(source, zink);
        Vertex current =zink;
        ArrayList<Vertex> Path= new ArrayList<>();
        Path.add(zink);

        while ((current != source) && (results.getValue().get(current)!=null))
        {
            current=results.getValue().get(current);
            Path.add(0,current);

        }
        for(Vertex v : Path) {
            System.out.print(v.Name);
            if (v != zink)
                System.out.print("->");
        }

    }
    public Graph MakeSmallGraph()
    {
        Graph mygraph= new Graph();
        final Vertex A1 = mygraph.addvertex("1");
        final Vertex B2 = mygraph.addvertex("2");
        final Vertex C3 = mygraph.addvertex("3");
        final Vertex D4 = mygraph.addvertex("4");
        final Vertex E5 = mygraph.addvertex("5");
        final Vertex F6 = mygraph.addvertex("6");
        final Vertex G7 = mygraph.addvertex("7");
        final Vertex H8 = mygraph.addvertex("8");
        final Vertex I9 = mygraph.addvertex("9");
        final Vertex J10 = mygraph.addvertex("10");
        //vi skal finde både distance og time
        mygraph.newedge(A1,B2,10,1);
        mygraph.newedge(A1,D4, 20,1);
        mygraph.newedge(A1,E5, 20,1);
        mygraph.newedge(A1,F6, 5,1);
        mygraph.newedge(A1,G7, 15,1);
        mygraph.newedge(B2,C3, 5,1);
        mygraph.newedge(B2,D4, 10,1);
        mygraph.newedge(C3, B2 , 15,1);
        mygraph.newedge(C3, D4 , 5,1);
        mygraph.newedge(D4, E5 , 10,1);
        mygraph.newedge(E5, F6 , 5,1);
        mygraph.newedge(G7, F6  , 10,1);
        mygraph.newedge(H8, G7 , 5,1);
        mygraph.newedge(H8, A1, 5,1);
        mygraph.newedge(H8, B2 , 20,1);
        mygraph.newedge(I9, H8 , 20,1);
        mygraph.newedge(I9, B2 , 15,1);
        mygraph.newedge(I9, J10 , 10,1);
        mygraph.newedge(J10, B2, 5,1);
        mygraph.newedge(J10, C3 , 15,1);

        return mygraph;

    }
}


