# The Mobile Store

This project will consist of five screens. You don't have to create a mobile store, you can use any other item as long as you create the following screens. You will be creating:

1. Login screen: Email and password fields and labels plus create and login buttons
2. Welcome onboarding screen
3. Instructions onboarding screen
4. Mobile Listing screen
5. Mobile Detail screen for adding a new mobile

## Getting Started

Open the starter project in the latest stable version of Android Studio.

Open the starter project in Android Studio

##Steps

1. Open the starter project in Android Studio

2. Add the navigation libraries to the app build.gradle file

3. Add the safe-arg plugin to the main and app build.gradle file

4. Create a new navigation xml file

5. Create a new Login destination.

   * Include email and password labels 

   - Include email and password fields
   - Create buttons for creating a new login and logging in with an existing account
   - Clicking either button should navigate to the Welcome Screen.

6. Create a new Welcome screen destination that includes:

   * A new layout
   * At least 2 textviews
   * A navigation button with actions to navigate to the instructions screen

7. Create a new Instruction destination that includes:

   * A new layout
   * At least 2 textviews
   * A navigation button with actions to navigate to the mobile list screen

8. Create a class that extends ViewModel

   *  Use a LiveData field that returns the list of mobiles

9. Create a new Mobile List destination that includes:

   * A new layout
   * A ScrollView
   * A LinearLayout for Mobile Items
   * A FloatingActionButton with an action to navigate to the Mobile detail screen

10. In MainActivity, setup the nav controller with the toolbar and an AppBarConfiguration.

11. Create a new Mobile Detail destination that includes:

    * A new layout
    * A TextView label and EditView for the
      * Mobile Name
      * Company
      * Mobile Model
      * Description
    * A Cancel button with an action to navigate back to the Mobile list screen
    * A Save button with an action to navigate back to the Mobile list screen and add a new Mobile to the Mobile View Model

12. Make sure you can’t go back to onboarding screens

13. In the Mobile List screen:

    * Use an Activity level ViewModel to hold a list of Mobiles (use by activityViewModels)
    * Observe the Mobiles variable from the ViewModel
    * Use DataBindingUtil to inflate the mobile_list layout
    * Add a new layout item into the scrollview for each mobile.
