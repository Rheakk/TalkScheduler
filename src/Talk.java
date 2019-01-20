/* Rhea Kothari
 * rkk2133
 * Defines a Talk class which has a speaker name, 
 * start time and end time. 
 */

public class Talk implements Comparable<Talk> {
    
    private int start;
    private int end;
    private String speaker;
    
    public Talk(String speakerName, int startTime, int endTime){
        speaker = speakerName;
        start = startTime;
        end = endTime;
    }
    
    public int compareTo(Talk talk){
        return Integer.compare(end, talk.end);
    }
    
    public String toString(){
		// use this method to easily print a Talk object
		return speaker + " " + start + " " + end;
	}
    
    public boolean endBefore(Talk talk){
        return (this.end <= talk.start);
    }
    
}