package com.klu.app;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.klu.model.Student;
import com.klu.config.AppConfig;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        long id = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Year: ");
        int year = sc.nextInt();

        // XML Configuration
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student1 = (Student) context.getBean("student");

        student1.setCourse(course);
        student1.setYear(year);

        System.out.println("\nXML Configuration Output");
        System.out.println("Student ID : " + id);
        System.out.println("Name       : " + name);
        student1.display();

        // Annotation Configuration
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Student student2 = ctx.getBean(Student.class);

        student2.setCourse(course);
        student2.setYear(year);

        System.out.println("\nAnnotation Configuration Output");
        System.out.println("Student ID : " + id);
        System.out.println("Name       : " + name);
        student2.display();

        sc.close();
    }
}