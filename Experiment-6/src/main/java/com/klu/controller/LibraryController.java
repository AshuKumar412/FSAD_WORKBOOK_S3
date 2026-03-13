package com.klu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.klu.model.Book;

@RestController
public class LibraryController {

 List<Book> bookList = new ArrayList<>();

 // 1 welcome
 @GetMapping("/welcome")
 public String welcome() {
  return "Welcome to Online Library System";
 }

 // 2 count
 @GetMapping("/count")
 public int countBooks() {
  return 150;
 }

 // 3 price
 @GetMapping("/price")
 public double price() {
  return 499.99;
 }

 // 4 books list
 @GetMapping("/books")
 public List<String> getBooks() {

  List<String> books = new ArrayList<>();

  books.add("Java Programming");
  books.add("Spring Boot Guide");
  books.add("Data Structures");

  return books;
 }

 // 5 path variable
 @GetMapping("/books/{id}")
 public String getBookById(@PathVariable int id) {

  return "Book details for ID: " + id;

 }

 // 6 request param
 @GetMapping("/search")
 public String searchBook(@RequestParam String title) {

  return "Searching for book: " + title;

 }

 // 7 author
 @GetMapping("/author/{name}")
 public String author(@PathVariable String name) {

  return "Books written by Author: " + name;

 }

 // 8 add book
 @PostMapping("/addbook")
 public String addBook(@RequestBody Book book) {

  bookList.add(book);

  return "Book added successfully";

 }

 // 9 view books
 @GetMapping("/viewbooks")
 public List<Book> viewBooks() {

  return bookList;

 }

}