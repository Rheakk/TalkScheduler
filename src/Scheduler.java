/* Rhea Kothari
 * rkk2133
 * Defines a Scheduler class – a repository
 * for all methods to schedule the talks 
 */
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Scheduler {

    public static boolean isTesting = false;
    
    public static ArrayList<Talk> makeTalks(String fileName) throws FileNotFoundException {
        //Adding each word from text file to an ArrayList
        ArrayList<String> strTalks = new ArrayList<String>();
        String word;
        try {
            File inFile = new File (fileName);
            Scanner input = new Scanner(inFile);
            while (input.hasNext()){
                strTalks.add(input.next());
            }
        }
        catch (FileNotFoundException fe){
            System.out.println("File not Found " + fileName);
            throw fe;
        }
        //Using the consistent format of the text file to
        //create talk objects and adding them to ArrayList
        ArrayList<Talk> talks = new ArrayList<Talk>();
        for (int i = 0; i < strTalks.size(); i=i+3) {
            try {
                String speaker = strTalks.get(i);
                int start = Integer.parseInt(strTalks.get(i+1));
                int end = Integer.parseInt(strTalks.get(i+2));
                Talk talk = new Talk(speaker, start, end);
                talks.add(talk);
            }
            catch (Exception e) {
                System.out.println ("bad input from file at " + i);
                continue;
            }
        }
        Collections.sort(talks);
        if (isTesting){
            System.out.println ("Printing Sorted...");
            for (Talk talk : talks){
                System.out.println(talk.toString());
            }
            System.out.println ("Printed--------\n");
        }
        
        return talks;
    }

    public static ArrayList<Talk> scheduleTalks(ArrayList<Talk> talks){
        ArrayList<Talk> schedule = new ArrayList<Talk>();   
        Talk currTalk = talks.get (0);
        Talk lastScheduledTalk = currTalk; //storing the first talk (pluto) to compare with later
        schedule.add (currTalk); //adding first talk to the schedule ArrayList
        for (int i = 1; i < talks.size(); i++){
            currTalk = talks.get(i);
            if (lastScheduledTalk.endBefore(currTalk)){
                schedule.add (currTalk);
                lastScheduledTalk = currTalk; //replacing variable to compare 
                                              //with next talk from ArrayList talks 
            }
        }
        return schedule;
    }
    
    
    
    
}
