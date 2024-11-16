package org.example;
import java.util.*;
public class CourseChapters {
    Scanner scanner =new Scanner(System.in);
    public void JavaChapters(){

        System.out.println("JAVA");
        System.out.println("Course Overview:\n" + "1. Platform-Independent\n" + "2. Object-Oriented\n" + "3. Secure\n" + "4. Multithreading\n" + "5. Rich Standard Library");
        int chapterChoice=scanner.nextInt();

        if(chapterChoice==1){
            System.out.println("PLATFORM INDEPENDENT:");
            System.out.println("     Java’s \"write once, run anywhere\" (WORA) capability allows" +" code to run on any platform with a JVM.");
        }
        else if(chapterChoice==2){
            System.out.println("OBJECT ORIENTED:");
            System.out.println("     Supports OOP principles like encapsulation, inheritance " + "and polymorphism, enhancing modularity and reusability.");
        }
        else if(chapterChoice==3){
            System.out.println("SECURE:");
            System.out.println("     Java offers built-in security features, including the Java Security Manager and" + " bytecode verification.");
        }
        else if(chapterChoice==4){
            System.out.println("MULTI THREADING:");
            System.out.println("     Java provides robust support for multithreading, " +
                    "allowing for concurrent processing and responsive applications.");

        }
        else if(chapterChoice==5){
            System.out.println("RICH STANDARD LIBRARY:");
            System.out.println("     Java SE includes extensive libraries for networking, data structures, I/O" + " and more.");
        }
        else {
            System.out.println("WRONG INPUT");
        }
    }

    public void CPlusPlusChapter(){
        System.out.println("C++");
        System.out.println("Course Overview:\n" + "    Object-Oriented Programming (OOP)\n" + "2. Memory Management\n" + "3. Low-Level Manipulation\n" + "4. Efficiency and Performance\n" + "5. Rich Standard Library");
        int chapterChoice=scanner.nextInt();
        if(chapterChoice==1){
            System.out.println("OBJECT ORIENTED PROGRAMMING:");
            System.out.println("     C++ supports object-oriented programming, which allows you to model real-world entities as objects. The four pillars of OOP — Encapsulation, Abstraction, Inheritance, and Polymorphism — are fundamental to C++.");
        }
        else if(chapterChoice==2){
            System.out.println("MEMORY MANAGEMENT:");
            System.out.println("     C++ provides dynamic memory management using pointers. This allows programmers to allocate and deallocate memory manually, offering greater control over system resources.");
        }
        else if(chapterChoice==3){
            System.out.println("LOW LEVEL MANIPULATION");
            System.out.println("    C++ allows for low-level memory manipulation, which makes it suitable for developing system-level software (such as operating systems, device drivers, etc.) that needs direct interaction with hardware.");
        }
        else if(chapterChoice==4){
            System.out.println("EFFICIENCY AND PERFORMANCE:");
            System.out.println("     One of C++'s strongest points is its efficiency and performance. It is a compiled language, meaning it is translated directly into machine code, making it much faster than interpreted languages.");

        }
        else if(chapterChoice==5){
            System.out.println("RICH STANDARD LIBRARY:");
            System.out.println("     C++ has a comprehensive standard library (which includes input/output handling, containers, algorithms, etc.) and external libraries that provide functionality for specific tasks (like GUI programming, networking, etc.).");
        }
        else {
            System.out.println("WRONG INPUT");
        }
    }

    public void DbmsChapter() {
        System.out.println("DBMS");
        System.out.println("Course Overview:\n" + "1. . Object-Oriented Programming (OOP)\n" + "2. Memory Management\n" + "3. Low-Level Manipulation\n" + "4. Efficiency and Performance\n" + "5. Rich Standard Library");
        int chapterChoice = scanner.nextInt();
        if(chapterChoice == 1){
            System.out.println("OBJECT ORIENTED PROGRAMMING:");
            System.out.println("     DBMS supports object-oriented programming, which allows you to model real-world entities as objects. The four pillars of OOP — Encapsulation, Abstraction, Inheritance, and Polymorphism — are fundamental to DBMS.");
        }
        else if(chapterChoice == 2){
            System.out.println("MEMORY MANAGEMENT:");
            System.out.println("     DBMS provides dynamic memory management using pointers. This allows programmers to allocate and deallocate memory manually, offering greater control over system resources.");
        }
        else if(chapterChoice == 3){
            System.out.println("LOW LEVEL MANIPULATION");
            System.out.println("    DBMS allows for low-level memory manipulation, which makes it suitable for developing system-level software (such as operating systems, device drivers, etc.) that needs direct interaction with hardware.");
        }
        else if(chapterChoice == 4){
            System.out.println("EFFICIENCY AND PERFORMANCE:");
            System.out.println("     One of DBMS's strongest points is its efficiency and performance. It is a compiled language, meaning it is translated directly into machine code, making it much faster than interpreted languages.");
        }
        else if(chapterChoice == 5){
            System.out.println("RICH STANDARD LIBRARY:");
            System.out.println("     DBMS has a comprehensive standard library (which includes input/output handling, containers, algorithms, etc.) and external libraries that provide functionality for specific tasks (like GUI programming, networking, etc.).");
        }
        else {
            System.out.println("WRONG INPUT");
        }

    }


}
