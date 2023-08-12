package com.route.islamiappc38gsat.designPatterns

/**
 *  Design Patterns :-
 *      A set of Solutions for common problems
 *
 *   Creational Design Patterns :-
 *
 *
 * 1- Design Patterns (Creational , Structural , Behavioral Patterns)
 * 2- SOLID Principles
 * 3- Data Structures (Linked List , Map , Stack , Queue)
 * 4- Algorithms (Insertion Sort , Quick Sort , Recursion basics)
 *
 *
 *
 *
 *
 */

// Singleton Pattern
val database1 = Database.getInstance()
val database2 = Database.getInstance()

class Database private constructor() {
    companion object {
        var databaseInstance: Database? = null
        fun getInstance(): Database {
            if (databaseInstance == null) {
                databaseInstance = Database()
            }
            return databaseInstance!!
        }
    }

}