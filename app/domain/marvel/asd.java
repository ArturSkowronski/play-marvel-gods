package domain.marvel;

/**
 * Created by arturskowronski on 18/02/15
 */
public class asd {
  public static void main(String [ ] args){
    String[] splitted = "(())".split("");
    int sum = 0;
    int amount = 0;

    for (String split : splitted) {
      if(split.equals("(")) sum++;
      if(split.equals(")")) sum--;
      amount++;
      if(sum == 0) break;
    }

    System.out.println((sum==0 && splitted.length == amount) ? "Balanced": "Unbalanced");
  }
}
