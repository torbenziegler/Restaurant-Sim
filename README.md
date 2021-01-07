# Restaurant Simulation

During the second semester at the Stuttgart Media University, we were encouraged to work on a project together in a group. In our case it was a restaurant management app.

If there is a lot going on in restaurants, it can happen that one of the customers placed orders cannot be prepared due to missing ingredients. We had the original idea to address this problem by developing an application that assists service staff in the ordering process by placing orders beforehand to make the ingredients comparable to the ones in stock. It also gives customers the opportunity to place their orders independently and gives managers the opportunity to view stocks and to fill them up if necessary.

## Demos

Demonstration of customer routine
![Customer demo](https://github.com/torbenziegler/Restaurant-Sim/blob/master/src/main/resources/restaurant%20customer.gif)

Demonstration of manager routine
![Manager demo](https://github.com/torbenziegler/Restaurant-Sim/blob/master/src/main/resources/restaurant%20manager.gif)

## Usage Flow

1. The app starts with a login window in which you enter your login info.

Customer: 
> Username: customer
>
> Password: password

Manager:
> Username: manager
>
> Password: password

2. It is followed by a kitchen and location selection. You have the choice between three fictional restaurants: french, german and italian cuisine. There are three locations for each restaurant. 

3. If the registration was successful, you will get, depending on the user, the view for customers or managers.

4. As a customer, you get to a menu of the selected restaurant to place a new order. During the selection, the customer can relax and listen to the respective national music.
If the customer adds a dish, a comparison with the stocks takes place. Depending on whether there are enough ingredients for the dish an indication of a successfully placed order or insufficient quantity of available stocks is displayed.

5. As a manager you get an overview of the current stock. New ingredients can be replenished when deliveries have arrived.


> For more information: ![see the full documentation](https://github.com/torbenziegler/Restaurant-Sim/blob/master/src/main/resources/Dokumentation%20SE2-Projekt.pdf)
