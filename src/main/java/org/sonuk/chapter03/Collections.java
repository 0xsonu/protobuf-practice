package org.sonuk.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonuk.models.chapter03.Book;
import org.sonuk.models.chapter03.Library;

import java.util.List;

public class Collections {
    private static final Logger logger = LoggerFactory.getLogger(Collections.class);

    public static void main(String[] args) {
        var book = Book.newBuilder()
                .setTitle("Head First Java - Part 1")
                .setAuthor("Sonu Kumar")
                .setPublicationYear(2014)
                .build();

        var book2 = Book.newBuilder()
                .setTitle("Head First Java - Part 2")
                .setAuthor("Sonu Kumar")
                .setPublicationYear(2018)
                .build();
        var book3 = Book.newBuilder()
                .setTitle("Head First Java - Part 3")
                .setAuthor("Sonu Kumar")
                .setPublicationYear(2020)
                .build();
        var library = Library.newBuilder()
                .setName("My Library")
//                .addBook(book)
//                .addBook(book2)
//                .addBook(book3)
                .addAllBook(List.of(book, book2, book3))
                .build();

        logger.info(library.toString());

    }
}
