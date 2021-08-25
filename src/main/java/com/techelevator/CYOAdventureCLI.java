package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CYOAdventureCLI {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        printMenu();

        String userResponse = userInput.nextLine();

        if ("1".equals(userResponse)) {
            System.out.println("Sounds boring! Let's go!");
            System.out.println("You've arrived at the grocery store. There's a parking spot close to the door " +
                    "that is for Quick Trips of 15 minutes or less. Do you take it? " +
                    "\n(Y)es! I can't pass up a good parking spot! " +
                    "\n(N)o way! I'll never be done shopping that quickly. ");
            String parkResponse = userInput.nextLine().toLowerCase();
            if ("y".equals(parkResponse)) {
                System.out.println("You've got everything on your list now. Do you stop to browse in the garden center?" +
                        "\n(Y)es, always! " +
                        "\n(N)ope, I've killed enough plants in my life. ");
                String plantResponse = userInput.nextLine().toLowerCase();
                if ("y".equals(plantResponse)) {
                    System.out.println("I hope you like the plant you chose, because the delay caused your car to get towed! " +
                            "You're now forced to take a ride-share to the tow yard to retrieve the car. It will cost $200. " +
                            "\nDo you pay the money or abandon your car? " +
                            "\n1) Pay the money, obviously." +
                            "\n2) Leave it. I'm going home.");
                    String carResponse = userInput.nextLine();
                    if ("1".equals(carResponse)) {
                        goToTow();
                    } else if ("2".equals(carResponse)) {
                        System.out.println("You take a ride-share home, unpack your groceries, and try again tomorrow. ");
                    }
                    else {
                        System.out.println("That's not an option right now. Try again tomorrow.");
                    }
                } else if ("n".equals(plantResponse)) {
                    System.out.println("Now your groceries are home and unloaded. What next? " +
                            "\n1) Watch a movie and go to bed. " +
                            "\n2) This has been a dull day. Let's take a trip.");
                    String sleepOrTravel = userInput.nextLine();
                    if ("1".equals(sleepOrTravel)) {
                        System.out.println("You have a nice, quiet evening in. Good night.");
                    } else if ("2".equals(sleepOrTravel)) {
                        System.out.println(surpriseTrip());
                    }
                    else {
                        System.out.println("That's not an option at this time. Try again tomorrow.");
                    }

                } else {
                    System.out.println("That's not an option right now. Try again tomorrow.");
                }
            } else if ("n".equals(parkResponse)) {
                System.out.println("You've got everything on your list, plus a few impulse purchases. When " +
                        "you get to your car there's a flier on your windshield for a free concert in the park. " +
                        "Do you go? " +
                        "\n(Y)eah, sure. " +
                        "\n(N)o, I have other plans this evening. ");
                String concertResponse = userInput.nextLine().toLowerCase();
                if ("y".equals(concertResponse)) {
                    System.out.println("You get to the concert and the band is great. " +
                            "But when the show is over, you realize your car has been towed! " +
                            "\n");
                    goToTow();
                } else if ("n".equals(concertResponse)) {
                    System.out.println("You get home and unload your groceries. Are you ready for a night in or feeling adventurous?" +
                            "\n1) I'm in for the night." +
                            "\n2) I'm feeling spontaneous.");
                    String adventureResponse = userInput.nextLine();
                    if ("1".equals(adventureResponse)) {
                        System.out.println("Good night.");
                    } else if ("2".equals(adventureResponse)) {
                        System.out.println("You go to the airport, intent on booking the next flight anywhere. ");
                        System.out.println(surpriseTrip());
                    }
                    else {
                        System.out.println("That's not an option at this time. Try again tomorrow.");
                    }
                }
                else {
                    System.out.println("That's not an option at this time. Try again tomorrow.");
                }

            }
            else {
                System.out.println("That's not an option at this time. Try again tomorrow.");
            }
        } else if ("2".equals(userResponse)) {
            System.out.println("When you pull up to your favorite coffee place, you see that there is a line out the door. " +
                    "Do you wait, or go home?" +
                    "\n1) I'll wait in any line for coffee." +
                    "\n2) Not worth it. I'm going home.");
            String coffeeInput = userInput.nextLine();
            if ("1".equals(coffeeInput)) {
                Character inLine = new Character("Emerson", true);
                System.out.println("While in line you meet " + inLine.getName() + ". They ask if you would like " +
                        "to enter a sweepstakes. All you have to do is provide your name and phone number. " +
                        "Do you do it?" +
                        "\n1) No way. I'm not going to give my information to a stranger." +
                        "\n2) Sure.");
                String sweepstakesInput = userInput.nextLine();
                if ("1".equals(sweepstakesInput)) {
                    System.out.println("You wait about 30 more minutes, get your coffee, and go home for a relaxing day.");
                }
                else if ("2".equals(sweepstakesInput)) {
                    System.out.println("Good choice! You will later learn that you won the sweepstakes. The prize was a vacation. ");
                    System.out.println(surpriseTrip());
                }
                else {
                    System.out.println("That's not an option at this time.");
                }
            }
            else if ("2".equals(coffeeInput)) {
                System.out.println("You go home to relax for the rest of the day with movies and popcorn.");
            }
            else {
                System.out.println("That's not an option at this time. Try again tomorrow.");
            }

        } else if ("3".equals(userResponse)) {
                System.out.println(surpriseTrip());

        } else if ("4".equals(userResponse)) {
                System.out.println("If you insist. See you tomorrow.");
        }
        else {
            System.out.println("Not an option at this time. Try again tomorrow.");
        }

     }



    public static String surpriseTrip() {
        String tripString = "";
        List<String> trips = new ArrayList<>();

        File file = new File("TripFile.txt");
        try {
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String destination = fileScanner.nextLine();

                trips.add(destination);

                Collections.shuffle(trips);
                if (trips.get(0).equals("Quebec")) {
                    tripString = "You found a great deal on a trip to Quebec. Enjoy!";
                } else if (trips.get(0).equals("Madrid")) {
                    tripString = "Who knew a spontaneous flight to Madrid could be so affordable. Have fun!";
                } else if (trips.get(0).equals("Los Angeles")) {
                    tripString = "You fly to your best friend's house in LA and stay forever!";
                } else if (trips.get(0).equals("No trip")) {
                    tripString = "All flights are canceled due to inclement weather. You should have just stayed home.";
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tripString;
    }

    public static void goToTow() {
        Scanner canScan = new Scanner(System.in);
        boolean goTo2 = false;
        System.out.println("When you get to the tow yard, there's someone taking notes near a row of cars " +
                "and someone walking into the office. Who do you approach to ask about your vehicle? " +
                "\n1) Person walking into the building " +
                "\n2) Person taking notes ");
        String choice = "";
        String approachChoice = canScan.nextLine();
        if ("1".equals(approachChoice)) {
            Character attendant = new Character("Janice", false);
            System.out.println("You walk into the office and read the name plate on the desk. " +
                    "\n'Hi, " + attendant.getName() + ", can you please help me get my towed car back?'");
            if (attendant.isHelpful()) {
                System.out.println(attendant.getName() + " agrees to help.");
            } else if (!attendant.isHelpful()) {
                System.out.println(attendant.getName() + " tells you that's not their job, and directs " +
                        "you to the person outside.");
                goTo2 = true;
            }
        }
        if ("2".equals(approachChoice) || goTo2) {
            Character attendant2 = new Character("Harvey", true);
            System.out.println("You approach the person outside, who introduces themself as " +
                    attendant2.getName() + ". You ask if they can help you get your car out.");
            if (attendant2.isHelpful()) {
                System.out.println(attendant2.getName() + " agrees to help! You pay the fee and drive home in your car.");
            } else if (!attendant2.isHelpful()) {
                System.out.println("Looks like your car will spend the night here. Call a ride-share and" +
                        "come back tomorrow to sort this out. :(");
            }
            else {
                System.out.println("That's not an option at this time. Try again tomorrow.");
            }
        }
        else {
            System.out.println("That's not an option at this time. Try again tomorrow.");
        }
    }
    public static void printMenu() {
        System.out.println("Hello. You have a full day ahead of you. What do you want to do first? (Select a number)" +
                "\n1) Go to the grocery store" +
                "\n2) Go to the coffee shop" +
                "\n3) Take a spontaneous trip" +
                "\n4) Go back to bed");
    }

    }

