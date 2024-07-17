# ImageGallery
#Project Context A client has asked us to create an image management system to store their favourite images. This 
system will allow users to upload and view images, add to favourites, edit an image (e.g. the title) or delete it. 
To achieve this, we will use object-oriented programming concepts such as classes, objects, encapsulation and 
inheritance in Java.

#Project Description The aim of this project is to develop an image management system in Java that allows users to:

View a list of images (image and title).
1. Add images to the database
2. Remove images from the database
3. Edit an existing image

#Aims of the Project:
To reinforce students' object-oriented programming concepts. 
Apply encapsulation to hide the 
internal implementation of classes and protect data. 
Develop a flowchart explaining the image management system. 
Develop code to represent the flowchart.

#Execution Details:

System Structure: The system will adhere to an MVC (Model-View-Controller) architecture, incorporating the following 
components:

1. Model: Will include classes representing the data and business logic. 
2. View: Will handle the data presentation to the user. 
3. Controller: Will mediate between the Model and the View, processing user requests and updating the view as necessary.

#System Components:

1. Model (ImageGallery) A class representing a tutorial with attributes such as id, title, description and URL View: 
2. User Interface: Initially, this could be either a console application or a basic graphical user interface (GUI). 
3. Controller (ImageGalleryController) A class that manages user requests and coordinates actions between the View and 
the Model. 
4. MySQL Database: A MySQL database will be set up with a “bd_ImageGallery” table to store the tutorial information.

#SOLID Principles:

Single Responsibility Principle (SRP): Each class will have a single responsibility. 
Open/Closed Principle (OCP): The system will be designed to allow for extension without modification of existing code. 
Liskov Substitution Principle (LSP): Derived classes will be interchangeable with their base classes without affecting 
the system's functionality. Interface Segregation Principle (ISP): Specific interfaces will be created for distinct 
sets of functionalities. Dependency Inversion Principle (DIP): High-level modules will not depend on low-level modules; 
both will depend on abstractions.

#Technologies Used:

Java: Core application development. 
MySQL: Database management. 
Spring Framework: Implementing MVC architecture Dependency Injection, and other enterprise features. 
Hibernate: Object-Relational Mapping (ORM) with the MySQL database. 
Maven: Project build and dependency management. 
JUnit: Testing application components.

#Action Steps:

Database Design: Create the database and the Tutorials table. 
Model Development: Implement the Tutorial classes. 
View Development: Develop the user interface (TutorialServices). 
Controller Development: Implement the TutorialController class. 
Integration and Testing: Integrate all components and conduct tests to ensure the system's functionality. 
Documentation and Demo: Prepare documentation and a functional demonstration for the client.

Project development URL: Kanban- JIRA: https://romerobellorini.atlassian.net/jira/software/projects/IGJ/boards/2 
Pseudocode-MIRO: https://miro.com/app/board/uXjVK2Cv234=/

![ImageGalleryPseudoCode](https://github.com/JuanMolinaRey/ImageGallery/blob/main/Image%20Gallery.jpg?raw=true)
