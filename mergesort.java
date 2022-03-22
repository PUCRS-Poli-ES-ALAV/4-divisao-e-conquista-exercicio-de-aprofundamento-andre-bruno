import java.util.ArrayList;
import java.util.List;

class Application {
  public static void main(String[] args) {

    Application app = new Application();

    List <Integer> list01 = app.generateList(32); // caso 1 -> 4 bits
    List <Integer> list02 = app.generateList(1024); // caso 2 -> 16 bits
    List <Integer> list03 = app.generateList(1048576); // caso -> 64 bits

    long time01 = app.countTime(() -> app.mergeSort(list01));
    long time02 = app.countTime(() -> app.mergeSort(list02));
    long time03 = app.countTime(() -> app.mergeSort(list03));

    System.out.println("Caso 1 de 4 bits: " + time01 + " ms");
    System.out.println("Caso 2 de 16 bits: " + time02 + " ms");
    System.out.println("Caso 3 de 64 bits: " + time03 + " ms");
  }

  public List<Integer> generateList(int size) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      list.add((int) (Math.random() * 1024));
    }
    return list;
  }

  public List<Integer> mergeSort(List<Integer> list) {
    if (list.size() == 1) {
      return list;
    }

    List<Integer> left = mergeSort(list.subList(0, list.size() / 2));
    List<Integer> right = mergeSort(list.subList(list.size() / 2, list.size()));

    return merge(left, right);
  }

  public List<Integer> merge(List<Integer> left, List<Integer> right) {
    List<Integer> result = new ArrayList<>();
    int leftIndex = 0;
    int rightIndex = 0;

    while (leftIndex < left.size() && rightIndex < right.size()) {
      if (left.get(leftIndex) < right.get(rightIndex)) {
        result.add(left.get(leftIndex));
        leftIndex++;
      } else {
        result.add(right.get(rightIndex));
        rightIndex++;
      }
    }

    while (leftIndex < left.size()) {
      result.add(left.get(leftIndex));
      leftIndex++;
    }

    while (rightIndex < right.size()) {
      result.add(right.get(rightIndex));
      rightIndex++;
    }
    return result;
  }

  public long countTime(Runnable r) {
    long start = System.currentTimeMillis();
    r.run();
    long end = System.currentTimeMillis();
    return end - start;
  }
}
