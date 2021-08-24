package train.swift;

import java.io.IOException;

public class Test {
  
  public static class A { 
    public synchronized void m(){ 
      System.out.println("m in A");
    }

    public void n() throws IOException { 
      System.out.println("n in A");
      throw new IOException();
    }
  }

  public static class B extends A { 
    public void m() { 
      System.out.println("m in B");
    }

    public void n() { 
      System.out.println("n in B");
    }
  }

  public void test() {
    A a = new A();
    a.m();
    try {
      a.n();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  interface Readable {
    void readBook();
    void setBookMark();
  }

  abstract class Book implements Readable {
    public void readBook() {

    }
  }

  class Ebook extends Book {

    @Override
    public void setBookMark() {
    }
    
  }

  public static void main(String[] args) {
    Test t = new Test();
    t.test();

    String s1 = "abc";
    String s2 = "abc";

    System.out.println((Object)s1);
    System.out.println((Object)s2);

    StringBuilder sb = new StringBuilder(5);
    System.out.println(sb.toString().equals(""));
  }

}
