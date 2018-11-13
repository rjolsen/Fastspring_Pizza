# Fastspring_Pizza
---------------------
##Assumptions:

Environment and Toolset:
>Eclipse

>Java 8

>Servlets

>HTML

Comments:
>Due to time constraints and not having a development environment setup I assumed the quickest would be to use Eclipse and HttpSerlets to do the rendering of HTML pages.  Also without any database installed I chose to update static objects in memory in order to add a remove items from a list of pizza toppings, In real life database tables would be better suited to contain the data items that can be added or removed by a user configured with authorized privileges.  JUnit test cases were created for all class Getter and Setter methods even though this is not necessary since they typically do not manipulate the data.

Main URL:
>http://localhost:8080/Fastspring_Pizza/
From this page the user can:
>1. Create a new pizza order.
>2. Track an existing pizza order by the order Id.
>3. Store manager can control toppings(Add or Delete) - anyone can act as manager.

Tracking URL:
>http://localhost:8080/Fastspring_Pizza/TrackOrder
From this page the user can:
>1. Track an existing pizza orderand its current state by the order Id.

Update Toppings URL:
>http://localhost:8080/Fastspring_Pizza/UpdateToppings
From this page the store manager can:
>1. Update toppings available(Add or Delete).

Manager URL:
>http://localhost:8080/Fastspring_Pizza/Manager
From this apge the store manager can:
>1. Update the status of a pizza order.
>2. Update toppings available(Add or Delete).