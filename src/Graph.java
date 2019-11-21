import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;


public class Graph {
    private ArrayList<Vertex> Vertices = new ArrayList<>();

    public Vertex addvertex(String id) {
        Vertex newvertex = new Vertex(id);
        Vertices.add(newvertex);
        return newvertex;
    }

    public void addvertex(Vertex v) {
        Vertices.add(v);
    }

    public Vertex getvertex(String s) {
        for (Vertex v : Vertices) {
            if (v.Name == s)
                return v;
        }
        return null;
    }

    public void newedge(Vertex from, Vertex to, int dist, int tim) {
        Edge newedge = new Edge(from, to);
        newedge.distance = dist;
        newedge.time = tim;
    }


    public Pair<Integer, Map<Vertex, Vertex>> ShortestDistance(Vertex source, Vertex zink) {
        Map<Vertex, Vertex> PredecessorMap = new HashMap<>(); //denne skal opdateres heletiden
        Map<Vertex, Integer> DistanceMap = new HashMap<>();
        Map<Vertex, Integer> DistanceMapDisplay = new HashMap<>();
        // initialize arrays
        Vertex vertex;
        for (Vertex v : Vertices) {
            DistanceMap.put(v, 1000);
            PredecessorMap.put(v, null);
        }

        DistanceMap.put(source, 0);

        for (int count = 0; count < Vertices.size(); count++) {

            vertex = getmin(DistanceMap);

            for (int i = 0; i < vertex.getOutEdges().size(); i++) {

                if (vertex.getOutEdges().get(i).distance + DistanceMap.get(vertex)
                        < DistanceMap.get(vertex.getOutEdges().get(i).getTovertex())) {
                    DistanceMap.put(vertex.getOutEdges().get(i).getTovertex(), vertex.getOutEdges().get(i).distance + DistanceMap.get(vertex));
                    /*System.out.println(vertex.getOutEdges().get(i).getFromvertex().Name + " " + vertex.getOutEdges().get(i).getTovertex().Name);
                    System.out.println("Distancemap Values");
                    System.out.println(DistanceMap.values());*/
                    PredecessorMap.put(vertex.getOutEdges().get(i).getTovertex(), vertex);
                }
            }
            int theRemoved = DistanceMap.put(vertex, -1);
            DistanceMapDisplay.put(vertex, theRemoved);
            //}
            //System.out.println(DistanceMapDisplay.keySet());
        }
        return (new Pair<Integer, Map<Vertex, Vertex>>(DistanceMapDisplay.get(zink), PredecessorMap));
    }


    public Vertex getmin(Map<Vertex, Integer> qmap) {

        int value = 1000;
        Vertex vertex = null;
        //Her looper vi igennem hele distancemap og retriever den vertex som er kortest fra source vertex
        for (Map.Entry<Vertex, Integer> entry : qmap.entrySet()) { //o(v)

            if ((entry.getValue() < value || vertex==null) && entry.getValue() != -1) {
                value = entry.getValue();
                vertex = entry.getKey();
            }
        }
        // Your code
        return vertex;
    }
}


class Vertex {
    public String Name;
    public ArrayList<Edge> OutEdges = new ArrayList<>();

    public Vertex(String id) {
        Name = id;
    }

    public void addOutEdge(Edge outedge) {
        OutEdges.add(outedge);
    }

    public ArrayList<Edge> getOutEdges() {
        return OutEdges;
    }
}

class Edge {
    private Vertex fromvertex;
    private Vertex tovertex;
    public int distance = 0;
    public int time = 0;

    public Vertex getTovertex() {
        return tovertex;
    }

    public Vertex getFromvertex() {
        return fromvertex;
    }

    public Edge(Vertex from, Vertex to) {
        fromvertex = from;
        tovertex = to;
        fromvertex.addOutEdge(this);
        //If not directional
        tovertex.addOutEdge(this);
    }
}


