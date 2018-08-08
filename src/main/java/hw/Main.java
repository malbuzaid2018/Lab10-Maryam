package hw;

import java.util.*;
import org.jgrapht.*;
import org.jgrapht.Graph;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.ClosestFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.RandomWalkIterator;

public class Main {

  public static void main(final String[] args) {

    final String CN = CountryCodes.CN;
    final String VN = CountryCodes.VN;
    final String LA = CountryCodes.LA;
    final String MM = CountryCodes.MM;
    final String NP = CountryCodes.NP;
    final String KG = CountryCodes.KG;

    final Graph<String, DefaultEdge> myMap = new SimpleGraph<>(DefaultEdge.class);

    myMap.addVertex(CN);
    myMap.addVertex(VN);
    myMap.addVertex(LA);
    myMap.addVertex(MM);
    myMap.addVertex(NP);
    myMap.addVertex(KG);

    // Add edges for 5 countries that share a border with China

    myMap.addEdge(CN, VN);
    myMap.addEdge(CN, LA);
    myMap.addEdge(CN, MM);
    myMap.addEdge(CN, NP);
    myMap.addEdge(CN, KG);

    // Vietnam also shares a border with Laos
    myMap.addEdge(VN, LA);

    // Laos also shares a border with Myanmar
    myMap.addEdge(LA, MM);

    System.out.println(myMap);

    System.out.println("\nBreadth first iteration starting from China");

    final Iterator<String> bf = new BreadthFirstIterator<>(myMap, CN);
    while (bf.hasNext()) {
      final String country = bf.next();
      System.out.println(country);
    }

    System.out.println("\nBreadth first iteration starting from Vietnam");

    final Iterator<String> bf2 = new BreadthFirstIterator<>(myMap, VN);
    while (bf2.hasNext()) {
      final String country = bf2.next();
      System.out.println(country);
    }

    System.out.println("\nClosest first iteration starting from China");

    final Iterator<String> cf = new ClosestFirstIterator<>(myMap, CN);
    while (cf.hasNext()) {
      final String country = cf.next();
      System.out.println(country);
    }

    System.out.println("\nClosest first iteration starting from Vietnam");

    final Iterator<String> cf2 = new ClosestFirstIterator<>(myMap, VN);
    while (cf2.hasNext()) {
      final String country = cf2.next();
      System.out.println(country);
    }

    System.out.println("\nDepth first iteration starting from China");

    final Iterator<String> df = new DepthFirstIterator<>(myMap, CN);
    while (df.hasNext()) {
      final String country = df.next();
      System.out.println(country);
    }

    System.out.println("\nDepth first iteration starting from Vietnam");

    final Iterator<String> df2 = new DepthFirstIterator<>(myMap, VN);
    while (df2.hasNext()) {
      final String country = df2.next();
      System.out.println(country);
    }

    System.out.println(
        "\nRandom walk iterator for starting point in China with a max number of steps");

    final Iterator<String> rw = new RandomWalkIterator<>(myMap, CN, true, 8);
    while (rw.hasNext()) {
      final String country = rw.next();
      System.out.println(country);
    }

    System.out.println(
        "\nRandom walk iterator for starting point in Vietnam with a max number of steps");

    final Iterator<String> rw2 = new RandomWalkIterator<>(myMap, VN, true, 8);
    while (rw2.hasNext()) {
      final String country = rw2.next();
      System.out.println(country);
    }

    System.out.println("\nPrint map colors");

    GreedyColoring colorMap = new GreedyColoring(myMap);
    System.out.println(colorMap.getColoring());
  }
}
