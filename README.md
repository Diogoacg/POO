
# Object-Oriented Programming

Tiago Matos Guedes (A97369)

Diogo Afonso Costa Gonçalves (A101919)

## Introduction
As part of the Object-Oriented Programming course, we were assigned a practical project involving the development of a platform for managing physical activities and health. The main objective of this platform is to provide users with an interactive experience where they can monitor and manage their physical activities, as well as track their progress towards fitness and well-being goals.

In order to adhere to object-oriented programming principles, it is crucial to establish a well-structured class hierarchy that promotes scalability and maintainability of the system. This ensures that new features and functionalities can be added in the future without compromising the existing structure.

In this report, we will present and justify the adopted class hierarchy for the fitness platform project, as well as architectural details that we consider fundamental for the sustainable development of the platform.

## Classes

### Fitness App

The overall program to which we have referred as Fitness App.

### Activities

Activity is one of the classes in our system that refers to characteristics that all types of activities contain, with several types of activities existing:

#### Track Running

A subclass of the Activity class that consists of activities that only include distance as an instance variable.

#### Swimming

A subclass of the Activity class that consists of activities that only include distance as an instance variable, with the difference from track running being that it has less distance and the same caloric expenditure.

#### Mountain Running

A subclass of the Activity class that consists of activities that encompass both distance and altitude of the activity.

#### Mountain Biking

A subclass of the Activity class that consists of activities that encompass both distance and altitude of the activity, with the difference from mountain running being that it has less caloric expenditure.

#### Push-Ups

A subclass of the Activity class that consists of activities that only include repetitions as an instance variable.

#### Sit-Ups

A subclass of the Activity class that consists of activities that only include repetitions as an instance variable.

#### Bench Press

A subclass of the Activity class that consists of activities that encompass repetitions and weight as instance variables.

#### Leg Press

A subclass of the Activity class that consists of activities that encompass repetitions and weight as instance variables, but as a leg exercise requires less caloric expenditure.

### Users

The User class has all the instance variables that we found intrinsic to a user of this app:

#### Professional Users

A subclass of the User class that defines more experienced users, for example, those with the highest multiplicative factor and therefore higher caloric expenditure than other users.

#### Amateur Users

A subclass of the User class that refers to the intermediate level of a user, i.e., users who have an average multiplicative factor in caloric expenditure.

#### Occasional Users

A subclass of the User class, which refers to users whose multiplicative factor is lower, due to being less regular than the previous ones.

### Training Plans

Training Plans are one of the classes in our app that have the functionality of grouping a certain number of activities that a respective user has planned to do on a certain date.

### Statistics

Statistics was a module created in our app with the functionality of being able to know some peculiarities about our "save", for example:

- Which user burned the most calories.
- Which user performed the most activities.
- Which type of activity is most performed.
- How many kms did a user perform in a period or ever
- How many meters of altitude did a user total in a period or ever
- What is the most demanding training plan in terms of proposed caloric expenditure
- List a user's activities

### Records

The records class is responsible for the records of each modality represented in the app, representing either the highest number of calories burned, or the longest distance in distance activities, or even the heaviest weight lifted in weight activities, etc.

### Controller

It receives a message from the Reader and from there interprets which functionality is required by the user, then that same message is resent, along with a flag indicating the functionality, to the respective controller.

#### Records Controller

Upon receiving the message and flag sent by the Controller, it knows how to notify the Manager without the message having to be interpreted again, as it is the registry controller, it is natural that all its notifications are related to the alteration of the data structures present in the Manager.

#### Statistics Controller

Like the previous controller, it receives a message and flag from the main controller and notifies the Manager regarding statistical issues.

### Manager

It is within this section that the data structures that fully support the correct functioning of the system are included, so this is where the Manager class operates as per the notifications received from the controllers.

Since the Manager has to safeguard the records of objects such as users, activities, training plans, and records, it must have data structures that allow direct access to a specific object. However, it is not correct to implement a Manager that has collections of such different objects.

Auxiliary classes were then created to be able to deal with each collection individually:

- Users Manager
- Activities Manager
- Training Plans Manager
- Records Manager

### Menu

This is the class that enables communication between the user and the app, trying to be as concise as possible and easy to understand for the user in question.

## Functionalities

- Insert User ⇒ Adds a new user to the system.
- Insert Activity ⇒ Allows adding a new activity to the system.
- Insert Training Plan ⇒ Allows the creation of a new training plan by a user.
- Remove User ⇒ Removes an existing user from the system.
- Remove Activity ⇒ Removes an existing activity from the system.
- Remove Training Plan ⇒ Removes an existing training plan from the system.
- List Users ⇒ Shows a list of all users registered in the system.
- List Activities ⇒ Displays a list of all available activities in the system.
- List Training Plans ⇒ Presents a list of all training plans registered in the system.
- Register Activity ⇒ Allows a user to register a specific activity in the system.
- Get Records ⇒ Allows users to view activity records in the system.
- Advance in Time ⇒ Allows the system administrator to advance the current date.
- Statistics ⇒ Provides various statistics about system usage.

## Conclusion

In conclusion, despite some functionalities not being 100% implemented or exactly as requested, we have a functional project and, in our opinion, well organized. We did our best with our knowledge to make the code as readable as possible and preserving the hierarchy and encapsulation as much as possible. It was overall a project that contributed significantly to our growth in object-oriented programming.

Additionally, we would like to mention some difficulties encountered during the project development. In particular, we had difficulty fully understanding what was requested in certain parts of the statement, such as the categorization of activities as "hard", the precise definition of the concept of activity time - whether it was fixed or filled in later by the user - and even the definition of what constitutes an activity within the context of the application. Despite these challenges, we were able to overcome them and produce a solution that meets the main requirements of the project.
