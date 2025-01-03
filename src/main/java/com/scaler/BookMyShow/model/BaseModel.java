package com.scaler.BookMyShow.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

// MappedSuperClass is an annotation which indicates that the BaseModel will be a super class
// for all the classes and the id from this class will act as the id in table that will be
// created. Since we are using MappedSuperClass, we don't have to make the class abstract
// It is understood that this is the super class of all the classes
@MappedSuperclass
@Getter
@Setter
public class BaseModel {
        // This annotation will ensure that we keep generating ids for the tables created
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
}


/*
If the entities in a class are private,then we will need getter and setter methods for them.
If there are a lot of entities, the getters and setters will make te class look long and unclean.

That's why we have Lombok dependency to make that easier for us.
We simply have to add annotations @Getter and @Setter on top of the file.

Now when the java code compiles and converts into bytecode. Lombok will automatically
add getters and setters. These are simple setters and getters that will just set the entity values
and return them.

If we want a logic to be written inside getters and setters then we will have to write them
explicitly inside the class.

The compiled code will contain getters and setters with the Lombok annotations. But the code that
I am writing here will not contain them.

Spring Data JPA

In this project all the tables will be created using classes. And since we are using an ORM model -
Object Relational Mapping. The classes will be automatically converted into tables. We can create highly
scalable projects without writing a single query. And that will happen through the ORM model that we
are using.
 */
