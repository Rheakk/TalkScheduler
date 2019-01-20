/* Rhea Kothari
 * UNI: rkk2133
 * PROGRAMMING PROJECT 5
 * Due Date: Nov 21st @11:59PM
 */
 
 Talk Class:
     - A class to construct the talk object - has instance variables speaker name, start time, and end time
     - I used end times as the sorting standard in my compareTo method
     - I included a function toString() to easily print the talk object for testing purposes
     - I also included endBefore() as the check method to see if two talks overlap when scheduling them
       in the Scheduler class

 Scheduler Class:
     In makeTalks():
         - I converted the info from the text file into talk objects by first taking each word and adding them
         as Strings to an ArrayList
         - I then use the ordering of the text file (speaker startTime endTime) to create talk objects out of each
         element from the ArrayList. I include a badInput exception to account for the ordering in the text file
         possibly being messed up.
     In makeSchedule():
         - I first add the first talk – Pluto – to the list and store the talk into variable "lastScheduledTalk"
         so I can compare the next talk with it
         - I call endBefore() from Talk class to check if talks overlap - if they do, I add the currentTalk to
         ArrayList schedule and update lastScheduledTalk with the currentTalk to compare the next talk with. 

     
 
 